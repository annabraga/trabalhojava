import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.sound.midi.*;


public class ThreeButtons extends MouseAdapter implements ActionListener{
	JFrame frame = new JFrame("Exercicio de JFrame");
	JButton button1 = new JButton("Ana");
	JButton button2 = new JButton("Braga");
	JButton button3 = new JButton("ERRAR!");
	
	public boolean shape;
	public boolean shape1=false;
	
	int counter1=0;
	
	
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
		frame.getContentPane().add(BorderLayout.NORTH,button3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener (this);
	}
	public 	void actionPerformed(ActionEvent e){
		
		if(e.getSource() == button1){
			shape = false;
			frame.repaint();
			counter1++;
		}
		if(counter1>1){
			shape = true;
			frame.repaint();
		}
		else if (e.getSource()==button2){
			try{
				int x=8/0;
			}
			catch(Exception ex){
				shape1=true;
				frame.repaint();
			}
			
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
			
			if (shape==true){
				g.fillOval(x,y,d1,d1);
				}
			else if (shape==false){
				g.fillRect(x,y,d1,d1);
				}	
			if (shape1==true){
				g.setColor(Color.BLACK);
				g.fillRect(30,30,600,600);
			}
		}
	}
}
