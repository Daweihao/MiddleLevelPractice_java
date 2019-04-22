package io;

import java.io.*;

public class CombineFile {
    public static void main(String[] args) {
        mergeFiles("test.pdf");
    }

    private static void mergeFiles(String s) {

        try {
            File destFile = new File(s);
            FileOutputStream fos = new FileOutputStream(destFile);
            int index = 0;
            while (true){
                String tempName = s + "-" + index++;
                File inputFile = new File(tempName);
                if (!inputFile.exists())
                    break;
                FileInputStream fio = new FileInputStream(inputFile);
                byte[] data = new byte[((int) inputFile.length())];
                fio.read(data);
                fio.close();
                fos.write(data);
                fos.flush();
                System.out.printf("Output subfiles %s to test.pdf %n", tempName);
            }
            fos.close();
            System.out.printf("Output file size is %d in bytes", destFile.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
