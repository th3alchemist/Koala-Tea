package com.KoalaTea.model;

import java.sql.Date;

public class User {

	private int id;//primary key
	private String email;
	private byte[] password;
	private String fname;
	private String lname;
	private String address;
	private Date date_of_birth;
}
