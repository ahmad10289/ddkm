package com.ddkm.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component
@Scope("prototype")
public class RequestBody {
	
	private String requestType;
	private List<ProgrammeArchived> programmeArchivedList;
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public List<ProgrammeArchived> getProgrammeArchivedList() {
		return programmeArchivedList;
	}
	public void setProgrammeArchivedList(List<ProgrammeArchived> programmeArchivedList) {
		this.programmeArchivedList = programmeArchivedList;
	}

	
}
