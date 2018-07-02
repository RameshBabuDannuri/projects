package com.raudra.entiry;

import java.util.Date;

public class Course {
  private   int id;
  private   String name;
  private   int price;
  private   String description;
  private   boolean enabled;
  private   Date startDate;
  private   Date endDate;

  public Course() {
  }

  public Course(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", description='" + description + '\'' +
            ", enabled=" + enabled +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            '}';
  }
}
