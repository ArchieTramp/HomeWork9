public class Loader implements Worker {
    static {
        System.out.println("qq");
    }

    @Override
    public void doWork() {
        System.out.println("er");
    }

}