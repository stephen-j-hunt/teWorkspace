import com.techelevator.FlowerOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        FlowerOrder shop = new FlowerOrder("Basic", 0);
        List<FlowerOrder> orders = new ArrayList<>();
        System.out.println(shop);
        File source = new File("FlowerInput.csv");
        try (Scanner input = new Scanner(source)) {

            while (input.hasNextLine()) {

            }

            {
                String[] textLine = input.nextLine().split(",");
                orders.add(new FlowerOrder(textLine[0], Integer.parseInt(textLine[1])));
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("File does not exist");

            FlowerOrder customerOrder = new FlowerOrder(shop.getBoquetType(), shop.getNumberOfRoses());
            orders.add(customerOrder);
            System.out.println(shop.getSubtotal());
        }
        }
}
