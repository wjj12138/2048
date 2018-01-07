package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{

	private static final long serialVersionUID = 1L;
	private int num;
	public MyButton() {
		this.num = 0;
		this.setIcon(new ImageIcon("numimage/black.PNG"));
	}
	
	public MyButton(int num) {
		this.num = num;
		String path = "numimage//" + num + ".PNG";
		ImageIcon icon = new ImageIcon(path);
		this.setIcon(icon);
	}
	
	public void setNum(int num) {
		this.num = num;
		String path = "numimage//" + num + ".PNG";
		ImageIcon icon = new ImageIcon(path);
		this.setIcon(icon);
	}
	
	public int getNum() {
		return this.num;
	}
}
