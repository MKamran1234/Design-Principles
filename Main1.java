import java.util.*;

// Interface for food
interface Food {
    int getNutrition();
}

// Concrete Food class
class Sausage implements Food {
    private int nutrition;
    private String color;
    private Date expiration;

    public Sausage(int nutrition, String color, Date expiration) {
        this.nutrition = nutrition;
        this.color = color;
        this.expiration = expiration;
    }

    @Override
    public int getNutrition() {
        return nutrition;
    }

    public String getColor() {
        return color;
    }

    public Date getExpiration() {
        return expiration;
    }
}

// Cat class that now depends on Food interface
class Cat {
    private int energy;

    public Cat() {
        this.energy = 0;
    }

    public void eat(Food food) {
        this.energy += food.getNutrition();
    }

    public int getEnergy() {
        return energy;
    }
}

// Example Usage
public class Main1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Food sausage = new Sausage(50, "Brown", new Date());
        cat.eat(sausage);
        System.out.println("Cat's energy: " + cat.getEnergy());
    }
}