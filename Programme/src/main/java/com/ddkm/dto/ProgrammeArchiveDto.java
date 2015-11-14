package com.ddkm.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PROGRAMME_ARCHIVED")
public class ProgrammeArchiveDto {
	
	@EmbeddedId
	private ProgrammePrimaryKey programmePrimaryKey;
	
	@Column(name="GENRE")
	private String genre;

	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_ID", unique=true)
	private String fileID;
	
	@Column(name="PRODUCER_NAME")
	private String producerName;
	
	@Column(name="MEDIA_NUMBER")
	private String mediaNmumber;
	
	@Column(name="MEDIA_FORMAT")
	private String mediaFormat;
		
	@Column(name="EDITOR")
	private String editor;
	
	@Column(name="EDIT_SUIT")
	private String editSuit;
	
	@Column(name="PROGRAMME_TYPE")
	private String programType;
	
	@Column(name="TECHNICAL_DIRECTOR")
	private String techinalDirector;
	
	@Column(name="QUALITY_REMARK")
	private String qualityRemark;
	
	@Column(name="QUALITY_CONTROL")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean qualityControl;
	
	@Column(name="STATUS")
	private String status;

	@ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable
	private Set<PersonDto> artists = new HashSet<PersonDto>(0);
	
	@ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable
	private Set<PersonDto> guests = new HashSet<PersonDto>(0);
	
	@ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable
	private Set<PersonDto> cameramen = new HashSet<PersonDto>(0);	
	
	public ProgrammeArchiveDto() {
		super();
	}

	public ProgrammeArchiveDto(ProgrammePrimaryKey programmePrimaryKey, String genre, String subject, String fileName,
			String producerName, String mediaNmumber, String mediaFormat, String editor, String editSuit, String programType) {
		super();
		this.programmePrimaryKey = programmePrimaryKey;
		this.genre = genre;
		this.subject = subject;
		this.fileName = fileName;
		this.producerName = producerName;
		this.mediaNmumber = mediaNmumber;
		this.mediaFormat = mediaFormat;
		this.editor = editor;
		this.editSuit = editSuit;
		this.programType = programType;
	}

	
	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public ProgrammePrimaryKey getProgrammePrimaryKey() {
		return programmePrimaryKey;
	}

	public void setProgrammePrimaryKey(ProgrammePrimaryKey programmePrimaryKey) {
		this.programmePrimaryKey = programmePrimaryKey;
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

	public Set<PersonDto> getArtists() {
		return artists;
	}

	public void setArtists(Set<PersonDto> artists) {
		this.artists = artists;
	}

	public Set<PersonDto> getGuests() {
		return guests;
	}

	public void setGuests(Set<PersonDto> guests) {
		this.guests = guests;
	}

	public Set<PersonDto> getCameramen() {
		return cameramen;
	}

	public void setCameramans(Set<PersonDto> cameramen) {
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

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getEditSuit() {
		return editSuit;
	}

	public void setEditSuit(String editSuit) {
		this.editSuit = editSuit;
	}

	public void setCameramen(Set<PersonDto> cameramen) {
		this.cameramen = cameramen;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
