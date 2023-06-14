

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("ename");
		String password=request.getParameter("epwd");
		String email=request.getParameter("eemail");
		String gender=request.getParameter("gender");
		long mobile_no=Long.parseLong(request.getParameter("emno"));
		String state=request.getParameter("estate");
		String country=request.getParameter("ecountry");
		String address=request.getParameter("eadd");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dhanunjay","welcome");
			PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setLong(5,mobile_no);
			ps.setString(6,state);
			ps.setString(7,country);
			ps.setString(8,address);
		 int i=ps.executeUpdate();
		 out.println("You Are Registered Successfully...");
		 con.close();
		}
		catch (Exception ex)
		{
			out.print(ex);
		}
		}
	}


