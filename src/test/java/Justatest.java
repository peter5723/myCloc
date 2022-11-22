import myCloc.FileWalker;
import myCloc.MyFolder;
import org.junit.Assert;
import org.junit.Test;
import myCloc.MyFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Justatest {
    @Test
    public void justTest(){
        System.out.print("helllo!!!!");
    }
    @Test
    public void testReadFile() throws IOException {
        MyFile f = new MyFile();
        String path = "C:\\Users\\Peter\\作业\\skeleton-sp21-master\\proj1\\deque\\LinkedListDeque.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        //f.outputFile();
    }
    @Test
    public void readBlankFile() throws IOException {
        MyFile f = new MyFile();
        String path = ".\\src\\test\\testFile\\a.txt";
        File root1 = new File(path);
        f.readFromFile(root1);
        //f.outputFile();
        Assert.assertEquals("not equal "+f.getNumOfRows()+"with "+6,6,f.getNumOfRows());
    }
    @Test
    public void testNumOfRows() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("C:\\Users\\Peter\\作业\\高程\\Mycloc");
        MyFolder folder0 = fw.getFolder();
        for (Object f : folder0) {
            MyFile f1 = (MyFile) f;
            int x = f1.getNumOfRows();
            int x1 = f1.getNumOfCode();
            int x2 = f1.getNumOfEmptyRows();
            int x3 = f1.getCommentLines();
            System.out.println(f1.getFilename()+" "+x+" "+x1+" "+x2+" "+x3);
        }
    }
    @Test
    public void testBlankRows() throws IOException {
        MyFile f = new MyFile();
        String path = ".\\src\\test\\testFile\\a.txt";
        File root1 = new File(path);
        f.readFromFile(root1);
        //f.outputFile();
        Assert.assertEquals("not equal "+ f.getNumOfEmptyRows() +" with "+5,5,f.getNumOfEmptyRows());

    }
    @Test
    public void testCommentRows() throws IOException {
        MyFile f = new MyFile();
        String path = "./src/test/testFile/testComment.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        Assert.assertEquals(15, f.getCommentLines());
    }

    @Test
    public void testRegex1() {
        String line = "/*just test";
        String regex = "/\\*.*";
        Assert.assertTrue(Pattern.matches(regex,line));
    }
    @Test
    public void testRegex2() {
        String line = "//a comment";
        String regex = ".*//.*";
        Assert.assertTrue(Pattern.matches(regex,line));
    }
    //cloc是有bug的，测试这个文件时，发现String regex = ".*//.*";这句让它计算抽风了，就不用他作为测试依据了
    @Test
    public void testCommandMyFile() throws IOException {
        MyFile f = new MyFile();
        String path = "./src/main/java/myCloc/MyFile.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        Assert.assertEquals(10, f.getCommentLines());
    }
    @Test
    public void testThisProj() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk(".");
        Assert.assertEquals(6,fw.getFolder().getNumOfFiles());
        Assert.assertEquals(43,fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(32,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(326,fw.getFolder().getNumOfCodeLines());
    }
}
