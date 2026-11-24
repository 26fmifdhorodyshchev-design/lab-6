import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Uncrashable Calculator === (введіть exit для виходу)");

        while (true) {
            try {
                System.out.print("Перше число: ");
                if (scan.hasNext("(?i)exit")) break;
                double a = scan.nextDouble();      // InputMismatchException, якщо не число

                System.out.print("Операція (+, -, *, /): ");
                if (scan.hasNext("(?i)exit")) break;
                String op = scan.next();

                System.out.print("Друге число: ");
                if (scan.hasNext("(?i)exit")) break;
                double b = scan.nextDouble();

                double result;
                switch (op) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("Cannot divide by zero!");
                        }
                        result = a / b;
                        break;
                    default:
                        System.out.println("Невідома операція: " + op);
                        continue;
                }
                System.out.println("Результат: " + a + " " + op + " " + b + " = " + result);

            } catch (InputMismatchException e) {
                System.out.println("Помилка: потрібно ввести число, а не літери!");
                scan.nextLine(); // очищення буфера, щоб цикл не став нескінченним
            } catch (ArithmeticException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        System.out.println("Калькулятор завершив роботу.");
        scan.close();
    }
}
