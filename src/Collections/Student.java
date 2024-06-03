package Collections;

public class Student implements Comparable<Student>{
    private String name;
    private Integer rollNo;
    Student(){
        name=null;
        rollNo=0;
    }
    Student(String name,Integer rollNo){
        this.name=name;
        this.rollNo=rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public int compareTo(Student student) {
        return student.getName().compareTo(this.name);
    }
}
