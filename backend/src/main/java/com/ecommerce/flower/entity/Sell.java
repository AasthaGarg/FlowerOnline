package com.ecommerce.flower.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Sell {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	@ManyToOne
	@JoinColumn(name="spid",referencedColumnName = "pid")
	private Product spid;
	
	@ManyToOne
	@JoinColumn(name="suid",referencedColumnName = "uid")
	private Customer suid;
	
	private Date dateOfPurchase;
	private int count;
	private int amount;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Product getSpid() {
		return spid;
	}
	public void setSpid(Product spid) {
		this.spid = spid;
	}
	public Customer getSuid() {
		return suid;
	}
	public void setSuid(Customer suid) {
		this.suid = suid;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Sell [sid=" + sid + ", spid=" + spid + ", suid=" + suid + ", dateOfPurchase=" + dateOfPurchase
				+ ", count=" + count + ", amount=" + amount + "]";
	}	

}
