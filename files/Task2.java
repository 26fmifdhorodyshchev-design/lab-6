import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Which index would you like to see? ");
            int index = scan.nextInt();
            System.out.println("Planet: " + planets[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: index must be between 0 and " + (planets.length - 1) + ".");
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter an integer.");
        } finally {
            System.out.println("Thank you for using the Planet Finder.");
            scan.close();
        }
    }
}
