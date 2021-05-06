package com.harish.starting.model;

import java.util.Date;

public class Candidate {
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
String email;
String name;
Date joindate;
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
String location;
String feedback;
String institution;
String cpp;
String java;
String python;
String angular;
String react;
String javascript;
String android;String contact;
String jobDescription;
public String getCpp() {
	return cpp;
}
public void setCpp(String cpp) {
	this.cpp = cpp;
}
public String getJava() {
	return java;
}
public void setJava(String java) {
	this.java = java;
}
public String getPython() {
	return python;
}
public void setPython(String python) {
	this.python = python;
}
public String getAngular() {
	return angular;
}
public void setAngular(String angular) {
	this.angular = angular;
}
public String getReact() {
	return react;
}
public void setReact(String react) {
	this.react = react;
}
public String getJavascript() {
	return javascript;
}
public void setJavascript(String javascript) {
	this.javascript = javascript;
}
public String getAndroid() {
	return android;
}
public void setAndroid(String android) {
	this.android = android;
}
public Candidate(int id, String email, String name, Date joindate, String location, String feedback, String institution,
		String contact,String cpp, String java, String python, String angular, String react, String javascript, String android,String jobDescription) {
	super();
	this.id = id;
	this.email = email;
	this.name = name;
	this.joindate = joindate;
	this.location = location;
	this.feedback = feedback;
	this.institution = institution;
	this.contact = contact;
	this.cpp = cpp;
	this.java = java;
	this.python = python;
	this.angular = angular;
	this.react = react;
	this.javascript = javascript;
	this.android = android;
	this.jobDescription=jobDescription;
	
}
//String skills;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getFeedback() {
	return feedback;
}
public void setFeeback(String feeback) {
	feedback = feeback;
}
public String getInstitution() {
	return institution;
}
public void setInstitution(String institution) {
	this.institution = institution;
}
public Date getJoindate() {
	return joindate;
}
public void setJoindate(Date joindate) {
	this.joindate = joindate;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
//public String getSkills() {
//	return skills;
//}
//public void setSkills(String skills) {
//	this.skills = skills;
//}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}

}
//
//name
//email
//location
//feedback
//join-date
//institution
//contact no
//skill
