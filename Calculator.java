
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            printMenu();

            System.out.print("Choose an option (1-5): ");
            choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Please choose a number from 1 to 5.");
                continue;
            }

            System.out.print("First number: ");
            double a = scanner.nextDouble();

            System.out.print("Second number: ");
            double b = scanner.nextDouble();

            if (choice == 4 && b == 0) {
                System.out.println("Cannot divide by zero.");
                continue;
            }

            double result = calculate(choice, a, b);

            String operator = switch (choice) {
                case 1 -> "+";
                case 2 -> "-";
                case 3 -> "*";
                case 4 -> "/";
                default -> "";
            };

            System.out.printf("%.2f %s %.2f = %.2f%n",
                    a, operator, b, result);

        } while (choice != 5);

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Simple Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
    }

    static double calculate(int choice, double a, double b) {
        switch (choice) {
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                return a / b;
            default:
                return 0;
        }
    }
}
