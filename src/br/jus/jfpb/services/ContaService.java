package br.jus.jfpb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.jus.jfpb.daos.ContaDAO;
import br.jus.jfpb.model.Conta;

@Service
@Transactional
public class ContaService {
	
	@Autowired
	private ContaDAO contaDAO;

//	public void inserir(Conta conta) throws Exception {	
//		if (conta.getNome_do_beneficiario() == null) {
//			throw new Exception("O nome do beneficiario é obrigatório");
//		}
//		contaDAO.inserir(conta);
//	}
//	public void atualizar(Conta conta) throws Exception {
//		if (conta.getNome_do_beneficiario() == null) {
//			throw new Exception("O nome do beneficiario é obrigatório");
//		}
//		contaDAO.atualizar(conta);
//	}
//	public Conta buscarPorId(Long id) {
//		Conta conta = null;
//		return contaDAO.buscarPorID(id);
//	}
//	public void remover(Conta conta) throws Exception {
//		contaDAO.excluir(conta);
//	}

	public List<Conta> listar() {
		return contaDAO.listar();
	}
	public List<Conta> buscarPorNome(String filtro) {
		return contaDAO.buscarPorNome(filtro);
	}
}	

//Desenvolvido por Yuri Santos