package dev.struchkov.yandex.stream;

public class Worker {

    private final String name;
    private final Integer age;
    private final String position;
    private final Long salary;

    public Worker(String name, Integer age, String position, Long salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public static Worker of(String name, Integer age, String position, Long salary) {
        return new Worker(name, age, position, salary);
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
