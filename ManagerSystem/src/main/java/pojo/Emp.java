package pojo;

public class Emp {
    private int id;
    private String name;
    private int age;
    private int salary;
    private int bonus;
    private String date;

    public Emp(int id, String name, int age, int salary, int bonus, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
        this.date = date;
    }

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", date='" + date + '\'' +
                '}';
    }
}
