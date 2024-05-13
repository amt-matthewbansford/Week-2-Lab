import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {
    private final int length;
    private final int breadth;

    public Area(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int returnArea() {
        return length * breadth;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = 0;
        int breadth = 0;

        try {
            System.out.println("Enter length: ");
            length = scanner.nextInt();
            System.out.println("Enter breadth: ");
            breadth = scanner.nextInt();

//            Creating Object Area
            if (length > 0 && breadth > 0) {
                Area rectangleArea = new Area(length, breadth);
                int area = rectangleArea.returnArea();
                System.out.println("Area of the rectangle: " + area);
            } else {
                System.out.println("Length and breadth must be positive integers");
            }
        }
            catch (InputMismatchException e) {
            System.out.println("Length and breadth should be integers");
        }
        scanner.close();
    }
}


