package com.nana.test.struct.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {
	private String name;
	private String surname;

	private Date birthdayDate;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(final Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

		stb.append(getName());
		stb.append(" ");
		stb.append(getSurname());
		stb.append(" : ");
		stb.append(dateFormat.format(getBirthdayDate()));

		return stb.toString();
	}
}
