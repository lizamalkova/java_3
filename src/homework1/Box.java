package homework1;

import java.util.ArrayList;

public class Box<T> {

    private float weight;
    private T type;
    private ArrayList<T> fruits;

    public Box(T type) {
        fruits = new ArrayList<>();
        this.type = type;
    }

    public int size() {
        return fruits.size();
    }

    public void addFruits(int count) {
        if (type instanceof Apple) {
            for (int i = 0; i < count; i++) {
                fruits.add((T) new Apple());
                weight += (new Apple().getWeight());
            }
        } else if (type instanceof Orange) {
            for (int i = 0; i < count; i++) {
                fruits.add((T) new Orange());
                weight += (new Orange().getWeight());
            }
        }
    }

    public boolean compare(Box box) {
        return this.weight == box.weight;
    }

    public void changeBox(Box box) {
        if (box.type.getClass().equals(this.type.getClass())) {
        for (int i = fruits.size(); i > 0; i--) {
            box.addFruits(1);
            fruits.remove(0);
        }} else {
            System.out.println("Нельзя смешивать фрукты!");
        }

    }
}