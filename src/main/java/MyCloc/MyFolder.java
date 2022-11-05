package MyCloc;

import java.util.Iterator;
import java.util.ArrayList;
public class MyFolder  {
    private String folderName;
    private int numOfFiles;
    private int numOfRows;
    private ArrayList<MyFile> folder;

    public MyFolder(String folderName) {
        numOfFiles = 0;
        numOfRows = 0;
        this.folderName = folderName;
        folder = new ArrayList<MyFile>();
    }

    public void addFile(MyFile f) {
        folder.add(f);
        numOfFiles++;
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
