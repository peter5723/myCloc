package myCloc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class MyFolder implements Iterable {
    private String folderName;
    private int numOfFiles;
    private int numOfRows;
    private int numOfCodeLines;
    private int numOfEmptyLines;
    private int numOfCommandLines;
    private ArrayList<MyFile> folder;

    public MyFolder() {
        numOfFiles = 0;
        numOfRows = numOfEmptyLines= numOfCodeLines=numOfCommandLines=0;
        folder = new ArrayList<MyFile>();
    }

    public void addFile(MyFile f) throws IOException {
        if(!Pattern.matches(".*.java",f.getFilename())) return;
        //只考虑java文件
        folder.add(f);
        numOfFiles++;
        numOfRows += f.getNumOfRows();
        numOfCodeLines += f.getNumOfCode();
        numOfEmptyLines += f.getNumOfEmptyRows();
        numOfCommandLines += f.getCommentLines();
    }

    public int getNumOfFiles() {
        return numOfFiles;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCodeLines() {
        return numOfCodeLines;
    }
    public int getNumOfEmptyLines() {
        return numOfEmptyLines;
    }
    public int getNumOfCommandLines() {
        return numOfCommandLines;
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
