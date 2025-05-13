package job.search.constant;

public enum JarCommandEnum {
    MOVIE_EXAMPLE("MovieShowExample-1.0-SNAPSHOT.jar"),
    LIBRARY_EXAMPLE("LibraryExample-1.0-SNAPSHOT.jar"),
    ATM_EXAMPLE("ATMExample-1.0-SNAPSHOT.jar"),
    JAVA_STREAM("Java8Example-1.0-SNAPSHOT.jar"),
    JOB_SEARCH("JobSearchExample-1.0-SNAPSHOT.jar"),
    OBSERVER("ObserverPattern-1.0-SNAPSHOT.jar"),
    PARKING_LOT("ParkingExample-1.0-SNAPSHOT.jar"),
    LIFT_PROGRAM("LiftExample-1.0-SNAPSHOT.jar"),
    SINGLETON("SingleTonPattern-1.0-SNAPSHOT.jar");

    private String command;

    JarCommandEnum(String command) {
        this.command = command;
    }

    public String command() {
        return this.command;
    }
}
