abstract class Vehicle {
    String make;
    String model;
    int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public abstract void accelerate();

    public void details(){
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    };

    static class Car extends Vehicle {
        public Car(String make, String model, int year) {
            super(make, model, year);
        }

        @Override
        public void accelerate() {
            System.out.println("The car's acceleration is smooth");
        }
    }

    static class Bike extends Vehicle {
        public Bike(String make, String model, int year) {
            super(make, model, year);
        }

        @Override
        public void accelerate() {
            System.out.println("The bike's acceleration is faster");
        }
    }

    public static void main (String[] args) {
        Vehicle car = new Car ("Toyota","Corolla",2024);
        Vehicle bike = new Bike ("Yamaha","YZF-R1",2024);

//        Printing car details and acceleration behaviour
        System.out.println("Car Details: ");
        car.details();
        System.out.println("Acceleration Behaviour: ");
        car.accelerate();

//        Printing bike details and acceleration Behaviour
        System.out.println("Bike Details: ");
        bike.details();
        System.out.println("Acceleration Behaviour: ");
        bike.accelerate();
    }
}


