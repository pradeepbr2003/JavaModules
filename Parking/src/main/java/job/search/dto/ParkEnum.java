package job.search.dto;

public enum ParkEnum {

    FOUR_WHEEL("4-wheel"), TWO_WHEEL("2-wheel"), ALLOTTED("allotted"), AVAILABLE("available");

    private String value;

    ParkEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
