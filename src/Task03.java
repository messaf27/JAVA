import java.util.Scanner;

// import org.w3c.dom.stylesheets.MediaList;

/*
 * Реализовать простой калькулятор
 */

public class Task03 {

    public static String[] MenuList  = new String[] {
        "Сумма", 
        "Разность", 
        "Произведение", 
        "Деление",
        "Выход"
    };

    public static void main(String[] args) {
        System.out.println("========== Задача №3 =============");

        int oneDigit = GetInputDigit(1);
        int twoDigit = GetInputDigit(2);

        String result = CalcProcess(MenuList, oneDigit, twoDigit);
        System.out.println("==================================");
        System.out.printf("Результат вычисления: %s \n", result);
        System.out.println("==================================");
    }

    static int PrintMenu(String list[]) {
        Scanner scan = new Scanner(System.in);
        boolean inputResult = false;
        int inputDigit = 0;
        System.out.println("----------------------------------");
        System.out.println("Выберете действие: ");
        do{
            for (int i = 0; i < list.length; i++) {
                System.out.printf("[%d] %s \n", i + 1, list[i]);
            }
            System.out.println("----------------------------------");

            inputResult = scan.hasNextInt();
            inputDigit = scan.nextInt();
            if(inputResult) {
                if((inputDigit < 1) 
                || (inputDigit > list.length)) {
                    System.out.printf("Неверный ввод, введите число от %d до %d \n", 1, list.length);
                    inputResult = false;
                }
            } 
        }while(!inputResult);

        scan.close();

        return inputDigit;
    }

    static int GetInputDigit(int digNum){
        int dig = 0;
        boolean flag = false;
        Scanner scan = new Scanner(System.in);


        do {
            System.out.printf("Введите число №%d: ", digNum);
            flag = scan.hasNextInt();

            if(scan.hasNextInt()) {
                dig = scan.nextInt();
                return dig;
            }else{
                System.out.printf("Неверный ввод!!! \n");
            }
            scan.close();

        } while (!flag);

        // while(!flag){

        //     System.out.printf("Введите число №%d: ", digNum);
        //     flag = scan.hasNextInt();

        //     if(scan.hasNextInt()) {
        //         dig = scan.nextInt();
        //         return dig;
        //     }else{
        //         System.out.printf("Неверный ввод!!! \n");
        //     }
        //     scan.close();
        // }

        return dig;
    }

        static String CalcProcess(String list[], int a, int b){
            String result = null;

            switch (PrintMenu(list)) {
                case 1: result = String.format("%d", (int)(a + b));                
                    break;

                case 2: result = String.format("%d", (int)(a - b));                
                    break;

                case 3: result = String.format("%d", (int)(a * b));                
                    break;

                case 4: result = String.format("%.2f", ((float)a/(float)b));             
                    break;

                case 5: result = "Выход из программы";             
                    break;

                default:
                    result = "Пункт меню не найден!!!";    
                    break;
            }

        return result;
    }
}
