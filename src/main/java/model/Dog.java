package model;

import java.util.Objects;

public class Dog extends Pet {

    private String size;

    @Override
    public String toString() {
        return "Pet {" +
                "type = " + super.getType() +
                ", sex = " + super.getSex()+
                ", age = " + super.getAge()+
                ", name = " + super.getName()+
                ", size = " + size +
                ", ownerName= " + super.getOwnerName() +
                "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public void setSize(String size) { this.size = size; }

    public String getSize() { return size; }
}
