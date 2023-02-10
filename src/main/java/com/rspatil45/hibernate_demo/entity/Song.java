package com.rspatil45.hibernate_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name =  "Song")
public class Song {
	//songId, songName, singer
	@Id
	private int songId;
	
	@Column(name="songName") //here datamember name and column name are same so it is optional to provide @Column tag but it is standard practice to use it.
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
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", artist=" + artist + "]";
	}
	
	
}
