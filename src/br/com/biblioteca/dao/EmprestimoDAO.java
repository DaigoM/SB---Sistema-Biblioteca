package br.com.biblioteca.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Item;
import br.com.biblioteca.model.Solicitacao;
import br.com.biblioteca.model.Usuario;

public class EmprestimoDAO {
	public EmprestimoDAO(){
	}
	public List<Emprestimo> consultarEmprestimo(){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select e from Emprestimo as e");
		List<Emprestimo> emprestimos = query.getResultList();
		return emprestimos;
	}
	public List<Emprestimo> consultarMinhaLista(long id){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select e from Emprestimo as e where e.usuario.id= :paramIdUsuario");
		query.setParameter("paramIdUsuario", id);
		List<Emprestimo> emprestimos = query.getResultList();
		return emprestimos;

	}
	public boolean limiteEmprestimo(Emprestimo e, Usuario u){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		long id = u.getId();
		Query query =manager.createQuery("select count(*) from Emprestimo where solicitacao=true and devolucao=false and usuario.id = :paramId");
		query.setParameter("paramId", id);
		
		long count = (long) query.getSingleResult();
		if(count>=3){
			return true;
		}else{
			return false;
		}
	}
	public void solicitacao(Emprestimo e, Usuario u){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		long id = u.getId();
		Query query =manager.createQuery("select count(*) from Emprestimo where solicitacao=true and devolucao=false and usuario.id = :paramId");
		query.setParameter("paramId", id);
		
		long count = (long) query.getSingleResult();
		if(count<3){
			Date data = new Date(System.currentTimeMillis());
			Calendar c = Calendar.getInstance();
			c.setTime(data);
			e.setDataEmprestimo(c);
			e.setSolicitacao(false);
			e.setDevolucao(false);
			
			manager.getTransaction().begin();
			manager.persist(e);
			manager.getTransaction().commit();
			
			System.out.println("Registro de emprestimo concluido!");
			manager.close();
		
		}
		
	}
	public void validaSolicitacao(Emprestimo e){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		e = manager.find(Emprestimo.class, e.getId());
		e.setSolicitacao(true);
		e.getItem().setDisponivel(false);
		manager.merge(e);
		manager.getTransaction().commit();
	}
	public void registraDevolucao(Emprestimo e){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		e = manager.find(Emprestimo.class, e.getId());
		e.setDevolucao(true);
		Date data = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		e.setDataDevolucao(c);
		e.getItem().setDisponivel(true);
		manager.merge(e);
		manager.getTransaction().commit();
	}
}
