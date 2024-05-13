public class Shape {
    public double calculateArea() {
        return 0.0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }

//    Creating Circle subclass
    public static class Circle extends Shape {
        public double radius;

//        constructor
    public Circle(double radius) {
        this.radius = radius;
    }

//    Circle methods
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

    public static class Rectangle extends Shape {
        public double length;
        public double width;

        //        constructors
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        //        Rectangle methods
        @Override
        public double calculateArea() {
            return length * width;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle(7, 10);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
    }
}