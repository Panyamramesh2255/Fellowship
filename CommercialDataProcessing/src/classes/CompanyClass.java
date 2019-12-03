package classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author  PanyamRamesh
 * purpose: Company model class
 *
 */
public class CompanyClass {
	@JsonIgnoreProperties
    String id;
	@JsonIgnoreProperties
    String name;
	@JsonIgnoreProperties
    int numberofshares;
	@JsonIgnoreProperties
    int sharevalue;
public CompanyClass(String id,String name,int numberofshres,int sharevalue)
{
this.id=id;
this.name=name;
this.numberofshares=numberofshres;
this.sharevalue=sharevalue;
}
public CompanyClass()
{
	}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumberofshares() {
	return numberofshares;
}
public void setNumberofshares(int numberofshares) {
	this.numberofshares = numberofshares;
}
public int getSharevalue() {
	return sharevalue;
}
public void setSharevalue(int sharevalue) {
	this.sharevalue = sharevalue;
}
@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", numberofshares=" + numberofshares + ", sharevalue="
			+ sharevalue ;
}


}


