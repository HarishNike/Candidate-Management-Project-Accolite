package com.harish.starting.model;

public class Skill {
 int id;
 String cpp;
String java;
 String python;
 String angular;
 String react;
 String javascript;
String android;
public Skill(int id, String cpp, String java, String python, String angular, String react, String javascript,
		String android) {
	super();
	this.id = id;
	this.cpp = cpp;
	this.java = java;
	this.python = python;
	this.angular = angular;
	this.react = react;
	this.javascript = javascript;
	this.android = android;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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


}
