

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet 
{
	static String custID="", output="", coID="";
	static Connection conn;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String companyID, position, cityID, stateID, firstN, lastN, address, email,Address,zip,Title, ID;
		// TODO Auto-generated method stub
		 try {
	        	//URL of Oracle database server
	        	 
	             String url = "jdbc:oracle:thin:testuser/password@localhost"; 
	             try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             
	             //properties for creating connection to Oracle database
	             Properties props = new Properties();
	             props.setProperty("user", "testdb");
	             props.setProperty("password", "password");
	           
	             //creating connection to Oracle database using JDBC
	             try {
	     			conn = DriverManager.getConnection(url,props);
	     		} catch (SQLException e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     		}
	             custID= request.getParameter("custID");
	             coID=request.getParameter("companyID");
	             System.out.println(custID + "   " +coID);
	             
	             
	             if(coID==null)
	             {
	             //System.out.println(custID);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("select * from UserInfo where ID=" + custID);   
	             output+="<table border=2 color=white>";
	             output+="<tr><th>ID </th><th>Title</th><th>First Name</th><th>Last Name</th><th> Address </th><th> Zip Code</th><th> Email </th><th> Position </th><th> Company ID"
	             		+ "</th><th> City ID </th><th> State ID</th></tr> ";
	            while(rs.next())
	            {
	            	ID= rs.getString("ID");
	            	Title= rs.getString("TITLE");
	           		firstN= rs.getString("FIRSTNAME");
	           		lastN= rs.getString("LASTNAME");
	           		Address=rs.getString("ADDRESS");
	           		zip=rs.getString("ZIP");
	           		email=rs.getString("EMAIL");
	           		position=rs.getString("POSIT");
	           		companyID=rs.getString("COMPANYID");
	           		cityID=rs.getString("CITYID");
	           		stateID=rs.getString("STATEID");
	           		//System.out.println(ID + " "+ Title + " "+ firstN + " "+ lastN + " "+ Address + " "+ zip + " "+ email + " "+ position + " "+companyID + " "+cityID + " "+stateID);
	           	
	           		output+= "<tr><td>" +ID + "</td><td>"+ Title+ "</td><td>"+ firstN + "</td><td>"+ lastN +"</td><td>"+ Address + "</td><td>"+ zip +
	           				"</td><td>" + email+ "</td><td>" + position +"</td><td>"+ companyID+ "</td><td>"+ cityID+ "</td><td>" +stateID +"</td></tr>";   
	            }
	             request.setAttribute("message", output);
	    	     getServletContext().getRequestDispatcher("/Details.jsp").forward(request,response);
	    	     output="";
	             }
	             else
	             {
	            	 
	            	 Statement stmt = conn.createStatement();
		             ResultSet rs = stmt.executeQuery("select * from UserInfo where COMPANYID=" + coID);   
		             output+="<table border=2 color=white>";
		             output+="<tr><th>ID </th><th>Title</th><th>First Name</th><th>Last Name</th><th> Address </th><th> Zip Code</th><th> Email </th><th> Position </th><th> Company ID"
		             		+ "</th><th> City ID </th><th> State ID</th></tr> ";
		             while(rs.next())
		             {
		            	ID= rs.getString("ID");
		            	Title= rs.getString("TITLE");
		           		firstN= rs.getString("FIRSTNAME");
		           		lastN= rs.getString("LASTNAME");
		           		Address=rs.getString("ADDRESS");
		           		zip=rs.getString("ZIP");
		           		email=rs.getString("EMAIL");
		           		position=rs.getString("POSIT");
		           		companyID=rs.getString("COMPANYID");
		           		cityID=rs.getString("CITYID");
		           		stateID=rs.getString("STATEID");
		           		//System.out.println(ID + " "+ Title + " "+ firstN + " "+ lastN + " "+ Address + " "+ zip + " "+ email + " "+ position + " "+companyID + " "+cityID + " "+stateID);
		           	
		           		output+= "<tr><td>" +ID + "</td><td>"+ Title+ "</td><td>"+ firstN + "</td><td>"+ lastN +"</td><td>"+ Address + "</td><td>"+ zip +
		           				"</td><td>" + email+ "</td><td>" + position +"</td><td>"+ companyID+ "</td><td>"+ cityID+ "</td><td>" +stateID +"</td></tr>";   
		             }
		             request.setAttribute("message", output);
		    	     getServletContext().getRequestDispatcher("/Details.jsp").forward(request,response);
		    	     output="";
	             }
	            conn.close();
	            
	            
	
	} 
		 catch (SQLException e)
		 {
		// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
