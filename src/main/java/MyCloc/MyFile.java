package MyCloc;

public class MyFile {
    private String filename;
    private int numOfRows;
    private String contents;

    public MyFile(String filename, String contents) {
        this.filename = filename;
        this.contents = contents;
        numOfRows = getRowsOfContents(contents);
    }

    private int getRowsOfContents(String contents) {
        //TODO:calculate the RowsOfContents
        return 0;
    }

    public int getNumOfRows() {
        return numOfRows;
    }
}
