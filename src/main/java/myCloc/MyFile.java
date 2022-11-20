package myCloc;
//若一行是里面没有内容的空白行，换行也没有，这一行不计算在内；比如说空文件
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        if(str == null || str.isEmpty())
        {
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


    /*
    @source:https://stackoverflow.com/questions/5283200/how-to-count-comment-single-multiple-lines-in-java
     */
    private static int countCommentLines(String str) throws IOException {
        int commentCount = 0;
        BufferedReader br = new BufferedReader(new StringReader(str));
        String line;
        while ((line = br.readLine())!=null) {
            if (line.startsWith("/*")) {
                commentCount++;
                while ((line = br.readLine())!=null) {
                    commentCount++;
                    if (line.endsWith("*/")) {
                        break;
                    }
                }
            }
            else if (line.startsWith("//")) {
                commentCount++;
            }

        }
        return commentCount;
    }

}