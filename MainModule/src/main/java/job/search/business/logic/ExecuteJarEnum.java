package job.search.business.logic;

import job.search.constant.JarCommandEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static job.search.business.logic.ExecuteJar.execute;

public enum ExecuteJarEnum {

    JAR_LIST(Arrays.stream(JarCommandEnum.values()));

    private List<ExecuteJar> executeJarList = new ArrayList<>();

    ExecuteJarEnum(Stream<JarCommandEnum> jarCommandEnums) {
        jarCommandEnums.forEach(jc -> this.executeJarList.add(() -> execute(jc.command())));
    }

    public List<ExecuteJar> get() {
        return this.executeJarList;
    }

}
