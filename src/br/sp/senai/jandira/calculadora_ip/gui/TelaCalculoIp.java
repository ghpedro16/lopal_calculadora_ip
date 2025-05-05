package br.sp.senai.jandira.calculadora_ip.gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCalculoIp {

	private JLabel lblEnderecoIp;
	private JLabel lblCidr;
	private JPanel painelOctetos;
	private JTextField txtPrimeiroOcteto;
	private JTextField txtSegundoOcteto;
	private JTextField txtTerceiroOcteto;
	private JTextField txtQuartoOcteto;

	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setSize(500, 405);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Calculadora de IP");
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
		lblEnderecoIp = new JLabel();
		lblEnderecoIp.setText("Endereço IP");
		lblEnderecoIp.setBounds(37, 20, 220, 35);
		lblEnderecoIp.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Painel octetos
		painelOctetos = new JPanel(new GridLayout(1, 4, 5, 0));
		painelOctetos.setBounds(37, 60, 280, 30);
		
		txtPrimeiroOcteto = new JTextField();
		txtSegundoOcteto = new JTextField();
		txtTerceiroOcteto = new JTextField();
		txtQuartoOcteto = new JTextField();
		
		painelOctetos.add(txtPrimeiroOcteto);
		painelOctetos.add(txtSegundoOcteto);
		painelOctetos.add(txtTerceiroOcteto);
		painelOctetos.add(txtQuartoOcteto);
		
		// Cidr
		lblCidr = new JLabel();
		lblCidr.setText("Cidr");
		lblCidr.setBounds(380, 20, 100, 35);
		lblCidr.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Mostrar na tela
		tela.getContentPane().add(lblEnderecoIp);
		tela.getContentPane().add(lblCidr);
		tela.getContentPane().add(txtPrimeiroOcteto);
		tela.getContentPane().add(txtSegundoOcteto);
		tela.getContentPane().add(txtTerceiroOcteto);
		tela.getContentPane().add(txtQuartoOcteto);
		
		// Tornar tela visivel
		tela.setVisible(true);
	}

}
