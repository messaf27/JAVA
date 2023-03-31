
/*
 * Реализуйте очередь с помощью LinkedList со следующими методами:
    • enqueue() — помещает элемент в конец очереди,
    • dequeue() — возвращает первый элемент из очереди и удаляет его,
    • first() — возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;

import javax.print.attribute.standard.Sides;

public class Task04_02 {

    static LinkedList<Integer> queueList = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("========== Задача №04-02 =============");
        System.out.println(queueString());

        enqueue(10);
        enqueue(12);
        enqueue(20);
        enqueue(234);

        System.out.println(queueString());

        System.out.println(dequeue());
        System.out.println(queueString());
        System.out.println(first());
        System.out.println(queueString());
        
        System.out.println("==================================");
    }

    public static void enqueue(Integer elem) {
        queueList.addLast(elem);
    }

    public static Integer dequeue() {
        int elem = queueList.getFirst();
        queueList.removeFirst();
        return elem;
    }

    public static Integer first() {
        return queueList.getFirst();
    }

    public static String queueString() {
        return queueList.toString();
    }

}
