package job.search;


import job.search.event.impl.AdditionOperation;
import job.search.event.impl.DivisionOperation;
import job.search.event.impl.MultiplyOperation;
import job.search.event.impl.SubtractOperation;
import job.search.event.interfaces.ArithmeticOperationObserver;
import job.search.event.topic.ArithmeticOperation;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestObserverPattern {
    public static void main(String[] args) {

        List<ArithmeticOperationObserver> list = List.of(new AdditionOperation(), new SubtractOperation(), new MultiplyOperation(), new DivisionOperation());
        ArithmeticOperation arithmetic = new ArithmeticOperation();
        list.forEach(arithmetic::subscribe);
        System.out.println("------------------------------------------------------------");

        arithmetic.notify(20, 5);
        System.out.println("------------------------------------------------------------");

        arithmetic.unsubscribe(list.get(0));
        arithmetic.unsubscribe(list.get(3));
        System.out.println("------------------------------------------------------------");

        arithmetic.notify(20, 5);
    }
}