package com.harish.starting.model;

public class Location {
String location;
public Location(String location, int count) {
	super();
	this.location = location;
	this.count = count;
}
int count;
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Location [location=" + location + ", count=" + count + "]";
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

}
