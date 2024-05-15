package com.magicvet;

import model.Cat;
import model.Client;
import model.Dog;
import model.Pet;

import java.util.Arrays;
import java.util.Comparator;

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

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });


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

        Arrays.sort(cats, new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                return pet1.getName().compareTo(pet2.getName());
            }
        });

        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }

        Arrays.sort(cats, new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                return Integer.parseInt(pet1.getAge()) - Integer.parseInt(pet2.getAge());
            }
        });

        for (Cat cat : cats) {
            System.out.println(cat.getAge());
        }

        Arrays.sort(cats, new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                return pet1.getHealth().getValue() - pet2.getHealth().getValue();
            }
        });

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " has " + cat.getHealth() + " health.");
        }
        System.out.println(new Cat());
        System.out.println(new Dog());
        System.out.println(new Client());
    }

}