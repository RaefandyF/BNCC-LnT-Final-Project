import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Db {

	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public Db() {
		// TODO Auto-generated constructor stub
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ptpudding", "root", "");
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InsertMenu (String kodeMenu, String namaMenu, String hargaMenu, String stokMenu) {
		try {
			if (kodeMenu.startsWith("PD-")){
				ps = con.prepareStatement("insert into Menu values (?,?,?,?)");
				ps.setString(1, kodeMenu);
				ps.setString(2, namaMenu);
				ps.setString(3, hargaMenu);
				ps.setString(4, stokMenu);
				ps.execute();	
				JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan", "Informasi", 
						JOptionPane.PLAIN_MESSAGE);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Kode menu harus diawali huruf 'PD-' dengan huruf besar", "Informasi", 
											JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getdata() {
		try {
			ps = con.prepareStatement("Select * from Menu");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public void UpdateHarga(String HargaMenu, String KodeMenu) {
		try {			
		ps = con.prepareStatement("UPDATE `Menu` SET `HargaMenu` = ? WHERE `Menu`.`KodeMenu` = ?");
		ps.setString(1, HargaMenu);
		ps.setString(2, KodeMenu);
		ps.execute();
		rs = getdata();
		
		while(rs.next()) {
			String data = rs.getString("KodeMenu");
			if (KodeMenu.equals(data)) {
				JOptionPane.showMessageDialog(null, "Harga Menu Berhasil di Update", "Informasi", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		}
		
	public void UpdateStok(String StokMenu, String KodeMenu) {
		try {
		ps = con.prepareStatement("UPDATE `Menu` SET `StokMenu` = ? WHERE `Menu`.`KodeMenu` = ?");
		ps.setString(1, StokMenu);
		ps.setString(2, KodeMenu);
		ps.execute();
		
		rs = getdata();
		while(rs.next()) {
			String data = rs.getString("KodeMenu");
			if (KodeMenu.equals(data)) {
				JOptionPane.showMessageDialog(null, "Stok Menu Berhasil di Update", "Informasi", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void UpdateMenu(String HargaMenu, String StokMenu, String KodeMenu) {
			try {
			ps = con.prepareStatement("UPDATE `Menu` SET `HargaMenu` = ?, `StokMenu` = ? "
									+ "WHERE `Menu`.`KodeMenu` = ?");
			ps.setString(1, HargaMenu);
			ps.setString(2, StokMenu);
			ps.setString(3, KodeMenu);
			ps.execute();
			
			rs = getdata();
			while(rs.next()) {
				String data = rs.getString("KodeMenu");
				if (KodeMenu.equals(data)) {
					JOptionPane.showMessageDialog(null, "Data Menu Berhasil di Update", "Informasi", 
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		public void DeleteMenu(String KodeMenu) {
			try {
			rs = getdata();
			
			while(rs.next()) {
				String data = rs.getString("KodeMenu");
				if (KodeMenu.equals(data)) {
					JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Informasi", 
							JOptionPane.PLAIN_MESSAGE);
				}
			}
			ps = con.prepareStatement("DELETE FROM `Menu` WHERE `Menu`.`KodeMenu` = ?");
			ps.setString(1, KodeMenu);
			ps.execute();
			
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
