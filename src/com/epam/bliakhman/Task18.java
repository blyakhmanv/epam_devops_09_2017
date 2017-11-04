package com.epam.bliakhman;

import java.util.*;

public class Task18 {

    // TODO метод сортировки, принимающий компаратор, умеющий сравнивать людей по именам и список сотрудников
    // TODO private static void sortByName(??? comparator, ??? list) {
    // TODO        Collections.sort(list, comparator);
    // TODO }

    // TODO метод сортировки, принимающий компаратор, умеющий сравнивать объекты по весу и список сотрудников
    // TODO private static void sortByWeight(??? comparator, ??? list) {
    // TODO    Collections.sort(list, comparator);
    // TODO }

    // TODO метод, выбирающий работников у которых зп больше 65000 из исходного списка и помещающий в список сотрудников
    // TODO private static void selectEmployeesWithSalaryGreaterThen65000(??? src, ??? dst)

    // TODO метод, выбирающий объекты у которых вес меньше 65 из исходного списка и помещающий в список физических объектов
    // TODO private static void selectObjectsWithWeightLessThen65(??? src, ??? dst)

    public static void main(String[] args) {

        List<Employee> employees =  Arrays.asList (
                new Employee(90, "Дмитрий", "Светличный", 80000),
                new Employee(60, "Алексей", "Мельников", 60000),
                new Employee(81, "Семен", "Паршин", 70000),
                new Employee(85, "Семен", "Мельников", 65000)
        );

        sortByWeight( Employee.comparatorByWeight, employees);
        System.out.println(employees);

        sortByName( Employee.comparatorByName, employees);
        System.out.println(employees);

        List<Object> richGuys = new ArrayList<>();
        selectEmployeesWithSalaryGreaterThen65000 (employees, richGuys);
        System.out.println(richGuys);

        List<PhysicalObject> lightObjects = new ArrayList<>();
        selectObjectsWithWeightLessThen65 (employees, lightObjects);
        System.out.println(lightObjects);
    }

    private static void selectObjectsWithWeightLessThen65 (List<? extends PhysicalObject> src, List<PhysicalObject> dst){
        for ( PhysicalObject physicalObject : src ) {
            if ( physicalObject.getWeight () < 65){
                dst.add ( physicalObject );
        }
        }

    }

    private static void selectEmployeesWithSalaryGreaterThen65000 (List<? extends Employee> src, List<Object> dst) {
        for ( Employee employee : src ) {
            if (employee.getSalary () > 65000) {
                dst.add ( employee );
            }
        }

    }

    private static void sortByWeight(Comparator<? super PhysicalObject> comparator, List<? extends PhysicalObject> list) {
       Collections.sort(list, comparator);
   }

    private static void sortByName(Comparator<? super Person> comparator, List<? extends Person> list) {
       Collections.sort(list, comparator);
    }

}






abstract class PhysicalObject implements  Comparable{

    private final double weight;

    PhysicalObject(double weight) {
        this.weight = weight;
    }

    /** @return Вес. */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }

    public static final Comparator<PhysicalObject> comparatorByWeight = new Comparator<PhysicalObject>(){

        @Override
        public int compare(PhysicalObject o1, PhysicalObject o2) {
            return Double.compare ( o1.weight, o2.weight );
        }

    };

}

abstract class Person extends PhysicalObject {

    private final String firstName;
    private final String lastName;

    Person(double weight, String firstName, String lastName) {
        super(weight);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** @return Имя. */
    public String getFirstName() {
        return firstName;
    }

    /** @return Фамилия. */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return super.toString() + " " + firstName + " " + lastName;
    }

    public static final Comparator<Person> comparatorByName = new Comparator<Person>(){

        @Override
        public int compare(Person o1, Person o2) {
            if (o1.lastName.equals ( o2.lastName )) {
                return o1.firstName.compareTo ( o2.firstName );
            }
            else {
                return(o1.lastName.compareTo ( o2.lastName ));
            }
        }

    };

}

class Employee extends Person {

    private int salary;

    public Employee(double weight, String firstName, String lastName, int salary) {
        super(weight, firstName, lastName);
        this.salary = salary;
    }

    /** @return Зарплата. */
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + salary;
    }

    @Override
    public int compareTo (Object o) {
        return 0;
    }
}

