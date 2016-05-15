package com.abe.usersApi;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("users")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class DBUser {
	@Id
	private ObjectId _id;
	@Property
	@XmlElement(required = true)
	private String fname;
	@Property
	@XmlElement(required = true)
	private String lname;
	@Property
	@XmlElement(required = true)
	private String uname;
	@Property
	@XmlElement(required = true)
	private String email;
	@Property
	@XmlElement(required = true)
	private String pic;
	@Property
	private boolean online;



	public DBUser() {

	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}


}

