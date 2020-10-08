package io;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.InetAddress;

public class txtToString {

    public static String txtToString(File file) {
        String result = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = "";
            while (!StringUtils.isEmpty(s = bufferedReader.readLine())) {
                result += "\n" + s;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

        String s = txtToString(new File("E:/网址.txt"));
        System.out.println(s);
    }
}
