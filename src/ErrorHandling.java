public class ErrorHandling {
    public static void divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Dividing by zero is not allowed");
        } else {
            System.out.println(num1 / num2);
        }
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 0;

        try {
            divide(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
