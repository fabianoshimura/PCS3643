package br.usp.pcs.mvc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Apolice {

    public Apolice() {

    }

    public Apolice(String marcaVeiculo, String modeloVeiculo, int anoVeiculo, Double valorContratacao,
                   TipoFranquiaCasco tipoFranquiaCasco, Boolean franquiaAcessorios, Double valorAcessorios, Double valorFranquiaCasco, Double valorFranquiaAcessorios,
                   Double valorPremio, Double valorSegurado, int numeroApolice, String nomeSegurado,
                   String CPF, String email, String endereco, Date dataNascimento, Status status,
                   Boolean danosMateriais, Boolean danosCorporais) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.valorContratacao = valorContratacao;
        this.tipoFranquiaCasco = tipoFranquiaCasco;
        this.franquiaAcessorios = franquiaAcessorios;
        this.valorAcessorios = valorAcessorios;
        this.valorFranquiaCasco = valorFranquiaCasco;
        this.valorFranquiaAcessorios = valorFranquiaAcessorios;
        this.valorPremio = valorPremio;
        this.valorSegurado = valorSegurado;
        this.numeroApolice = numeroApolice;
        this.nomeSegurado = nomeSegurado;
        this.CPF = CPF;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.danosMateriais = danosMateriais;
        this.danosCorporais = danosCorporais;
    }

    private String marcaVeiculo;

    private String modeloVeiculo;

    private int anoVeiculo;

    private Double valorContratacao;

    private TipoFranquiaCasco tipoFranquiaCasco;

    private Boolean franquiaAcessorios;

    private Double valorAcessorios;

    private Double valorFranquiaCasco;

    private Double valorFranquiaAcessorios;

    private Double valorPremio;

    private Double valorSegurado;

    private int numeroApolice;

    private String nomeSegurado;

    private String CPF;

    private String email;

    private String endereco;

    private Date dataNascimento;

    private Status status;

    private Boolean danosMateriais;

    private Boolean danosCorporais;

    public Double getValorAcessorios() {
        if (valorAcessorios == null) {
            return 0.0;
        }
        return valorAcessorios;
    }

    public void setValorAcessorios(Double valorAcessorios) {
        this.valorAcessorios = valorAcessorios;
    }

    public Boolean getDanosMateriais() {
        return danosMateriais;
    }

    public void setDanosMateriais(Boolean danosMateriais) {
        this.danosMateriais = danosMateriais;
    }

    public Boolean getDanosCorporais() {
        return danosCorporais;
    }

    public void setDanosCorporais(Boolean danosCorporais) {
        this.danosCorporais = danosCorporais;
    }

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

    public int getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(int anoVeiculo) {
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

    public Double getValorFranquiaCasco() {
        return valorFranquiaCasco;
    }

    public void setValorFranquiaCasco(Double valorFranquiaCasco) {
        this.valorFranquiaCasco = valorFranquiaCasco;
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

    public Double getValorFranquiaAcessorios() {
        return valorFranquiaAcessorios;
    }

    public void setValorFranquiaAcessorios(Double valorFranquiaAcessorios) {
        this.valorFranquiaAcessorios = valorFranquiaAcessorios;
    }

    public void setDadosCliente(String nome, String email, String cpf, String endereco, String dataNascimento) throws ParseException {
        setNomeSegurado(nome);
        setEmail(email);
        setCPF(cpf);
        setEndereco(endereco);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        setDataNascimento(format.parse(dataNascimento));
    }

    public void setDadosVeiculo(String marcaVeiculo, String modeloVeiculo, String anoVeiculo, String valorContratacao) {
        setMarcaVeiculo(marcaVeiculo);
        setModeloVeiculo(modeloVeiculo);
        setAnoVeiculo(Integer.parseInt(anoVeiculo));
        setValorContratacao(Double.parseDouble(valorContratacao));
    }

    public void calcularValores() {
        calcularFranquias();
        calcularPremio();
    }

    private void calcularFranquias() {
        valorFranquiaAcessorios = franquiaAcessorios ? 0.15 * valorAcessorios : 0;

        valorFranquiaCasco = tipoFranquiaCasco.getMultiplyFranquiaCasco() * valorContratacao;
    }

    private void calcularPremio() {
        Double premioCasco = tipoFranquiaCasco.getMultiplyPremioCasco() * valorContratacao;
        if (getAge() < 25) {
            premioCasco = premioCasco * (1 + tipoFranquiaCasco.getMultiplyAge());
        }

        Double premioAcessorios = franquiaAcessorios ? 0.005 * valorAcessorios : 0;

        Double premioDanosMateriais = 0.0025 * 100000;

        Double premioDanosCorporais = 0.0025 * 100000;

        valorPremio = (premioCasco + premioAcessorios + premioDanosCorporais + premioDanosMateriais) * 1.0738;
    }

    private long getAge() {
        long diferencaEmMilis = Math.abs(new Date().getTime() - dataNascimento.getTime());
        long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMilis, TimeUnit.MILLISECONDS);

        return Math.abs(diferencaEmDias / 365);
    }

    public String getDataNascimentoString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(dataNascimento);
    }

    public String getCoberturasString() {
        if (danosMateriais && danosCorporais) {
            return "Danos Materiais, Danos Corporais";
        }
        if (danosMateriais) {
            return "Danos Materiais";
        }
        if (danosCorporais) {
            return "Danos Corporais";
        }
        return "Nenhum";
    }

    public enum TipoFranquiaCasco {
        Majorada(0.1, 0.02, 0.005),
        Obrigatoria(0.08, 0.03, 0.01),
        Reduzida(0.06, 0.05, 0.02);

        private Double multiplyFranquiaCasco;
        private Double multiplyPremioCasco;
        private Double multiplyAge;

        public Double getMultiplyFranquiaCasco() {
            return multiplyFranquiaCasco;
        }

        public Double getMultiplyPremioCasco() {
            return multiplyPremioCasco;
        }

        public Double getMultiplyAge() {
            return multiplyAge;
        }

        TipoFranquiaCasco(Double multiplyFranquiaCasco,
                          Double multiplyPremioCasco,
                          Double multiplyAge) {
            this.multiplyFranquiaCasco = multiplyFranquiaCasco;
            this.multiplyPremioCasco = multiplyPremioCasco;
            this.multiplyAge = multiplyAge;
        }
    }

    public enum Status {
        Ativa,
        Encerrada,
        Cancelada
    }
}
