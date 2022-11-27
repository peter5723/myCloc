import myCloc.FileWalker;
import myCloc.MyFolder;
import org.junit.Assert;
import org.junit.Test;
import myCloc.MyFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class testPart {
    @Test
    public void justTest(){
        System.out.print("helllo!!!!");
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
        fw.walk(".");
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
    public void testCommentMyFile() throws IOException {
        MyFile f = new MyFile();
        String path = "./src/main/java/myCloc/MyFile.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        Assert.assertEquals(5, f.getCommentLines());
    }
    @Test
    public void testThisProj() throws IOException {
        MyFile f = new MyFile();
        String path = "src/test/java/testPart.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        Assert.assertEquals(5,f.getNumOfEmptyRows());
        Assert.assertEquals(82,f.getNumOfCode());
        Assert.assertEquals(3, f.getCommentLines());
    }
}
