package job.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String commandForSingleTon = "java -jar SingleTonPattern-1.0-SNAPSHOT.jar";
        String commandForObserver = "java -jar ObserverPattern-1.0-SNAPSHOT.jar";
        String commandForJava8 = "java -jar Java8Example-1.0-SNAPSHOT.jar";
        executeJar(commandForJava8);
        executeJar(commandForObserver);
        executeJar(commandForSingleTon);

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
