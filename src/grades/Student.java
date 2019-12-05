package grades;

import java.util.ArrayList;

public class Student {
    private String studentName;
    private ArrayList<Integer> grades;

    public Student(String name){
        this.studentName = name;
        grades = new ArrayList<>();
    }

    public String getName(){
        return this.studentName;
    }

    public void addGrade(int grade){
        grades.add(grade);
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
