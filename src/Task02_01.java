
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
import org.json.JSONObject;

public class Task02_01 {
    // Исходные данные
    static String sqlRequest = "select * from students where ";
    static String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
    // static String jsonFilter = "{\"name\":\"null\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\", \"freak\":\"No\", \"sex\":\"man\"}";

    public static void main(String[] args) {
        System.out.println("========== Задача №02-01 =============");
        System.out.printf("JsonFilter: %s\n", jsonFilter);
        System.out.printf("SQLRequest: %s\n",getSQLRequestJsonFilter(sqlRequest, jsonFilter));
        System.out.println("======================================");
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
        JSONObject jsonObject = new JSONObject(jsonFilterStr);
        String[] jParamArr  = JSONObject.getNames(jsonObject);
        StringBuilder stringRequestBuild = new StringBuilder();

        PrintParseJson(jsonObject);

        stringRequestBuild.append(sqlReqStr);

        for(int key = 0; key < jParamArr.length; key++){

            if(jsonObject.getString(jParamArr[key]).contains("null"))
                continue;
            else {
                stringRequestBuild.append (
                String.format("%s=%s", 
                    jParamArr[key], 
                    jsonObject.getString(jParamArr[key]))
                );

                if((key < jParamArr.length - 1) && !jsonObject.getString(jParamArr[key + 1]).contains("null"))
                    stringRequestBuild.append(" and ");        
            }           
        }

        requestResultStr = stringRequestBuild.toString();

        return requestResultStr;
    }
}
