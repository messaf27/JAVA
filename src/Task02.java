/*
 * 2. Вывести все простые числа от 1 до 1000
 */
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("========== Задача №1 =============");
        System.out.print("Введите число N: ");
        int n = scan.nextInt();
        System.out.println("------- Натуральные числа --------");
        PrintPrimeNumbers(n);
        System.out.println("==================================");
        scan.close();
    }

    static boolean IsPrime(int x) {
        if (x < 2) 
            return false;

        for (int i = 2; i * i <= x; i++)
        {
            if ((x % i) == 0) 
                return false;
        }
        return true;
    }

    static void PrintPrimeNumbers(int n) {

        for (int i = 0; i < n; i++) {

            if(IsPrime(i)){
                System.out.println(i);
            }
        }
    }
}
