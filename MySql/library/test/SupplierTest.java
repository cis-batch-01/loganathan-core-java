package com.technocis.library.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.technocis.library.DAO.SupplierDAO;
import com.technocis.library.impl.SupplierDAOImpl;
import com.technocis.library.model.Author;
import com.technocis.library.model.Supplier;

public class SupplierTest {
	public static void SupplierManager(){
		  Scanner scan=new Scanner(System.in);
		  SimpleDateFormat  sdf =new SimpleDateFormat("dd-MM-yyyy");
		  SupplierDAO supplierdao=new SupplierDAOImpl();
		   System.out.println("Supplier details");
		   char choice='n';
		   do{
		  System.out.println("1.get Supplier\n2.getAll Supplier\n3.add Supplier\n4.update Supplier\n5.delete Supplier");
		  System.out.println("select any one");
		  int option=Integer.parseInt(scan.nextLine());
		  switch(option) {
		  case 1:
		   System.out.println("Enter the Supplier id");
		   int selectId=Integer.parseInt(scan.nextLine());
		   Supplier supplier=supplierdao.getSupplier(selectId);
		   System.out.println(supplier!=null?"data is showed\n"+supplier:"no data");
		  break;
		  case 2:
		  List<Supplier> supplierList=supplierdao.getAllSupplier();
		  if(supplierList.isEmpty()) {
			  System.out.println("data is not found");
		  }
		  else {
		  for(Supplier sup :supplierList){
			  System.out.println(sup!=null?"data is showed\n"+sup:"data is not found");
		  }
		  }
		  break;
		  case 3:
		  System.out.println("Enter the Supplier details");
		   System.out.println("This  details to be enter (name,phone,address,mail_id,password )");
		   String insert=scan.nextLine();
		   String data[]=insert.split(",");
		    Supplier insertsupplier=new Supplier(data[0],data[1], Long.parseLong(data[2]),data[3],(data[4]));
		  Supplier insertData=supplierdao.addSupplier(insertsupplier);
		   System.out.println(insertData!=null?"data is stored\n"+insertData:"no data stored");
		  break;
		  case 4:
			  System.out.println("Enter the Supplier id");
			   int updateId=Integer.parseInt(scan.nextLine());
			   Supplier oldData= supplierdao.getSupplier(updateId);
			   System.out.println(oldData + "\n updateauthor");  
		  System.out.println("Enter the Supplier details");
		   System.out.println("This  details to be enter (name,phone,address,mail_id,password )");
		   String updateSupplier=scan.nextLine();
		   String update[]=updateSupplier.split(",");
		  
		    Supplier updatesupplier=new Supplier( update[0], update[1], Long.parseLong(update[2]), update[3], update[4]);
		  Supplier updateData=supplierdao.updateSupplier(updateId, updatesupplier);
		    System.out.println(updateData!=null?"data is updated\n"+updateData:"data is not updated");
		  
		  break;
		  case 5:
		  System.out.println("Enter the Supplier id");
		   int Id=Integer.parseInt(scan.nextLine());
		   Supplier delete=supplierdao.deleteSupplier(Id);
		   System.out.println(delete!=null?"delete is success\n"+delete:"delete is not success");
		  break;
		  default:
		  System.out.println("invalid choice");
		  break;
		   }System.out.println("Do you want continue in Supplier(y/n):");
		   choice =scan.nextLine().charAt(0);
		  } while(choice=='y'||choice=='Y');
}
	}
