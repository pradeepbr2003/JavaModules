package job.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static job.search.ExecuteJarEnum.*;

public class Main {

    public static void main(String[] args) {
        Runnable singleTonRunnable = () -> executeJar(SINGLETON.command());
        Runnable observerRunnable = () -> executeJar(OBSERVER.command());
        Runnable java8Runnable = () -> executeJar(JAVA_STREAM.command());
        Runnable liftProgramRunnable = () -> executeJar(LIFT_PROGRAM.command());

        java8Runnable.run();
        observerRunnable.run();
        liftProgramRunnable.run();
        singleTonRunnable.run();
    }

    private static void executeJar(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
