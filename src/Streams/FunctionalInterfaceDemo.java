package Streams;

public interface FunctionalInterfaceDemo {
    void print();
    default void printIntefaceName(){
        System.out.println("Printing Interface Name: FunctionalInterfaceDemo");
    }
    static public void printAliasName(){
        System.out.println("Printing : It can be written in form of lambda expression");
    }
}
