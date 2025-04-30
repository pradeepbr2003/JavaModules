package job.search.business.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static job.search.constant.ExecuteJarEnum.*;

public interface IMain {

    List<ExecuteJar> jarList =
            List.of(() -> execute(JAVA_STREAM.command()),
                    () -> execute(OBSERVER.command()),
                    () -> execute(JOB_SEARCH.command()),
                    () -> execute(JOB_SEARCH.command()),
                    () -> execute(LIFT_PROGRAM.command()),
                    () -> execute(SINGLETON.command()));

    private static void execute(String command) {
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
