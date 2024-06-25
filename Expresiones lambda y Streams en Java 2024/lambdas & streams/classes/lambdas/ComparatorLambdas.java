package classes.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ComparatorLambdas {

    public static final Logger logger = Logger.getLogger(ComparatorLambdas.class.getName());

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 7, 23, 3);
        numbers.sort((a, b) -> a - b);
        logger.info(numbers::toString);

        List<String> names = Arrays.asList("Max", "Alex", "Opal");
        names.sort(String::compareTo);
        logger.info(names::toString);

        names.sort(Comparator.reverseOrder());
        logger.info(names::toString);

        List<Person> persons = Arrays.asList(
                new Person("Jose", 12), new Person("Lucas", 21), new Person("Roy", 2), new Person("Mari", 2));
        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        logger.info(persons::toString);
    }

    public static class Person {
        private String name;
        private Integer age;

        /**
         * @param name
         * @param age
         */
        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public Integer getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(Integer age) {
            this.age = age;
        }

    }

}
