package hcipackage;
/*
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class Region {

State current_state ;
ArrayList<JButton> icons;
ArrayList<Point> positions;
JButton [] avaliablepositions;

public JButton[] getAvaliablepositions() {
	return avaliablepositions;
}
public void setAvaliablepositions(JButton[] avaliablepositions) {
	this.avaliablepositions = avaliablepositions;
}
int [] color;
String name;

public Region(State current_state, ArrayList<JButton> icons, ArrayList<Point> positions,int[] color) {
	super();
	this.current_state = current_state;
	this.icons = icons;
	this.positions = positions;
	//this.color = color;
}
public Region(String name){
	this.name = name;
}
public Region() {
	super();

}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public State getCurrent_state() {
	return current_state;
}
public void setCurrent_state(State current_state) {
	this.current_state = current_state;
}
public ArrayList<JButton> getIcons() {
	return icons;
}
public void setIcons(ArrayList<JButton> icons) {
	this.icons = icons;
}
public ArrayList<Point> getPositions() {
	return positions;
}
public void setPositions(ArrayList<Point> positions) {
	this.positions = positions;
}

}
*/

//import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Region {

State current_state ;
JButton [] icons;
ArrayList<Point> positions = new ArrayList<Point>();
ArrayList<JButton> avaliablepositions;


public ArrayList<JButton> getAvaliablepositions() {
	return avaliablepositions;
}
public void setAvaliablepositions(ArrayList<JButton> avaliablepositions) {
	this.avaliablepositions = avaliablepositions;
}
int [] color;
String name;

public Region(State current_state, JButton [] icons, ArrayList<Point> positions) {
	super();
	this.current_state = current_state;
	this.icons = icons;
	this.positions = positions;
	
	//this.color = color;
}
public Region(String name,State current_state){
	this.name = name;
	this.current_state = current_state;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public State getCurrent_state() {
	return current_state;
}
public void setCurrent_state(State current_state) {
	this.current_state = current_state;
}
public JButton [] getIcons() {
	return icons;
}
public void setIcons(JButton [] icons) {
	this.icons = icons;
}

public ArrayList<Point> getPositions() {
	return positions;
}
public void setPositions(ArrayList<Point> cloudPoints) {
	this.positions = cloudPoints;
}

}
