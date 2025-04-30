package job.search.business.logic;

import java.util.List;

import static job.search.business.logic.ExecuteJar.execute;
import static job.search.constant.JarCommandEnum.*;

public enum ExecuteJarEnum {
    JAR_LIST(List.of(() -> execute(JAVA_STREAM.command()), () -> execute(OBSERVER.command()), () -> execute(JOB_SEARCH.command()), () -> execute(JOB_SEARCH.command()), () -> execute(LIFT_PROGRAM.command()), () -> execute(SINGLETON.command())));

    private List<ExecuteJar> executeJarList;

    ExecuteJarEnum(List<ExecuteJar> executeJarList) {
        this.executeJarList = executeJarList;
    }

    public List<ExecuteJar> get() {
        return this.executeJarList;
    }

}
