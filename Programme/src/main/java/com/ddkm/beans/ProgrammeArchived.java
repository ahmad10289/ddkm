package com.ddkm.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component
@Scope("prototype")
public class ProgrammeArchived {

	private String fileID;

	private String programmeName;

	private String episodeNumber;

	private String producerName;

	private String mediaNmumber;

	private String genre;

	private boolean qualityControl;

	private String qualityRemark;

	private String mediaFormat;

	private String subject;
	
	private String fileName;
	
	private String editor;
	
	private String editSuit;
	
	private String programType;
	
	private String techinalDirector;
	
	private String remarks;
	
	private String status;
	
	private List<PersonBean> artists;
	
	private List<PersonBean> guests;
	
	private List<PersonBean> cameramen;

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

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

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getMediaNmumber() {
		return mediaNmumber;
	}

	public void setMediaNmumber(String mediaNmumber) {
		this.mediaNmumber = mediaNmumber;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isQualityControl() {
		return qualityControl;
	}

	public void setQualityControl(boolean qualityControl) {
		this.qualityControl = qualityControl;
	}

	public String getQualityRemark() {
		return qualityRemark;
	}

	public void setQualityRemark(String qualityRemark) {
		this.qualityRemark = qualityRemark;
	}

	public String getMediaFormat() {
		return mediaFormat;
	}

	public void setMediaFormat(String mediaFormat) {
		this.mediaFormat = mediaFormat;
	}

	public List<PersonBean> getArtists() {
		return artists;
	}

	public void setArtists(List<PersonBean> artists) {
		this.artists = artists;
	}

	public List<PersonBean> getGuests() {
		return guests;
	}

	public void setGuests(List<PersonBean> guests) {
		this.guests = guests;
	}

	public List<PersonBean> getCameramen() {
		return cameramen;
	}

	public void setCameramen(List<PersonBean> cameramen) {
		this.cameramen = cameramen;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEditor() {
		return editor;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getTechinalDirector() {
		return techinalDirector;
	}

	public void setTechinalDirector(String techinalDirector) {
		this.techinalDirector = techinalDirector;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getEditSuit() {
		return editSuit;
	}

	public void setEditSuit(String editSuit) {
		this.editSuit = editSuit;
	}
	
	

}
