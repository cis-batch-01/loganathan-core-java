package com.phones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import topics.Topic;

public class Phone {
	private String phoneName;
	private String companyName;
	private String serious;
	private String madeCountry;
	private Date manufactureYear;
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSerious() {
		return serious;
	}
	public void setSerious(String serious) {
		this.serious = serious;
	}
	public String getMadeCountry() {
		return madeCountry;
	}
	public void setMadeCountry(String madeCountry) {
		this.madeCountry = madeCountry;
	}
	public Date getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(Date manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	public Phone(String phoneName, String companyName, String serious, String madeCountry, Date manufactureYear) {
		super();
		this.phoneName = phoneName;
		this.companyName = companyName;
		this.serious = serious;
		this.madeCountry = madeCountry;
		this.manufactureYear = manufactureYear;
	}
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((madeCountry == null) ? 0 : madeCountry.hashCode());
		result = prime * result + ((manufactureYear == null) ? 0 : manufactureYear.hashCode());
		result = prime * result + ((phoneName == null) ? 0 : phoneName.hashCode());
		result = prime * result + ((serious == null) ? 0 : serious.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (madeCountry == null) {
			if (other.madeCountry != null)
				return false;
		} else if (!madeCountry.equals(other.madeCountry))
			return false;
		if (manufactureYear == null) {
			if (other.manufactureYear != null)
				return false;
		} else if (!manufactureYear.equals(other.manufactureYear))
			return false;
		if (phoneName == null) {
			if (other.phoneName != null)
				return false;
		} else if (!phoneName.equals(other.phoneName))
			return false;
		if (serious == null) {
			if (other.serious != null)
				return false;
		} else if (!serious.equals(other.serious))
			return false;
		return true;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
		return String.format("%-15s%-16s%-16s%-15s%-15s\n", phoneName,companyName,serious,madeCountry,sdf.format(manufactureYear));
	}
	public static Phone createPhone(String stringdata) throws NumberFormatException, ParseException {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
				String [] data=stringdata.split(",");
				Phone phone=new Phone((data[0]),data[1],data[2],data[3],sdf.parse(data[4]));
				return phone;
			}

}
