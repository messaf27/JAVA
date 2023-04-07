import java.util.ArrayList;
import java.util.HashMap;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

public class Task05_01 {

    public static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    public static void main(String[] args) {

        System.out.println("========== Задача №05-01 =============");
        phoneBook.put("Ivanov Ivan", new ArrayList<String>());
        phoneBook.get("Ivanov Ivan").add("+79247895634");
        phoneBook.get("Ivanov Ivan").add("+75698712368");

        phoneBook.put("Petrov Vasiliy", new ArrayList<String>());
        phoneBook.get("Petrov Vasiliy").add("+79247823454");
        phoneBook.get("Petrov Vasiliy").add("+75555712368");
        phoneBook.get("Petrov Vasiliy").add("+75555733368");

        phoneBook.put("Pupkin Fedor", new ArrayList<String>());
        phoneBook.get("Pupkin Fedor").add("+79247823454");

        System.out.println(phoneBook);
        System.out.println("======================================");
    }
}

/*
 * Terminal out: 
* ========== Задача №05-01 =============
* {Petrov Vasiliy=[+79247823454, +75555712368, +75555733368], Ivanov Ivan=[+79247895634, +75698712368], Pupkin Fedor=[+79247823454]}
* ======================================
 */
