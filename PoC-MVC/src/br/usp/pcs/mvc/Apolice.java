package br.usp.pcs.mvc;

import java.util.Date;

public class Apolice {

    public Apolice(String marcaVeiculo, String modeloVeiculo, String anoVeiculo, Double valorContratacao, TipoFranquiaCasco tipoFranquiaCasco, Boolean franquiaAcessorios, Double valorFranquia, Double valorPremio, Double valorSegurado, int numeroApolice, String nomeSegurado, String CPF, String email, String endereco, Date dataNascimento, Status status) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.valorContratacao = valorContratacao;
        this.tipoFranquiaCasco = tipoFranquiaCasco;
        this.franquiaAcessorios = franquiaAcessorios;
        this.valorFranquia = valorFranquia;
        this.valorPremio = valorPremio;
        this.valorSegurado = valorSegurado;
        this.numeroApolice = numeroApolice;
        this.nomeSegurado = nomeSegurado;
        this.CPF = CPF;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.status = status;
    }

    private String marcaVeiculo;

    private String modeloVeiculo;

    private String anoVeiculo;

    private Double valorContratacao;

    private TipoFranquiaCasco tipoFranquiaCasco;

    private Boolean franquiaAcessorios;

    private Double valorFranquia;

    private Double valorPremio;

    private Double valorSegurado;

    private int numeroApolice;

    private String nomeSegurado;

    private String CPF;

    private String email;

    private String endereco;

    private Date dataNascimento;

    private Status status;

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public Double getValorContratacao() {
        return valorContratacao;
    }

    public void setValorContratacao(Double valorContratacao) {
        this.valorContratacao = valorContratacao;
    }

    public TipoFranquiaCasco getTipoFranquiaCasco() {
        return tipoFranquiaCasco;
    }

    public void setTipoFranquiaCasco(TipoFranquiaCasco tipoFranquiaCasco) {
        this.tipoFranquiaCasco = tipoFranquiaCasco;
    }

    public Boolean getFranquiaAcessorios() {
        return franquiaAcessorios;
    }

    public void setFranquiaAcessorios(Boolean franquiaAcessorios) {
        this.franquiaAcessorios = franquiaAcessorios;
    }

    public Double getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(Double valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Double getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(Double valorPremio) {
        this.valorPremio = valorPremio;
    }

    public Double getValorSegurado() {
        return valorSegurado;
    }

    public void setValorSegurado(Double valorSegurado) {
        this.valorSegurado = valorSegurado;
    }

    public int getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(int numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public String getNomeSegurado() {
        return nomeSegurado;
    }

    public void setNomeSegurado(String nomeSegurado) {
        this.nomeSegurado = nomeSegurado;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

enum TipoFranquiaCasco {
    Majorada,
    Obrigatoria,
    Reduzida
}

enum Status {
    Ativa,
    Encerrada,
    Cancelada
}