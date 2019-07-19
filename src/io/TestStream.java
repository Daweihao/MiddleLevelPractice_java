package io;

import java.io.*;
import java.util.Scanner;

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
//        Hero[] hs = new Hero[10];
//        for (int i = 0; i < 10; i++) {
//            hs[i] = new Hero(i);
//        }
//        File f = new File("./garen.lol");
//
//        try (
//                FileOutputStream fos = new FileOutputStream(f);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             FileInputStream fis = new FileInputStream(f);
//             ObjectInputStream ois = new ObjectInputStream(fis);
//             ) {
//           oos.writeObject(hs);
//           Hero[] h2 = (Hero[]) ois.readObject();
//           for (Hero h : h2){
//               System.out.printf("hero: %d\n",h.hp);
//           }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        // inputStream as the entrance for system.in
//        try (InputStream is = System.in) {
//            while (true){
//                int i = is.read();
//                System.out.println(i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // scanner class
//        Scanner s= new Scanner(System.in);
//        while (true){
//            String line = s.nextLine();
//            System.out.println(line);
//        }
        //
        File f = new File("./src/io/Model.txt");
        try (
                FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
            String str = "";
//            while (true){
                char cs[] = new char[(int) f.length()];
                fr.read(cs);
                str = new String(cs);
//                String s = br.readLine();
//                if (s == null)break;
//                str += "\n";
//            }
            System.out.println(str);
            Scanner s = new Scanner(System.in);
            System.out.println("input class name: ");
            String name = s.nextLine();
            str=str.replaceAll("@class@", name);
            System.out.println("input attribute type: ");
            str= str.replaceAll("@type@", s.next());
            System.out.println("input attribute name:");
            String s1 = s.next();
            str = str.replaceAll("@property@", s1);
            str = str.replaceAll("@Uproperty@", upperFirst(s1));
            String fileName = name + ".java";

            System.out.printf("替换后: \n%s", str);
            File file = new File("./",fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String upperFirst(String str){
        char c = Character.toUpperCase(str.charAt(0));
        String sub = str.substring(1);
        return c + sub;

    }

}
