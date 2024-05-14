import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Price: " + price;
    }
}

class Pizza extends Item {
    private String size;
    private boolean extraSauce;

    public Pizza(String name, double price, String size, boolean extraSauce) {
        super(name, price);
        this.size = size;
        this.extraSauce = extraSauce;
    }

    public String getSize() {
        return size;
    }

    public boolean hasExtraSauce() {
        return extraSauce;
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size + ", Extra Sauce: " + (extraSauce ? "Yes" : "No");
    }
}

public class PizzaShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pizza> order = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for pizza " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Size (M/L): ");
            String size = scanner.nextLine();
            System.out.print("Extra Sauce (Yes/No): ");
            boolean extraSauce = scanner.nextLine().equalsIgnoreCase("Yes");
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            Pizza pizza = new Pizza(name, price, size, extraSauce);
            order.add(pizza);
        }
        System.out.println("Order details:");
        for (Pizza pizza : order) {
            System.out.println(pizza);
        }
        double total = 0;
        for (Pizza pizza : order) {
            total += pizza.getPrice();
        }
        double totalWithVAT = total * 1.20;
        System.out.println("Total with VAT: " + totalWithVAT);
    }
}
 