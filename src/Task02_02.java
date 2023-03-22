/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
import java.io.IOException;
import java.util.logging.*;

public class Task02_02 {
    static int[] intArr  = new int[] {10, 57, 345, 87, 88, 34, 2, 11, 12, 15};
    public static Logger logger = Logger.getLogger(Task02_02.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        // Init Logger Object
        FileHandler fh = new FileHandler(".\\src\\info.log");
        fh.setEncoding("UTF-8");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        System.out.println("========== Задача №02-02 =============");
        System.out.printf("Before: %s\n",getArrString(intArr));
        System.out.println("--------------------------------------");
        bubbleSorter(intArr);
        System.out.println("--------------------------------------");
        System.out.printf("After: %s\n",getArrString(intArr));
        System.out.println("======================================");
    }

    static String getArrString(int arr[]){
        StringBuilder arrStrBuilder = new StringBuilder();

        for (int i : arr) {
            arrStrBuilder.append(i + " ");
        }
        
        return arrStrBuilder.toString();
    }

    static private void writeLog(int first, int second, int arr[]) {
        String logStr = String.format("Меняем местами \"%d\" и \"%d\": [ %s]\n", first, second, getArrString(arr));
        logger.info(logStr);
        // System.out.println(logStr);
    }

    static private void bubbleSorter(int arr[]) {     
        for (int i = arr.length - 1; i >= 1; i--) {  
            for (int j = 0; j < i; j++) {       
                if(arr[j] > arr[j + 1]) {
                    writeLog(arr[j], arr[j + 1], arr);
                    int temp = arr[j];      
                    arr[j] = arr[j + 1];       
                    arr[j + 1] = temp;          
                }                          
            }
        }
    }
}
