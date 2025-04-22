package job.search.event.topic;


import job.search.event.interfaces.ArithmeticOperationObserver;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperation {

    List<ArithmeticOperationObserver> observerList = new ArrayList<>();

    public void subscribe(ArithmeticOperationObserver observer) {
        observerList.add(observer);
        System.out.printf("%n %s is successfully subscribed ", observer.getName());
    }

    public void unsubscribe(ArithmeticOperationObserver observer) {
        observerList.remove(observer);
        System.out.printf("%n %s is un-subscribed ", observer.getName());
    }

    public void notify(int num1, int num2) {
        observerList.forEach(observer -> observer.performOperation(num1, num2));
    }

}
