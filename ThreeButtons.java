import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;


public class ThreeButtons implements ActionListener{
	JFrame frame = new JFrame("Exercicio de JFrame");
	JButton button1 = new JButton("Ana");
	JButton button2 = new JButton("Braga");
	JButton button3 = new JButton("ERRAR!");
	
	int counter1=0;
	int counter2=0;
	int counter3=0;
	
	public static void main (String[] args){
		ThreeButtons gui = new ThreeButtons();
		gui.go();
	}
	
	public void go(){
	
		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.setSize(700,700);
		frame.setVisible(true);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.getContentPane().add(BorderLayout.EAST,button2);
		frame.getContentPane().add(BorderLayout.WEST,button1);
		frame.getContentPane().add(BorderLayout.CENTER,button3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener (this);
	}
	public 	void actionPerformed(ActionEvent e){
		
		if(e.getSource() == button1){
			counter1++;			
		}
		else if(e.getSource() == button2){
			counter2++;
		}
		else if(e.getSource()==button3){
			counter3++;
		}
	}
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
	
			int red = (int)(Math.random()*255);
			int green= (int)(Math.random()*255);
			int blue=(int)(Math.random()*255);

			int x = (int)(Math.random()*355);
			int y = (int)(Math.random()*355);
			int d1 = (int)(Math.random()*355);

			Color randomColor = new Color (red,green,blue,100);
			g.setColor(randomColor);
	}
	}
}
