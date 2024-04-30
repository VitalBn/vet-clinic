package com.magicvet;

import com.magicvet.comparator.DogSizeComparator;
import model.Dog;

import java.util.Arrays;

public class SandBox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XXL),
                new Dog(Dog.XXL),
                new Dog(Dog.XS),
                new Dog(Dog.S)
        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }
    }

}