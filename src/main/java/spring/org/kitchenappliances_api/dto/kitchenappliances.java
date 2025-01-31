package spring.org.kitchenappliances_api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class kitchenappliances {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String modle;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getModle() {
	return modle;
}
public void setModle(String modle) {
	this.modle = modle;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
private int price;
private String brand;
}
