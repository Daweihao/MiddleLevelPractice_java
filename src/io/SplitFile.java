package io;

import java.io.*;
import java.util.Arrays;

public class SplitFile {

    public static void main(String[] args) {
        int eachSize = 100 * 1024;
        File f = new File("test.pdf");
        splitFile(f, eachSize);

    }
    public static void splitFile(File file, int size){
        if (0 == file.length())
            throw new RuntimeException("Length cannot be zero!");
        FileInputStream fis = null;
        byte data[] = new byte[((int) file.length())];
        try {
            fis = new FileInputStream(file);
            String name = file.getName();


            fis.read(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        int nums;
        if (file.length() % size == 0)
            nums = ((int) (file.length() / size));
        else nums = ((int) (file.length() / size)) + 1;

        for (int i = 0; i < nums ; i++ ) {
            String filename = file.getName() + "-" + i;
            File filetemp = new File(filename);
            FileOutputStream fos = null;
            byte[] eachContent;
            if (i != nums -1){
                eachContent = Arrays.copyOfRange(data, i * size, (i+1) * size);
            }else eachContent = Arrays.copyOfRange(data, i * size, data.length);
            try {
                fos = new FileOutputStream(filetemp);
                fos.write(eachContent);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != fos){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
