import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        writeClass();
        compileMyClass();
        useMyClassLoader();
    }

    private static void compileMyClass() {


    }

    private static void useMyClassLoader() throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> kindClass = classLoader.loadClass("Loader");
        Worker loader = (Worker) kindClass.newInstance();
        loader.doWork();


    }

    public static void writeClass() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("что под саутом");
        String text = scanner.nextLine();

        String starter = "public class Loader implements Worker {\n" +
                "    static {\n" +
                "        System.out.println(\"" + text + "\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void doWork() {\n" +
                "        System.out.println(\"Finish again\");\n" +
                "    }\n" +
                "\n" +
                "}";


        String writer = starter;
        byte[] ba = writer.getBytes();

        FileOutputStream fos = new FileOutputStream("Loader.java");

        fos.write(ba);

    }

}
