package com.ddkm.sevice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddkm.beans.PersonBean;
import com.ddkm.beans.ProgrammeArchived;
import com.ddkm.dao.ProgrammeDAO;
import com.ddkm.dto.PersonDto;
import com.ddkm.dto.ProgrammeArchiveDto;
import com.ddkm.dto.ProgrammePrimaryKey;

@Service
public class ProgrammeArchiveService {
	@Autowired
	ProgrammeDAO programmeDAO;	
	
	
	public  List<ProgrammeArchived> getProgrammeArchives() {		
		List<ProgrammeArchiveDto> prgrmArchiveDtos= programmeDAO.getAllProgrammes();
		return getResponseBeans(prgrmArchiveDtos);		
	}
	
	private List<ProgrammeArchived> getResponseBeans(List<ProgrammeArchiveDto> prgrmArchiveDtos) {
		List<ProgrammeArchived> prgrmArchives = null;
		if(null != prgrmArchiveDtos) {
			prgrmArchives = new ArrayList<ProgrammeArchived>(prgrmArchiveDtos.size());
			for(ProgrammeArchiveDto dto : prgrmArchiveDtos) {
				ProgrammeArchived pgmArc = new ProgrammeArchived();
				
				pgmArc.setEpisodeNumber(dto.getProgrammePrimaryKey().getEpisodeNumber());
				pgmArc.setProgrammeName(dto.getProgrammePrimaryKey().getProgrammeName());
				pgmArc.setFileID(dto.getFileID());
				pgmArc.setGenre(dto.getGenre());
				pgmArc.setMediaFormat(dto.getMediaFormat());
				pgmArc.setMediaNmumber(dto.getMediaNmumber());
				pgmArc.setProducerName(dto.getProducerName());
				pgmArc.setSubject(dto.getSubject());
				pgmArc.setFileName(dto.getFileName());
				pgmArc.setEditor(dto.getEditor());
				pgmArc.setEditSuit(dto.getEditSuit());
				
				if(dto.getArtists() != null && dto.getArtists().size()!=0) {
					List<com.ddkm.beans.PersonBean> artists = new ArrayList<com.ddkm.beans.PersonBean>(dto.getArtists().size());
					for(com.ddkm.dto.PersonDto artistDto : dto.getArtists()) {
						com.ddkm.beans.PersonBean person = new com.ddkm.beans.PersonBean();
						person.setName(artistDto.getName());
						artists.add(person);
					}
					pgmArc.setArtists(artists);
				}
				
				if(dto.getGuests() != null && dto.getGuests().size()!=0) {
					List<com.ddkm.beans.PersonBean> guests = new ArrayList<com.ddkm.beans.PersonBean>(dto.getArtists().size());
					for(com.ddkm.dto.PersonDto guest : dto.getGuests()) {
						com.ddkm.beans.PersonBean person = new com.ddkm.beans.PersonBean();
						person.setName(guest.getName());
						guests.add(person);
					}
					pgmArc.setGuests(guests);
				}

				if(dto.getCameramen() != null && dto.getCameramen().size()!=0) {
					List<com.ddkm.beans.PersonBean> cameraMen = new ArrayList<com.ddkm.beans.PersonBean>(dto.getCameramen().size());
					for(com.ddkm.dto.PersonDto cameraMan : dto.getCameramen()) {
						com.ddkm.beans.PersonBean person = new com.ddkm.beans.PersonBean();
						person.setName(cameraMan.getName());
						cameraMen.add(person);
					}
					pgmArc.setCameramen(cameraMen);
				}
				
				prgrmArchives.add(pgmArc);
			}
		}
		return prgrmArchives;
	}
	
	public  void createProgrammeArchives(List<ProgrammeArchived> programmesBean) {
		List<ProgrammeArchiveDto> prgrmArchiveDtos = getDTO(programmesBean);
		programmeDAO.saveProgrammes(prgrmArchiveDtos);;	
	}
	
	private List<ProgrammeArchiveDto> getDTO(List<ProgrammeArchived> programmesBean) {
		List<ProgrammeArchiveDto> prgrmArchiveDtos = null;
		if(null != programmesBean) {
			prgrmArchiveDtos = new ArrayList<ProgrammeArchiveDto>(programmesBean.size());
			for(ProgrammeArchived bean : programmesBean) {
				ProgrammeArchiveDto dto = new ProgrammeArchiveDto();
				ProgrammePrimaryKey ppk = new ProgrammePrimaryKey();
				
				ppk.setEpisodeNumber(bean.getEpisodeNumber());
				ppk.setProgrammeName(bean.getProgrammeName());
				dto.setProgrammePrimaryKey(ppk);
				dto.setFileID(bean.getFileID());
				dto.setGenre(bean.getGenre());
				dto.setMediaFormat(bean.getMediaFormat());
				dto.setMediaNmumber(bean.getMediaNmumber());
				dto.setProducerName(bean.getProducerName());
				dto.setSubject(bean.getSubject());
				dto.setFileName(bean.getFileName());
				dto.setEditor(bean.getEditor());
				dto.setEditSuit(bean.getEditSuit());
				
				if(bean.getArtists() != null && bean.getArtists().size() != 0) {
					Set<com.ddkm.dto.PersonDto> artists = new HashSet<com.ddkm.dto.PersonDto>(bean.getArtists().size());
					for(com.ddkm.beans.PersonBean person : bean.getArtists()) {						
						com.ddkm.dto.PersonDto artist = new com.ddkm.dto.PersonDto();
						artist.setName(person.getName());
						artists.add(artist);
					}
					dto.setArtists(artists);
				}
				
				if(bean.getGuests() != null && bean.getGuests().size() != 0) {
					Set<com.ddkm.dto.PersonDto> guests = new HashSet<com.ddkm.dto.PersonDto>(bean.getGuests().size());
					for(com.ddkm.beans.PersonBean person : bean.getGuests()) {						
						com.ddkm.dto.PersonDto guest = new com.ddkm.dto.PersonDto();
						guest.setName(person.getName());

						guests.add(guest);
					}
					dto.setGuests(guests);
				}
				
				if(bean.getCameramen() != null && bean.getCameramen().size() != 0) {
					Set<com.ddkm.dto.PersonDto> cameramen = new HashSet<com.ddkm.dto.PersonDto>(bean.getArtists().size());
					for(com.ddkm.beans.PersonBean person : bean.getCameramen()) {						
						com.ddkm.dto.PersonDto cameraMan = new com.ddkm.dto.PersonDto();
						cameraMan.setName(person.getName());

						cameramen.add(cameraMan);
					}
					dto.setCameramans(cameramen);
				}
				
				prgrmArchiveDtos.add(dto);
			}
		}
		return prgrmArchiveDtos;
	}
	
	public void updateProgrammeArchives(List<ProgrammeArchived> programmesBean) {
		List<ProgrammeArchiveDto> prgrmArchiveDtos = getDTO(programmesBean);
		programmeDAO.updateProgrammes(prgrmArchiveDtos);;	
	}
	
	public void deleteProgrammeArchives(List<ProgrammeArchived> programmesBean) {
		List<ProgrammeArchiveDto> prgrmArchiveDtos = getDTO(programmesBean);
		programmeDAO.deleteProgrammes(prgrmArchiveDtos);;	
	}
}
