package com.app.project.main.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Entity
@Table(name="movie", catalog="casestudy")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mid;
	private String name;
	private String genre;
	private String productionHouse;
	private String platform;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int mid, String name, String genre, String productionHouse, String platform) {
		super();
		this.mid = mid;
		this.name = name;
		this.genre = genre;
		this.productionHouse = productionHouse;
		this.platform = platform;
	}
	public int getId() {	
		return mid;
	}
	public void setId(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getProductionHouse() {
		return productionHouse;
	}
	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
}
