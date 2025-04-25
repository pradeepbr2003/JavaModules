package job.search;

public enum ExecuteJarEnum {
    SINGLETON("java -jar SingleTonPattern-1.0-SNAPSHOT.jar"),
    OBSERVER("java -jar ObserverPattern-1.0-SNAPSHOT.jar"),
    JAVA_STREAM("java -jar Java8Example-1.0-SNAPSHOT.jar"),
    LIFT_PROGRAM("java -jar LiftExample-1.0-SNAPSHOT.jar");

    private String command;

    ExecuteJarEnum(String command) {
        this.command = command;
    }

    String command() {
        return this.command;
    }
}
