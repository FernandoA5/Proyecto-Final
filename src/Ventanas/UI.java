package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.ventanas;
import Main.window;

public class UI {
	
	public static JButton volver = new JButton();
	
	public UI()
	{
		volver.setLayout(null);
		volver.setText("<<");
		volver.setBackground(Color.white);
		volver.setForeground(Color.BLACK);
		volver.setBounds(0, 640, 100, 51);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//
				int t = window.alU.size();
				//
				ventanas.admU(window.alU.get(t-2));
				
			}
		};
		volver.addActionListener(al);
	}
	public void setVisible(boolean v)
	{
		volver.setVisible(v);
		window.p.add(volver);
	}
}
