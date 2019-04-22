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

        try {
            FileInputStream fis = new FileInputStream(file);
            String name = file.getName();

            byte data[] = new byte[((int) file.length())];
            fis.read(data);
            int nums;
            if (file.length() % size == 0)
                nums = ((int) (file.length() / size));
            else nums = ((int) (file.length() / size)) + 1;

            FileOutputStream fos;
            for (int i = 0; i < nums ; i++ ) {
                String filename = file.getName() + "-" + i;
                File filetemp = new File(filename);
                fos = new FileOutputStream(filetemp);
                byte[] eachContent;
                if (i != nums -1){
                    eachContent = Arrays.copyOfRange(data, i * size, (i+1) * size);
                }else eachContent = Arrays.copyOfRange(data, i * size, data.length);
                fos.write(eachContent);
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
