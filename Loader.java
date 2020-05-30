public class Loader implements Worker {
    static {
        System.out.println("Start app");
    }

    @Override
    public void doWork() {
        System.out.println("Finish app");
    }

}