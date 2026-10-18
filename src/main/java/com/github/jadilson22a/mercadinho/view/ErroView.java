package com.github.jadilson22a.mercadinho.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ErroView {
	
	private String errorText;
	private JFrame frame;

	public ErroView(String errorText) {
		this.errorText = errorText;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton sairButton = new JButton("sair");
		frame.getContentPane().add(sairButton, BorderLayout.SOUTH);
		
		JLabel erroText = new JLabel(this.errorText);
		erroText.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(erroText, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
