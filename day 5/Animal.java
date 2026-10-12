public class Animal {
    public void Sound(){
        System.out.println("I am an animal");
    }
}

 class Dog extends Animal{
    public void Sound(){
        System.out.println("Barks");
    }
}

 class Cat extends Animal{
    public void Sound(){
        System.out.println("Meows");
    }
}

 class Main{
    public static void main(String[] args) {
        Animal obj1=new Dog();
        Animal obj2=new Cat();
        obj1.Sound();
        obj2.Sound();
    }
}
