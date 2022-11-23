import myCloc.FileWalker;
import myCloc.MyFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;



public class testAll {
    @Test
    public void testBlankFile() throws IOException {
        MyFile f = new MyFile();
        String path = "src/test/testFile/blank.java";
        File root1 = new File(path);
        f.readFromFile(root1);
        Assert.assertEquals(0,f.getNumOfEmptyRows());
        Assert.assertEquals(0,f.getNumOfCode());
        Assert.assertEquals(0, f.getCommentLines());
    }
    @Test
    public void testBlankFolder() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/blankFolder");
        Assert.assertEquals(0,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(0,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(0, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(2,fw.getFolder().getNumOfFiles());
    }

    @Test
    public void testOneFileWithCode() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/Hello1.java");
        Assert.assertEquals(5,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(0,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(0, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(1,fw.getFolder().getNumOfFiles());
    }
    @Test
    public void testFolderWithNoJava() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/folderNoJava");
        Assert.assertEquals(0,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(0,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(0, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(0,fw.getFolder().getNumOfFiles());
    }
    @Test
    public void testOneFileWithCommentAndCodeAndBlank() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/testComment.java");
        Assert.assertEquals(7,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(15,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(6, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(1,fw.getFolder().getNumOfFiles());
    }
    @Test
    public void testOneFolder() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/folderOneFile");
        Assert.assertEquals(5,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(1,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(1, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(1,fw.getFolder().getNumOfFiles());
    }

    @Test
    public void oneFolderWithMulFiles() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/folderMulFiles");
        Assert.assertEquals(8,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(4,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(5, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(3,fw.getFolder().getNumOfFiles());
    }

    @Test
    public void mulFolders() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/folderMulFolders");
        Assert.assertEquals(12,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(16,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(7, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(2,fw.getFolder().getNumOfFiles());
    }

    @Test
    public void mulFoldersAndFiles() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/mulFoldersAndFiles");
        Assert.assertEquals(22,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(9,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(4, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(3,fw.getFolder().getNumOfFiles());
    }

    @Test
    public void javaAndOther() throws IOException {
        FileWalker fw = new FileWalker();
        fw.walk("src/test/testFile/javaAndOther");
        Assert.assertEquals(11,fw.getFolder().getNumOfCodeLines());
        Assert.assertEquals(7,fw.getFolder().getNumOfCommandLines());
        Assert.assertEquals(1, fw.getFolder().getNumOfEmptyLines());
        Assert.assertEquals(2,fw.getFolder().getNumOfFiles());
    }
}
