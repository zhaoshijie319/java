package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class ByteIO {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Paths.get("E:", "test.txt").toString()));
        byte[] bs = new byte[1024];
        int len = 0;
        while ((len = bis.read(bs)) != -1) {
            System.out.print(new String(bs, 0, len));
        }
        bis.close();
    }
}
