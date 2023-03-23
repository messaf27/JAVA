/*
 * Дана json-строка (можно сохранить в файл и читать из файла):
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * 
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 * Пример вывода:
 *  Студент Иванов получил 5 по предмету Математика.
 *  Студент Петрова получил 4 по предмету Информатика. 
 *  Студент Краснов получил 5 по предмету Физика.
 */


// Import JSON Lib from https://github.com/stleary/JSON-java
// Locate in this project: .\lib\json-20230227.jar
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task02_03 {
    public static void main(String[] args) throws IOException {

        File dbJson = new File(".\\src\\db.json");
        // PrintFile(dbJson);
        parseJsonFile(dbJson);
    }

    /**
     * @param file
     */
    private static void PrintFile(File file) {
        StringBuilder fileLines = new StringBuilder();
        try {
            String str;
            BufferedReader fileBuff = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

            while ((str = fileBuff.readLine()) != null) {
                // System.out.println(str);
                // fileLines.append(str);
                fileLines.append(str+"\n");
            }
            fileBuff.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(fileLines.toString());
    }

    private static String getStrFromJsonFile(File jsonFile) {
        StringBuilder fileLines = new StringBuilder();
        try {
            String str;
            BufferedReader fileBuff = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile), "UTF8"));

            while ((str = fileBuff.readLine()) != null) {
                // System.out.println(str);
                // fileLines.append(str);
                fileLines.append(str+"\n");
            }
            fileBuff.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileLines.toString();
    }

    private static void parseJsonFile(File jsonFile) {
        JSONObject jsonObject = new JSONObject(getStrFromJsonFile(jsonFile));
        String[] jArr = JSONObject.getNames(jsonObject);

        for (String name : jArr) {
            System.out.println(name);
        }

        // System.out.println(jArr.toString());
    }
}
