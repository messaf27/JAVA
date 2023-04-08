
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
import java.util.TreeMap;
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
        // TreeMap<String, Integer> map = new TreeMap<>();
        HashMap<String, Integer> mapRaiting = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < arrNames.length; i++) {
            mapRaiting.put(arrNames[i], random.nextInt(5));
        }

        // Сортируем по рейтинку (значению)
        // mapRaiting.entrySet().stream()
        // .sorted(Map.Entry.<String, Integer>comparingByValue()
        // .reversed()).forEach(System.out::println);

        HashMap<String, Integer> mapRepPersonNames = new HashMap<>();

        for (Entry<String, Integer> person : mapRaiting.entrySet()) {
            // System.out.println(person.getKey());
            String[] nameArr =  person.getKey().toString().split(" ");
            // System.out.println(nameArr[0]);
            int counter = 0;

            for (Entry<String, Integer> map : mapRaiting.entrySet()) {
                if(map.getKey().toString().contains(nameArr[0]))
                {
                    counter++;
                    mapRepPersonNames.put(map.getKey(), counter);
                }
            }
        }

        System.out.println(mapRepPersonNames);
    }
}
