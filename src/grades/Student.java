package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String studentName;
    private ArrayList<Integer> grades;
    private HashMap<String, String> attendance;

    public Student(String name){
        this.studentName = name;
        grades = new ArrayList<>();
        attendance = new HashMap<>();
    }

    public String getName(){
        return this.studentName;
    }

    public ArrayList<Integer> getGrades() { return this.grades; }

    public void recordAttendance(String date, String value){
        if(value.equalsIgnoreCase("a") || value.equalsIgnoreCase("p")){
            attendance.putIfAbsent(date, value.toUpperCase());
        }else {
            System.out.println("Incorrect format for recording attendance");
        }

    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public double attendancePercentage(){
        double total = 0;
        double totAbsences = 0;

        for (HashMap.Entry<String, String> entry : attendance.entrySet()) {
            if(entry.getValue().equals("A")){
                totAbsences ++;
            }
        }

        total = ((attendance.size() - totAbsences) / attendance.size())*100;
        return total;
    }

    public void getAbsences(){
        int counter = 0;

        for (HashMap.Entry<String, String> entry : attendance.entrySet()) {
            if(entry.getValue().equals("A")){
                System.out.printf("| %s |%n", entry.getKey());
                counter++;
            }
        }

        if(counter == 0){
            System.out.println("N/A");
        }
    }

    public double getGradeAverage(){
        double total = 0;

        if(!grades.isEmpty()){
            for(int i=0; i < grades.size(); i++){
                total += grades.get(i);
            }

            total = total / grades.size();
        }

        return total;
    }

    public static void main(String[] args){
        Student joe = new Student("Joe");
        Student amy = new Student("Amy");

        System.out.println(joe.getName());
        joe.addGrade(90);
        joe.addGrade(78);
        joe.addGrade(80);
        System.out.println("Average: " + joe.getGradeAverage());

        System.out.println(amy.getName());
        System.out.println(amy.getGradeAverage());
        amy.addGrade(50);
        amy.addGrade(60);
        System.out.println("Average: " + amy.getGradeAverage());
    }
}
