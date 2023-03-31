import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
 * 
 */

public class Task04_00 {

    static  final long OP_NUM = 10_000_000;
    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<>();
        LinkedList<Integer> linkList = new LinkedList<>();
        Random random = new Random();

        long startTime = 0;
        long stopTime = 0;

        System.out.println("========== Задача №04-00 =============");
        
        startTime = System.currentTimeMillis();

        for (var i = 0; i < OP_NUM; i++) {
            arrList.add(random.nextInt(999));
        }

        stopTime = System.currentTimeMillis();
        System.out.println("---------------- ArrayList ---------------");
        // System.out.printf("StartTime: %d\n", startTime);
        // System.out.printf("StopTime: %d\n", stopTime);
        System.out.printf("OpTime ArrList = %d\n", stopTime - startTime);

        startTime = System.currentTimeMillis();

        for (var i = 0; i < OP_NUM; i++) {
            linkList.add(random.nextInt(999));
        }

        stopTime = System.currentTimeMillis();
        System.out.println("---------------- LinkedList --------------");
        // System.out.printf("StartTime: %d\n", startTime);
        // System.out.printf("StopTime: %d\n", stopTime);
        System.out.printf("OpTime LinkList = %d\n", stopTime - startTime);
    }
}
