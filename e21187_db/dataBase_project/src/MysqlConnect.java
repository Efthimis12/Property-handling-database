
import java.sql.*;


public class MysqlConnect {
	static String connection = "jdbc:mysql://localhost:3306/project_loans";
	static String user = "root";
	static String password = "";
public static void main(String[] args) throws SQLException {
	
	
	String driver = "com.mysql.jdbc.Driver";
	try{
		
		Class.forName(driver).getDeclaredConstructor().newInstance();
		Connection conn = DriverManager.getConnection(connection, user,password);
		System.out.println("Connected to database");
	}catch(Exception e) {
		e.printStackTrace();
	}	
	
} 

	
public ResultSet insertTenant(int tenant_num, String name, String surname, String father_name,
		String business_name, String street, int number, int t_k,
		String city) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();


        String query = "INSERT INTO `tenant`(`tenant_num`, `name`, `surname`, `father_name`, `business_name`,"
        		+ " `street`, `Number`, `t_k`, `city`) VALUES ('"+ tenant_num +"','"+ name +"'"
        		+ ",'"+ surname +"','"+ father_name +"','"+ business_name +"',"
        		+ "'"+ street +"','"+ number +"','"+ t_k +"','"+ city +"');";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}
	
public ResultSet insertOwner(int num, String name, String surname, String father_name,
		String business_name, String business_type, String street,
		int number, int t_k, String city) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();

        String query = "INSERT INTO `owner`(`recognize_number`, `name`, `surname`, `father_name`,"
        		+ " `business_name`, `business_type`, `street`, `Number`, `t_k`, `city`) VALUES "
        		+ "('"+ num +"','"+ name +"','"+ surname +"','"+ father_name +"','"+ business_name +"',"
        		+ "'"+ business_type +"','"+ street +"',"
        		+ "'"+ number +"','"+ t_k +"','"+ city +"');";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
    	if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}	

public ResultSet insertWorker(int num, String name, String surname, String father_name ,String gender,
		String speciality, int salary, String street, int number, int t_k,
		String city, int shop_shop_number) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_loans", "root", "");
        st = conn.createStatement();

        String query = "INSERT INTO `worker`(`worker_number`, `name`, `surname`, `father_name`,"
        		+ " `gender`, `speciality`, `salary`, `street`,"
        		+ " `Number`, `t_k`, `city`, `shop_shop_number` ) VALUES ('"+ num +"',"
        		+ "'"+ name +"','"+ surname +"','"+ father_name +"','"+ gender +"',"
        		+ "'"+ speciality +"','"+ salary +"','"+ street +"','"+ number +"',"
        		+ "'"+ t_k +"','"+ city +"','"+ shop_shop_number +"')";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}

public ResultSet insertEmail(String email, int tenant_tenant_num, int owner_recognize_number, 
		int worker_worker_number, int shop_shop_number) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();

        String query = "INSERT INTO `email`(`email`, `tenant_tenant_num`, `owner_recognize_number`, `worker_worker_number`,"
        		+ " `shop_shop_number` ) VALUES ('"+ email +"', '"+ tenant_tenant_num +"',  '"+ owner_recognize_number +"','"+ worker_worker_number +"','"+ shop_shop_number +"')";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}

public ResultSet insertTelephone(int telephone, int tenant_tenant_num, int owner_recognize_number, 
		int worker_worker_number, int shop_shop_number) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();

        String query = "INSERT INTO `telephone`(`telephone`, `tenant_tenant_num`, `owner_recognize_number`, `worker_worker_number`,"
        		+ " `shop_shop_number` ) VALUES ('"+ telephone +"', '"+ tenant_tenant_num +"',  '"+ owner_recognize_number +"', '"+ worker_worker_number +"','"+ shop_shop_number +"')";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}

public ResultSet insertShop(int num, String street, int number, int t_k,
		String city) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();

        String query = "INSERT INTO `shop`(`shop_number`, "
        		+ " `street`, `Number`, `t_k`, `city` ) VALUES ('"+ num +"',"
        		+ "'"+ street +"','"+ number +"','"+ t_k +"','"+ city +"')";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
}	

	

