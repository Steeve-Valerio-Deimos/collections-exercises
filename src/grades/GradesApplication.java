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
        joe.recordAttendance("2017-10-02", "A");
        joe.recordAttendance("2017-10-03", "P");
        joe.recordAttendance("2017-10-04", "P");
        joe.recordAttendance("2017-10-05", "A");

        Student amy = new Student("Amy");
        amy.addGrade(90);
        amy.addGrade(99);
        amy.addGrade(94);
        amy.recordAttendance("2017-10-02", "P");
        amy.recordAttendance("2017-10-03", "P");
        amy.recordAttendance("2017-10-04", "P");
        amy.recordAttendance("2017-10-05", "P");

        Student danielle = new Student("Danielle");
        danielle.addGrade(30);
        danielle.addGrade(45);
        danielle.addGrade(60);
        danielle.recordAttendance("2017-10-02", "A");
        danielle.recordAttendance("2017-10-03", "a");
        danielle.recordAttendance("2017-10-04", "a");
        danielle.recordAttendance("2017-10-05", "P");

        Student craig = new Student("Craig");
        craig.addGrade(78);
        craig.addGrade(86);
        craig.addGrade(95);
        craig.recordAttendance("2017-10-02", "A");
        craig.recordAttendance("2017-10-03", "P");
        craig.recordAttendance("2017-10-04", "P");
        craig.recordAttendance("2017-10-05", "P");

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
            System.out.println("\nPlease choose from the following:");
            System.out.println("1. Individual Student Record");
            System.out.println("2. Get All Grades From All Students");
            System.out.println("3. View Overall Class Average");
            System.out.println("4. Print CSV Report For All Students");
            System.out.println("5. Check Student Absence Days");
            System.out.println("6. Exit");
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
                                System.out.printf("Current Average: %.2f%n", students.get(response).getGradeAverage());
                                System.out.printf("Attendance Percentage: %.2f%% %n%n", students.get(response).attendancePercentage());

                            } else {
                                System.out.printf("%nSorry, no student found with the Github username of \"%s\".%n%n", response);
                            }

                            System.out.println("Would you like to see another student? (Y/N)");
                            response = sc.nextLine();
                            response = response.trim();

                            if (response.equalsIgnoreCase("y")) {
                                anotherStudent = true;//
                            } else {
                                anotherStudent = false;
                            }

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
                        System.out.printf("Class Total Grade Average %.2f%n", total);

                        break;

                    case 4:

                        System.out.printf("%25s%25s%25s%n", "GitHub Username:", "Average Grades:", "Name:");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        for (HashMap.Entry<String, Student> entry : students.entrySet()) {
                            System.out.printf("%25s%25.2f%25s%n",entry.getKey(), entry.getValue().getGradeAverage(), entry.getValue().getName());
                        }
                        break;
                case 5:
                        sc.nextLine();
                        System.out.println("\nWhat student would you like to see more information on?");
                        String response = sc.nextLine();
                        response.trim();

                        if (students.containsKey(response)) {
                            System.out.println(students.get(response).getName() + " days of absence: ");
                            students.get(response).getAbsences();

                        } else {
                            System.out.printf("%nSorry, no student found with the Github username of \"%s\".%n%n", response);
                        }

                    break;

                    default:
                        another = false;
                        System.out.println("Goodbye, and have a wonderful day!");
                }

//
        }while(another);




    }
}
