package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Funcionario;
import br.com.biblioteca.model.Item;
import br.com.biblioteca.model.Usuario;

public class FuncionarioDAO extends UsuarioDAO{
	public FuncionarioDAO(){
	}
	Connection connection;
	
	public boolean existeFuncionario(Usuario usuario){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Usuario as u "+ "where u.login= :paramLogin and u.senha= :paramSenha");
		query.setParameter("paramLogin", usuario.getLogin());
		query.setParameter("paramSenha", usuario.getSenha());
		Usuario u = (Usuario) query.getSingleResult();
		
		if(usuario.getLogin().equals(u.getLogin()) && usuario.getSenha().equals(u.getSenha())){
			manager.close();
			return true;
		}else{
			manager.close();
		return false;
		}
		
	}
	public Usuario buscaFuncionario(String login, String senha){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Usuario as u "+ "where u.login= :paramLogin and u.senha= :paramSenha");
		query.setParameter("paramLogin", login);
		query.setParameter("paramSenha", senha);
		Usuario u = (Usuario) query.getSingleResult();
		return u;
	}
	public void adicionarItem(Item i){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(i);
		manager.getTransaction().commit();
		manager.close();
		
	}
	//sera usado para mudar o valor de solicitacao e devolucao no controller.
	public void atualizar(Emprestimo emp){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.refresh(emp);
		manager.getTransaction().commit();
		manager.close();
		
	}
}
