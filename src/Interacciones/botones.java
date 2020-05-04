package Interacciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.ventanas;
import Main.window;

public class botones extends JFrame implements ActionListener {
	JButton btn;
	
	public botones(String Label)
	{
		setLayout(null);
		btn=new JButton(Label);
		btn.addActionListener(this);
		window.p.add(btn);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("HOLAAA");
		
	}
}
