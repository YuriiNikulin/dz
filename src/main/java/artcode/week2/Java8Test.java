package artcode.week2;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 28.01.17.
 */
public class Java8Test {

    public static final int MIN_USER_AGE = 18;
    public static final int MAX_USER_AGE = 80;


    public static void main(String[] args) {




    }

    public List<User> generateUsers(int size){
        List<User> users = Stream.generate(() -> {

            String name = UUID.randomUUID().toString();
            int userAge = MIN_USER_AGE + (int) (Math.random() * (MAX_USER_AGE - MIN_USER_AGE));

            int randomPetTypeIndex = (int) (Math.random() * PetType.values().length);
            PetType randomType = PetType.values()[randomPetTypeIndex];

            return new User(name,
                    userAge,
                    Collections.singletonList(//pet
                            new PetBuilder()//new class
                                    .setHealth(true)
                                    .setType(randomType)
                                    .setName(name + randomType)
                                    .build()));
        }).limit(size).collect(Collectors.toList());

        return users;
    }


    public String getUser(List<User> users, int minAge, int maxAge) {

        return users.stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                if (user.age >= minAge && user.age <= maxAge) {
                    return true;
                } else return false;

                //return (user.age>=18 && user.age<30).map()

            }
        }).map(user -> user.pets).toArray().toString();
    }


    static class User {

        final String name;
        final int age;
        final List<Pet> pets;

        public User(String name, int age, List<Pet> pets) {
            this.name = name;
            this.age = age;
            this.pets = pets;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", pets=" + pets +
                    '}';
        }
    }

    static class PetBuilder {
        PetType type;
        String name;
        boolean health;

        public PetBuilder setType(PetType type) {
            this.type = type;
            return this;
        }

        public PetBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder setHealth(boolean health) {
            this.health = health;
            return this;
        }

        public Pet build() {
            return new Pet(type, name, health);
        }
    }

    private static class Pet {
        final PetType type;
        final String name;
        final boolean health;

        public Pet(PetType type, String name, boolean healt) {
            this.type = type;
            this.name = name;
            this.health = healt;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    ", health=" + health +
                    '}';
        }
    }

    private enum PetType {
        DOG, CAT, FISH;

    }
}




