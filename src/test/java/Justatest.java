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
}
