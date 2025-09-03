package machine;

import java.util.Scanner;

public class UI {
    private final Scanner scanner = new Scanner(System.in);
    private final CoffeeMachine machine = new CoffeeMachine(400,540,120,9, 550);

    public void start() {
        String action;
        do {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            action = scanner.nextLine().trim();
            switch (action) {
                case "buy" -> {
                    if (machine.getCoffeesProduced() >= 10) {
                        System.out.println("I need cleaning!");
                    } else {
                        buyCoffee();
                    }
                }
                case "take" -> takeMoney();
                case "fill" -> fillMachine();
                case "remaining" -> printCoffeeMachine();
                case "clean" -> cleanMachine();
                case "exit" -> {}
                default -> System.out.println("Invalid action");
            }
        } while(!action.equals("exit"));
    }

    public void printCoffeeMachine() {
        String str = """
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d of coffee beans
                %d disposable cups
                $%d of money
                """.formatted(machine.getWater(),
                            machine.getMilk(),
                            machine.getCoffeeBeans(),
                            machine.getDisposableCups(),
                            machine.getMoney());
        System.out.println(str);
    }

    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine().trim();
        if (input.equals("back")) {return;}

        Coffee choice = switch (input) {
            case "1" -> Coffee.ESPRESSO;
            case "2" -> Coffee.LATTE;
            case "3" -> Coffee.CAPPUCCINO;
            default ->  null;
        };
        if (choice == null) return;

        String result = machine.checkResources(choice);
        if (result != null) {
            printNotEnough(result);
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            machine.sellCoffee(choice);
        }
    }

    private void takeMoney() {
        System.out.println("I gave you $" + machine.collectMoney());
    }

    private void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        machine.addWater(readNumber());
        System.out.println("Write how many ml of milk you want to add:");
        machine.addMilk(readNumber());
        System.out.println("Write how many grams of coffee beans you want to add:");
        machine.addCoffeeBeans(readNumber());
        System.out.println("Write how many disposable cups you want to add:");
        machine.addDisposableCups(readNumber());
    }

    private int readNumber() {
        int amount = Integer.parseInt(scanner.nextLine().trim());
        return Math.max(amount, 0);
    }

    private void printNotEnough(String ingredient) {
        System.out.println("Sorry, not enough " + ingredient + "!");
    }

    private void cleanMachine() {
        machine.clean();
        System.out.println("I have been cleaned!");
    }
}
