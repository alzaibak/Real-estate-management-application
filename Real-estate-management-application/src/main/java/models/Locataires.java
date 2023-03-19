package models;

import java.sql.Date;

public class Locataires {
int id;
String firstN;
String lastN;
Date BirthD;
int  phoneN;
String upToDate;
int sold;

public Locataires() {
	super();
}

public Locataires (int id, String firstN,String lastN, Date BirthD,int phoneN,String upToDate,int sold) {
	this.id=id;
	this.firstN =firstN;
	this.lastN =lastN;
	this.BirthD=BirthD;
	this.phoneN=phoneN;
	this.upToDate=upToDate;
	this.sold=sold;

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstN() {
	return firstN;
}

public void setFirstN(String firstN) {
	this.firstN = firstN;
}

public String getLastN() {
	return lastN;
}

public void setLastN(String lastN) {
	this.lastN = lastN;
}

public Date getBirthD() {
	return BirthD;
}

public void setBirthD(Date birthD) {
	BirthD = birthD;
}

public int getPhoneN() {
	return phoneN;
}

public void setPhoneN(int phoneN) {
	this.phoneN = phoneN;
}

public String getUpToDate() {
	return upToDate;
}

public void setUpToDate(String upToDate) {
	this.upToDate = upToDate;
}

public int getSold() {
	return sold;
}

public void setSold(int sold) {
	this.sold = sold;
}

}
