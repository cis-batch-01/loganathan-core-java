package com.phones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhoneBo {

	public  List<Phone>filterByCompanyName(List<Phone> phoneList,String companyName)
	{
		List<Phone> resList=new ArrayList<Phone>(); //creating the list with genere
		for(Phone phone:phoneList) {
			if(phone.getCompanyName().contains(companyName)) {
			resList.add(phone);
		}
		
		}
		return resList;
	}
	
	public  List<Phone>filterByDate(List<Phone> phoneList,Date manufactureDate){
		
		List<Phone> resList=new ArrayList<Phone>();
		for(Phone phone:phoneList) {
			if(phone.getManufactureYear().after(manufactureDate)||phone.getManufactureYear().equals(manufactureDate))
			{
				resList.add(phone);
			}
				
			}
			
		return resList;
	}

	
}
	
