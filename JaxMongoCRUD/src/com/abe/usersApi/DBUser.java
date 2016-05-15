package com.abe.usersApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * @author abe
 *
 *         This class represents a single user in the MongoDB. It is used for
 *         both Morphia for the DB mapping, as well as the xml binding for the
 *         application/json or application/xml response to the http GET request
 * 
 *         (It includes both annotations - Morphia and JAXB)
 * 
 */
@Entity("users")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class DBUser {
	@Id
	@XmlTransient
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
	@XmlElement()
	private String pic;
	@Property
	@XmlTransient
	private boolean online;

	public DBUser() {

	}

	public DBUser(String fname, String lname, String uname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.email = email;
	}

	public DBUser(String fname, String lname, String uname, String email, String pic) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.email = email;
		this.pic = pic;
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
