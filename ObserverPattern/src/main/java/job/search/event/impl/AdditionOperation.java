package job.search.event.impl;


import job.search.event.interfaces.ArithmeticOperationObserver;

public class AdditionOperation implements ArithmeticOperationObserver {
    protected String name = "Addition Observer";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performOperation(int num1, int num2) {
        System.out.printf("%n sum of %d + %d  = %d", num1, num2, (num1 + num2));
    }
}
