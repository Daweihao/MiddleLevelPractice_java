package io;

import java.io.*;

public class TestStream {
    public static void main(String[] args) {

//        try {
//            File f = new File("Readme.md");
//            FileInputStream fis = new FileInputStream(f);
//            File f1 = new File("xyz/pyq/Test.txt");
//            File parent  = f1.getParentFile();
//            if(!parent.exists()){
//                parent.mkdirs();
//            }
//
//            byte[] all = new byte[((int) f.length())];
//            fis.read(all);
//            for (byte each : all){
//                System.out.println(each);
//            }
//            fis.close();
//
//            FileOutputStream fos = new FileOutputStream(f1);
//            byte data[] = {88,89};
//            fos.write(data);
//            fos.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File f = new File("Readme.md");
//        try (FileReader fr = new FileReader(f)){
//            char[] all = new char[(int) f.length()];
//            fr.read(all);
//            for (char b : all){
//                System.out.println(b);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Hero[] hs = new Hero[10];
        for (int i = 0; i < 10; i++) {
            hs[i] = new Hero(i);
        }
        File f = new File("./garen.lol");

        try (
                FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis);
             ) {
           oos.writeObject(hs);
           Hero[] h2 = (Hero[]) ois.readObject();
           for (Hero h : h2){
               System.out.printf("hero: %d\n",h.hp);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
