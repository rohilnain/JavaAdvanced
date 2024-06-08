package Serialisation;

import java.io.*;

public class SerialisationDemo {
    public static void main(String[] args) {
//        try {
//            writingOnFile();
//        } catch (IOException e) {
//            System.out.println("Catching writing object Exception: " + e);
//        }

        try {
            readingOnFile();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Reading on file: " + e);
        }
//          There are some other input and output streams
//        BufferedInputStream and BufferedOutputStream: Buffer the data for efficient reading and writing.
//        DataInputStream and DataOutputStream: Read and write primitive Java data types.
//        ByteArrayInputStream and ByteArrayOutputStream: Read and write data to and from byte arrays.
//        FilterInputStream and FilterOutputStream: Used to create customized input and output streams.

    }

    private static void writingOnFile() throws IOException {
        FileOutputStream fo = new FileOutputStream("abcd.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        System.out.println("In writing method before writing");

        Student student1 = new Student("Rohil", 22);
        Student student2 = new Student("Rohit", 2);
        oo.writeObject(student1);
        oo.writeObject(student2);
        double e = 7.2;
        oo.writeDouble(e);

        oo.close();
        fo.close();
    }

    private static void readingOnFile() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("/Users/rohilnain/Desktop/JavaAdvanced/JavaAdvanced/abcd.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        Student student1 = (Student) oi.readObject();
        Student student2 = (Student) oi.readObject();
        Double number = oi.readDouble();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(number);

        oi.close();
        fi.close();
    }
}
