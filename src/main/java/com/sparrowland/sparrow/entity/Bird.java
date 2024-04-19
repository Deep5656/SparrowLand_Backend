package com.sparrowland.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Entity
@Table(name = "Birds")
@Builder
public class Bird {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String subTitle;
	@Lob
	@Column(length = 100000)
	private byte[] image;
	@Column(length = 100000)
	@NotNull
	private String about;

	
	

	public Bird() {
		super();
	}

	public Bird(int id, String title, String subTitle, String about, byte[] image) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.about = about;
		this.image = image;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