public ResultSet insertProperty(int property_num, int sq_meters, String type, String street,
		int number, int t_k, String city, int owner_recognize_number,  int worker_worker_number) 
		throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
        // in the following query setting tenant_tenant_num as '0' indicates that property is not loaned
        // helps with inserting new unloaned property
	    String query ="INSERT INTO `property`(`property_number`, `sq_meters`, `type`, `street`, `Number`, `t_k`,"
	    		+ " `city`, `owner_recognize_number`, `tenant_tenant_num`, `worker_worker_number`)"
	    		+ " VALUES ('"+ property_num +"','"+ sq_meters +"','"+ type +"','"+ street +"', "
	    		+ "'"+ number +"','"+ t_k +"','"+ city +"','"+ owner_recognize_number +"','0','"+ worker_worker_number +"')";
	    st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;
	
}

public ResultSet insertRental(int hire_number, String sign_date, String starting_date, String end_date,
		int property_property_num, int tenant_tenant_num) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
	String query ="INSERT INTO `contract`(`hire_number`, `sign_date`, `starting_date`, `end_date`, `property_property_number`, `tenant_tenant_num`) "
			+ "VALUES ('"+ hire_number +"','"+ sign_date +"','"+ starting_date +"','"+ end_date +"','"+ property_property_num +"','"+ tenant_tenant_num +"')";
	st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
	
}

public ResultSet updateTenant( int t_num,String var1, int value1, String var2, String value2) 
		throws SQLException {
	
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
	    if( var1 == null) {// case variable = String
		
	        String query = "UPDATE `tenant` SET `"+ var2 +"`='"+value2 +"' WHERE `tenant_num` ="+ t_num ;
	        st.executeUpdate(query);
	    }else {// case variable = int
		
		    String query ="UPDATE `tenant` SET `"+ var1 +"`='"+ value1 +"' WHERE `tenant_num` ="+ t_num ;
		    st.executeUpdate(query);
	    }
	    
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;     
	
}



public ResultSet updateProperty(int p_num,String var1, int value1, String var2, String value2)
		throws SQLException {
	// checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
	    if( var1 == null) {// case variable = String
		
	        String query ="UPDATE `property` SET `"+ var2 +"`='"+value2 +"' WHERE `property_number` ="+ p_num ;
	        st.executeUpdate(query);
	    }else {// case variable = int
		
	    	String query ="UPDATE `property` SET `"+ var1 +"`='"+value1 +"' WHERE `property_number` ="+ p_num ;
	    	st.executeUpdate(query);
	    } 
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;    	 
			
			
}

public ResultSet updateRental(int hire_num,String var1, int value1, String var2, String value2)
		throws SQLException {
	
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
	    if( var1 == null) {// case variable = String
		
	        st.executeUpdate("UPDATE `contract` SET `"+ var2 +"`='"+value2 +"' WHERE `hire_number` ="+ hire_num) ;
	    }else {// case variable = int
		
		    st.executeUpdate("UPDATE `contract` SET `"+ var1 +"`='"+value1 +"' WHERE `hire_number` ="+ hire_num);
	    }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;  
			
}


public ResultSet select(String entity, String variable, int value) throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query ="SELECT * FROM "+ entity +" WHERE "+ variable +" = '"+ value +"'";
        res = st.executeQuery(query);
        
        if (!res.next()) {
            res.close(); // Close the ResultSet
            res = null; // Set it to null
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
       
    
    	if (st != null) {
    		st.close();
    	}
    	if (conn != null) {
    		conn.close();
    	}
    }

    return res; 
}

