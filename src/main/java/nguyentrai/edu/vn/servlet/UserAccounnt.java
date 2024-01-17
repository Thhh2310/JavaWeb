package nguyentrai.edu.vn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserAccounnt")
public class UserAccounnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
	private static final String ConnectionUtils = null;

    public UserAccounnt() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();	//Write to client
		
		out.println("<html><head><meta charset='UTF-8><title>InputForm</title></head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> DEMO tra cứu bằng Servlet </h1>");
		out.println("<form action='SearchAccount' method='post'>");
		out.println("<p> Input phone: ");
		out.println("<input type=text name='phone'/>");
		out.println("<p> <input type='submit' value='Search'/>");
		out.println("</form>");
		
		try {
			String sql = "Select * from USER_ACCOUNT ";
			Connection conn = ConnectionUtils.getMSSQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			
	out.println("<tr><th>User</th> <th>Name</th> <th>Phone</th></tr>");
			if (rs != null) {
				while (rs.next()) {
					//Đọc dữ liệu và hiển thị
					out.println("<tr>");
					out.println("<td>" + rs.getString("CusUser") +  "</td>");
					out.println("<td>" + rs.getString("CusName") +  "</td>");
					out.println("<td>" + rs.getString("CusPhone") +  "</td>");
					out.println("</tr>");
				}
			}
			rs.close();
			out.println("</table>");
		} catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() +  "</h1>");
			out.println("<p>" + ex.toString() +  "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
