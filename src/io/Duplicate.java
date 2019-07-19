package io;

import java.io.*;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
//        String srcFile = "./src/io/Hero.java";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input the deplicate name");
//        String destFile = "./src/io/" + sc.nextLine();
        copyFolder("./src","./srcCopy");
    }
    public static void copyFolder(String srcFolder, String destFolder){
        File src = new File(srcFolder);
        File dest = new File(destFolder);
        if (!src.exists()) {
            return;
        }
        if (!src.isDirectory()) return;
        if (src.isFile()) {
            return;
        }
        if (!dest.exists()) {
            dest.mkdirs();
        }
        String destPath = dest.getAbsolutePath();
        String folderPath = src.getAbsolutePath();
        if (src.isDirectory()){
            // find all files and folders in the folder
            File[] files = src.listFiles();
            for (File f : files){
                String filePath = f.getAbsolutePath();
                String destSubPath = destPath + filePath.substring(folderPath.length());
                if (f.isFile()){
                    copyFile(filePath, destSubPath);
                }else if (f.isDirectory()){
                    copyFolder(filePath, destSubPath);
                }

            }

        }
    }
    public static void copyFile(String srcFile, String destFile){
        File input = new File(srcFile);
        File output = new File(destFile);
        try(
                FileReader fr = new FileReader(input);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(output);
        PrintWriter pw = new PrintWriter(fw)) {
           while (true){
               String line = br.readLine();
               if (null == line){
                   pw.flush();
                   break;
               }
               pw.write(line + "\n");
               System.out.println(line);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
