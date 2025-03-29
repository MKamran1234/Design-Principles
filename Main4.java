import java.util.*;

// Engine interface
interface Engine {
    void move();
}

// Concrete Engine classes
class CombustionEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Moving with combustion engine...");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Moving with electric engine...");
    }
}

// Driver interface
interface Driver {
    void navigate();
}

// Concrete Driver classes
class Human implements Driver {
    @Override
    public void navigate() {
        System.out.println("Human is driving...");
    }
}

class Robot implements Driver {
    @Override
    public void navigate() {
        System.out.println("Robot is navigating...");
    }
}

// Transport class using composition
class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("Delivering " + cargo + " to " + destination);
        driver.navigate();
        engine.move();
    }
}

// Example Usage
public class Main4 {
    public static void main(String[] args) {
        Transport truck = new Transport(new CombustionEngine(), new Human());
        truck.deliver("Warehouse", "Electronics");

        Transport drone = new Transport(new ElectricEngine(), new Robot());
        drone.deliver("Customer", "Package");
    }
}