/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */


public class Task02_02 {
    static int[] intArr  = new int[] {10, 57, 345, 87, 88, 34, 2, 11, 12, 15};

    public static void main(String[] args) {
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

    static private void writeLog(int first, int second) {
        String logStr = String.format("Меняем местами \"%d\" и \"%d\"", first, second);
        System.out.println(logStr);
    }

    static private void bubbleSorter(int arr[]) {     
        for (int out = arr.length - 1; out >= 1; out--){  
            for (int in = 0; in < out; in++) {       
                if(arr[in] > arr[in + 1])
                {
                    writeLog(arr[in], arr[in + 1]);

                    int temp = arr[in];      
                    arr[in] = arr[in + 1];       
                    arr[in + 1] = temp;          
                }                          
            }
        }
    }
}
