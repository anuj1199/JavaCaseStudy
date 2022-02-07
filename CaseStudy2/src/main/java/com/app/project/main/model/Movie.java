package com.app.project.main.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Entity
@Table(name="movies", catalog="casestudy")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String genre;
	private String productionHouse;
	private String platform;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String name, String genre, String productionHouse, String platform) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.productionHouse = productionHouse;
		this.platform = platform;
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
