package myapp;

import java.util.List;
import java.io.Console;
import java.util.LinkedList;

public class Workshop01 {
    public static void main(String[] args) {
        // .split()
        // .trim()
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        while (true) {
            String input = cons.readLine();
            input = input.trim().toLowerCase();
            // LIST
            if (input.equals("list")) {
                if (cart.size() == 0) {
                    System.out.println("Your cart is empty");
                } else {
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.printf("%d. %s\n", (i + 1), cart.get(i));
                    }
                }
                // DELETE
            } else if (input.startsWith("delete")) {
                Integer indexDel = (Integer.parseInt(input.split(" ")[1]));
                if (indexDel > cart.size()) {
                    System.err.println("Incorrect item index");
                } else {
                    System.out.printf("%s removed from cart\n", cart.get(indexDel - 1));
                    // cart.remove(indexDel);
                    cart.remove(indexDel - 1);
                }
                // ADD
            } else if (input.startsWith("add")) {
                input = input.replace(",", "");
                String[] addItems = input.split(" ");
                for (int i = 1; i < addItems.length; i++) {
                    if (cart.contains(addItems[i])) {
                        System.err.printf("You have %s in your cart\n", addItems[i]);
                    } else {
                        cart.add(addItems[i]);
                        System.out.printf("%s added to cart\n", addItems[i]);
                    }
                }
            }
        }
    }
}