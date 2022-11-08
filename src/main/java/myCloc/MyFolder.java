package myCloc;

import java.util.ArrayList;
import java.util.Iterator;

public class MyFolder implements Iterable {
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
        return numOfRows;
    }


    @Override
    public Iterator iterator() {
        return new FileIterator();
    }
    private class FileIterator implements Iterator {
        private int nowPos;

        public FileIterator() {
            nowPos = 0;
        }
        @Override
        public boolean hasNext() {
            return nowPos < folder.size();
        }

        @Override
        public Object next() {
            Object fileReturn = folder.get(nowPos);
            nowPos++;
            return fileReturn;
        }
    }
}
