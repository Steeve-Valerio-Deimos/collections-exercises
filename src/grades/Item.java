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
           String name1 = o1.name.toLowerCase();
           String name2 = o2.name.toLowerCase();
//
//           String cat1 = o1.category;
//           String cat2 = o2.category;
//
//           return name1.compareTo(name2);
//           int value1 = name1.compareTo(name2);
//
//           if(value1 == 0){
//               int value2 = o1.category.compareTo(o2.category);
//               if(value2 != 0){
//                   return value2;
//               }
//           }
//
//           return value1;
           int value1 = o1.category.compareTo(o2.category);

           if(value1 != 0){
               return value1;
           }

           return o1.name.compareTo(o2.name);
       }
   };


}
