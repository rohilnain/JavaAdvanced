package Collections;


import java.util.*;

public class QueueClient {
    public static void main(String[] args) {
        Queue<Integer>q=new LinkedList<>();
        //can be implemented using ArrayDeque also
        //Also PriorityQueue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.poll();//it gives null if queue is empty
            //q.remove();
            //Retrieves and removes the head of this queue.
            // This method differs from poll() only in that it throws an exception
            // if this queue is empty.
        }

        //now lets see deque and its various methods
        Deque<String> dq=new ArrayDeque<>();
        dq.add("rohil");
        dq.add("romesh");
        dq.add("nikita");
        dq.addFirst("yukta");
        dq.addLast("anurag");

        while(!dq.isEmpty()){
            System.out.println(dq.poll());
            //System.out.println(dq.pollLast()); poll from last
        }


        //now lest see implementation of PriorityQueue
        Queue<Integer>pq=new PriorityQueue<>();//min heap
//        Queue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });  //max heap
        pq.add(12);
        pq.add(18);
        pq.add(34);
        pq.add(78);
        pq.add(90);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        //now using priority with a custom class
        PriorityQueue<Student>pqStudent=new PriorityQueue<Student>();
        //in this we haven't passed any comparator as student class is
        //implementing comparabale interafce
        //so for custom class objects we should give comparator or implement comparable
        //interface

        pqStudent.add(new Student("rohil",21));
        pqStudent.add(new Student("anurag",27));
        pqStudent.add(new Student("romesh",2));
        pqStudent.add(new Student("nikita",1));
        pqStudent.add(new Student("yukta",7));

//        for(Student student:pqStudent){
//            System.out.println(student.getName());
//        }  // will not give correct order as it gives min or max element on top
//        children positions can differ
        while(!pqStudent.isEmpty()){
            System.out.println(pqStudent.poll().getName());
        }


        //let's implement stack and see its methods also
        Deque<Integer>stack=new ArrayDeque<Integer>();
        //using LIFO property last in first out (push and pop method)
        stack.push(12);
        stack.push(14);
        stack.push(21);
        stack.push(61);
        stack.push(18);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
            //System.out.println(stack.pop());// same thing above
        }



    }
}
