package VuThiThanhThao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VuThiThanhThao.beans.VuThiThanhThao_2110900085_Book;

public class VuThiThanhThao_BookUtils {
	
	//Đọc danh sách sach
		public static List<VuThiThanhThao_2110900085_Book> queryProduct(Connection conn, Object maSach_msv) throws SQLException {
			String sql = "Select a.MaSach_msv, a.TenSach_msv, a.SoLuong_msv, a.DonGia_msv, a.Anh_msv from Book a";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<VuThiThanhThao_2110900085_Book> list = new ArrayList<VuThiThanhThao_2110900085_Book>();
				while (rs.next()) {
					String MaSach_msv = rs.getString("MaSach_msv");
					String TenSach_msv = rs.getString("TenSach_msv");
					int SoLuong_msv = rs.getInt("SoLuong_msv");
					float DonGia_msv = rs.getFloat("DonGia_msv");
					String Anh_msv = rs.getString("Anh_msv");
					VuThiThanhThao_2110900085_Book book = new VuThiThanhThao_2110900085_Book();
					book.setMaSach_msv(MaSach_msv);
					book.setTenSach_msv(TenSach_msv);
					book.setSoLuong_msv(SoLuong_msv);
					book.setDonGia_msv(DonGia_msv);
					book.setAnh_msv(Anh_msv);
					list.add(book);
				}
				return list;
		}
		
		//Tìm kiếm theo mã sach
		public static VuThiThanhThao_2110900085_Book findBook(Connection conn, String MaSach_msv) throws SQLException {
			String sql = "Select a.MaSach_msv, a.TenSach_msv, a.SoLuong_msv, a.DonGia_msv, a.Anh_msv a where a.MaSach_msv=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, MaSach_msv);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String TenSach_msv = rs.getString("TenSach_msv");
				int SoLuong_msv = rs.getInt("SoLuong_msv");
				float DonGia_msv = rs.getFloat("DonGia_msv");
				String Anh_msv = rs.getString("Anh_msv");
				VuThiThanhThao_2110900085_Book book = new VuThiThanhThao_2110900085_Book(MaSach_msv, TenSach_msv, SoLuong_msv, DonGia_msv, Anh_msv);
				return book;
			}
			return null;
		}
		
		//Thêm mới sach
		public static void insertBook(Connection conn, VuThiThanhThao_2110900085_Book book) throws SQLException {
			String sql = "Insert into Book(MaSach_msv, TenSach_msv, SoLuong_msv, DonGia_msv, Anh_msv) values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getMaSach_msv());
			pstm.setString(2, book.getTenSach_msv());
			pstm.setInt(3, book.getSoLuong_msv());
			pstm.setFloat(4, book.getDonGia_msv());
			pstm.setString(5, book.getAnh_msv());
			pstm.executeUpdate();
		}
		
		//Cập nhật sach
		public static void updateBook(Connection conn, VuThiThanhThao_2110900085_Book book) throws SQLException {
			String sql = "Update Book set TenSach_msv =?, SoLuong_msv =?, DonGia_msv =?, Anh_msv =? where MaSach_msv =?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getMaSach_msv());
			pstm.setString(2, book.getTenSach_msv());
			pstm.setInt(3, book.getSoLuong_msv());
			pstm.setFloat(4, book.getDonGia_msv());
			pstm.setString(5, book.getAnh_msv());
			pstm.executeUpdate();
		}
		
		//Xoá một sach
		public static void deleteProduct(Connection conn, String MaSach_msv) throws SQLException {
			String sql = "Delete From Product where Code =?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, MaSach_msv);
			pstm.executeUpdate();
		}
}
