package grades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GroceryList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> groceryList = new ArrayList<>();

        System.out.println("Welcome and come to create a Grocery List!");
        System.out.println("Would you like to create a Grocery List?");
        String response = sc.nextLine();
        response = response.trim();

        do{
            System.out.println("Choose from the following categories:");
            System.out.println("1. Produce");
            System.out.println("2. Dairy");
            System.out.println("3. Deli");
            int category = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the name of product");
            String productName = sc.nextLine();
            productName = productName.trim();
            System.out.printf("How many of the %s do you need?%n", productName);
            int amount = sc.nextInt();
            Item item;

           switch (category){
               case 1:
                   item = new Item(productName, "Produce", amount);
                   break;
               case 2:
                   item = new Item(productName, "Dairy", amount);
                   break;
               case 3:
                   item = new Item(productName, "Deli", amount);
                   break;
               default:
                   item = new Item(productName, "Dairy", amount);
                   break;
           }

           groceryList.add(item);

            System.out.println("What is the next step?");
            System.out.println("1. Add Item.");
            System.out.println("2. Complete list.");
            int step = sc.nextInt();

            if(step == 1){
                response = "y";
            }else{
                response = "n";
            }

        }while(response.equalsIgnoreCase("y"));

        printArray(groceryList);
    }

    public static void printArray(ArrayList<Item> list){
        if(!list.isEmpty()){
            Collections.sort(list, Item.compareName);
            for(int i=0; i < list.size(); i++){
                System.out.printf("| %s | %s | %d |%n",list.get(i).name,list.get(i).category, list.get(i).amount);
            }
        }
    }
}
