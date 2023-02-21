import com.techelevator.FlowerOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        FlowerOrder shop = new FlowerOrder("",0);
        List<FlowerOrder> orders = new ArrayList<>();
        File sourceFile = new File("FlowerInput.csv");
        try (Scanner input = new Scanner(sourceFile)) {
            while (input.hasNextLine()) {
                String[] textLine = input.nextLine().split(",");
                orders.add(new FlowerOrder(textLine[0], Integer.parseInt(textLine[1])));
            }
            } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
       // System.out.println(orders);
        double totalBalance = 0.00;
        for (double i = 0.0; i< orders.size(); i++) {
            totalBalance += orders.get((int) i).getSubtotal();
            System.out.println(orders.get((int) i));
        }
        System.out.format("The total balance = %2f",totalBalance);
    }
}
