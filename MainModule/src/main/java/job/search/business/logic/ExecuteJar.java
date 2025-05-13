package job.search.business.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

@FunctionalInterface
public interface ExecuteJar {
    String SPACE = " ";
    String HYPHEN = "-";
    String JAR = "jar";
    String JAVA = "java";
    String SLASH = "\\";
    String TARGET = "target";

    abstract void run();

    static void execute(String command) {
        try {
            String currentDirPath = Paths.get("").toAbsolutePath().toString();
            StringBuffer buffer = new StringBuffer(JAVA).append(SPACE).append(HYPHEN).append(JAR).append(SPACE).append(currentDirPath);
            if (!currentDirPath.contains("target")) {
                buffer.append(SLASH).append(TARGET);
            }
            command = buffer.append(SLASH).append(command).toString();
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
