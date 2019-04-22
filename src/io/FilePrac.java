package io;

import java.io.*;

public class FilePrac {
    public static void listFiles(File file){
        if (!file.isDirectory()){
            if (file.length() > maxsize){
                max = file;
                maxsize = file.length();
            }
            if (file.length()!=0 && file.length() < minsize){
                min = file;
                minsize = file.length();
            }
        }else {
            File[] temp = file.listFiles();
            if (null != temp)
                for (File each : temp){
                    listFiles(each);
                }
        }
    }
    static long maxsize = 0;
    static long minsize = Integer.MAX_VALUE;
    static File max = null;
    static File min = null;
    public static void main(String[] args) {
        File f1 = new File("/Users/weihaoran/Dropbox");
        try {
            FileInputStream fis = new FileInputStream(f1);
            FileOutputStream fos = new FileOutputStream(f1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listFiles(f1);

        System.out.println("max : " + max.getName() + "Length: "+ max.length());
        System.out.println("min: " + min.getName() + "Length" + min.length());
//        System.out.println(f1.getAbsolutePath());
//        File f2 = new File("src/");
//        System.out.println(f2.getAbsolutePath());
//        File f3 = new File(f1, "Test.txt");
//        System.out.println(f3.getAbsolutePath());
//        try {
//            System.out.println(f1.getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
