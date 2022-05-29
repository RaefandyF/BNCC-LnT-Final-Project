import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
	
	JButton button1,button2,button3,button4;

	MyFrame(){
		button1 = new JButton("INSERT");
		button2 = new JButton("VIEW");
		button3 = new JButton("UPDATE");
		button4 = new JButton("DELETE");
		button1.setFont(new Font("Serif",Font.BOLD, 18));
		button2.setFont(new Font("Serif",Font.BOLD, 18));
		button3.setFont(new Font("Serif",Font.BOLD, 18));
		button4.setFont(new Font("Serif",Font.BOLD, 18));

		
//		button1.setBounds(60,0,300,100);
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(300,100));
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
//		button1.setBorder(BorderFactory.createEtchedBorder());
		
		this.setTitle("Database PT Pudding");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,1));
		this.setSize(420,420);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			this.dispose();
			Insert insert = new Insert();
		}
		if(e.getSource()==button2) {
			this.dispose();
			View view = new View();
		}
		if(e.getSource()==button3) {
			this.dispose();
			Update update = new Update();
		}
		if(e.getSource()==button4) {
			this.dispose();
			Delete delete = new Delete();
	}
		
	}

}
