package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        boolean status;
        do {
            status = coffeeMachine.start();
        } while (status);
    }

    private boolean start() {
        String action = askAction();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return false;
                default:
                    break;
            }
        return true;
    }

    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        System.out.print("> ");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        System.out.print("> ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print("> ");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print("> ");
        this.cups += scanner.nextInt();
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print("> ");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                break;
        }

    }

    private void makeCoffee(int water, int milk, int beans, int price) {
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.money += price;
            this.cups--;
        }
        System.out.println();
    }

    private String askAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print("> ");
        return scanner.next();
    }

    private void printState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }
}
