package com.ddkm.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgrammePrimaryKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="PROGRAMME_NAME")
	private String programmeName;
	
	@Column(name="EPISODE_NUMBER")
	private String episodeNumber;

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public String getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
