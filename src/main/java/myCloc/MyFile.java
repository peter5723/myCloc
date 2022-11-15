package myCloc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyFile {
    private String filename;
    private int numOfRows;
    private String contents;

    public MyFile(String filename, String contents) {
        this.filename = filename;
        this.contents = contents;
        numOfRows = getRowsOfContents(contents);
    }
    public MyFile() {
        this.filename = null;
        this.contents = null;
        numOfRows = 0;
    }

    private int getRowsOfContents(String contents) {
        return countLines(contents);
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfEmptyRows() throws IOException {
        return countEmptyLines(contents);
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
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }
        return lines;
    }

    //TODO: 修改计算空行的办法。总行数应该是对的了
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
}




