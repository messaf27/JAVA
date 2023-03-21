import java.util.Scanner;

/*
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */

public class Task01 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
    
        System.out.println("========== Задача №1 =============");
        System.out.print("Введите число N: ");
        int n = scan.nextInt();
        System.out.println("----------------------------------");
        System.out.printf("Треугольное число = %d \n", NumCompute(n));
        System.out.println("==================================");
        scan.close();
    }

    static int NumCompute(int n) {
        int result = 0;

        for(int i = 0; i < n; i++) {
            // System.out.print(result);
            result += i; 
            // System.out.printf(" + %d = %d\n", i, result);
        }

        return result;
    }
}
