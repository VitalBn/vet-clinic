package com.magicvet.comparator;

import model.Dog;

import java.util.Comparator;

public class DogSizeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return convertSize(dog1.getSize()) - convertSize(dog2.getSize());
    }

    public static int convertSize(String size) {
        int value;
        switch (size) {
            case Dog.XS:  value = 1;
            break;
            case Dog.S:   value = 2;
            break;
            case Dog.M:   value = 3;
            break;
            case Dog.L:   value = 4;
            break;
            case Dog.XXL: value = 5;
            break;
            default:      value = 0;
        }
        return value;
    }
}
