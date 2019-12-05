package grades;

import java.sql.SQLOutput;
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
        boolean another = true;

        do{
            System.out.println("Would you like to see individual grades, or all student grades?");
            System.out.println("1. Individual Grades");
            System.out.println("2. Get All Grades");
            System.out.println("3. View Overall Class Average");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    boolean anotherStudent;
                    do {

                        sc.nextLine();
                        System.out.println("\nWhat student would you like to see more information on?");
                        String response = sc.nextLine();
                        response.trim();

                        if (students.containsKey(response)) {

                            System.out.printf("%nName: %s - Github Username: %s%n", students.get(response).getName(), response);
                            System.out.println("Grades :" + students.get(response).getGrades());
                            System.out.printf("Current Average: %.2f%n%n ", students.get(response).getGradeAverage());

                        } else {
                            System.out.printf("%nSorry, no student found with the Github username of \"%s\".%n%n", response);
                        }

                        System.out.println("Would you like to see another student? (Y/N)");
                        response = sc.nextLine();
                        response = response.trim();
//
                        if (response.equalsIgnoreCase("y")) {
                            anotherStudent = true;//
                        } else {
                            anotherStudent = false;
                        }
//                            a
                    } while (anotherStudent);

                    break;

                    case 2:
                        for (HashMap.Entry<String, Student> entry : students.entrySet()) {
                            System.out.println(entry.getKey() + entry.getValue().getGrades());
                        }
                        break;
                case 3:
                    double total = 0;
                    for (HashMap.Entry<String, Student> entry : students.entrySet()) {
                        total += entry.getValue().getGradeAverage();
                    }
                    total /= students.size();
                    System.out.printf("Total Grades Average %.2f%n", total);
                    break;

                    default:
                        another = false;
                }

//            System.out.println("\nWhat student would you like to see more information on?");
//            String response = sc.nextLine();
//            response.trim();
//
//            if(students.containsKey(response)){
//
//                System.out.printf("%nName: %s - Github Username: %s%n", students.get(response).getName(), response);
//                System.out.println("Grades :" + students.get(response).getGrades());
//                System.out.printf("Current Average: %.2f%n%n ", students.get(response).getGradeAverage());
//
//            }else{
//                System.out.printf("%nSorry, no student found with the Github username of \"%s\".%n%n", response);
//            }
//
//            System.out.println("Would you like to see another student? (Y/N)");
//            response = sc.nextLine();
//            response = response.trim();
//
//            if(response.equalsIgnoreCase("y")){
//                another = true;
//            }else{
//                another = false;
//                System.out.println("Goodbye, and have a wonderful day!");
//            }

        }while(another);




    }
}
