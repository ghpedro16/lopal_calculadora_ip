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
        validarOcteto(primeiroOcteto);
        this.primeiroOcteto = primeiroOcteto;
    }

    public int getSegundoOcteto() {
        return segundoOcteto;
    }

    public void setSegundoOcteto(int segundoOcteto) {
        validarOcteto(segundoOcteto);
        this.segundoOcteto = segundoOcteto;
    }

    public int getTerceiroOcteto() {
        return terceiroOcteto;
    }

    public void setTerceiroOcteto(int terceiroOcteto) {
        validarOcteto(terceiroOcteto);
        this.terceiroOcteto = terceiroOcteto;
    }

    public int getQuartoOcteto() {
        return quartoOcteto;
    }

    public void setQuartoOcteto(int quartoOcteto) {
        validarOcteto(quartoOcteto);
        this.quartoOcteto = quartoOcteto;
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

    private void validarOcteto(int valor) {
        if (valor < 0 || valor > 255) {
            throw new IllegalArgumentException("Octeto inválido: deve estar entre 0 e 255");
        }
    }

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
            return (int) Math.pow(2, 32 - cidr); // /31: 2 endereços, /32: 1 endereço
        } else {
            return (int) Math.pow(2, 32 - cidr) - 2; // Desconta network e broadcast
        }
    }

    public String mascaraDecimal() {
        int mask = 0xFFFFFFFF << (32 - cidr);
        return String.format("%d.%d.%d.%d",
                (mask >>> 24) & 0xFF,
                (mask >>> 16) & 0xFF,
                (mask >>> 8) & 0xFF,
                mask & 0xFF);
    }

    public String mascaraBinaria() {
        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            bin.append(i < cidr ? '1' : '0');
            if ((i + 1) % 8 == 0 && i != 31) {
                bin.append('.');
            }
        }
        return bin.toString();
    }

    private int ipParaInt() {
        return (primeiroOcteto << 24) | (segundoOcteto << 16) | (terceiroOcteto << 8) | quartoOcteto;
    }

    private String intParaIp(int ip) {
        return String.format("%d.%d.%d.%d",
                (ip >>> 24) & 0xFF,
                (ip >>> 16) & 0xFF,
                (ip >>> 8) & 0xFF,
                ip & 0xFF);
    }

    public String getPrimeiroIpValido() {
        if (cidr == 32) return getIp().split("/")[0];
        int ipDecimal = ipParaInt();
        int mask = 0xFFFFFFFF << (32 - cidr);
        int network = ipDecimal & mask;
        return intParaIp(network + 1);
    }

    public String getUltimoIpValido() {
        if (cidr == 32) return getIp().split("/")[0];
        int ipDecimal = ipParaInt();
        int mask = 0xFFFFFFFF << (32 - cidr);
        int broadcast = (ipDecimal & mask) | ~mask;
        return intParaIp(broadcast - 1);
    }

    public String getBroadcast() {
        int ipDecimal = ipParaInt();
        int mask = 0xFFFFFFFF << (32 - cidr);
        int broadcast = (ipDecimal & mask) | ~mask;
        return intParaIp(broadcast);
    }
}

