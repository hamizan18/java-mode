public class Animal {
    public void speak() {
        System.out.println("Animal sound..");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow meow!");
    }
}