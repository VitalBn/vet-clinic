package model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() {
    }

    public Dog(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "type = " + getType() +
                ", sex = " + getSex() +
                ", age = " + getAge() +
                ", name = " + getName() +
                ", size = " + getSize() +
                ", health = " + getHealth() +
                ", registrationDate = " + getRegistrationDate().format(FORMATTER) +
                ", ownerName= " + getOwnerName() +
                "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public enum Size {

        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Size fromString(String value) {
            for (Size size : values()) {
                if (size.toString().equals(value.toUpperCase())) {
                    return size;
                }
            }
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
    }
}
