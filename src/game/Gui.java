package game;

import javafx.beans.binding.ObjectExpression;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.*;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.*;

public class Gui extends JFrame implements KeyListener,ActionListener{
	private JFrame jf;
	private JPanel menu_jp;
	private JPanel button_jp;
	private JMenuBar menu_mb;
	private JMenu menu_jm;
	private JMenu help_jm;
	private JMenuItem menu1_jm;
	private JMenuItem menu2_jm;
	private JLabel score_jl;
	private MyButton[][] jb;
	public boolean flag = false;
	
	public Gui() {
		jf = new JFrame("2048");
		jf.setSize(320, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);jf.setVisible(true);
		jf.setLayout(new BorderLayout());
		initMenu();
		initButton();
		jf.setVisible(true);
		jf.addKeyListener(this);
	}
	
	private void initMenu() {
		menu_jp = new JPanel();
		menu_jp.setSize(320, 10);;
		button_jp = new JPanel();
		menu_mb = new JMenuBar();
		menu_jm = new JMenu("menu");
		help_jm = new JMenu("help");
		menu1_jm = new JMenuItem("begin");
		menu2_jm = new JMenuItem("again");
		menu1_jm.addActionListener(this);
		menu2_jm.addActionListener(this);
		menu_jm.add(menu1_jm);
		menu_jm.add(menu2_jm);
		menu_mb.add(menu_jm);
		menu_mb.add(help_jm);
		jf.setJMenuBar(menu_mb);
		score_jl = new JLabel("0");
		menu_jp.add(score_jl);
		jf.add(menu_jp,BorderLayout.NORTH);
	}
	private void initButton() {
		button_jp = new JPanel();
		button_jp.setLayout(new GridLayout(4, 4));
		jb = new MyButton[4][4];
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				ImageIcon icon = new ImageIcon("numimage/black.PNG");
				jb[i][j] = new MyButton();
				jb[i][j].setSize(80, 80);
				button_jp.add(jb[i][j]);
			}
		}
		jf.add(button_jp,BorderLayout.CENTER);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("VK_UP");
			MoveButton.moveUp(this);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("VK_DOWN");
			MoveButton.moveDown(this);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("VK_LEFT");
			MoveButton.moveLeft(this);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("VK_RIGHT");
			MoveButton.moveRight(this);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	public MyButton[][] getJb() {
		return this.jb;
	}
	
	public void setJb(int[][] num) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				jb[i][j].setNum(num[i][j]);;
			}
		}
	}

	public JLabel getScore_jl() {
		return this.score_jl;
	}

	public static void main(String[] args) {
		new Gui();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == menu1_jm) {
            System.err.println("开始按钮");
            MoveButton.addNum(this);
        }
        if(o == menu2_jm) {
            System.err.println("再次按钮");
            this.initButton();
        }
    }
}
