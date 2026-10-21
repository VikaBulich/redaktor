package model;

public class Dog implements SpeakBehavior{
    @Override
    public String speak() {
        return "gav - gav";
    }
}
