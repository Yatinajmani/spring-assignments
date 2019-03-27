package ttn.spring.thymeleaf.entity;

public class Employee {
    private String name;
    private Integer age;
    private Long contact;

    public Employee(String name, Integer age, Long contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
}
