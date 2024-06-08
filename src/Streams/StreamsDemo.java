package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        //Lets see functional Interface and lambda expression implementation
        FunctionalInterfaceDemo fid=new FunctionalInterfaceDemo() {
            @Override
            public void print() {
                System.out.println("inside functional interface");
            }
        };

        fid.print();
        fid.printIntefaceName();
        FunctionalInterfaceDemo.printAliasName();

        //now writing it in a form of Lambda Expression
        FunctionalInterfaceDemo fid1= () -> System.out.println("inside functional interface1");

        fid1.print();
        fid1.printIntefaceName();

        List<String>list=new ArrayList<>(Arrays.asList("Ram","Sham","man","monu","sonu","rohil"));
        List<String>list2=list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.length()<=3) return true;
                else return false;
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                String p="name ";
                p+=s;
                return p;
            }
        }).toList();

        System.out.println(list2);

        //now both function and predicate are functional interafec so they can
        //be replaced be with lambda expression

        List<String>list3=list.stream().filter((String s)->{
            return s.length()>3;
        }).map((String s)->{
            return "name "+s;
        }).collect(Collectors.toUnmodifiableList());

        System.out.println(list3);


        //lets implement one more example on streams using lambda expression
        List<Integer> abc = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 1 3 5 7 9
        // 1 9 25 49 81
        // 165


        //find only the odd numbers
        //calculate the square of such numbers
        //sum all the squares and give me the result
        Integer ans=abc.stream().filter((Integer val)->{
            return val%2!=0;
        }).map((Integer val)->{
            return val*val;
        }).reduce(0,(Integer val1,Integer val2)->{
            return val1+val2;
        });

        System.out.println(ans);


    }
}
