package job.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static job.search.common.ExecuteJarEnum.*;

public interface IMain {

    List<Runnable> runnableJars =
            List.of(() -> executeJar(JAVA_STREAM.command()),
                    () -> executeJar(OBSERVER.command()),
                    () -> executeJar(JOB_SEARCH.command()),
                    () -> executeJar(JOB_SEARCH.command()),
                    () -> executeJar(LIFT_PROGRAM.command()),
                    () -> executeJar(SINGLETON.command()));

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
