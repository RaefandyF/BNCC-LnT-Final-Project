import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
	Db dbcon = new Db();
	ResultSet rs;
	JPanel north,south,east,west;
	JLabel label1;
	JButton button1;

	public View() {

		rs = dbcon.getdata();
		this.setTitle("View Menu"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true); 
		this.setSize(420,420); 
		JTable tabel1 = new JTable();
		tabel1.setPreferredScrollableViewportSize(new Dimension(500,200));
		tabel1.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(tabel1);
		this.add(scrollPane);
		
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		
		label1 = new JLabel("Daftar Seluruh Menu");
		label1.setFont(new Font("Serif",Font.BOLD, 15));
		north.add(label1);
		
		button1 = new JButton("Tutup");
		south.add(button1);
		button1.addActionListener(this);
		
				
		DefaultTableModel table = new DefaultTableModel();
		table.addColumn("Kode Menu");
		table.addColumn("Nama Menu");
		table.addColumn("Harga Menu");
		table.addColumn("Stok Menu");
		tabel1.setModel(table);
		this.setVisible(true);
		
		try {
			while(rs.next()) {
				table.addRow(new Object[] {
					rs.getString("KodeMenu"),
					rs.getString("NamaMenu"),
					rs.getString("HargaMenu"),
					rs.getString("StokMenu")
				});
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			this.dispose();
		}	
		
		
	}

	public static void main(String[] args) {
		new View();

	}

}
