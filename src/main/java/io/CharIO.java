package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CharIO {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get("E:", "test.txt").toString()));
        String line;
        while (true) {
            if (!((line = bufferedReader.readLine()) != null)) break;
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
