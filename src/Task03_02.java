import java.util.ArrayList;

/*
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */

 import java.util.Random;

public class Task03_02 {

    public static void main(String[] args) {
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random random = new Random();

        System.out.println("========== Задача №03-02 =============");

        for (int i = 0; i < 20; i++) {
            arrList.add(random.nextInt(100));
        }

        System.out.printf("Исходный список: \n%s\n", arrList);

        for (int i = 0; i < arrList.size(); i++) {
             if((arrList.get(i) % 2) == 0)
             {
                arrList.remove(i);
             }
        }

        System.out.printf("Список без чётных чисел: \n%s\n", arrList);
        System.out.println("==================================");
    }
        
}  

