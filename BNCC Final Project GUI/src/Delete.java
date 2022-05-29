import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JFrame implements ActionListener {
	JPanel north,south,west,east,center;
	JLabel label;
	JButton submit;
	JTextField text1;
	Db dbcon = new Db();

	public Delete() {
			
			label = new JLabel("Masukan kode menu yang ingin di delete!");
			label.setFont(new Font("Serif",Font.BOLD, 12));
			text1 = new JTextField();
			center = new JPanel(new GridLayout(3,1));
			north = new JPanel();
			south = new JPanel();
			east = new JPanel();
			west = new JPanel();
			submit = new JButton("Submit");
			submit.addActionListener(this);
//			text1.setPreferredSize(new Dimension (40,40));
			this.setTitle("Delete Menu"); //sets title of frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
			this.setResizable(true); //prevent frame from being resized
			this.setSize(300,200);
			this.add(center, BorderLayout.CENTER);
			this.add(north, BorderLayout.NORTH);
			this.add(west, BorderLayout.WEST);
			this.add(east, BorderLayout.EAST);
			this.add(south, BorderLayout.SOUTH);
			center.add(label);
			center.add(text1);
			south.add(submit);
			this.setVisible(true);
					
		}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			dbcon.DeleteMenu(text1.getText());
			}
	}
	

	public static void main(String[] args) {
		new Delete();

	}

}
