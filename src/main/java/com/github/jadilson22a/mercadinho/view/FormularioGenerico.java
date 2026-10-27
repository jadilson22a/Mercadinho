package com.github.jadilson22a.mercadinho.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioGenerico {

	public FormularioGenerico(List<String> labels) {
		
		JFrame janela = new JFrame("Cadastro Produtos");
		janela.setSize(500, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null); // Centraliza a janela na tela do computador
		
		// 1. PAINEL EXTERNO (Gerenciador de Centralização)
		// centraliza automaticamente o que estiver dentro dele!
		JPanel painelExterno = new JPanel(new GridBagLayout());
		painelExterno.setBackground(new Color(240, 240, 240)); // Opcional: cor de fundo sutil
		
		// 2. PAINEL INTERNO (O Formulário Quadrado)
		JPanel painelFormulario = new JPanel(new GridBagLayout());
		painelFormulario.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), // Borda externa
				BorderFactory.createEmptyBorder(20, 20, 20, 20)       // Margem interna (Padding)
		));
		painelFormulario.setBackground(Color.WHITE);
		
		criarPainel(painelFormulario, labels);
		
		painelExterno.add(painelFormulario);
		
		janela.add(painelExterno);
		janela.setVisible(true);
	}
	
	private void criarPainel(JPanel painel, List<String> labels) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6); // Espaçamento entre campos
		
		for (int i = 0; i < labels.size(); i++) {
			gbc.gridy = i;
			
			// 1. CONFIGURAÇÃO DA LABEL (Coluna 0)
			gbc.gridx = 0;
			gbc.weightx = 0.0;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.LINE_END; // Alinha texto à direita
			painel.add(new JLabel(labels.get(i) + ":"), gbc);
			
			// 2. CONFIGURAÇÃO DO CAMPO DE TEXTO (Coluna 1)
			gbc.gridx = 1;
			gbc.weightx = 1.5; // Faz as caixas de texto terem larguras iguais entre si
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.LINE_START;
			painel.add(new JTextField(20), gbc); 
		}
		
		// 3. CONFIGURAÇÃO DO BOTÃO (Coluna 1)
		gbc.gridy = labels.size(); //Sempre vai deixar o botao na ultima posição
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		painel.add(new JButton("Salvar"), gbc);
	}

}
