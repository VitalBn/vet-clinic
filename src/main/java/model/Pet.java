package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private Health health;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "Pet {" +
                "type = " + type +
                ", sex = " + sex +
                ", age = " + age +
                ", name = " + name +
                ", health = " + health +
                ", registrationDate = " + registrationDate.format(FORMATTER) +
                ", ownerName= " + ownerName +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type) &&
                Objects.equals(sex, pet.sex) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(health, pet.health) &&
                Objects.equals(registrationDate, pet.registrationDate) &&
                Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, health, registrationDate, ownerName);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public enum Health {

        BAD(1),
        SO_SO(2),
        NORMAL(3),
        GOOD(4),
        EXCELLENT(5),
        UNKNOWN(0);

        private final int value;

        Health(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Pet.Health fromString(String value) {
            for (Pet.Health health : values()) {
                if (health.toString().equals(value.toUpperCase())) {
                    return health;
                }
            }
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }

    }
}
