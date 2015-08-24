

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Inputs
 */
@WebServlet("/Inputs")
public class Inputs extends HttpServlet {
	static Connection conn;
	static String output="", output2="";
	static int grade2, count=0;
	static double average, average2;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inputs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Fname, Lname, firstN, lastN, ID, companyName="", coID;
		Fname= request.getParameter("Fname");
        Lname= request.getParameter("Lname");
		
        System.out.println(Fname);
        System.out.println(Lname);
        
        try {
       	//URL of Oracle database server
       	 
            String url = "jdbc:oracle:thin:testuser/password@localhost"; 
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
            
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
         
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ID,FIRSTNAME,LASTNAME from UserInfo where lastname Like '%" + Lname +"%'");
       
        output+="<table border=2 color=white>";
        output+="<tr><th>First Name </th><th>Last Name</th></tr> ";   
        while(rs.next())
       	 {
        	ID= rs.getString("ID");
       		firstN= rs.getString("FIRSTNAME");
       		 System.out.println(ID);
       		 lastN= rs.getString("LASTNAME");
       		
       		 output+= "<tr><td><a href= DetailServlet?custID="+ ID +">" + firstN+ "</a></td><td>"+ lastN + "</td></tr>"; 
       		
       	 }
        conn.close();
        
        
     //creating connection to Oracle database using JDBC
       try {
			conn = DriverManager.getConnection(url,props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       Statement stmt2 = conn.createStatement();
       System.out.println("select COMPANYID, Company from Companies where company Like '%" + Lname +"%'");
       ResultSet rs2 = stmt2.executeQuery("select COMPANYID,Company from Companies where company Like '%" + Lname +"%'");
       
       
       output2+="<p></p><table border=1 color=white bgcolor=white>";
       output2+="<tr><th>Company Names</th></tr> ";
       
       //System.out.println(rs2.getRow());
       while(rs2.next())
       {
    	   companyName=rs2.getString("COMPANY");
    	   coID=rs2.getString("CompanyID");
    	   output2+= "<tr><td><a href= DetailServlet?companyID="+ coID + ">"+ companyName +"</a></td></tr>";
    	
       }
       conn.close();
       
       }
        catch (Exception e) 
        {
       	 e.getMessage();
        }
        
        request.setAttribute("message", output);
        request.setAttribute("message2", output2);
	     getServletContext().getRequestDispatcher("/Output.jsp").forward(request,response);
	     output="";
	     output2="";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		// TODO Auto-generated method stub
	}

}
