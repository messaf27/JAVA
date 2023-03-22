
/*
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * 
 * Example:
 *          "select * from students where name=Ivanov and country=Russia and city=Moscow
 * Статья про Json и Java:
 * "How to Parse JSON in Java" -> https://devqa.io/how-to-parse-json-in-java/
 */

// Import JSON Lib from https://github.com/stleary/JSON-java
// Locate in this project: .\lib\json-20230227.jar
import java.text.Format;

import org.json.JSONObject;

public class Task02_01 {
    // Исходные данные
    static String sqlRequest = "select * from students where ";
    static String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    public static void main(String[] args) {
        System.out.println("========== Задача №02-01 =============");
        System.out.printf("Json: %s\n", jsonFilter);

        getSQLRequestJsonFilter(sqlRequest, jsonFilter);

    }

    private static void PrintParseJson(JSONObject jObj) {
        System.out.println("-------------------------------");
        System.out.printf("name: %s\n",     jObj.getString("name")); 
        System.out.printf("country: %s\n",  jObj.getString("country")); 
        System.out.printf("city: %s\n",     jObj.getString("city")); 
        System.out.printf("age: %s\n",      jObj.getString("age")); 
        System.out.println("-------------------------------");
    }

    private static String getSQLRequestJsonFilter(String sqlReqStr, String jsonFilterStr) {
        String requestResultStr = null;

        StringBuilder stringRequestBuild = new StringBuilder();
        JSONObject jsonObject = new JSONObject(jsonFilterStr);

        String[] jParamArr  = new String[jsonObject.length()]; 
        jParamArr = JSONObject.getNames(jsonObject);

        stringRequestBuild.append(sqlReqStr);

        for(int idx = 0; idx < jParamArr.length; idx++){
            System.out.println(jParamArr[idx]);
            stringRequestBuild.append(String.format("%s=%s and", jParamArr[idx], jsonObject.getString(jParamArr[idx])));
        }

        requestResultStr = stringRequestBuild.toString();
        System.out.println(requestResultStr);

        // PrintParseJson(jsonObject);




        return requestResultStr;
    }
}
