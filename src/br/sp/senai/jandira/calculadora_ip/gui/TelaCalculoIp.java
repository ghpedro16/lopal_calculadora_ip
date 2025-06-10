package br.sp.senai.jandira.calculadora_ip.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sp.senai.jandira.calculadora_ip.model.Ip;

public class TelaCalculoIp {

	private JLabel lblEnderecoIp;
	private JLabel lblCidr;
	
	private JLabel lblIps;
	private JLabel lblClasse;
	private JLabel lblMascDecimal;
	private JLabel lblMascBinaria;
	private JLabel lblRedes;
	
	private JLabel lblResultadoIp;
	private JLabel lblResultadoClasse;
	private JLabel lblResultadoMascDec;
	private JLabel lblResultadoMascBin;
	private JLabel lblHosts;
	private JLabel lblMsgErro;
	
	private JPanel painelOctetos;
	private JPanel painelInfos;
	private JPanel painelResult;
	
	private JTextField txtPrimeiroOcteto;
	private JTextField txtSegundoOcteto;
	private JTextField txtTerceiroOcteto;
	private JTextField txtQuartoOcteto;
	private JTextField txtCidr;
	
	private JButton btnCalcular;
	private JButton btnLimpar;

//	public TelaCalculoIp() {
//		criarTela();
//	}
	
	public void criarTela() {
		JFrame tela = new JFrame("Calculadora de IP");
		tela.setSize(500, 405);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		txtCidr = new JTextField();
		txtCidr.setBounds(380, 60, 66, 30);
		
		// Botão calcular
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(37, 105, 200, 35);
		btnCalcular.setFont(new Font("Arial", Font.BOLD, 15));
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int primeiroOcteto = Integer.parseInt(txtPrimeiroOcteto.getText());
					int segundoOcteto = Integer.parseInt(txtSegundoOcteto.getText());
					int terceiroOcteto = Integer.parseInt(txtTerceiroOcteto.getText());
					int quartoOcteto = Integer.parseInt(txtQuartoOcteto.getText());
					int cidr = Integer.parseInt(txtCidr.getText());
					
					Ip calculadora = new Ip();
					calculadora.setPrimeiroOcteto(primeiroOcteto);
					calculadora.setSegundoOcteto(segundoOcteto);
					calculadora.setTerceiroOcteto(terceiroOcteto);
					calculadora.setQuartoOcteto(quartoOcteto);
					calculadora.setCidr(cidr);
					
					lblResultadoIp.setText(calculadora.getIp());
					lblResultadoClasse.setText(String.valueOf(calculadora.identificarClasse(primeiroOcteto)));
					lblResultadoMascDec.setText(calculadora.mascaraDecimal(null));
					lblResultadoMascBin.setText(calculadora.mascaraBinaria(null));
					lblHosts.setText(String.valueOf(calculadora.calcularHosts()));
					
				} catch (Exception e2) {
					lblMsgErro.setText("Insira um valor válido!");
					
				}
				
			}
		});
		
		// Botão limpar
		btnLimpar = new JButton();
		btnLimpar.setText("Limpar");
		btnLimpar.setBounds(246, 105, 200, 35);
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 15));
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPrimeiroOcteto.setText("");
				txtSegundoOcteto.setText("");
				txtTerceiroOcteto.setText("");
				txtQuartoOcteto.setText("");
				txtCidr.setText("");
				
				lblResultadoIp.setText("");
				lblResultadoClasse.setText("");
				lblResultadoMascDec.setText("");
				lblResultadoMascBin.setText("");
				lblHosts.setText("");
				
				lblMsgErro.setText("");
			}
		});
		
		// Painel de informações
		painelInfos = new JPanel(new GridLayout(6, 1, 0, 0));
		painelInfos.setBounds(37, 160, 200, 138);
		
		lblIps = new JLabel();
		lblIps.setText("IP: ");
		
		lblClasse = new JLabel();
		lblClasse.setText("Classe: ");
		
		lblMascDecimal = new JLabel();
		lblMascDecimal.setText("Másc. Decimal: ");
		
		lblMascBinaria = new JLabel();
		lblMascBinaria.setText("Másc. Binária: ");
		
		lblRedes = new JLabel();
		lblRedes.setText("Número de hosts: ");
		
		painelInfos.add(lblIps);
		painelInfos.add(lblClasse);
		painelInfos.add(lblMascDecimal);
		painelInfos.add(lblMascBinaria);
		painelInfos.add(lblRedes);
		
		// Painel de resultados
		painelResult = new JPanel(new GridLayout(6, 1, 0, 0));
		painelResult.setBounds(160, 160, 287, 138);
		
		lblResultadoIp = new JLabel();
		lblResultadoClasse = new JLabel();
		lblResultadoMascDec = new JLabel();
		lblResultadoMascBin = new JLabel();
		lblHosts = new JLabel();
		
		painelResult.add(lblResultadoIp);
		painelResult.add(lblResultadoClasse);
		painelResult.add(lblResultadoMascDec);
		painelResult.add(lblResultadoMascBin);
		painelResult.add(lblHosts);
		
		// Mostrar na tela
		tela.getContentPane().add(lblEnderecoIp);
		tela.getContentPane().add(painelOctetos);
		tela.getContentPane().add(lblCidr);
		tela.getContentPane().add(txtCidr);
		tela.getContentPane().add(btnCalcular);
		tela.getContentPane().add(btnLimpar);
		tela.getContentPane().add(painelInfos);
		tela.getContentPane().add(painelResult);
		
		// Tornar tela visivel
		tela.setVisible(true);
	}

}
