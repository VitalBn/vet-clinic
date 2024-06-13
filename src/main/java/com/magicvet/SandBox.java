package com.magicvet;

import model.Cat;
import model.Client;
import model.Dog;
import model.Pet;

import java.util.Arrays;

public class SandBox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S)
        };

        Arrays.sort(dogs, (dog1, dog2) -> dog1.getSize().getValue() - dog2.getSize().getValue());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Cat[] cats = {
                new Cat("Alisa", "5", Pet.Health.NORMAL),
                new Cat("Melisa", "3", Pet.Health.BAD),
                new Cat("Bob", "6", Pet.Health.SO_SO),
                new Cat("Alex", "7", Pet.Health.EXCELLENT),
                new Cat("Riki", "4", Pet.Health.GOOD),
        };

        Arrays.sort(cats, (cat1, cat2) -> cat1.getName().compareTo(cat2.getName()));

        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }

        Arrays.sort(cats, (cat1, cat2) -> Integer.parseInt(cat1.getAge()) - Integer.parseInt(cat2.getAge()));

        for (Cat cat : cats) {
            System.out.println(cat.getAge());
        }

        Arrays.sort(cats, (cat1, cat2) -> cat1.getHealth().getValue() - cat2.getHealth().getValue());

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " has " + cat.getHealth() + " health.");
        }
       /* System.out.println(new Cat());
        System.out.println(new Dog());
        System.out.println(new Client());*/
    }

}