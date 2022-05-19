package deadlock;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Deadlock {

    public static void main(String[] args) {

        Colleague colleague1 = new Colleague("Olivia");
        Colleague colleague2 = new Colleague("Daniel");
        ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        tp.execute(new Thread(() -> colleague1.ask(colleague2)));
        tp.execute(new Thread(() -> colleague2.ask(colleague1)));
        tp.shutdown();
    }
}
