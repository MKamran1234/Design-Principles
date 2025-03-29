import java.util.*;

// Employee interface
interface Employee {
    void doWork();
}

// Concrete Employee classes
class Designer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Designing UI/UX...");
    }
}

class Programmer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Writing code...");
    }
}

class Tester implements Employee {
    @Override
    public void doWork() {
        System.out.println("Testing software...");
    }
}

// Abstract Company class
abstract class Company {
    public abstract List<Employee> getEmployees();

    public void createSoftware() {
        List<Employee> employees = getEmployees();
        for (Employee e : employees) {
            e.doWork();
        }
    }
}

// Concrete Company classes
class GameDevCompany extends Company {
    @Override
    public List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Programmer());
    }
}

class OutsourcingCompany extends Company {
    @Override
    public List<Employee> getEmployees() {
        return Arrays.asList(new Programmer(), new Tester());
    }
}

// Example Usage
public class Main3 {
    public static void main(String[] args) {
        Company gameDev = new GameDevCompany();
        System.out.println("GameDev Company Employees:");
        gameDev.createSoftware();

        Company outsourcing = new OutsourcingCompany();
        System.out.println("Outsourcing Company Employees:");
        outsourcing.createSoftware();
    }
}