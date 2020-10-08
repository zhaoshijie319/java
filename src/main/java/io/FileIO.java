package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileIO {

    public static void main(String[] args) {
        Path source = Paths.get("C:","test.txt");
        Path target = Paths.get("D:", "test.txt");
        System.out.println(copyFile(source, target));
    }

    /**
     * 复制文件
     */
    public static Path copyFile(Path source, Path target) {
        try {
            System.out.println("source路径：" + source);
            //复制文件
            return Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    /**
     * 列出path下所有文件路径
     */
    public static void listAllFiles(Path path) {
        if (Files.notExists(path)) {
            return;
        }
        if (Files.isDirectory(path)) {
            try {
                Files.list(path).forEach(FileIO::listAllFiles);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(path);
            System.out.println(path.getFileName() + " isReadable: " + Files.isReadable(path)
                    + " isWritable: " + Files.isWritable(path)
                    + " isExecutable: " + Files.isExecutable(path)
            );
        }
    }
}
