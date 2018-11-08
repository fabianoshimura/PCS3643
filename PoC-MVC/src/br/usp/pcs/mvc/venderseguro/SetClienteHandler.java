package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;
import java.util.Date;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetClienteHandler extends VenderSeguroHandler {
    public SetClienteHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);

      }

    
    
    @Override
    public void execute() {
    	
    	   	
    	try {
			apolice.setDadosCliente(request.getParameter("nome"), request.getParameter("email"), request.getParameter("cpf"), request.getParameter("endereco"), request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
						
		}
    	
    	
    	String nome = request.getParameter("nome");
    	String email = request.getParameter("email");    	
    	String cpf = request.getParameter("cpf");
    	String endereco = request.getParameter("endereco");
    	String data = request.getParameter("dataNascimento");
    	
    	/*
    	Apolice apolice = new Apolice();
    	apolice.setNomeSegurado(nome);
    	apolice.setEmail(email);
    	apolice.setCPF(cpf);
    	apolice.setEndereco(endereco);
    	apolice.setDataNascimento(data);
    	
    	*/
    	
    	
    	
    }

    @Override
    public void validateInputs() {
    	    	   	
		if (verifyName("nome") == true){
    	
			System.out.print("nome true");
    		    		
    	}
    	
    	
    	if (verifyEmail("email") == true){
    		
    		
    	}
    	
    	if (verifyCPF("cpf") == true) {
    		
    		
    	}
    	
    	if (verifyDate("data") == true) {
    		
    	}
    	
    	
    	}
    
    
    
    private boolean verifyName(String name)
    {
        name = name.trim();
        if(name == null || name.equals(""))
            return false;
       // if(!name.matches("[a-zA-Z0-9._%+- ]"))
         //   return false;
        return true;
    }
    
    
    private boolean verifyEmail(String email)
    {
        email = email.trim();
        if(email == null || email.equals(""))
            return false;
       // if(!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
         //   return false;
        return true;
    }
        
    
    private boolean verifyCPF(String cpf)
    {
        cpf = cpf.trim();
        if(cpf == null || cpf.equals(""))
            return false;
        //if(!cpf.matches("[a-zA-Z0-9.]+-[a-zA-Z0-9]"))
          //  return false;
        return true;
    }
    
    private boolean verifyDate(String date)
    {
        date = date.trim();
        if(date == null || date.equals(""))
            return false;
        //if(!date.matches("[0-9]+[0-9]+/[0-9]+[0-9]+/[0-9]+[0-9]+[0-9]+[0-9]"))
            //return false;
        return true;
    }
    
    	  	   	
    }

