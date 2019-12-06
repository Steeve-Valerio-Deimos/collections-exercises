package grades;

import java.util.ArrayList;
import java.util.Comparator;

public class Item {
    String name;
    String category;
    int amount;

    public Item(String name, String category, int amount){
        this.name = name;
        this.category = category;
        this.amount = amount;

    }

   public static Comparator<Item> compareName = new Comparator<Item>() {
       @Override
       public int compare(Item o1, Item o2) {

           int value1 = o1.category.compareTo(o2.category);

           if(value1 != 0){
               return value1;
           }

           return o1.name.compareTo(o2.name);
       }
   };


}
