
/*
 * Иван Иванов 
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 *  Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task05_02 {

    public static String[] arrNames = new String[] {
        "Иван Иванов",
        "Светлана Петрова",
        "Кристина Белова",
        "Анна Мусина",
        "Анна Крутова",
        "Иван Юрин",
        "Петр Лыков",
        "Павел Чернов",
        "Петр Чернышов",
        "Мария Федорова",
        "Марина Светлова",
        "Мария Савина",
        "Мария Рыкова",
        "Марина Лугова",
        "Анна Владимирова",
        "Иван Мечников",
        "Петр Петин",
        "Иван Ежов"    
    };

    public static void main(String[] args) {
        HashMap<String, Integer> mapRaiting = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < arrNames.length; i++) {
            mapRaiting.put(arrNames[i], random.nextInt(5));
        }

        System.out.println("========== Задача №05-02 =============");

        // Сортируем по рейтинку (значению)
        System.out.println("--------------------------------------");
        System.out.println("Вывод сортировка по возврастанию популярности:");
        System.out.println("--------------------------------------");
        mapRaiting.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue()
        .reversed()).forEach(System.out::println);

        HashMap<String, Integer> mapRepPersonNames = new HashMap<>();

        for (Entry<String, Integer> person : mapRaiting.entrySet()) {
            int counter = 0;
            String[] nameArr =  person.getKey().toString().split(" ");
            for (Entry<String, Integer> map : mapRaiting.entrySet()) {
                if(map.getKey().toString().contains(nameArr[0]))
                {
                    counter++;
                    mapRepPersonNames.put(nameArr[0], counter);
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.printf("Результат подсчета повторяющихся имён:\n%s\n", mapRepPersonNames);
        System.out.println("==================================");
    }
}

/*
========== Задача №05-02 =============
--------------------------------------
Вывод сортировка по возврастанию популярности:
--------------------------------------
Марина Лугова=4
Иван Юрин=4
Павел Чернов=4
Петр Чернышов=4
Марина Светлова=3
Иван Иванов=3
Анна Крутова=3
Анна Мусина=1
Мария Федорова=1
Анна Владимирова=1
Иван Ежов=1
Светлана Петрова=0
Иван Мечников=0
Мария Савина=0
Кристина Белова=0
Петр Петин=0
Петр Лыков=0
Мария Рыкова=0
----------------------------------
Результат подсчета повторяющихся имён:
{Мария=3, Марина=2, Светлана=1, Анна=3, Кристина=1, Иван=4, Петр=4, Павел=1}
==================================
*/