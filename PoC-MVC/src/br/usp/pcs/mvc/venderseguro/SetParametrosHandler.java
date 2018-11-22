package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetParametrosHandler extends VenderSeguroHandler {
    private String valorContratacao;
    private String coberturaMaterial;
    private String coberturaCorporal;
    private String franquiaCasco;
    private String franquiaAcessorios;
    private String valorAcessorios;

    public SetParametrosHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);
    }

    @Override
    void execute() {
        if (valorContratacao != null) {
            apolice.setValorContratacao(Double.parseDouble(valorContratacao));
        }

        if (coberturaMaterial != null) {
            apolice.setDanosMateriais(true);
        } else {
            apolice.setDanosMateriais(false);
        }

        if (coberturaCorporal != null) {
            apolice.setDanosCorporais(true);
        } else {
            apolice.setDanosCorporais(false);
        }

        apolice.setTipoFranquiaCasco(Apolice.TipoFranquiaCasco.valueOf(franquiaCasco));

        if (franquiaAcessorios.equals("Sim")) {
            apolice.setFranquiaAcessorios(true);
            apolice.setValorAcessorios(Double.parseDouble(valorAcessorios));
        } else {
            apolice.setFranquiaAcessorios(false);
        }
    }

    @Override
    boolean validateInputs() {
        valorContratacao = request.getParameter("valor-contratacao");
        coberturaMaterial = request.getParameter("danos-materiais");
        coberturaCorporal = request.getParameter("danos-corporais");
        franquiaCasco = request.getParameter("franquia-casco");
        franquiaAcessorios = request.getParameter("franquia-acessorios");
        valorAcessorios = request.getParameter("valor-acessorios");

        if (franquiaCasco == null || franquiaAcessorios == null) {
            return false;
        }

        if (franquiaAcessorios.equals("Sim") && valorAcessorios == null) {
            return false;
        }

        return true;
    }
}
