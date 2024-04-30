package com.magicvet;

import com.magicvet.comparator.DogSizeComparator;
import com.magicvet.comparator.PetAgeComparator;
import com.magicvet.comparator.PetNameComparator;
import model.Cat;
import model.Dog;

import java.util.Arrays;

public class SandBox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS),
                new Dog(Dog.S)
        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Cat[] cats = {
                new Cat("Alisa", "5"),
                new Cat("Melisa", "3"),
                new Cat("Bob", "6"),
                new Cat("Alex", "7"),
                new Cat("Riki", "4"),
        };

        Arrays.sort(cats, new PetAgeComparator());

        for (Cat cat : cats) {
            System.out.println(cat.getAge());
        }

        Arrays.sort(cats, new PetNameComparator());

        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }
    }

}