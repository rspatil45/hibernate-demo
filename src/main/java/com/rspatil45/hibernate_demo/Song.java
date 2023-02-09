package com.rspatil45.hibernate_demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Song {
	//songId, songName, singer
	@Id
	private int songId;
	
	private String songName;
	
	@Column(name = "singer")
	private String artist;  //singer
	
	
	public int getId() {
		return songId;
	}
	public void setId(int id) {
		this.songId = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
}
