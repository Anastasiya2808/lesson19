package lesson18.empoyee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee( String name,  String company,  int salary,  int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }


    public static List<Employee> employeeGenerator(int num) {
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
            String randName = names[(int) (Math.random() * names.length)];
            String randCompany = companies[(int) (Math.random() * companies.length)];
            int randSalary = (int) ( 100_000 + Math.random() * 300_000);
            int randAge = (int) ( 21 + Math.random() * 39);
            employees.add(new Employee(randName, randCompany, randSalary, randAge));
        }
        return employees;
    }
}
