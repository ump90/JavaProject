package com.itheima.edu.pojo;

import java.util.Objects;

public class User {
  private int id;
  String name, gender;
  int salary;
  String joinDate;
  int dept_id;

  public User(int id, String name, String gender, int salary, String joinDate, int dept_id) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.salary = salary;
    this.joinDate = joinDate;
    this.dept_id = dept_id;
  }

  public User() {}

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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
  }

  public int getDept_id() {
    return dept_id;
  }

  public void setDept_id(int dept_id) {
    this.dept_id = dept_id;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", salary="
        + salary
        + ", joinDate='"
        + joinDate
        + '\''
        + ", dept_id="
        + dept_id
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id
        && salary == user.salary
        && dept_id == user.dept_id
        && name.equals(user.name)
        && gender.equals(user.gender)
        && joinDate.equals(user.joinDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gender, salary, joinDate, dept_id);
  }
}
