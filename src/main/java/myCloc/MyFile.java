package myCloc;
//若一行是里面没有内容的空白行，换行也没有，这一行不计算在内；比如说空文件

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class MyFile {
    private String filename;
    private int numOfRows;
    private int numOfCode;
    private int numOfBlank;
    private int numOfComment;
    private String contents;

    public MyFile(String filename, String contents) throws IOException {
        this.filename = filename;
        this.contents = contents;
        this.numOfRows = countLines(this.contents);
        this.numOfBlank = countEmptyLines(this.contents);
        this.numOfComment = countCommentLines(this.contents);
        this.numOfCode = numOfRows - numOfComment - numOfBlank;
    }

    public MyFile() {
        this.filename = null;
        this.contents = null;
        numOfRows = 0;
        numOfBlank = numOfCode = numOfComment = 0;
    }


    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCode() {
        return numOfCode;
    }

    public int getNumOfEmptyRows() throws IOException {
        return numOfBlank;
    }

    //注释: 只有单独的一行算是注释行，代码后面附着的不算注释行。
    public int getCommentLines() throws IOException {
        return numOfComment;
    }

    public String getFilename() {
        return this.filename;
    }

    public void readFromFile(File f) throws IOException {
        if (!f.isFile()) {
            return;
        }
        this.filename = f.getName();
        StringBuilder myString = new StringBuilder();
        try {
            File myObj = f;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myString.append(data);
                myString.append('\n');
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        this.contents = myString.toString();
        this.numOfRows = countLines(this.contents);
        this.numOfBlank = countEmptyLines(this.contents);
        this.numOfComment = countCommentLines(this.contents);
        this.numOfCode = numOfRows - numOfComment - numOfBlank;
    }

    public void outputFile() {
        System.out.println(contents);
    }

    /*@source
    https://stackoverflow.com/questions/2850203/count-the-number-of-lines-in-a-java-string
     */
    private static int countLines(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int lines = 0;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }
        return lines;//总行数等于“\n"的个数
    }


    private static int countEmptyLines(String str) throws IOException {
        final BufferedReader br = new BufferedReader(new StringReader(str));
        String line;
        int empty = 0;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                empty++;
            }
        }
        return empty;
    }


    private static int countCommentLines(String str) throws IOException {
        int commentCount = 0;
        BufferedReader br = new BufferedReader(new StringReader(str));
        Stack<String> st = new Stack<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (Pattern.matches("^\\s*//.*", line) && st.isEmpty()) {
                commentCount++;//"//"的情况，只考虑单独的一行。
                continue;
            }
            if (line.trim().isEmpty()) {
                continue;//空行就没什么好看了，直接看下一行
            }
            for (int i = 0; i < line.length(); i++) {
                if (st.isEmpty()) {
                    if (line.charAt(i) == '\"') {
                        st.add("\"");
                    } else if (line.charAt(i) == '/' && i != line.length() - 1 && line.charAt(i + 1) == '*') {
                        st.add("/*");
                    } else if (line.charAt(i) == '\\') {
                        i++;
                    } else if (line.charAt(i) == '/' && i != line.length() - 1 && line.charAt(i + 1) == '/') {
                        st.add("//");//在代码后面的//的情况。
                    }
                } else if (st.peek().equals("/*")) {
                    if (line.charAt(i) == '*' && i != line.length() - 1 && line.charAt(i + 1) == '/') {
                        st.pop();
                        commentCount++;
                    }
                } else if (st.peek().equals("\"")) {
                    if (line.charAt(i) == '\"') {
                        st.pop();
                    } else if (line.charAt(i) == '\\') {
                        i++;
                    }
                }
            }
            if ((!st.isEmpty()) && st.peek().equals("/*")) {
                commentCount++;
            }
            if ((!st.isEmpty()) && st.peek().equals("//")) {
                st.pop();
            }

        }
        return commentCount;
    }

}