public ResultSet case2() throws SQLException {
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query ="SELECT property.property_number FROM `shop`, `property` ,`worker` WHERE "
        		+ "property.worker_worker_number = worker.worker_number AND worker.shop_shop_number "
        		+ "= shop.shop_number ORDER BY shop.shop_number;";
        res = st.executeQuery(query);
        
        
        while (res.next()) {
            String element = res.getString("property.property_number");
            System.out.println(element);
            System.out.println("----------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
}


public ResultSet case3(String date) throws SQLException{
	
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query = "SELECT property.property_number,contract.property_property_number, contract.starting_date,"
			+ " contract.end_date FROM `property`, `contract` WHERE property.property_number ="
			+ " contract.property_property_number AND '"+ date +"' BETWEEN contract.starting_date AND"
			+ " contract.end_date;";
        res = st.executeQuery(query);
	
        while (res.next()) {
        	String element = res.getString("property.property_number");
        	System.out.println(element);
        	System.out.println("----------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	 if (st != null) {
             st.close();
         }
         if (conn != null) {
             conn.close();
         }
    }

    return res; 
}

public ResultSet case4(String city1, String strt, int  number,int t__k, String type1, int num, int sq) throws SQLException{
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        if( type1.equals("null")) { //case where user does not enter sq meters and property type
        	String query =  "SELECT property.property_number FROM `property`, `worker`, `shop` WHERE "
        			+ "shop.shop_number = '"+ num +"' AND shop.shop_number = worker.shop_shop_number AND "
        			+ "property.worker_worker_number = worker.worker_number AND property.city = '"+ city1 +"' "
        			+ "AND property.street = '"+ strt +"' AND property.Number = '"+ number +"' AND property.t_k "
        					+ "= '"+ t__k +"' AND property.sq_meters = '"+ sq +"' AND property.tenant_tenant_num = '0';";
        	res = st.executeQuery(query);
    	
        }else {	
        	String query =  "SELECT property.property_number FROM `property`, `worker`, `shop` WHERE "
        			+ "shop.shop_number = '"+ num +"' AND shop.shop_number = worker.shop_shop_number AND "
        			+ "property.worker_worker_number = worker.worker_number AND property.city = '"+ city1 +"' "
        			+ "AND property.street = '"+ strt +"' AND property.Number = '"+ number +"' AND property.t_k "
        			+ "= '"+ t__k +"' AND property.sq_meters = '"+ sq +"' AND property.type = '"+ type1 +"' "
        			+ "AND property.tenant_tenant_num = '0';";
        	res = st.executeQuery(query);
        }
        System.out.println(res);
        while (res.next()) {
        	String element = res.getString("property.property_number");
        	System.out.println(element);
        	System.out.println("----------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
}


public ResultSet case6() throws SQLException{
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query =  "DELETE FROM `property` WHERE property.tenant_tenant_num <> '0'";
        st.executeUpdate(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
}

public ResultSet case7() throws SQLException{
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query =  "SELECT property.property_number, property.tenant_tenant_num, tenant.tenant_num, "
			+ "add.add_id, add.property_property_number, journal.add_add_id FROM `property`, `tenant`, "
			+ "`add`, `journal` WHERE property.property_number = add.property_property_number AND "
			+ "property.tenant_tenant_num = tenant.tenant_num AND tenant.tenant_num = '0' AND "
			+ "journal.add_add_id = add.add_id ORDER BY property.property_number;";
        res = st.executeQuery(query);
        
        while (res.next()) {
        	String element = res.getString("property.property_number");
        	System.out.println(element);
        	System.out.println("----------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
}

public ResultSet case8() throws SQLException{
	//checked
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
        
        String query =  "SELECT tenant.tenant_num, visit.tenant_tenant_num, visit.visit_num FROM `tenant`, "
			+ "`visit` WHERE visit.tenant_tenant_num = tenant.tenant_num AND visit.visit_num > '1' "
			+ "ORDER BY tenant.tenant_num";
        res = st.executeQuery(query);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res; 
}

public ResultSet updateAddress(String entity, String attribute, int p_num, String var1, int value1, String var2, String value2) throws SQLException {

	
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
	    if( var1 == null) {// case variable = String
		
	        st.executeUpdate("UPDATE `"+ entity +
	    		 "` SET `"+ var2 +"` = '"+ value2 + "'"
	    		+ "WHERE "+ attribute +" ="+ p_num +";");
	    }else {// case variable = int
		
		    st.executeUpdate("UPDATE `"+ entity +
	    		 "` SET `"+ var1 +"` = '"+ value1 + "'"
	    		+ "WHERE "+ attribute +" ="+ p_num +";");
	    }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;  
}

public ResultSet updateET(String entity, String var, int num, String var1, int value1, String value2) throws SQLException {
	// checked
	
	Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    
    try {
        conn = DriverManager.getConnection(connection, user, password);
        st = conn.createStatement();
	
	    if( value2 != null) {// case variable = String
		
	        st.executeUpdate("UPDATE `"+ entity +
	    		 "` SET `"+ var1 +"` = '"+ value2 + "'"
	    		+ "WHERE "+ var +" ="+ num +";");
	    }else {// case variable = int
		
		    st.executeUpdate("UPDATE `"+ entity +
	    		 "` SET `"+ var1 +"` = '"+ value1 + "'"
	    		+ "WHERE "+ var +" ="+ num +";");
	    }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return res;  
}



}













