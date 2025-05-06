package job.search.common;

public enum AmountEnum {
    FIVE_HUNDRED(500l), TWO_HUNDRED(200l), HUNDRED(100l);
    private long currency;

    AmountEnum(Long currency) {
        this.currency = currency;
    }

    public long get() {
        return this.currency;
    }
}
