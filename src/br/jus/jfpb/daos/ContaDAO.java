package br.jus.jfpb.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jus.jfpb.model.Conta;


@Repository
public class ContaDAO extends AbstractDAO<Conta>{
	public ContaDAO() {
		super(Conta.class);
	}

	public List<Conta> buscarPorNome(String busca) {
		String sql = "select c from Conta c where upper(c.nomeBeneficiario) like upper(:nome)";
		Query query = manager.createQuery(sql);
		query.setParameter("nome", "%"+busca);
		System.out.println("Exibindo"+sql);
		System.out.println("Exibindo 2"+query.getResultList());
		return query.getResultList();
	}
}

//Desenvolvido por Yuri Santos