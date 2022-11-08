import myCloc.FileWalker;
import myCloc.MyFolder;
import org.junit.Test;
import myCloc.MyFile;

import java.io.File;

public class Justatest {
    @Test
    public void justTest(){
        System.out.print("helllo!!!!");
    }
    @Test
    public void testReadFile() {
        MyFile f = new MyFile();
        String path = "C:\\Users\\Peter\\作业\\skeleton-sp21-master\\proj1\\deque\\LinkedListDeque.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        f.outputFile();
    }

    @Test
    public void testNumOfRows() {
        FileWalker fw = new FileWalker();
        fw.walk("C:\\Users\\Peter\\作业\\高程\\Mycloc");
        MyFolder folder0 = fw.getFolder();
        for (Object f : folder0) {
            MyFile f1 = (MyFile) f;
            int x = f1.getNumOfRows();
            System.out.println(f1.gerFilename()+" "+x);
        }
    }
}
