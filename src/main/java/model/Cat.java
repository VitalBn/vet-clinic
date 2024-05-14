package model;

public class Cat extends Pet {

    public Cat() {

    }

    public Cat(String name, String age) {
        this.setName(name);
        this.setAge(age);
    }

    public Cat(String name, String age, Health health) {
        this.setName(name);
        this.setAge(age);
        this.setHealth(health);
    }
}
