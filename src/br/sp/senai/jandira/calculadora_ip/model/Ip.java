package br.sp.senai.jandira.calculadora_ip.model;

public class Ip {
	
	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;
	private int hosts;
	private String mascaraDecimal;
	private String mascaraBinario;
	private String classe;
	
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
	
	public int getHosts() {
		return hosts;
	}

	public String getMascaraDecimal() {
		return mascaraDecimal;
	}

	public String getMascaraBinario() {
		return mascaraBinario;
	}

	public String getClasse() {
		return classe;
	}

	public String getIp() {
		return primeiroOcteto + "." + segundoOcteto + "." + terceiroOcteto + "." + quartoOcteto;
	}
	
	public static String identificarClasse(int primeiroOcteto) {
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
	
	public static int calcularHosts(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }
	
	public static String mascaraDecimal(String classe) {
        switch (classe) {
            case "Classe A": return "255.0.0.0";
            case "Classe B": return "255.255.0.0";
            case "Classe C": return "255.255.255.0";
            default: return "Fora do Range";
        }
    }

	public static String mascaraBinaria(String classe) {
        switch (classe) {
            case "Classe A": return "11111111.00000000.00000000.00000000";
            case "Classe B": return "11111111.11111111.00000000.00000000";
            case "Classe C": return "11111111.11111111.11111111.00000000";
            default: return "Fora do Range";
        }
    }
	
	public void mostrarDados() {
		System.out.println("Mascara decimal: "  + mascaraDecimal);
		System.out.println("Mascara binario: " + mascaraBinario);
		System.out.println("Classe da Mascara: " + identificarClasse(primeiroOcteto));
		System.out.println("Hosts disponiveis: " + calcularHosts(cidr));
		System.out.println();
		System.out.println();
		
	}
	
	
}
