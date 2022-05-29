import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class Insert extends JFrame implements ActionListener {
	
	Db dbcon = new Db();
	JPanel center, south;
	JLabel label1, label2, label3, label4;
	JTextField textfield1,textfield2,textfield3,textfield4;
	JButton button;
	
	
	public Insert(){
		center = new JPanel(new GridLayout(8,1));
//		center.setBackground(Color.green);
		south = new JPanel();
//		south.setBackground(Color.red);
		label1 = new JLabel("Kode Menu:");
		label2 = new JLabel("Nama Menu:");
		label3 = new JLabel("Harga Menu:");
		label4 = new JLabel("Stok Menu:");
		label1.setFont(new Font("Serif",Font.BOLD, 12));
		label2.setFont(new Font("Serif",Font.BOLD, 12));
		label3.setFont(new Font("Serif",Font.BOLD, 12));
		label4.setFont(new Font("Serif",Font.BOLD, 12));
		
		textfield1 = new JTextField();
		textfield2 = new JTextField();
		textfield3 = new JTextField();
		textfield4 = new JTextField();
		button = new JButton("Submit");
		button.addActionListener(this);
		
		textfield1.setPreferredSize(new Dimension(400, 200));

		
		this.setTitle("Insert Menu"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setResizable(true); 
		this.setSize(420,420); 
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
//		center.setLayout(new GridLayout(3,2));
		center.add(label1);
		center.add(textfield1);
		center.add(label2);
		center.add(textfield2);
		center.add(label3);
		center.add(textfield3);
		center.add(label4);
		center.add(textfield4);
		south.add(button);
		this.setVisible(true);
		
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
			dbcon.InsertMenu(textfield1.getText(), textfield2.getText(), textfield3.getText(), 
							textfield4.getText());
		}
		
	}
	
	public static void main(String[] args) {
		new Insert();

	}

}
