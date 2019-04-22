package io;

import java.io.*;

public class TestStream {
    public static void main(String[] args) {

        try {
            File f = new File("Readme.md");
            FileInputStream fis = new FileInputStream(f);
            File f1 = new File("xyz/pyq/Test.txt");
            File parent  = f1.getParentFile();
            if(!parent.exists()){
                parent.mkdirs();
            }

            byte[] all = new byte[((int) f.length())];
            fis.read(all);
            for (byte each : all){
                System.out.println(each);
            }
            fis.close();

            FileOutputStream fos = new FileOutputStream(f1);
            byte data[] = {88,89};
            fos.write(data);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
