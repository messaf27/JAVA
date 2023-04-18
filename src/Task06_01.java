import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * NoteBook
 */
class NoteBook {

    static private int idCounter = 0; // static object counter

    private Integer uniqId;
    private Integer ram_gb;
    private Integer hdd_gb;
    private String os_name;
    private String color;

    NoteBook() {
        idCounter++;
        uniqId = idCounter;
        this.hdd_gb = 500;
        this.ram_gb = 16;
        this.os_name = "Windows 10";
        this.color = "Black";
    }

    NoteBook(Integer ram, Integer hdd, String os, String col) {
        this(); // for ++ id
        this.hdd_gb = hdd;
        this.ram_gb = ram;
        this.os_name = os;
        this.color = col;
    }

    public Integer getHDDValue() {
        return this.hdd_gb;
    }

    public Integer getRAMValue() {
        return this.ram_gb;
    }

    public String getColor() {
        return this.color;
    }

    public String getOSName() {
        return this.os_name;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d, Color: %s, RAM: %d GB, HDD: %d GB, OS: %s]",
                uniqId, this.color, this.ram_gb, this.hdd_gb, this.os_name);
    }
}

/**
 * Task06_01
 */
public class Task06_01 {

    public static String[] osNames = new String[] {
            "Windows 7",
            "Windows 10",
            "Windows 11",
            "MacOS",
            "Ubuntu"
    };

    public static String[] colors = new String[] {
            "Dark Gray",
            "Silver",
            "White",
            "Black",
            "Dark Blue"
    };

    public static HashMap<Integer, String> filterParametres = new HashMap<>();

    public static void main(String[] args) {

        HashSet<NoteBook> nbShop = CreateDataBase(15);
        PrintShop(nbShop);

        filterParametres.put(1, "ОЗУ");
        filterParametres.put(2, "Объём ЖД");
        filterParametres.put(3, "Операционная система");
        filterParametres.put(4, "Цвет");

        SetFilter(nbShop, filterParametres);

    }

    public static HashSet<NoteBook> CreateDataBase(int num) {

        HashSet<NoteBook> db = new HashSet<>();

        Random rnd = new Random();

        for (int i = 0; i < num; i++) {
            db.add(
                    new NoteBook(
                            rnd.nextInt(32),
                            rnd.nextInt(2000),
                            osNames[rnd.nextInt(5)],
                            colors[rnd.nextInt(5)]));
        }
        return db;
    }

    public static void PrintShop(HashSet<NoteBook> set) {
        for (NoteBook noteBook : set) {
            System.out.println(noteBook);
        }
    }

    public static void SetFilter(HashSet<NoteBook> set, HashMap<Integer, String> filter) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Задайте критерии фильтра: ");
        for (Entry<Integer, String> f : filter.entrySet()) {
            System.out.println(String.format("%d - %s", f.getKey(), f.getValue()));
        }
        System.out.println("Введите число: ");
        int inputParametrNum = scan.nextInt();

        switch (inputParametrNum) {

            case 1:
                System.out.printf("Введите мин. параметр \"%s\": \n", filter.get(inputParametrNum));
                int minRamVal = scan.nextInt();
                for (NoteBook noteBook : set) {
                    if (noteBook.getRAMValue() <= minRamVal) {
                        System.out.println(noteBook);
                    }
                }
                break;

            case 2:
                System.out.printf("Введите мин. параметр \"%s\": \n", filter.get(inputParametrNum));
                int minHddVal = scan.nextInt();
                for (NoteBook noteBook : set) {
                    if (noteBook.getHDDValue() <= minHddVal) {
                        System.out.println(noteBook);
                    }
                }
                break;

            case 3:
                for (int i = 0; i < osNames.length; i++)
                    System.out.printf("%d - %s\n", i + 1, osNames[i]);

                System.out.printf("Задайте параметр \"%s\": \n", filter.get(inputParametrNum));
                int osVal = scan.nextInt();
                for (NoteBook noteBook : set) {
                    if (noteBook.getOSName().contains(osNames[osVal - 1])) {
                        System.out.println(noteBook);
                    }
                }
                break;

            case 4:
                for (int i = 0; i < osNames.length; i++)
                    System.out.printf("%d - %s\n", i + 1, colors[i]);

                System.out.printf("Задайте параметр \"%s\": \n", filter.get(inputParametrNum));

                int colVal = scan.nextInt();
                for (NoteBook noteBook : set) {
                    if (noteBook.getColor().contains(colors[colVal - 1])) {
                        System.out.println(noteBook);
                    }
                }
                break;
        }
        scan.close();
    }

}
