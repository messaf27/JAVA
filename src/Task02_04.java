/*
 * К калькулятору из предыдущего дз добавить логирование.
 */
import java.util.logging.FileHandler;
import java.util.logging.*;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Scanner;

public class Task02_04 {

    public static String[] MenuList  = new String[] {
        "Сумма", 
        "Разность", 
        "Произведение", 
        "Деление",
        "Выход"
    };

    public static Logger logger = Logger.getLogger(Task02_04.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        // Init Logger Object
        FileHandler fh = new FileHandler(".\\src\\calc.log");
        fh.setEncoding("UTF-8");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        System.out.println("========== Задача №02-04 =============");

        int oneDigit = GetInputDigit(1);
        int twoDigit = GetInputDigit(2);

        String result = CalcProcess(MenuList, oneDigit, twoDigit);
        System.out.println("==================================");
        System.out.printf("Результат вычисления: %s \n", result);
        System.out.println("==================================");
    }

    // static private void writeLog(String logMsg) {
    //     logger.info(logMsg);
    //     logger.inf;
    // }

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
            if(inputResult) {
                inputDigit = scan.nextInt();
                if((inputDigit < 1) 
                || (inputDigit > list.length)) {
                    System.out.printf("Неверный ввод, введите число от %d до %d \n", 1, list.length);
                    logger.log(Level.WARNING, "Ввод для меню не верен!");
                    inputResult = false;
                }
            } 
        }while(!inputResult);

        scan.close();

        logger.log(Level.INFO, String.format("Пользователь выблал пункт меню:\"%d\": %s", inputDigit, list[inputDigit - 1]));

        return inputDigit;
    }

    static int GetInputDigit(int digNum){
        int dig = 0;
        boolean flag = false;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.printf("Введите число №%d: ", digNum);
            logger.log(Level.INFO, "Пользователю предложено ввести число");
            flag = scan.hasNextInt();

            if(flag) {
                dig = scan.nextInt();
                scan.nextLine();
                logger.log(Level.INFO, String.format("Пользователь ввел число \"%d\"", dig));
                return dig;
            }else{
                System.out.printf("Неверный ввод!!! \n");
                logger.log(Level.WARNING, "Не правильный ввод исходных данных (числа)");
            }
            scan.close();

        } while (!flag);

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

        logger.log(Level.INFO, String.format("Результат операции: %s", result));
        return result;
    }
}
