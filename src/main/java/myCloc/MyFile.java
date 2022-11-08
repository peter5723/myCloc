package myCloc;

import java.io.File;
import java.io.FileNotFoundException;
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
        //TODO:calculate the RowsOfContents
        return 0;
    }

    public int getNumOfRows() {
        return numOfRows;
    }
    public String gerFilename() {
        return this.filename;
    }
    public void readFromFile(File f) {
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
        String[] lines = str.split("\r\n|\r|\n");
        return  lines.length;
    }
}




