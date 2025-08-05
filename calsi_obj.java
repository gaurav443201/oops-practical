import java.util.Scanner;

// Calculator class with instance methods
class Calculator {

    // Binary operation method
    public double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;

            case '-':
                return num1 - num2;

            case '*':
                return num1 * num2;

            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                    return Double.NaN;
                }
                return num1 / num2;

            default:
                System.out.println("Invalid operator!");
                return Double.NaN;
        }
    }

    // Unary operation method
    public double calculateUnary(String op, double num) {
        switch (op.toLowerCase()) {
            case "sin":
                return Math.sin(Math.toRadians(num));

            case "cos":
                return Math.cos(Math.toRadians(num));

            case "tan":
                return Math.tan(Math.toRadians(num));

            case "log":
                if (num <= 0) {
                    System.out.println("Error: Log of non-positive number!");
                    return Double.NaN;
                }
                return Math.log10(num);

            default:
                System.out.println("Invalid function!");
                return Double.NaN;
        }
    }
}

// Main class with main method
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Calculator object
        Calculator calculator = new Calculator();

        System.out.println("Basic calculator");
        System.out.print("Enter operator (+, -, *, /) or function (sin, cos, tan, log): ");
        String op = scanner.next();

        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            // Call the instance method on the calculator object
            double result = calculator.calculate(num1, num2, op.charAt(0));
            System.out.println("Result: " + result);

        } else {
            System.out.print("Enter number (degrees for sin, cos, tan): ");
            double num = scanner.nextDouble();

            // Call the instance method on the calculator object
            double result = calculator.calculateUnary(op, num);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
