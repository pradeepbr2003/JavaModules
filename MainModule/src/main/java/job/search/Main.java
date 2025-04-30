package job.search;

public class Main implements IMain {

    public static void main(String[] args) {
        runnableJars.forEach(Runnable::run);
    }
}
