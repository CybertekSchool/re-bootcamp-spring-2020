package day4_OOP;

public class HomePage extends NavBar implements LoginOption{

    @Override
    public void clickNext() {
        System.out.println("Go to store page");
    }

    @Override
    public void signIn() {

    }

    // Elements for HomePage


}
