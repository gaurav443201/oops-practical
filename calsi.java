import java.util.Scanner;

public class calsi {

    public static double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;

            case '-':
                return num1 - num2;

            case '*':
                return num1 * num2;

            case '/':
                return num1 / num2;

            default:
                System.out.println("Invalid operator!");
                return 0;
        }
    }

  
    public static double calculateUnary(String op, double num) {
        switch (op.toLowerCase()) {
            case "sin":
                return Math.sin(Math.toRadians(num));

            case "cos":
                return Math.cos(Math.toRadians(num));

            case "tan":
                return Math.tan(Math.toRadians(num));

            case "log":
                return Math.log10(num);

            default:
                System.out.println("Invalid function!");
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Basic calculator");
        System.out.print("Enter operator (+, -, *, /) or function (sin, cos, tan, log): ");
        String op = scanner.next();

        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = calculate(num1, num2, op.charAt(0));
            System.out.println("Result: " + result);

        } else {
            System.out.print("Enter number (degrees for sin, cos, tan): ");
            double num = scanner.nextDouble();

            double result = calculateUnary(op, num);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
