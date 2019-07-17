package io;

import java.io.*;

public class CombineFile {
    public static void main(String[] args) {
        mergeFiles("test.pdf");
    }

    private static void mergeFiles(String s) {
        File destFile = new File(s);
        try(FileOutputStream fos = new FileOutputStream(destFile)) {
            int index = 0;
            while (true){
                String tempName = s + "-" + index++;
                File inputFile = new File(tempName);
                if (!inputFile.exists())
                    break;
                byte[] data;
                try (FileInputStream fio = new FileInputStream(inputFile)) {
                    data = new byte[((int) inputFile.length())];
                    fio.read(data);
                }
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
