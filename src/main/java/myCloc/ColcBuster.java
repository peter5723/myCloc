package myCloc;

public class ColcBuster {
    //读文件吗 从命令行读入地址，若地址对应的是文件，建立同名的MyFolder，里面的只有一个File
    //若地址对应的文件夹，递归读入文件，储存在MyFolder的File中
    //统计每个Myfile的指标
    //靠 没有考虑Folder里面还有Folder的情况
    //今天处理一下读取文件的情况
    //递归读取所有文件
    /*
    public static void main(String[] args) {

        String path = "C:\\Users\\Peter\\作业\\skeleton-sp21-master\\proj1";
        try (Stream<Path> stream = Files.walk(Paths.get(path))) {
            stream.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
    }

     */
}
