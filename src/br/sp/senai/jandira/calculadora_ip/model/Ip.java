package br.sp.senai.jandira.calculadora_ip.model;

public class Ip {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;

	// Getters e Setters com validações
	public int getPrimeiroOcteto() {
		return primeiroOcteto;
	}

	public void setPrimeiroOcteto(int primeiroOcteto) {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 255) {
			this.primeiroOcteto = primeiroOcteto;
		} else {
			throw new IllegalArgumentException("Octeto inválido: deve estar entre 0 e 255");
		}
	}

	public int getSegundoOcteto() {
		return segundoOcteto;
	}

	public void setSegundoOcteto(int segundoOcteto) {
		if (segundoOcteto >= 0 && segundoOcteto <= 255) {
			this.segundoOcteto = segundoOcteto;
		} else {
			throw new IllegalArgumentException("Octeto inválido: deve estar entre 0 e 255");
		}
	}

	public int getTerceiroOcteto() {
		return terceiroOcteto;
	}

	public void setTerceiroOcteto(int terceiroOcteto) {
		if (terceiroOcteto >= 0 && terceiroOcteto <= 255) {
			this.terceiroOcteto = terceiroOcteto;
		} else {
			throw new IllegalArgumentException("Octeto inválido: deve estar entre 0 e 255");
		}
	}

	public int getQuartoOcteto() {
		return quartoOcteto;
	}

	public void setQuartoOcteto(int quartoOcteto) {
		if (quartoOcteto >= 0 && quartoOcteto <= 255) {
			this.quartoOcteto = quartoOcteto;
		} else {
			throw new IllegalArgumentException("Octeto inválido: deve estar entre 0 e 255");
		}
	}

	public int getCidr() {
		return cidr;
	}

	public void setCidr(int cidr) {
		if (cidr >= 0 && cidr <= 32) {
			this.cidr = cidr;
		} else {
			throw new IllegalArgumentException("CIDR inválido: deve estar entre 0 e 32");
		}
	}

	// Métodos utilitários

	public String getIp() {
		return primeiroOcteto + "." + segundoOcteto + "." + terceiroOcteto + "." + quartoOcteto + "/" + cidr;
	}

	public String identificarClasse() {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "Classe A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "Classe B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "Classe C";
		} else {
			return "Classe desconhecida";
		}
	}

	public int calcularHosts() {
		if (cidr >= 31) {
			return (int) Math.pow(2, 32 - cidr); // /31 ou /32 são válidos em ponto-a-ponto
		} else {
			return (int) Math.pow(2, 32 - cidr) - 2;
		}
	}

	public String mascaraDecimal() {
		return mascaraDecimal(identificarClasse());
	}

	public String mascaraBinaria() {
		return mascaraBinaria(identificarClasse());
	}

	public String mascaraDecimal(String classe) {
		switch (classe) {
			case "Classe A": return "255.0.0.0";
			case "Classe B": return "255.255.0.0";
			case "Classe C": return "255.255.255.0";
			default: return "Fora do Range";
		}
	}

	public String mascaraBinaria(String classe) {
		switch (classe) {
			case "Classe A": return "11111111.00000000.00000000.00000000";
			case "Classe B": return "11111111.11111111.00000000.00000000";
			case "Classe C": return "11111111.11111111.11111111.00000000";
			default: return "Fora do Range";
		}
	}

	// NOVOS MÉTODOS

	private int ipParaInt() {
		return (primeiroOcteto << 24) | (segundoOcteto << 16) | (terceiroOcteto << 8) | quartoOcteto;
	}

	private String intParaIp(int ip) {
		int o1 = (ip >> 24) & 0xFF;
		int o2 = (ip >> 16) & 0xFF;
		int o3 = (ip >> 8) & 0xFF;
		int o4 = ip & 0xFF;
		return o1 + "." + o2 + "." + o3 + "." + o4;
	}

	public String getPrimeiroIpValido() {
		if (cidr == 32) return getIp().split("/")[0]; // apenas um host
		int ipDecimal = ipParaInt();
		int mask = -1 << (32 - cidr);
		int network = ipDecimal & mask;
		return intParaIp(network + 1);
	}

	public String getUltimoIpValido() {
		if (cidr == 32) return getIp().split("/")[0]; // apenas um host
		int ipDecimal = ipParaInt();
		int mask = -1 << (32 - cidr);
		int broadcast = (ipDecimal & mask) | ~mask;
		return intParaIp(broadcast - 1);
	}

	public String getBroadcast() {
		int ipDecimal = ipParaInt();
		int mask = -1 << (32 - cidr);
		int broadcast = (ipDecimal & mask) | ~mask;
		return intParaIp(broadcast);
	}
}
