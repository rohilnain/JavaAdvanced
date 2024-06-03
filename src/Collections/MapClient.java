package Collections;

import java.util.*;

public class MapClient {
    public static void main(String[] args) {

        //Map studying using hashMap (it is like unordered_map
        Map<Integer,String>mp=new HashMap<>();
        // Set<Integer>st=new HashSet<>(); //similarly for hashSet
        mp.put(1,"rohil");
        mp.put(8,"romesh");
        mp.put(2,"rohit");
        mp.put(3,"nishu");
        mp.put(5,"heena");
        mp.put(7,"meena");
        for(Map.Entry<Integer,String>entry:mp.entrySet()){
            System.out.println("HashMap key is: "+entry.getKey()+" and value is "+entry.getValue());
        }

        //removing
        mp.remove(7);

        System.out.println(mp);

        //now lets see LinkedHashMap (it maintains the insertion order)
        Map<String,String>mpLinkedHashMap=new LinkedHashMap<>();

        //similarlily Linked Hash Set
        //Set<String>stLinkedHashSet=new LinkedHashSet<>();

        mpLinkedHashMap.put("1","Rohil");
        mpLinkedHashMap.put("6","Yukta");
        mpLinkedHashMap.put("4","anurag");
        mpLinkedHashMap.put("3","rohit");
        mpLinkedHashMap.put("2","romesh");

        for(Map.Entry<String,String>entry:mpLinkedHashMap.entrySet()){
            System.out.println("Linked Hash map value is: "+entry.getKey()+" and value is: "+entry.getValue());
        }

        mpLinkedHashMap.remove("6");
        System.out.println(mpLinkedHashMap);

        //now lets see TreeMap (it contains the key in sorted manner)
        //you can also pass comparator how to sort this
        //if using custom class you can then either implement
        //Comparable interface or pass a comparator when intialising Map
        Map<String,String>mpTreeMap=new TreeMap<>();

        //or pass a comnparator to sort in descending order
        Map<String,String>mpTreeMap2=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        //similarlily Tree  Set
        //Set<String>stTreeSet=new TreeSet<>();

        mpTreeMap.put("1","Rohil");
        mpTreeMap.put("6","Yukta");
        mpTreeMap.put("4","anurag");
        mpTreeMap.put("3","rohit");
        mpTreeMap.put("2","romesh");

        for(Map.Entry<String,String>entry:mpTreeMap.entrySet()){
            System.out.println("Tree map value is: "+entry.getKey()+" and value is: "+entry.getValue());
        }

        mpTreeMap.remove("6");
        System.out.println(mpTreeMap);



        //lets See one for Set also :treeSet

        Set<Student>stTreeStudentSet=new TreeSet<Student>();
        //we have not given comparator here because our student class implements a
        //comparator but if it doesn't then you have to provide one

        stTreeStudentSet.add(new Student("Rohil",24));
        stTreeStudentSet.add(new Student("Anurag",20));
        stTreeStudentSet.add(new Student("Romesh",12));
        stTreeStudentSet.add(new Student("Anubhav",10));
        stTreeStudentSet.add(new Student("Nikita",8));

        for(Student student:stTreeStudentSet){
            System.out.println("Student name is: "+student.getName()+" and value is: "+student.getRollNo());
        }

        stTreeStudentSet.clear();
        System.out.println(stTreeStudentSet);



    }
}
