package br.com.gerenciador.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gerenciador.dao.imp.PessoaDAOImp;
import br.com.gerenciador.model.Pessoa;
import br.com.gerenciador.util.JPAUtil;

@Path("pessoas")
public class PessoaResource {

	private EntityManager em;
	
	public PessoaResource(){
		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca() {
		List<Pessoa> pessoa = new PessoaDAOImp(em).listaTodos();
		return ((Pessoa) pessoa).toJSON();
	}
	
}
