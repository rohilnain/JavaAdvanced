package Collections;

import java.util.*;

public class ListClient {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //or
        List<String> list2 = new ArrayList<>(Arrays.asList("nikita", "yukta", "nikita", "rohil"));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
            it2.remove();
        }

        //Size method
        System.out.println(list2.size());


        //List as LinkedList
        List<Integer> l1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (Integer i : l1) {
            if (i % 2 != 0) System.out.println("Odd number " + i);
            else System.out.println("Even number " + i);
        }

        //List as Vector (it increases by 100% when it reaches its capacity
        //unlike ArrayList which increases to 50%

        List<Student> v1 = new Vector<Student>();
        v1.add(new Student("rohil", 1));
        v1.add(new Student("romesh", 2));
        v1.add(new Student("anurag", 3));
        v1.add(new Student("nikta", 4));
        v1.add(new Student("yukta", 5));

        for (Student student : v1) {
            System.out.println("Student name: " + student.getName() + " and Roll No is " + student.getRollNo());
        }

        // v1.sort(); will not work because list sort method requires comparator
        //like this v1.sort(new Comparator<>{.....})

        //but if we use Collections.sort(v1) , it will work and take Comparable interface
        //method from student class

        Collections.sort(v1);
        System.out.println("After sorting in ascending order by implementing comparable interface");
        for (Student student : v1) {
            System.out.println("Student name: " + student.getName() + " and Roll No is " + student.getRollNo());
        }

        //now Collections.sort(v1,comparator)...can also takes comparator
        //and sorting in descending order
        Collections.sort(v1, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getName().compareTo(s1.getName());
            }
        });

        System.out.println("After sorting in descending order by implementing comparator");
        for (Student student : v1) {
            System.out.println("Student name: " + student.getName() + " and Roll No is " + student.getRollNo());
        }

        //now using list sort method with comparator
        v1.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("After sorting in ascending order by implementing list method sort and comparator");
        for (Student student : v1) {
            System.out.println("Student name: " + student.getName() + " and Roll No is " + student.getRollNo());
        }

    }
}
