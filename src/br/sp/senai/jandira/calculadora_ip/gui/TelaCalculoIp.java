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
	private JLabel lblPrimeiroIpValido;
	private JLabel lblUltimoIpValido;
	private JLabel lblBroadcast;
	
	private JLabel lblResultadoIp;
	private JLabel lblResultadoClasse;
	private JLabel lblResultadoMascDec;
	private JLabel lblResultadoMascBin;
	private JLabel lblHosts;
	private JLabel lblResultadoPrimeiroIpValido;
	private JLabel lblResultadoUltimoIpValido;
	private JLabel lblResultadoBroadcast;
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

	public void criarTela() {
		JFrame tela = new JFrame("Calculadora de IP");
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
		lblEnderecoIp = new JLabel();
		lblEnderecoIp.setText("Endereço IP");
		lblEnderecoIp.setBounds(37, 20, 220, 35);
		lblEnderecoIp.setFont(new Font("Arial", Font.BOLD, 15));
		
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
		
		lblCidr = new JLabel();
		lblCidr.setText("Cidr");
		lblCidr.setBounds(380, 20, 100, 35);
		lblCidr.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtCidr = new JTextField();
		txtCidr.setBounds(380, 60, 66, 30);
		
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
					lblResultadoClasse.setText(calculadora.identificarClasse());
					lblResultadoMascDec.setText(calculadora.mascaraDecimal());
					lblResultadoMascBin.setText(calculadora.mascaraBinaria());
					lblHosts.setText(String.valueOf(calculadora.calcularHosts()));
					lblResultadoPrimeiroIpValido.setText(calculadora.getPrimeiroIpValido());
					lblResultadoUltimoIpValido.setText(calculadora.getUltimoIpValido());
					lblResultadoBroadcast.setText(calculadora.getBroadcast());
				} catch (Exception e2) {
					lblMsgErro.setText("Insira um valor válido!");
				}
			}
		});
		
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
				lblResultadoPrimeiroIpValido.setText("");
				lblResultadoUltimoIpValido.setText("");
				lblResultadoBroadcast.setText("");
				lblMsgErro.setText("");
			}
		});
		
		painelInfos = new JPanel(new GridLayout(9, 1, 0, 0));
		painelInfos.setBounds(37, 160, 200, 225);
		
		lblIps = new JLabel("IP: ");
		lblClasse = new JLabel("Classe: ");
		lblMascDecimal = new JLabel("Másc. Decimal: ");
		lblMascBinaria = new JLabel("Másc. Binária: ");
		lblRedes = new JLabel("Número de hosts: ");
		lblPrimeiroIpValido = new JLabel("Primeiro IP válido: ");
		lblUltimoIpValido = new JLabel("Último IP válido: ");
		lblBroadcast = new JLabel("Broadcast: ");
		
		painelInfos.add(lblIps);
		painelInfos.add(lblClasse);
		painelInfos.add(lblMascDecimal);
		painelInfos.add(lblMascBinaria);
		painelInfos.add(lblRedes);
		painelInfos.add(lblPrimeiroIpValido);
		painelInfos.add(lblUltimoIpValido);
		painelInfos.add(lblBroadcast);
		
		painelResult = new JPanel(new GridLayout(9, 1, 0, 0));
		painelResult.setBounds(160, 160, 287, 225);
		
		lblResultadoIp = new JLabel();
		lblResultadoClasse = new JLabel();
		lblResultadoMascDec = new JLabel();
		lblResultadoMascBin = new JLabel();
		lblHosts = new JLabel();
		lblResultadoPrimeiroIpValido = new JLabel();
		lblResultadoUltimoIpValido = new JLabel();
		lblResultadoBroadcast = new JLabel();
		lblMsgErro = new JLabel();
		
		painelResult.add(lblResultadoIp);
		painelResult.add(lblResultadoClasse);
		painelResult.add(lblResultadoMascDec);
		painelResult.add(lblResultadoMascBin);
		painelResult.add(lblHosts);
		painelResult.add(lblResultadoPrimeiroIpValido);
		painelResult.add(lblResultadoUltimoIpValido);
		painelResult.add(lblResultadoBroadcast);
		painelResult.add(lblMsgErro);
		
		tela.getContentPane().add(lblEnderecoIp);
		tela.getContentPane().add(painelOctetos);
		tela.getContentPane().add(lblCidr);
		tela.getContentPane().add(txtCidr);
		tela.getContentPane().add(btnCalcular);
		tela.getContentPane().add(btnLimpar);
		tela.getContentPane().add(painelInfos);
		tela.getContentPane().add(painelResult);
		tela.setVisible(true);
	}
}
