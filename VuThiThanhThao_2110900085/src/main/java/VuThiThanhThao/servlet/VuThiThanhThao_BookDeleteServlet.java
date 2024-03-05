package VuThiThanhThao.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import VuThiThanhThao.conn.VuThiThanhThaoConnection;
import VuThiThanhThao.utils.VuThiThanhThao_BookUtils;


public class VuThiThanhThao_BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VuThiThanhThao_BookDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorString = null;
		String MaSach_msv = (String)request.getParameter("MaSach_msv");
		Connection conn = null;
		try {
			conn = VuThiThanhThaoConnection.getMSSQLConnection();
			VuThiThanhThao_BookUtils.deleteProduct(conn, MaSach_msv);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productDeleteError.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/VuThiThanhThao_BookList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
