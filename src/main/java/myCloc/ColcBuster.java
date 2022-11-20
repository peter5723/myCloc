package myCloc;

import java.io.IOException;
import java.util.regex.Pattern;
//C:\\Users\\Peter\\作业\\skeleton-sp21-master\\proj1

public class ColcBuster {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.err.println("Invalid command line, exactly one argument required");
            System.exit(1);
        }
        FileWalker fw = new FileWalker();
        fw.walk(args[0]);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Language                     files          blank        comment           code");
        System.out.printf("Java                            %d            %d            %d           %d\n",
                fw.getFolder().getNumOfFiles(), fw.getFolder().getNumOfEmptyLines(),
                fw.getFolder().getNumOfCommandLines(), fw.getFolder().getNumOfCodeLines());
        System.out.println("-------------------------------------------------------------------------------");
    }
}
