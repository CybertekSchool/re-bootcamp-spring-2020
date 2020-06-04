package day3_OOP;

public class Animal {

    String name;

    public Animal() {
    name = "No name";
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    int getNum(){
        return 10;
    }

//    @Override
//    public String toString() {
//        return getName();
//    }



}
