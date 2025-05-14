package job.search.constant;

public enum GenericEnum {
    SPACE(" "),
    HYPHEN("-"),
    JAR("jar"),
    JAVA("java"),
    SLASH("\\"),
    TARGET("target");

    private String value;

    GenericEnum(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }

}
