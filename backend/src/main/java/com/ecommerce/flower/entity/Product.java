package com.ecommerce.flower.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String description;
	private String size;
	private int price;
	private String category;
	private Date date;
	private int count;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", description=" + description + ", size=" + size + ", price="
				+ price + ", category=" + category + ", date=" + date + ", count=" + count + "]";
	}
	
	
	
	
	/*@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", imageType=" + imageType + ", imageName=" + imageName
				+ ", image=" + Arrays.toString(image) + ", description=" + description + ", size=" + size + ", price="
				+ price + ", category=" + category + ", date=" + date + ", count=" + count + "]";
	}*/
	
	
	
	

}
