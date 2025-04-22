package job.search.event.impl;

import job.search.event.interfaces.ArithmeticOperationObserver;

public class DivisionOperation implements ArithmeticOperationObserver {
    protected String name = "Division Observer";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performOperation(int num1, int num2) {
        System.out.printf("%n division of %d / %d  = %d", num1, num2, (num1 / num2));
    }
}
