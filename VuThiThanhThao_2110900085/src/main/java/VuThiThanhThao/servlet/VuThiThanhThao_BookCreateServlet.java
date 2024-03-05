package VuThiThanhThao.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import VuThiThanhThao.beans.VuThiThanhThao_2110900085_Book;
import VuThiThanhThao.conn.VuThiThanhThaoConnection;

public class VuThiThanhThao_BookCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VuThiThanhThao_BookCreateServlet() {
        super();
       
    }

  //Hiển thị trang thêm mới sach
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/VuThiThanhThao_BookCreate.jsp");
  		dispatcher.forward(request, response);
  	}
  	
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String MaSach_msv = (String) request.getParameter("MaSach_msv");
		String TenSach_msv = (String) request.getParameter("TenSach_msv");
		String DonGia_msvStr = (String) request.getParameter("DonGia_msv");
		float DonGia_msv = 0;
		try {
			DonGia_msv = Float.parseFloat(DonGia_msvStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		VuThiThanhThao_BookCreateServlet book = new VuThiThanhThao_BookCreateServlet(MaSach_msv, TenSach_msv, DonGia_msv);
		
		//Kiểm tra code ít nhất 1 ký tự [a-zA-Z_0-9]
				String regex = "\\w+";
				if (MaSach_msv == null || !MaSach_msv.matches(regex)) {
					errorString = "VuThiThanhThao_BookCreate Code invalid!";
				}
				
				if (errorString != null) {
					request.setAttribute("errorString", errorString);
					request.setAttribute("VuThiThanhThao_BookCreate", VuThiThanhThao_2110900085_Book);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/VuThiThanhThao_BookCreate.jsp");
					dispatcher.forward(request, response);
					return;
				}
				Connection conn = null;
				try {
					conn = VuThiThanhThaoConnection.getMSSQLConnection();
					VuThiThanhThaoConnection.insertBook(conn, VuThiThanhThao_2110900085_Book);
					response.sendRedirect(request.getContextPath() + "/VuThiThanhThao_BookList");
				} catch (Exception e) {
					e.printStackTrace();
					errorString = e.getMessage();
					request.setAttribute("errorString", errorString);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/VuThiThanhThao_BookCreate.jsp");
					dispatcher.forward(request, response);
				}
	}

}
