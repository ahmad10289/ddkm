package com.ddkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.ddkm.beans.ProgrammeArchived;
import com.ddkm.beans.ResponseBody;
import com.ddkm.dao.ProgrammeDAO;
import com.ddkm.dto.ProgrammeArchiveDto;
import com.ddkm.sevice.ProgrammeArchiveService;

@RestController
@RequestMapping("/operations")
public class TestController {

	@Autowired
	ProgrammeDAO programmeDAO;
	
	@Autowired
	ProgrammeArchived pgm;
	
	@Autowired
	ProgrammeArchiveService programmeArchiveService;
	
	@RequestMapping(value = "/{name}/{age}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String name, @PathVariable String age) {
		String result="Hello "+name+ " "+age + " Welcome to Doordarshan Mumbai";
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/getAllPlayList", method = RequestMethod.GET)
	public String get(ModelMap model) {
		List<ProgrammeArchiveDto> playList = programmeDAO.getAllProgrammes();
		model.addAttribute("playList", playList);
		return "UserList";
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ResponseBody getProgrammes() {
		ResponseBody responseBody = new ResponseBody();
		List<ProgrammeArchived> programmes = programmeArchiveService.getProgrammeArchives();
		responseBody.setResponse(programmes);
		responseBody.setStatusCode(200);
		responseBody.setStatusMessage("Fetched Successfully");
		return responseBody;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseBody saveProgrammes(@RequestBody com.ddkm.beans.RequestBody requestBody) {
		ResponseBody responseBody = new ResponseBody();
		if(null != requestBody && null != requestBody.getProgrammeArchivedList()) {
			programmeArchiveService.createProgrammeArchives(requestBody.getProgrammeArchivedList());
			responseBody.setStatusCode(200);
			responseBody.setStatusMessage("Created Successfully");
		} else {
			responseBody.setStatusCode(400);
			responseBody.setStatusMessage("No Programme Archives found in the request");
		}
		return responseBody;
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces="application/json", consumes="application/json")
	public ResponseBody updateProgrammes(@RequestBody com.ddkm.beans.RequestBody requestBody) {
		ResponseBody responseBody = new ResponseBody();
		if(null != requestBody && null != requestBody.getProgrammeArchivedList()) {
			programmeArchiveService.createProgrammeArchives(requestBody.getProgrammeArchivedList());
			responseBody.setStatusCode(200);
			responseBody.setStatusMessage("Updated Successfully");
		} else {
			responseBody.setStatusCode(400);
			responseBody.setStatusMessage("No Programme Archives found in the request");
		}
		return responseBody;
	}

	@RequestMapping(method = RequestMethod.DELETE, produces="application/json", consumes="application/json")
	public ResponseBody deleteProgrammes(@RequestBody com.ddkm.beans.RequestBody requestBody) {
		ResponseBody responseBody = new ResponseBody();
		if(null != requestBody && null != requestBody.getProgrammeArchivedList()) {
			programmeArchiveService.deleteProgrammeArchives(requestBody.getProgrammeArchivedList());
			responseBody.setStatusCode(200);
			responseBody.setStatusMessage("Deleted Successfully");
		} else {
			responseBody.setStatusCode(400);
			responseBody.setStatusMessage("No Programme Archives found in the request");
		}
		return responseBody;
	}
	
}