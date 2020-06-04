package day3_OOP;

public class Dog extends Animal {

    // Dog is a Animal
    // Dog has a name

    public Dog(String name) {
        super(name);
    }

    @Override
    public String getName(){
        return "Dog's name is: " + name;
    }

    @Override
    int getNum() {
        return 20;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("jack");
        System.out.println(dog.getName());
        Animal a = new Animal("joe");
        System.out.println(a.getName());

        System.out.println(dog.getNum());


    }

}
