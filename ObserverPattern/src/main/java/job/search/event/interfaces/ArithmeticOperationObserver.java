package job.search.event.interfaces;

public interface ArithmeticOperationObserver {
    String getName();

    void performOperation(int num1, int num2);
}
