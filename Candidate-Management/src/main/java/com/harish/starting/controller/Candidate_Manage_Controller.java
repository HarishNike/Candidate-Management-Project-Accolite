package com.harish.starting.controller;
import com.harish.starting.CandImpl.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
//import org.slf4j.event.Level;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harish.starting.Interfaces.CandInterface;
import com.harish.starting.model.*;
import com.sun.org.apache.xml.internal.serialize.Method;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Candidate_Manage_Controller {
@Autowired
CanRepo c;

Logger l=LoggerFactory.getLogger(Candidate_Manage_Controller.class);
public String name;
public Candidate_Manage_Controller(CanRepo s)
{//only used when testing...
	this.c=s;
}
@RequestMapping("/v1/home")//( expression = "attributes['name']" ) 
public Map<String, String> getUserName(@AuthenticationPrincipal( expression = "attributes['name']" ) String username ) {
    this.name=username;
//	System.out.println(prin.toString());
	return Collections.singletonMap("name",username);
}
@RequestMapping("/name")
public String g()
{
	return this.name;
}

@GetMapping(value="/getallcandidates")
public List<Candidate> getAllCandidates()
{
	return c.getAllCandidates();
}
@GetMapping(value="/getlocationcount")
public List<Location> getlocationcount()
{
	
	return c.getlocationcount();
	
}
@GetMapping("/newtoken")
public String newtoken()
{
	String token = UUID.randomUUID().toString();
	return token;
}

@GetMapping("getbyid/{i}")
public Candidate getbyId(@PathVariable int i)
{
	return c.getbyId(i);
}

@GetMapping("/getcandidatebylocation/{l}")
public List<Candidate> getloc(@PathVariable String l)
{
	return c.getcandbyloc(l);
}
@GetMapping("/getcandidatebyemail/{l}")
public List<Candidate> getemail(@PathVariable String l)
{
	return c.getcandbyemail(l);
}
@GetMapping("/getskill")
public List<Location> getskill()
{
	return c.getskill();
}
@GetMapping("/getcandidatebyjob/{l}")
public List<Candidate> getjob(@PathVariable String l)
{
	return c.getcandbyjob(l);
}
@GetMapping("/getJobcount")
public List<Location> getjobcount()
{
	return c.getJobcount();
//return c.getlocationcount();
}
@RequestMapping("/addcandidate")
public String saving_cand(@RequestBody Candidate candidate)
{	
	return c.save(candidate);
//	l.info("Candidate:"+candidate.getId()+"\t Name:"+candidate.getName()+"  Added Successfully");
	
}

@RequestMapping(value="/deletecandidate/{id}")
public List<Candidate> delete(@PathVariable Integer id)
{	
	String r=c.delete(id);
	if(r=="success")l.info("Candidate deleted-ID:" +id);
	return c.getAllCandidates();
}
@RequestMapping("/updatecandidate/{id}")
public List<Candidate> updateCandidate(@RequestBody Candidate candidate,@PathVariable Integer id)
{
	

 String r=c.update(new Candidate(id,candidate.getEmail(),candidate.getName(),candidate.getJoindate(),candidate.getLocation(),candidate.getFeedback(),candidate.getInstitution(),candidate.getContact(),candidate.getCpp(),candidate.getJava(),candidate.getPython(),candidate.getAngular(),candidate.getReact(),candidate.getJavascript(),candidate.getAndroid(),candidate.getJobDescription()));
 if(r=="updated")l.info("Updated Candidate-ID: "+id+"\tCandidate Name:"+candidate.getName());
 return c.getAllCandidates();
 //	return candidateService.getAllCandidates();
	//return "updattes";	
}
@RequestMapping("/addlogs")
public String returnlogs(@RequestBody Logs logs)
{
	return c.addlogs(logs);
}
@GetMapping("/getlogs")
public List<Logs> retulogs()
{
	return c.getlogs();
}

}
