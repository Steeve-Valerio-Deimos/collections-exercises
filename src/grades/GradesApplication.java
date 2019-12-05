package grades;

import java.util.HashMap;
import java.util.Scanner;

public class GradesApplication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HashMap<String, Student> students = new HashMap<>();

        Student joe = new Student("Joe");
        joe.addGrade(70);
        joe.addGrade(80);
        joe.addGrade(90);

        Student amy = new Student("Amy");
        amy.addGrade(90);
        amy.addGrade(99);
        amy.addGrade(94);

        Student danielle = new Student("Danielle");
        danielle.addGrade(30);
        danielle.addGrade(45);
        danielle.addGrade(60);

        Student craig = new Student("Craig");
        craig.addGrade(78);
        craig.addGrade(86);
        craig.addGrade(95);

        students.put("SloppyJoe", joe);
        students.put("AmyMaybe", amy);
        students.put("BetterDanielle9087", danielle);
        students.put("notCraigList",craig);

        System.out.println("Welcome to Github Portal Command Line!");
        System.out.println("\nHere are the Github username of our students:\n");

        for(String i : students.keySet()){
            System.out.printf(" | %s | ",i);
        }
        System.out.println();
        boolean another;

        do{
            System.out.println("\nWhat student would you like to see more information on?");
            String response = sc.nextLine();
            response.trim();

            if(students.containsKey(response)){
                System.out.printf("%nName: %s - Github Username: %s%nCurrent Average: %.2f%n%n", students.get(response).getName(), response, students.get(response).getGradeAverage());
            }else{
                System.out.printf("%nSorry, no student found with the Github username of \"%s\".%n%n", response);
            }

            System.out.println("Would you like to see another student? (Y/N)");
            response = sc.nextLine();
            response = response.trim();

            if(response.equalsIgnoreCase("y")){
                another = true;
            }else{
                another = false;
            }

        }while(another);




    }
}
