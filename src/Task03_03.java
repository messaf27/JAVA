import java.util.ArrayList;
import java.util.Random;

/*
 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. 
 */

public class Task03_03 {
    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random random = new Random();

        System.out.println("========== Задача №03-03 =============");

        // Наполняем коллекцию случайными числами от 0 до 100
        for (int i = 0; i < 163; i++) {
            arrList.add(random.nextInt(777));
        }

        System.out.printf("Исходный список: \n%s\n", arrList);

        int maxNum = 0;
        int minNum = arrList.get(0);
        int avgNum = 0;

        for (Integer integer : arrList) {

            // MAX
            if (integer > maxNum)
                maxNum = integer;
            // MIN
            if (integer < minNum)
                minNum = integer;
        }
        avgNum = arrList.size() / 2;

        System.out.printf("MAX = %d\n", maxNum);
        System.out.printf("MIN = %d\n", minNum);
        System.out.printf("AVG = %d\n", arrList.get(avgNum));
        System.out.println("==================================");
    }
}
