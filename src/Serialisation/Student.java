package Serialisation;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -187798789L;

    private String name;
    private Integer rollNo;

    public Student() {
        this.name = null;
        this.rollNo = 0;
    }

    public Student(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
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
    public String toString() {
        return "Student{name='" + name + "', rollNo=" + rollNo + '}';
    }
}
