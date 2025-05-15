

import java.sql.*;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MysqlConnect conn = new MysqlConnect();
		
		
		
		do {
			try {
				switch(printMenu()) {
				case 1: // insert or update data base
					System.out.println("********* OPTIONS **********\n"
							+ "1. Insert Tenant\n"
							+ "2. Insert Property\n"
							+ "3. Insert Rental\n"
							+ "4. Update Tenant\n"
							+ "5. Update Propety\n"
							+ "6. Update Rental\n"
							);
					int choice = sc .nextInt();
					
					ResultSet exists;
					exists = conn.select("tenant", "tenant_num", 0);// if not exist saves tenant with number 0 helps with property, email & telephone insert
					if(exists == null ) {
						conn.insertTenant(0, null, null, null, null, null, 0, 0, null);
					}
				
					exists = conn.select("owner", "recognize_number", 0);// if not exist saves owner with number 0 helps with email & telephone insert
					if(exists == null ) {
						conn.insertOwner(0, null, null, null, null, null, null, 0, 0, null);
					}
					
					exists = conn.select("worker", "worker_number", 0);// if not exist saves worker with number 0 helps with email & telephone insert
					if(exists == null ) {
						conn.insertWorker(0, null, null, null, null, null, 0, null, 0, 0, null, 0);
					}
					
					exists = conn.select("shop", "shop_number", 0);// if not exist saves shop with number 0 helps with email & telephone insert
					if(exists == null ) {
						conn.insertShop(0, null, 0, 0, null);
					}

					switch (choice) {
		                case 1://checked
		                	// Handle tenant insertion
		                    
		                	System.out.println("Please enter tenant's number:\n");
		                	int t_num = sc.nextInt();//enter tenant number
		                	
		                	// searches if tenant's number already exists
		                	ResultSet rs1 = conn.select("tenant", "tenant_num", t_num);
					
		                
		                	if (rs1 != null) {//if true asks user if he wants to update or no
		                		
		                		System.out.println("Tenant already exists!");
		                		break;
		                	}
		                	else {
		                		
		                		System.out.println("Please enter tenant's name or null if it is a business:\n");
		                		String t_name = sc.next();//enter tenant name	
		                		System.out.println("Please enter tenant's surname or null if it is a business:\n");
		                		String t_surname = sc.next();//enter tenant surname
		                		System.out.println("Please enter tenant's fathername or null if it is a business:\n");
		                		String t_fname = sc.next();//enter tenant father name
		                		System.out.println("Please enter tenant's business name or null if it is a person:\n");
		                		String t_bname = sc.next();//enter business name
		                		System.out.println("Please enter tenant's address street:\n");
		                		String t_street = sc.next();//enter street from address
		                		System.out.println("Please enter tenant's address number:\n");
		                		int t_addr_num = sc.nextInt();//enter tenant's address number
		                		System.out.println("Please enter tenant's address T_K:\n");
		                		int t_t_k = sc.nextInt();//enter tenant's address T_K: taxydromikos kodikas
		                		System.out.println("Please enter tenant's city of residence\n");
		                		String t_city = sc.next();//enter city of residence
		                		System.out.println("Please enter tenant's email:\n");
		                		String t_email = sc.next();//enter email
		                		System.out.println("Please enter tenant's telephone number:\n");
		                		int t_tel = sc.nextInt();//enter tenant's telephone number
		                		
		                		
		                    	
		                		conn.insertTenant(t_num, t_name, t_surname, t_fname, t_bname, t_street, t_addr_num,
									t_t_k, t_city);
								
		                		conn.insertEmail(t_email, t_num, 0, 0, 0); // inserts tenants email
		                		conn.insertTelephone(t_tel, t_num, 0, 0, 0);// inserts tenants telephone number
		                		
		                		break;
		                	}
						
		                    
		                case 2://checked
		                	// Handle property insertion
		                	
		                	System.out.println("Please enter property's number:\n");
		                	int p_num = sc.nextInt();//enter property number
		                	
		                	// searches if property's number already exists
		                	
						    ResultSet rs2 = conn.select("property", "property_number", p_num);
						    
						
						    if (rs2 != null) {// case property exists already
		                		
		                    	System.out.println("Property already exists.\n");
		                    	break;

						    }
						    else {//if user wants to add new property he must add new owner or use an existing one
							
						    	System.out.println("Please enter owner's number:\n");
						    	int o_num = sc.nextInt();//enter owner number
		                	
		                	// searches if owner's number already exists
						    	rs1 = conn.select("owner", "recognize_number", o_num);
					
		                
						    	if (rs1 == null) { // if owner doesn't already exists
						    		
						    		System.out.println("Owner not found! please insert the following attributes:\n");
						    	
		                		
						    		System.out.println("Please enter owner's name or null if it is a business:\n");
						    		String o_name = sc.next();//enter owner name	
						    		System.out.println("Please enter owner's surname or null if it is a business:\n");
						    		String o_surname = sc.next();//enter owner surname
						    		System.out.println("Please enter owner's fathername or null if it is a business:\n");
						    		String o_fname = sc.next();//enter owner father name
						    		System.out.println("Please enter owner's business name or null if it is a person:\n");
						    		String o_bname = sc.next();//enter business name
						    		System.out.println("Please enter owner's business type or null if it is a person:\n");
						    		String o_btype = sc.next();//enter business type
						    		System.out.println("Please enter owner's address street (instead of space use _):\n");
						    		String o_street = sc.next();//enter street from address
						    		System.out.println("Please enter owner's address number:\n");
						    		int o_addr_num = sc.nextInt();//enter owner's address number
						    		System.out.println("Please enter owner's address T_K:\n");
						    		int o_t_k = sc.nextInt();//enter owner's address T_K: taxydromikos kodikas
						    		System.out.println("Please enter owner's city of residence\n");
						    		String o_city = sc.next();//enter city of residence
						    		System.out.println("Please enter owner's email:\n");
			                		String o_email = sc.next();//enter email
			                		System.out.println("Please enter owner's telephone number:\n");
			                		int o_tel = sc.nextInt();//enter owner's telephone number
			
		                 
		                    	
						    		conn.insertOwner(o_num, o_name, o_surname, o_fname, o_bname, o_btype,
						    				 o_street, o_addr_num, o_t_k, o_city);
						    		
						    		conn.insertEmail(o_email, 0, o_num, 0, 0);
						    		conn.insertTelephone(o_tel, 0, o_num, 0, 0);
						    		//must add workers number 
						    	}	
						    	System.out.println("Please enter worker's number:\n");//with the addition of a new property
						    		//user must add a new worker or use an existing one
						    	int w_num = sc.nextInt();//enter worker number
			                	
			                	// searches if worker's number already exists
							    rs1 = conn.select("worker", "worker_number", w_num);
						
			                
							    if (rs1 == null) {//if true asks user if he wants to update or no
							    			
							    	System.out.println("Worker not found! please insert the following attributes:\n");
			                		
							    	System.out.println("Please enter worker's name :\n");
							    	String w_name = sc.next();//enter worker name	
							    	System.out.println("Please enter worker's surname :\n");
							    	String w_surname = sc.next();//enter worker surname
							    	System.out.println("Please enter worker's fathername :\n");
							    	String w_fname = sc.next();//enter worker father name
							    	System.out.println("Please enter worker's gender :\n");
							    	String w_gender = sc.next();//enter worker gender
							    	System.out.println("Please enter worker's speciality:\n");
							    	String w_speciality = sc.next();//enter worker speciality
							    	System.out.println("Please enter worker's salary:\n");
							    	int w_salary = sc.nextInt();//enter worker salary
							    	System.out.println("Please enter worker's address street (instead of space use _) :\n");
							    	String w_street = sc.next();//enter street from address
							    	System.out.println("Please enter worker's address number:\n");
							    	int w_addr_num = sc.nextInt();//enter workers's address number
							    	System.out.println("Please enter worker's address T_K:\n");
							    	int w_t_k = sc.nextInt();//enter workers's address T_K: taxydromikos kodikas
							    	System.out.println("Please enter worker's city of residence\n");
							    	String w_city = sc.next();//enter city of residence
							    	System.out.println("Please enter worker's shop number:\n");
							    	int w_s_num = sc.nextInt();//enter workers's address T_K: taxydromikos kodikas
							    	System.out.println("Please enter worker's email:\n");
			                		String w_email = sc.next();//enter email
			                		System.out.println("Please enter worker's telephone number:\n");
			                		int w_tel = sc.nextInt();//enter worker's telephone number
			                 
							    	rs1 = conn.select("shop", "shop_number", w_s_num);
							    	
							    	if(rs1 == null) {
							    		System.out.println("Shop doesn't exist! Please enter the following attributes:\n");
							    		
							    		System.out.println("Please enter shop's address street (instead of space use _):\n");
    							    	String s_street = sc.next();//enter shop from address
    							    	System.out.println("Please enter shop's address number:\n");
    							    	int s_addr_num = sc.nextInt();//enter shop's address number
    							    	System.out.println("Please enter shop's address T_K:\n");
    							    	int s_t_k = sc.nextInt();//enter shop's address T_K: taxydromikos kodikas
    							    	System.out.println("Please enter shop's city \n");
    							    	String s_city = sc.next();//enter city of residence
    							    	System.out.println("Please enter shop's email:\n");
    			                		String s_email = sc.next();//enter email
    			                		System.out.println("Please enter shop telephone number:\n");
    			                		int s_tel = sc.nextInt();//enter shop's telephone number
    							    	
    							    	conn.insertShop(w_s_num, s_street, s_addr_num, s_t_k, s_city);
    							    	conn.insertEmail(s_email, 0, 0, 0, w_s_num);
    						    		conn.insertTelephone(s_tel, 0, 0, 0, w_s_num);
							    	}
			                    	
							    	conn.insertWorker( w_num, w_name, w_surname, w_fname,
							    				w_gender, w_speciality,w_salary, w_street, 
							    				w_addr_num, w_t_k, w_city, w_s_num);
							    	
							    	conn.insertEmail(w_email, 0, 0, w_num, 0);
						    		conn.insertTelephone(w_tel, 0, 0, w_num, 0);
			                 
			                    
									
							    }		
						    	


							    System.out.println("Please enter property's square meters:\n");
							    int s_meters = sc.nextInt();//enter square meters
							    System.out.println("Please enter property's type:\n");
							    String p_type = sc.next();//enter property type
							    System.out.println("Please enter property's address street:\n");
							    String p_street = sc.next();//enter street from address
							    System.out.println("Please enter property's address number:\n");
							    int p_addr_num = sc.nextInt();//enter property's address number
							    System.out.println("Please enter property's address T_K:\n");
							    int p_t_k = sc.nextInt();//enter property's address T_K: taxydromikos kodikas
							    System.out.println("Please enter property's city:\n");
							    String p_city = sc.next();//enter city

						
							    conn.insertProperty(p_num, s_meters, p_type, p_street, p_addr_num, p_t_k, p_city, o_num,
						    			w_num);
						    	}	
						    
						    break;
		                     
		               case 3://checked
		                    // Handle rental insertion
		                	System.out.println("Please enter contract's number:\n");
		                	int c_num = sc.nextInt();//enter contract number
		                	
		                	// searches if property's number already exists
					
						    ResultSet rs3 = conn.select("contract","hire_number"
						    		+ "", c_num);
					
					    	if (rs3 != null) {// contract exists
					    		System.out.println("Contranct already exists!");
					    		break;
						    }
					    	else {//contract doesn't exist
					    		System.out.println("Please enter property's number:\n");
						    	int p_p_num = sc.nextInt();//enter property's number
						    	
						    	ResultSet rs4 = conn.select("property", "property_number", p_p_num);
						    	
						    	if(rs4 != null) {
						    		ResultSet rs5 = conn.select("contract", "property_property_number", p_p_num);
						    		if(rs5 != null) {
						    			System.out.println("Property already rented!\n");//property inside the database and rented
						    		}else {
						    			System.out.println("Property found!\nIt is available for renting!");// property inside the database ,not rented 
						    		}
						    	}else {
						    		System.out.println("Property not found!:\n");// property is not inside the database
						    		break;
						    	}

						    	System.out.println("Please enter contract's sign date:\n");
						    	String c_date = sc.next();//enter contract's sign date
						     	System.out.println("Please enter contract's start date:\n");
						    	String c_start_date = sc.next();//enter contract's start date
						    	System.out.println("Please enter contract's end date:\n");
						    	String c_end_date = sc.next();//enter contract's end date
						    	
						
						    	
						    	System.out.println("Please enter tenant's number:\n");//then user must insert the new tenant
			                    t_num = sc.nextInt();//enter tenant number
			                	
			                	// searches if tenant's number already exists
			                	rs1 = conn.select("tenant", "tenant_num", t_num);
						
			                
			                	if (rs1 != null) {//if true asks user if he wants to update or no
			                		
			                		System.out.println("Tenant exists.\n");
			                	}	
			                	else {
			                		
			                		System.out.println("Please enter tenant's name or null if it is a business:\n");
			                		String t_name = sc.next();//enter tenant name	
			                		System.out.println("Please enter tenant's surname or null if it is a business:\n");
			                		String t_surname = sc.next();//enter tenant surname
			                		System.out.println("Please enter tenant's fathername or null if it is a business:\n");
			                		String t_fname = sc.next();//enter tenant father name
			                		System.out.println("Please enter tenant's business name or null if it is a person:\n");
			                		String t_bname = sc.next();//enter business name
			                		System.out.println("Please enter tenant's address street (instead of space use _):\n");
			                		String t_street = sc.next();//enter street from address
			                		System.out.println("Please enter tenant's address number:\n");
			                		int t_addr_num = sc.nextInt();//enter tenant's address number
			                		System.out.println("Please enter tenant's address T_K:\n");
			                		int t_t_k = sc.nextInt();//enter tenant's address T_K: taxydromikos kodikas
			                		System.out.println("Please enter tenant's city of residence\n");
			                		String t_city = sc.next();//enter city of residence
			                		System.out.println("Please enter tenant's email:\n");
			                		String t_email = sc.next();//enter email
			                		System.out.println("Please enter tenant's telephone number:\n");
			                		int t_tel = sc.nextInt();//enter tenant's telephone number
			                    	
			                		conn.insertTenant(t_num, t_name, t_surname, t_fname, t_bname, t_street, t_addr_num,
										t_t_k, t_city);
			                		conn.insertEmail(t_email, t_num, 0, 0, 0);
			                		conn.insertTelephone(t_tel, t_num, 0, 0, 0);
			                 
			                    	
			                		
			                		
			                	}
			                	conn.insertRental(c_num, c_date, c_start_date, c_end_date, p_p_num, t_num);
			                	break;
					    	}
					
		                case 4://checked
		                    // Handle tenant update
		                	int ans1 = 1;
	                		do {
	                		    	
	                		    if (ans1 == 1) {
	                		    	System.out.println("Please enter tenant's number");// helps finding which tenant we will change
	    		                    int t_num1 = sc.nextInt();
	    		                    ResultSet find1 = conn.select("tenant", "tenant_num", t_num1);
	    		                    if(find1 == null) {
	    		                    	System.out.println("Tenant does not exist!");
	    		                    	
	    		                    }
	    		                    else {
	    		                    	System.out.println("Enter the variable and then the value:\n");
	    		                    	System.out.println("Choices for variable: name, surname, father_name, business_name, email, telephone, street, Number, t_k, city\n");
	    		                    	String variable = sc.next();
	    		                    	int value2;
	    		                    	if ( !variable.equals("Number") && !variable.equals("t_k")) {// case variable type string
	    		                    		String value1 = sc.next();
	                		    		
	    		                    		conn.updateTenant( t_num1, null, -1, variable, value1);
									    //null indicates that no int value will change
	    		                    	}else {
	    		                    		value2 = sc.nextInt();
									    
	    		                    		conn.updateTenant(t_num1, variable, value2, null, null);
								        // null indicates than no string value will change
	    		                    	}
	    		                    	System.out.println("Do you want to continue updating tenant with number:"+ t_num1 +" or upgrade another tenant? Enter 1(Yes) or 2(No)\n");
	    		                    	ans1 = sc.nextInt();
	    		                    }	
	    		               }else if (ans1 != 2 && ans1 != 1) {
	    		                   	System.out.println("Invalid answer! Enter 1(Yes) or 2(No)\n");
	    		                   	ans1 = sc.nextInt();
	    		               }
	                		    }while (ans1 != 2);
	                		      
		                    break;
		                case 5://checked
		                    // Handle property update
		                    ans1 = 1;
		                    int p_num1;
	                		do {
	                		    	
	                		    if (ans1 == 1) {
	                		    	System.out.println("Please enter property's number");// helps finding which property we will change
	    		                    p_num1 = sc.nextInt();
	    		                    ResultSet find1 = conn.select("property", "property_number", p_num1);
	    		                    if(find1 == null) {
	    		                    	System.out.println("Property does not exist!");
	    		                    	
	    		                    }
	    		                    else {
	    		                    	System.out.println("Enter the variable and then the value:\n");
	    		                    	System.out.println("Choices for variable: sq_meters, type, street, Number, t_k, city,"
	                		    			+ " owner_recognize_number, tenant_tenant_num, worker_worker_number\n");
	    		                    	String variable = sc.next();
	    		                    	int value2;
	    		                    	if ( !variable.equals("owner_recognize_number") && !variable.equals("worker_worker_number") && !variable.equals("tenant_tenant_num") && !variable.equals("type") && !variable.equals("street") && !variable.equals("city") ) {// variable type = int
	    		                    		value2 = sc.nextInt();
										
	    		                    		conn.updateProperty( p_num1, variable, value2, null, null);
										
	    		                    	}else if(variable.equals("owner_recognize_number")) {// if we update owner_recognize_number
                		    			//we must update owner entity as well
                		    			
	    		                    		value2 = sc.nextInt();
	    		                    		rs2 = conn.select("owner", "recognize_number", value2);
	    		                    		if(rs2 != null) {// if owner already exists upgrade
                		    				
                		    				conn.updateProperty( p_num1, variable, value2, null, null);
	    		                    		}else { // else insert new one
	    		                    			System.out.println("Owner doesn't exist! Please enter the following attributes:\n");
	    		                    			System.out.println("Please enter owner's name or null if it is a business:\n");
	    		                    			String o_name = sc.next();//enter owner name	
	    		                    			System.out.println("Please enter owner's surname or null if it is a business:\n");
	    		                    			String o_surname = sc.next();//enter owner surname
	    		                    			System.out.println("Please enter owner's fathername or null if it is a business:\n");
	    		                    			String o_fname = sc.next();//enter owner father name
	    		                    			System.out.println("Please enter owner's business name or null if it is a person:\n");
	    		                    			String o_bname = sc.next();//enter business name
	    		                    			System.out.println("Please enter owner's business type or null if it is a person:\n");
	    		                    			String o_btype = sc.next();//enter business type
	    		                    			System.out.println("Please enter owner's address street (instead of space use _):\n");
	    		                    			String o_street = sc.next();//enter street from address
	    		                    			System.out.println("Please enter owner's address number:\n");
	    		                    			int o_addr_num = sc.nextInt();//enter owner's address number
	    		                    			System.out.println("Please enter owner's address T_K:\n");
	    		                    			int o_t_k = sc.nextInt();//enter owner's address T_K: taxydromikos kodikas
	    		                    			System.out.println("Please enter owner's city of residence\n");
	    		                    			String o_city = sc.next();//enter city of residence
	    		                    			System.out.println("Please enter owner's email:\n");
	    		                    			String o_email = sc.next();//enter email
	    		                    			System.out.println("Please enter owner's telephone number:\n");
	    		                    			int o_tel = sc.nextInt();//enter owner's telephone number
        		                 
        		                    	
	    		                    			conn.insertOwner(value2, o_name, o_surname, o_fname, o_bname, o_btype,
        						    				 o_street, o_addr_num, o_t_k, o_city);
        						    		
	    		                    			conn.insertEmail(o_email, 0, value2, 0, 0);
	    		                    			conn.insertTelephone(o_tel, 0, value2, 0, 0);
        		                 
        		                    	
        						    		
	    		                    			conn.updateProperty( p_num1, variable, value2, null, null);
	    		                    		}
	                		    	
	    		                    	}else if(variable.equals("worker_worker_number")) {// if we update worker_worker_number
                		    			//we must update worker entity as well
	    		                    		value2 = sc.nextInt();
	    		                    		rs2 = conn.select("worker", "worker_number", value2);
	    		                    		if(rs2 != null) {// if owner already exists upgrade
	    		                    			
	    		                    			conn.updateProperty( p_num1, variable, value2, null, null);
	    		                    		}else { 
	    		                    			System.out.println("Worker doesn't exist! Please enter the following attributes:\n");
	    		                    			System.out.println("Please enter worker's name :\n");
	    		                    			String w_name = sc.next();//enter worker name	
	    		                    			System.out.println("Please enter worker's surname :\n");
	    		                    			String w_surname = sc.next();//enter worker surname
	    		                    			System.out.println("Please enter worker's fathername :\n");
	    		                    			String w_fname = sc.next();//enter worker father name
	    		                    			System.out.println("Please enter worker's gender :\n");
	    		                    			String w_gender = sc.next();//enter worker gender
	    		                    			System.out.println("Please enter worker's speciality:\n");
	    		                    			String w_speciality = sc.next();//enter worker speciality
	    		                    			System.out.println("Please enter worker's salary:\n");
	    		                    			int w_salary = sc.nextInt();//enter worker salary
	    		                    			System.out.println("Please enter worker's address street (instead of space use _):\n");
	    		                    			String w_street = sc.next();//enter street from address
	    		                    			System.out.println("Please enter worker's address number:\n");
	    		                    			int w_addr_num = sc.nextInt();//enter workers's address number
	    		                    			System.out.println("Please enter worker's address T_K:\n");
	    		                    			int w_t_k = sc.nextInt();//enter workers's address T_K: taxydromikos kodikas
	    		                    			System.out.println("Please enter worker's city of residence\n");
	    		                    			String w_city = sc.next();//enter city of residence
	    		                    			System.out.println("Please enter worker's shop number:\n");
	    		                    			int w_s_num = sc.nextInt();//enter worker shop number
	    		                    			System.out.println("Please enter worker's email:\n");
	    		                    			String w_email = sc.next();//enter email
	    		                    			System.out.println("Please enter worker's telephone number:\n");
	    		                    			int w_tel = sc.nextInt();//enter worker's telephone number
        			                 
	    		                    			rs1 = conn.select("shop", "shop_number", w_s_num);
        							    	
	    		                    			if(rs1 == null) {
	    		                    				System.out.println("Shop doesn't exist! Please enter the following attributes:\n");
	    		                    				
	    		                    				System.out.println("Please enter shop's address street (instead of space use _):\n");
	    		                    				String s_street = sc.next();//enter shop from address
	    		                    				System.out.println("Please enter shop's address number:\n");
	    		                    				int s_addr_num = sc.nextInt();//enter shop's address number
	    		                    				System.out.println("Please enter shop's address T_K:\n");
	    		                    				int s_t_k = sc.nextInt();//enter shop's address T_K: taxydromikos kodikas
	    		                    				System.out.println("Please enter shop's city \n");
	    		                    				String s_city = sc.next();//enter city of residence
	    		                    				System.out.println("Please enter shop's email:\n");
	    		                    				String s_email = sc.next();//enter email
	    		                    				System.out.println("Please enter shop telephone number:\n");
	    		                    				int s_tel = sc.nextInt();//enter shop's telephone number
            			                	
            							    	
	    		                    				conn.insertShop(w_s_num, s_street, s_addr_num, s_t_k, s_city);
	    		                    				conn.insertEmail(s_email, 0, 0, 0, w_s_num);
	    		                    				conn.insertTelephone(s_tel, 0, 0, 0, w_s_num);
	    		                    			}
        			                    	
	    		                    			conn.insertWorker( value2, w_name, w_surname, w_fname,
	    		                    					w_gender, w_speciality,w_salary, w_street, 
	    		                    					w_addr_num, w_t_k, w_city, w_s_num);
        							    	
	    		                    			conn.insertEmail(w_email, 0, 0, value2, 0);
	    		                    			conn.insertTelephone(w_tel, 0, 0, value2, 0);
        						    		
        							    	conn.updateProperty( p_num1, variable, value2, null, null);
	    		                    		}
                		    			
	    		                    	
	                		    	
	                		        
	    		                    	}else {// variable type = string
	    		                    		String value1 = sc.next();
	    		                    		System.out.println("else");
	    		                    		conn.updateProperty(p_num1, null, -1, variable, value1);
										
	    		                    	}
	    		                    	System.out.println("Do you want to continue updating property with number:"+ p_num1 +" Enter 1(Yes) or 2(No)\n");
	    		                    	ans1 = sc.nextInt();
	    		                    }	
	                		    }else if (ans1 != 2 && ans1 != 1) {
	                		    	System.out.println("Invalid answer! Enter 1(Yes) or 2(No)\n");
			                        ans1 = sc.nextInt();
	                		    }
	                		}while (ans1 != 2);
	                		      
		                    break;
		                case 6://checked
		                    // Handle rental update
		                    ans1 = 1;
		                    
	                		do {
	                		    	
	                		    if (ans1 == 1) {
	                		    	System.out.println("Please enter contract's number");// helps finding which contract we will change
	    		                    c_num = sc.nextInt();
	    		                    ResultSet find1 = conn.select("contract", "hire_number", c_num);
	    		                    if(find1 == null) {
	    		                    	System.out.println("Tenant does not exist!");
	    		                    	
	    		                    }
	    		                    else {
	    		                    	System.out.println("Enter the variable and then the value:\n");
	    		                    	System.out.println("Choices for variable: sign_date, starting_date, end_date, property_property_number, tenant_tenant_num\n");
	    		                    	String variable = sc.next();
	    		                    	int value2;
	    		                    	if ( !variable.equals("property_property_number") && !variable.equals("tenant_tenant_num"))  {// variable type = String
	    		                    		
	    		                    		String value1 = sc.next();
										
	    		                    		conn.updateRental( c_num, null, -1, variable, value1);
                		    			
	    		                    	}
	    		                    	else if(variable.equals("property_property_number")){
	                		    		
	    		                    		value2 = sc.nextInt();
	    		                    		rs2 = conn.select("property", "property_num", value2);
	    		                    		if(rs2 == null) {//property's number not found
	                		    			
	    		                    			System.out.println("Property doesn't exist\n");
	    		                    			break;
	    		                    		}
	    		                    		else {
	    		                    			conn.updateRental( c_num, variable, value2, null, null);
	    		                    		}
	                		    	
	    		                    	}else if(variable.equals("tenant_tenant_num")) {
	    		                    		value2 = sc.nextInt();
	                		    	
	    		                    		rs2 = conn.select("tenant", "tenant_num", value2);
	    		                    		if(rs2 != null) {// if tenant already exists upgrade
            		    				
	    		                    			conn.updateRental( c_num, variable, value2, null, null);
	    		                    		}else {
	    		                    			System.out.println("Tenant doesn't exist! Please enter the following attributes:\n");
	    		                    			System.out.println("Please enter tenant's name or null if it is a business:\n");
	    		                    			String t_name = sc.next();//enter tenant name	
	    		                    			System.out.println("Please enter tenant's surname or null if it is a business:\n");
	    		                    			String t_surname = sc.next();//enter tenant surname
	    		                    			System.out.println("Please enter tenant's fathername or null if it is a business:\n");
	    		                    			String t_fname = sc.next();//enter tenant father name
	    		                    			System.out.println("Please enter tenant's business name or null if it is a person:\n");
	    		                    			String t_bname = sc.next();//enter business name
	    		                    			System.out.println("Please enter tenant's address street:\n");
	    		                    			String t_street = sc.next();//enter street from address
	    		                    			System.out.println("Please enter tenant's address number:\n");
	    		                    			int t_addr_num = sc.nextInt();//enter tenant's address number
	    		                    			System.out.println("Please enter tenant's address T_K:\n");
	    		                    			int t_t_k = sc.nextInt();//enter tenant's address T_K: taxydromikos kodikas
	    		                    			System.out.println("Please enter tenant's city of residence\n");
	    		                    			String t_city = sc.next();//enter city of residence
	    		                    			System.out.println("Please enter tenant's email:\n");
	    		                    			String t_email = sc.next();//enter email
	    		                    			System.out.println("Please enter tenant's telephone number:\n");
	    		                    			int t_tel = sc.nextInt();//enter tenant's telephone number
	        		                    	
	    		                    			conn.insertTenant(value2, t_name, t_surname, t_fname, t_bname, t_street, t_addr_num,
	    		                    					t_t_k, t_city);
	    		                    			conn.insertEmail(t_email, value2, 0, 0, 0);
	    		                    			conn.insertTelephone(t_tel, value2, 0, 0, 0);
	        		                		
	    		                    			conn.updateRental( c_num, variable, value2, null, null);
	    		                    		}
	    		                    	}	
	    		                    }
	                		    		
	                		    }
				          	}while( ans1 != 1);
	                		  break;
		                
		                default:
		                    System.out.println("Invalid choice.");
		            }       
				
			    case 2://checked
			    	conn.case2();
				    break;
					
                case 3://checked
			    	
                	System.out.println("Please enter from today's date:\n");
                	String date = sc.next();//user enters from current date
 
					conn.case3(date);
					break;
				
                case 4://checked
                	
                	System.out.println("Please enter property's desired city:");
                	String city1 = sc.next();//user enters property's city
                	System.out.println("Please enter the street from property's address (instead of space use _):");
                	String strt = sc.next();//user enters the street from property's address
                	System.out.println("Please enter the number from property's address :");
                	int number = sc.nextInt();//user enters the number from property's address
                	System.out.println("Please enter the T_K from property's address:");
                	int t__k = sc.nextInt();//user enters property's T_K
                	System.out.println("Please enter property's type(or null if you don't have any preference):");
                	String type1 = sc.next();//user enters  property's type
                	System.out.println("Please enter the shop's number :");
                	int num = sc.nextInt();//user enters shop's number
                	System.out.println("Please enter the property's square meters or :");
                	int sq = sc.nextInt();//user enters square meters
                	
                	conn.case4(city1, strt, number, t__k, type1, num, sq);

						
				     break;
                case 5://checked
                	ResultSet rs3;
                	ResultSet rs4;
                	int c_num;
                	do {
                    	System.out.println("Please enter contract's number:\n");
                    	c_num = sc.nextInt();//enter contract number
                    	System.out.println("Please enter property's number:\n");
	                	int p_num = sc.nextInt();//enter property number
                	
                	    // searches if property's number already exists
			            rs3 = conn.select("contract","hire_number", c_num);
			            rs4 = conn.select("contract", "property_property_number", p_num);
			            
			            if(rs3 != null) {
			            	System.out.println("Contract already exists!\n");
			            	break;
			            }
			            if(rs4 == null) {
			            	System.out.println("Property doesn't exist!\n");
			            	break;
			            }
                	}while(rs3 != null || rs4 == null );// until user gives a new contract number
                	                   						   //and an existing property
                	
                	System.out.println("Please enter contract's sign date:\n");
			    	String c_date = sc.next();//enter contract's sign date
			     	System.out.println("Please enter contract's start date:\n");
			    	String c_start_date = sc.next();//enter contract's start date
			    	System.out.println("Please enter contract's end date:\n");
			    	String c_end_date = sc.next();//enter contract's end date
			    	System.out.println("Please enter property's number:\n");
			    	int p_p_num = sc.nextInt();//enter contract number
			    	
			    	System.out.println("Please enter tenant's number:\n");// enters property's tenant
                	int t_num = sc.nextInt();//enter tenant number
                	
                	// searches if tenant's number already exists
                	ResultSet rs1 = conn.select("tenant", "tenant_num", t_num);
			
                
                	if (rs1 != null) {//if true tenant with tenant_num = t_num is used
                		
                		System.out.println("Tenant already exists!");
                		
                	}
                	else { //else a new one is inserted in the database
                		
                		System.out.println("Please enter tenant's name or null if it is a business:\n");
                		String t_name = sc.next();//enter tenant name	
                		System.out.println("Please enter tenant's surname or null if it is a business:\n");
                		String t_surname = sc.next();//enter tenant surname
                		System.out.println("Please enter tenant's fathername or null if it is a business:\n");
                		String t_fname = sc.next();//enter tenant father name
                		System.out.println("Please enter tenant's business name or null if it is a person:\n");
                		String t_bname = sc.next();//enter business name
                		System.out.println("Please enter tenant's address street (instead of space use _):\n");
                		String t_street = sc.next();//enter street from address
                		System.out.println("Please enter tenant's address number:\n");
                		int t_addr_num = sc.nextInt();//enter tenant's address number
                		System.out.println("Please enter tenant's address T_K:\n");
                		int t_t_k = sc.nextInt();//enter tenant's address T_K: taxydromikos kodikas
                		System.out.println("Please enter tenant's city of residence\n");
                		String t_city = sc.next();//enter city of residence
                		System.out.println("Please enter tenant's email:\n");
                		String t_email = sc.next();//enter email
                		System.out.println("Please enter tenant's telephone number:\n");
                		int t_tel = sc.nextInt();//enter tenant's telephone number
                    	
                		conn.insertTenant(t_num, t_name, t_surname, t_fname, t_bname, t_street, t_addr_num,
							t_t_k, t_city);

                		conn.insertEmail(t_email, t_num, 0, 0, 0);
                		conn.insertTelephone(t_tel, t_num, 0, 0, 0);
                	}
			
			
			    	conn.insertRental(c_num, c_date, c_start_date, c_end_date, p_p_num, t_num);
			    	
			    	break;
			    	
			          
				    
                case 6:
                	
                	conn.case6();
                	break;
                
                case 7:
                	
                	conn.case7();
                	break;
                	
                case 8:
                	
                	conn.case8();
                	break;
                	
                case 9:
                	
                	System.out.println("Which variable you want to upgrade?\n"
                			+ "1.email\n"
                			+ "2.telephone number\n"
                			+ "3.Address(city)\n"
                			+ "4.Address(street)\n"
                			+ "5.Address(number)\n"
                			+ "6.Address(t_k)\n"
                			+ "7.Exit\n");
                	
                	int choice1 = sc.nextInt();  
                	
                	do {
                    	switch(choice1) {
                    	    case 1:
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant \n");
                    	    	String entity = sc.next();
                    	    	while (!entity.equals("worker") && !entity.equals("tenant") && !entity.equals("owner") && !entity.equals("shop")) {
                    	    		System.out.println("This entity doesn't have an email attribute.\n");
                    	    		System.out.println("Try entering 'worker' or 'owner' or 'shop' or 'tenant'\n");
                    	    		entity = sc.next();
                	    	}
                	    	
                    	    	String var;
                    	    	if(entity.equals("tenant")) {
                    	    		var = "tenant_tenant_num";
                    	    		
                    	    	}else if(entity.equals("owner")){
                    	    		var = "owner_recognize_number";
            	         
                    	    	}	else {
            	    	
                    	    		var = entity + "_" +entity +"_number";
                    	    	}
                    	    	
                    	    	int number1;
                    	    	do {
                    	    		System.out.println("Please enter "+ entity +"'s number:\n");
                    	    		number1 = sc.nextInt(); 
                	    	
                    	    		exists = conn.select("email", var, number1);
                    	    		if(exists == null) {
                    	    			System.out.println("You entered invalid number!\n");
                    	    		}
                	    	
                    	    	}while(exists == null); 
                	    	
                    	    	System.out.println("Please enter new email:\n");
                    	    	String value  = sc.next();
                	    	
                    	    	conn.updateET( "email", var, number1, "email",0, value);
                	    	
                    	    	break;
                	    
                    	    case 2:
                	    	
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant \n");
                    	    	String entity1 = sc.next();
                    	    	while (!entity1.equals("worker") && !entity1.equals("tenant") && !entity1.equals("owner") && !entity1.equals("shop")) {
                    	    		System.out.println("This entity doesn't have a telephone attribute.\n");
                    	    		System.out.println("Try entering 'worker' or 'owner' or 'shop' or 'tenant'\n");
                    	    		entity1 = sc.next();
                    	    	}
                	    	
                    	    	String var1;
                    	    	if(entity1.equals("tenant")) {
                    	    		var1 = "tenant_tenant_num";
            	    		
                    	    	}else if(entity1.equals("owner")){
                    	    		var1 = "owner_recognize_number";
            	         
                    	    	}	else {
            	    	
                    	    		var1 =  entity1 + "_" + entity1 +"_number";
                    	    	}
                    	    	ResultSet exists1;
                    	    	int number2;
                    	    	do {
                    	    		System.out.println("Please enter "+ entity1 +"'s number:\n");
                    	    		number2 = sc.nextInt(); 
                	    	
                    	    		exists1 = conn.select(entity1, var1, number2);
                    	    		if(exists1 == null) {
                    	    			System.out.println("You entered invalid number!\n");
                    	    		}
                	    	
                    	    	}while(exists1 == null); 
                	    	
                    	    	System.out.println("Please enter new telephone:\n");
                    	    	int value1  = sc.nextInt();
                	    	
                    	    	conn.updateET("telephone", var1, number2, "telephone", value1, null);                	    	
                    	    	break;
                	    	
                    	    case 3:
                	    	
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant, property \n");
                    	    	String entity2 = sc.next();
                    	    	while (!entity2.equals("worker") && !entity2.equals("tenant") && !entity2.equals("owner") && !entity2.equals("shop") && !entity2.equals("property")) {
                    	    		System.out.println("This entity doesn't have a city attribute.\n");
                    	    		System.out.println("Try entering 'Worker' or 'owner' or 'shop' or 'tenant' or 'property'!\n");
                    	    		entity2 = sc.next();
                    	    	}
                	    	
                    	    	String var2;
                    	    	if(entity2.equals("tenant")) {
                    	    		var2 = "tenant_num";
                    	    		System.out.println(var2);
            	    		
                    	    	}else if(entity2.equals("owner")){
                    	    		var2 = "recognize_number";
                    	    		System.out.println(var2);
            	         
                    	    	}	else {
            	    	
                    	    		var2 =  entity2 +"_number";
                    	    		System.out.println(var2);
                    	    	}
                    	    	ResultSet exists2;
                    	    	int number3;
                    	    	do {
                    	    		System.out.println("Please enter "+ entity2 +"'s number:\n");
                    	    		number3 = sc.nextInt(); 
                	    	
                    	    		exists2 = conn.select(entity2, var2, number3);
                    	    		if(exists2 == null) {
                    	    			System.out.println("You entered invalid number!\n");
                    	    		}
                	    	
                    	    	}while(exists2 == null); 
                    	    	
                    	    	System.out.println("Please enter new city:\n");
                    	    	String value2  = sc.next();
                	    	
                    	    	conn.updateAddress(entity2, var2, number3, null, 0, "city", value2);
                    	    	
                    	    	break;
                	    	
                    	    case 4:
                	    	
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant, property \n");
                    	    	String entity3 = sc.next();
                    	    	while (!entity3.equals("worker") && !entity3.equals("tenant") && !entity3.equals("owner") && !entity3.equals("shop") && !entity3.equals("property")) {
                    	    		System.out.println("This entity doesn't have a street attribute.\n");
                    	    		System.out.println("Try entering 'Worker' or 'Owner' or 'Shop' or 'Tenant' or 'Property'!\n");
                    	    		entity3 = sc.next();
                    	    	}
                	    	
                    	    	String var3;
                    	    	if(entity3.equals("tenant")) {
                    	    		var3 = "tenant_num";
            	    		
                    	    	}else if(entity3.equals("owner")){
                    	    		var3 = "recognize_number";
            	         
                    	    	}	else {
            	    	
                    	    		var3 =  entity3 +"_number";
                    	    	}
                    	    	ResultSet exists3;
                    	    	int number4;
            	        		do {
            	        			System.out.println("Please enter"+ entity3 +"'s number:\n");
            	        			number4 = sc.nextInt(); 
                	    	
            	        			exists3 = conn.select(entity3, var3, number4);
            	        			if(exists3 == null) {
            	        				System.out.println("You entered invalid number!\n");
            	        			}
                	    	
            	        		}while(exists3 == null); 
                	    	
            	        		System.out.println("Please enter new street:\n");
            	        		String value3  = sc.next();
                	    	
            	        		conn.updateAddress(entity3, var3, number4, null, 0, "street", value3);
                	    	
            	        		break;	
                	    	
                    	    case 5:
                	    	
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant, property \n");
                    	    	String entity4 = sc.next();
                    	    	while (!entity4.equals("worker") && !entity4.equals("tenant") && !entity4.equals("owner") && !entity4.equals("shop") && !entity4.equals("property")) {
                    	    		System.out.println("This entity doesn't have a Number attribute.\n");
                	    			System.out.println("Try entering 'Worker' or 'Owner' or 'Shop' or 'Tenant' or 'Property'!\n");
                	    			entity4 = sc.next();
                    	    	}
                	    	
                    	    	String var4;
                    	    	if(entity4.equals("tenant")) {
                    	    		var4 = "tenant_num";
            	    		
                    	    	}else if(entity4.equals("owner")){
                    	    		var4 = "recognize_number";
            	        		 
                    	    	}	else {
            	    	
                    	    		var4 =  entity4 +"_number";
                    	    	}
                    	    	ResultSet exists4;
                    	    	int number5;
                    	    	do {
                    	    		System.out.println("Please enter"+ entity4 +"'s number:\n");
                	        		number5 = sc.nextInt(); 
                	    	
                	        		exists4 = conn.select(entity4, var4, number5);
                	        		if(exists4 == null) {
                	        		System.out.println("You entered invalid number!\n");
                	        		}
                	    	
                    	    	}while(exists4 == null); 
                	    	
                    	    	System.out.println("Please enter new Number:\n");
                    	    	int value4  = sc.nextInt();
                	    	
                    	    	conn.updateAddress(entity4, var4, number5, "Number", value4, null, "0");
                	    	
                    	    	break;
                	    	
                    	    case 6:
                    	    	
                    	    	System.out.println("Please enter which entity you want to update:\n");
                    	    	System.out.println("Choices: owner, worker, shop, tenant, property \n");
                    	    	String entity5 = sc.next();
                    	    	while (!entity5.equals("worker") && !entity5.equals("tenant") && !entity5.equals("owner") && !entity5.equals("shop") && !entity5.equals("property")) {
                    	    		System.out.println("This entity doesn't have a Number attribute.\n");
                    	    		System.out.println("Try entering 'Worker' or 'Owner' or 'Shop' or 'Tenant' or 'Property'!\n");
                    	    		entity5 = sc.next();
                    	    	}
                 	    	
                    	    	String var5;
                    	    	if(entity5.equals("Tenant")) {
             	        		 var5 = "tenant_num";
             	    		
                    	    	}else if(entity5.equals("Owner")){
             	        		 var5 = "recognize_number";
             	         
                    	    	}	else {
             	    	
                    	    		var5 =  entity5 +"_number";
                    	    	}
                    	    	ResultSet exists5;
                    	    	int number6;
                    	    	do {
                    	    		System.out.println("Please enter"+ entity5 +"'s number:\n");
                    	    		number6 = sc.nextInt(); 
                 	    	
                    	    		exists5 = conn.select(entity5, var5, number6);
                    	    		if(exists5 == null) {
                    	    			System.out.println("You entered invalid number!\n");
                    	    		}
                 	    	
                    	    	}while(exists5 == null); 
                 	    	
                    	    	System.out.println("Please enter new t_k:\n");
                    	    	int value5  = sc.nextInt();
                 	    	
                    	    	conn.updateAddress(entity5, var5, number6, "t_k", value5, null, "0");
                    	    	
                    	    	break;
                    	    
                    	    case 7:
                    	    	break;
                    	    	
                    	}  
                    	
                    	System.out.println("Which variable you want to upgrade?\n"
                    			+ "1.email\n"
                    			+ "2.telephone number\n"
                    			+ "3.Address(city)\n"
                    			+ "4.Address(street)\n"
                    			+ "5.Address(number)\n"
                    			+ "6.Address(t_k)\n"
                    			+ "7.Exit\n");
                    	
                    	choice1 = sc.nextInt();
                	}while(choice1 != 7 );
                case 10:
                	break;
				}		
		    }catch (SQLException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
				
				
		}while( printMenu() != 10);
				
		
	}
	
	
	

	static private int printMenu() {

		Scanner sc = new Scanner(System.in);
		int choice1;
		
		do {
		    System.out.println("************* MENU *************\n"
			    + "1. Insert or Update the Data Base\n"
			    + "2. Show the list with every property available per shop\n"
			    + "3. Show every property with an active contract from all the shops\n"
			    + "4. Show the list of properties available for renting for a particular shop\n"
			    + "5. Make a contract for property renting\n"
			    + "6. Delete every unavailable property for renting\n"
			    + "7. Show every unrented property from every shop which is published in the newspaper\n"
			    + "8. Show every possible tenant who visited a property more than once\n"
			    + "9. Update email, telephone number or address\n"
			    + "10. Exit Menu\n");
		    
		    choice1 = sc.nextInt();
		    
	    }while( choice1 < 1 || choice1 > 9);
		
		return choice1;
	}
	
	
	

}
