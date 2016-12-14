package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.model.Item;
import br.com.biblioteca.model.Usuario;


public class UsuarioDAO {
	
	public UsuarioDAO(){
	}
	
	Connection connection;
	//verificacao de login
	public boolean existeUsuario(Usuario usuario){
		//select 1 from usuario where login=  and senha=  ;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Usuario as u where u.login= :paramLogin and u.senha= :paramSenha");
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
	
	public Usuario buscaUsuario(String login, String senha){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Usuario as u "+ "where u.login= :paramLogin and u.senha= :paramSenha");
		query.setParameter("paramLogin", login);
		query.setParameter("paramSenha", senha);
		Usuario u = (Usuario) query.getSingleResult();
		return u;
	}
	public void adiciona(Usuario u){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();    
		manager.persist(u);
		manager.getTransaction().commit();
		manager.close();
	}
}
