import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JFrame implements ActionListener {
	
	JPanel north,south,west,east,center,center2;
	JLabel label1,label2,label3;
	JButton submit;
	JTextField text1,text2,text3;
	Db dbcon = new Db();
	

	public Update() {
		
		label1 = new JLabel("Masukan kode menu yang ingin di update!");
		label2 = new JLabel("Update harga menu:");
		label3 = new JLabel("Update stok menu:");
		label1.setFont(new Font("Serif",Font.BOLD, 12));
		label2.setFont(new Font("Serif",Font.BOLD, 12));
		label3.setFont(new Font("Serif",Font.BOLD, 12));
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		center = new JPanel(new GridLayout(6,1));
//		center2 = new JPanel(new GridLayout(3,1));
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		submit = new JButton("Submit");
		submit.addActionListener(this);
		text1.setPreferredSize(new Dimension (40,40));
		this.setTitle("Update Menu"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
		this.setResizable(true); //prevent frame from being resized
		this.setSize(400,300);
		this.add(center, BorderLayout.CENTER);
//		this.add(center2, BorderLayout.CENTER);
		this.add(north, BorderLayout.NORTH);
		this.add(west, BorderLayout.WEST);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
		center.add(label1);
		center.add(text1);
		center.add(label2);
		center.add(text2);
		center.add(label3);
		center.add(text3);
		south.add(submit);
		this.setVisible(true);
				
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			if (text3.getText().equals("")) {
			dbcon.UpdateHarga(text2.getText(), text1.getText());
			}
			
			else if (text2.getText().equals("")) {
				dbcon.UpdateStok(text3.getText(), text1.getText());
				}	
			else {
				dbcon.UpdateMenu(text2.getText(), text3.getText(), text1.getText());
			}
		}
		}

	public static void main(String[] args) {
		new Update();

	}

}
