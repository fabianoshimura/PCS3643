package br.usp.pcs.mvc.venderseguro;

public class Veiculo {
    private int marca = 0;
    private int modelo = 0;
    private String ano = "";

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
        if (marca == 0) {
            throw new IllegalStateException();
        }
        this.modelo = modelo;
        this.ano = "";
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        if (marca == 0 || modelo == 0) {
            throw new IllegalStateException();
        }
        this.ano = ano;
    }
}