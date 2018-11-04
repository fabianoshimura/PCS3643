package br.usp.pcs.mvc;

public class Veiculo {
    int marca = 0;
    int modelo = 0;
    String ano = "";

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
        this.modelo = 0;
        this.ano = "";
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
        this.ano = "";
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}