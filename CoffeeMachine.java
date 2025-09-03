package machine;


public class CoffeeMachine {
    private int milk;
    private int water;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private int coffeesProduced = 0;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.milk = milk;
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void makeCoffee(int water,  int milk, int coffeeBeans) {
        this.water -= water;
        this.milk -= milk;
        this.coffeeBeans -= coffeeBeans;
        disposableCups--;
        coffeesProduced++;
    }

    public void sellCoffee(Coffee coffee) {
        makeCoffee(coffee.getWater(), coffee.getMilk(), coffee.getCoffeeBeans());
        money += coffee.getPrice();
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public int getCoffeesProduced() {
        return coffeesProduced;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public void addDisposableCups(int disposableCups) {
        this.disposableCups += disposableCups;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void setCoffeesProduced(int coffeesProduced) {
        this.coffeesProduced = coffeesProduced;
    }

    public int collectMoney() {
        int aux = money;
        money = 0;
        return aux;
    }

    private boolean isThereEnough(int ingredient, int amount) {
        return ingredient >= amount;
    }

    public String checkResources(Coffee coffee) {
        if (!isThereEnough(water, coffee.getWater())) return "water";
        if (!isThereEnough(milk, coffee.getMilk())) return "milk";
        if (!isThereEnough(coffeeBeans, coffee.getCoffeeBeans())) return "coffee beans";
        if (!isThereEnough(disposableCups,1)) return "disposable cups";
        return null;
    }

    public void clean() {
        this.coffeesProduced = 0;
    }
}