package myCloc;

import java.util.ArrayList;
public class MyFolder  {
    private String folderName;
    private int numOfFiles;
    private int numOfRows;
    private ArrayList<MyFile> folder;

    public MyFolder() {
        numOfFiles = 0;
        numOfRows = 0;
        folder = new ArrayList<MyFile>();
    }

    public void addFile(MyFile f) {
        folder.add(f);
        numOfFiles++;
        numOfRows += f.getNumOfRows();
    }

    public int getNumOfFiles() {
        return numOfFiles;
    }

    public int getNumOfRows() {
        int tmp = 0;
        for (MyFile f:folder) {
            tmp += f.getNumOfRows();
        }
        return tmp;
    }



}
