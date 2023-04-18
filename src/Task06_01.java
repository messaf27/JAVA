import java.util.HashSet;
import java.util.Random;

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

    NoteBook(){
        idCounter++;
        uniqId = idCounter;
        this.hdd_gb = 500;
        this.ram_gb = 16;
        this.os_name = "Windows 10";
        this.color = "Black";
    }

    NoteBook(Integer ram, Integer hdd, String os, String col){
        this(); // for ++ id
        this.hdd_gb = hdd;
        this.ram_gb = ram;
        this.os_name = os;
        this.color = col;
    }

    @Override
    public String toString(){
        return String.format("Notebook [ID: %d, Color: %s, RAM: %d GB, HDD: %d GB, OS: %s] ", 
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

    public static void main(String[] args) {
        
        HashSet<NoteBook> nbShop = CreateDataBase(200);
        // for (NoteBook noteBook : nbShop) {
        //     System.out.println(noteBook);
        // }

        PrintShop(nbShop);
    }

    public static HashSet<NoteBook> CreateDataBase(int num){

        HashSet<NoteBook> db = new HashSet<>();

        Random rnd = new Random();

        for (int i = 0; i < num; i++) {
            db.add
            (
                new NoteBook
                (
                    rnd.nextInt(32), 
                    rnd.nextInt(2000),
                    osNames[rnd.nextInt(5)],
                    colors[rnd.nextInt(5)]
                )
            );
        }
        return db;
    }  

    public static void PrintShop(HashSet<NoteBook> set)
    {      
        for (NoteBook noteBook : set) {
            System.out.println(noteBook);
        }
    }

}
