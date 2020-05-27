import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static List<String > list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//        Worker worker = new Loader();
//        worker.doWork();

        write();
        useMyClassLoader();
    }

    private static void useMyClassLoader() throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> kindClass = classLoader.loadClass("Loader");
        Worker loader = (Worker) kindClass.newInstance();
        loader.doWork();


    }
    public static void write(){
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        if (x == "") {
            System.out.println("stop");
                    }
        list.add(x);
        System.out.println(list);
    }
}
