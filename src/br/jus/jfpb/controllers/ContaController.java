package br.jus.jfpb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.jus.jfpb.model.Conta;
import br.jus.jfpb.services.ContaService;


@Controller
@RequestMapping(value="/")
public class ContaController {

	@Autowired
	private ContaService contaService;
 
	@RequestMapping(method = RequestMethod.GET, value = {"listar"})
	public String list(ModelMap map) {
		//serve para listar tudo, para fins de teste 
	    /*List<Conta> contas = contaService.listar();
    	  map.addAttribute("contas", contas);*/
		map.addAttribute("filtro", new Conta());
		return "/listar";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"filtrar"})
	public String filter(@ModelAttribute("filtro") Conta filtro, ModelMap map) {
		try {
			if((filtro.getNomeBeneficiario() == null || filtro.getNomeBeneficiario().equals("")) || (filtro.getCpf() == null || filtro.getCpf().equals("")) ){
				return "/listar2";
				
			}
			
			List<Conta> contas = contaService.buscarPorNome(filtro.getNomeBeneficiario());
			List<Conta> contaOk = new ArrayList();
			for (Conta conta : contas) {
				map.addAttribute("contaOk", contaOk);
				map.addAttribute("filtro", filtro);
				
				if((conta.getCpf().equals("00000000000"))){
					contaOk.add(conta);
					System.out.println("Exibindo1"+filtro.getCpf());
					System.out.println("Exibindo2"+conta.getCpf());
					return "/listar";
				}
				
				if(filtro.getCpf().equals(conta.getCpf())){
					contaOk.add(conta);
					System.out.println("Exibindo3"+filtro.getCpf());
					System.out.println("Exibindo4"+conta.getCpf());
					return "/listar";
				}
				if((conta.getCpf() == null) || (conta.getCpf().equals(""))){
					return "/listar2";
				}
				/*if(!(filtro.getCpf().equals(conta.getCpf())) && !(conta.getCpf().equals("00000000000"))){
					System.out.println("Exibindo5"+filtro.getCpf());
					System.out.println("Exibindo6"+conta.getCpf());
					return "/listar2";	*/
				else{
					return "/listar2";
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/listar2";
	}
}

//Desenvolvido por Yuri Santos