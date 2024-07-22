package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Laptop 
{   @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int sno;
    @Column(nullable=false)
    private String lname;
    @Column(nullable=false)
    private String brand;
    @Column(nullable=false)
    private String generation;
    @ManyToOne
  @JoinColumn
  @JsonIgnore
    private Student student;
    
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	@Override
	public String toString() {
		return "Laptop [sno=" + sno + ", lname=" + lname + ", brand=" + brand + ", generation=" + generation + "]";
	}
    
  
}
