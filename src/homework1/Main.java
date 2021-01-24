package homework1;

public class Main {

    public static void main(String[] args) {

        Box<Apple> apple_Box = new Box<>(new Apple());
        Box<Orange> orange_Box = new Box<>(new Orange());
        Box<Apple> apple_Box1 = new Box<>(new Apple());
        Box<Apple> apple_Box2 = new Box<>(new Apple());
        apple_Box.addFruits(5);
        orange_Box.addFruits(20);
        apple_Box.addFruits(25);

        System.out.println(apple_Box.size());
        System.out.println(orange_Box.size());

        System.out.println(apple_Box.compare(orange_Box));

        apple_Box.changeBox(apple_Box1);
        System.out.println(apple_Box.size());
        System.out.println(apple_Box1.size());
        orange_Box.changeBox(apple_Box2);
        System.out.println(orange_Box.size());
        System.out.println(apple_Box2.size());

    }
}

