package job.search;

import job.search.business.logic.ExecuteJar;

import static job.search.business.logic.ExecuteJarEnum.JAR_LIST;

public class Main {
    public static void main(String[] args) {
        JAR_LIST.get().forEach(ExecuteJar::run);
    }
}
