/*
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.
 */
import java.util.LinkedList;
import java.util.Random;

public class Task04_01 {

    static final int ELEM_NUM = 25;

    static LinkedList<Integer> list = new LinkedList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        
        // Наполняем коллекцию случайными числами от 0 до 100
        for (int i = 0; i < ELEM_NUM; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println("========== Задача №04-01 =============");
        System.out.printf("Исходная коллекция: \n%s\n", list);

        // With For Loop
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(i, list.remove(list.size() - 1));
        }

        // Alternate version
        // Collections.reverse(list);

        System.out.printf("Обращенная коллекция: \n%s\n", list);
        System.out.println("==================================");
    }
}
