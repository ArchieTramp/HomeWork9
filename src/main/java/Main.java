import javax.tools.*;
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

    private static void compileMyClass() throws IOException {
        File loaderfile = new File("./Loader.java");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        File parentDirectory = loaderfile.getParentFile();
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(parentDirectory));
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(loaderfile));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
        fileManager.close();

    }

    private static void useMyClassLoader() throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> kindClass = classLoader.loadClass("Loader");
        Worker loader = (Worker) kindClass.newInstance();
        loader.doWork();


    }

    public static void writeClass() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("что под саутами");
        String text = scanner.nextLine();
        String textagain = scanner.nextLine();

        String starter = "public class Loader implements Worker {\n" +
                "    static {\n" +
                "        System.out.println(\"" + text + "\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void doWork() {\n" +
                "        System.out.println(\"" + textagain + "\");\n" +
                "    }\n" +
                "\n" +
                "}";


        String writer = starter;
        byte[] ba = writer.getBytes();

        FileOutputStream fos = new FileOutputStream("Loader.java");

        fos.write(ba);

    }

}
