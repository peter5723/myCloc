package myCloc;
//@Source https://stackoverflow.com/questions/2056221/recursively-list-files-in-java
import java.io.File;
import java.io.IOException;

public class FileWalker {
    private MyFolder folder;
    public FileWalker() {
        folder = new MyFolder();
    }
    public void walk( String path ) throws IOException {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) {
            if (root.isFile()) {
                MyFile tmpFile = new MyFile();
                tmpFile.readFromFile(root);
                folder.addFile(tmpFile);
            }
            return;
        }

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
            }
            else {
                MyFile tmpFile = new MyFile();
                tmpFile.readFromFile(f);
                folder.addFile(tmpFile);
            }
        }
    }

    public MyFolder getFolder() {
        return folder;
    }

    public static void main(String[] args) throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("C:\\Users\\Peter\\作业\\skeleton-sp21-master\\proj1" );
    }

}
