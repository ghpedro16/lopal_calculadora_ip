package br.sp.senai.jandira.calculadora_ip.model;

public class Ip {
	
	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;
	
	public int getPrimeiroOcteto() {
		return primeiroOcteto;
	}

	public void setPrimeiroOcteto(int primeiroOcteto) {
		this.primeiroOcteto = primeiroOcteto;
	}

	public int getSegundoOcteto() {
		return segundoOcteto;
	}

	public void setSegundoOcteto(int segundoOcteto) {
		this.segundoOcteto = segundoOcteto;
	}

	public int getTerceiroOcteto() {
		return terceiroOcteto;
	}

	public void setTerceiroOcteto(int terceiroOcteto) {
		this.terceiroOcteto = terceiroOcteto;
	}

	public int getQuartoOcteto() {
		return quartoOcteto;
	}

	public void setQuartoOcteto(int quartoOcteto) {
		this.quartoOcteto = quartoOcteto;
	}
	
	public int getCidr() {
		return cidr;
	}

	public void setCidr(int cidr) {
		this.cidr = cidr;
	}

	public String getIp() {
		return primeiroOcteto + "." + segundoOcteto + "." + terceiroOcteto + "." + quartoOcteto + "/" + cidr;
	}
	
	public String identificarClasse(int primeiroOcteto) {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "Classe A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "Classe B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "Classe C";
		} else {
			return "Insira um valor válido";
		}
		
	}
	
	public int calcularHosts() {
		if (cidr >= 32) {
			return 1;
		} else {
			return (int) Math.pow(2, 32 - cidr) - 2;
		}
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
	
}
