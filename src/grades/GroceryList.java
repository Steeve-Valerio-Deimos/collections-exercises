package grades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GroceryList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> groceryList = new ArrayList<>();

        System.out.println("\nWelcome and come to create a Grocery List!");
        System.out.println("\nWould you like to create a Grocery List?(Y/N)");
        String response = sc.nextLine();
        response = response.trim();

        if(response.equalsIgnoreCase("y")) {

            do {
                System.out.println("What is the next step?");
                System.out.println("1. Add Item.");
                System.out.println("2. Edit List Item");
                System.out.println("3. Remove List Item");
                System.out.println("4. Complete list.");
                int step = sc.nextInt();

                switch (step){
                    case 1:
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

                        switch (category) {
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
                                item = new Item(productName, "Undefined", amount);
                                break;
                        }

                        groceryList.add(item);
                        response = "y";
                        break;
                    case 2:
                        printArray(groceryList);
                        System.out.println("Please select the item to edit:");
                        int index = sc.nextInt();
                        System.out.printf("You selected %s in %s with the amount of %d to edit....%n",groceryList.get(index).name,groceryList.get(index).category, groceryList.get(index).amount);
                        System.out.println("Enter the new quantity on your item:");
                        int newQuantity = sc.nextInt();
                        System.out.printf("Your new item is %s in %s with the amount of %d....%n",groceryList.get(index).name,groceryList.get(index).category, newQuantity);
                        item = new Item(groceryList.get(index).name, groceryList.get(index).category, newQuantity);
                        groceryList.remove(index);
                        groceryList.add(index, item);
                        printArray(groceryList);
                        response = "y";
                        break;
                    case 3:
                        printArray(groceryList);
                        System.out.println("Please select the item to remove:");
                        int index2 = sc.nextInt();
                        System.out.printf("You selected %s in %s with the amount of %d to remove....%n",groceryList.get(index2).name,groceryList.get(index2).category, groceryList.get(index2).amount);
                        System.out.println("Is this correct? (Y/N)");
                        String removeYN = sc.next();
                        removeYN = removeYN.trim();

                        if(removeYN.equalsIgnoreCase("y")){
                            groceryList.remove(index2);
                            System.out.println("Item removed from list.");
                            printArray(groceryList);
                        }

                        response = "y";
                        break;
                    case 4:
                        response = "n";
                        break;
                    default:
                        response = "y";
                        break;
                }


            } while (response.equalsIgnoreCase("y"));

            System.out.println("Do you want to print the completed list or by category?");
            System.out.println("1. Complete List");
            System.out.println("2. By Category");
            int choice = sc.nextInt();

            if (choice == 1) {
                printArray(groceryList);
            } else if (choice == 2) {
                System.out.println("Choose from the following categories:");
                System.out.println("1. Produce");
                System.out.println("2. Dairy");
                System.out.println("3. Deli");
                int catChoice = sc.nextInt();

                switch (catChoice) {
                    case 1:
                        printCategory(groceryList, "Produce");
                        break;
                    case 2:
                        printCategory(groceryList, "Dairy");
                        break;
                    case 3:
                        printCategory(groceryList, "Deli");
                        break;
                    default:
                        System.out.println("Incorrect Category...Displaying all items.");
                        printArray(groceryList);
                }
            }

        }else {
            System.out.println("Thank you for using the Grocery List App...");
            System.out.println("Have a nice day...");
        }

    }

    public static void printArray(ArrayList<Item> list){
        if(!list.isEmpty()){
            Collections.sort(list, Item.compareName);

            System.out.println("No    Name        Category    Amount");
            System.out.println("-------------------------------------");

            for(int i=0; i < list.size(); i++){
                System.out.printf("%-3d | %-10s | %-10s | %-10d |%n",i,list.get(i).name,list.get(i).category, list.get(i).amount);
            }
        }
    }

    public static void printCategory(ArrayList<Item> list, String category){
        Collections.sort(list, Item.compareName);
        System.out.println("  Name        Category     Amount");
        System.out.println("----------------------------------");

        for(int i=0; i < list.size(); i++){
            if(list.get(i).category.equals(category)){
                System.out.printf("| %-10s | %-10s | %-10d |%n",list.get(i).name,list.get(i).category, list.get(i).amount);
            }

        }
    }
}
