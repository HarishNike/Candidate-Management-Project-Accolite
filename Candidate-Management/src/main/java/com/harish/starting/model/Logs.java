package com.harish.starting.model;

import java.sql.Time;
import java.util.Date;

public class Logs {
public String name;
public String operation;
public Date date;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getOperation() {
	return operation;
}
public void setOperation(String operation) {
	this.operation = operation;
}

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Logs(String name, String operation, Date datetime) {
	super();
	this.name = name;
	this.operation = operation;
	this.date=datetime;
}


}
