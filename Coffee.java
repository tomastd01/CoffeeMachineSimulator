package machine;

public enum Coffee {
    CAPPUCCINO("Cappuccino", 200, 100, 12, 6),
    LATTE("Latte", 350, 75, 20, 7),
    ESPRESSO("Espresso", 250,0,16,4);

    private final String name;
    private final int milk;
    private final int water;
    private final int coffeeBeans;
    private final int price;

    Coffee(String name, int water, int milk, int coffeeBeans, int price) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
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

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name;
    }
}
