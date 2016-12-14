package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.model.Item;

public class ItemDAO {
	public ItemDAO(){
	}
	public Item pesquisaItem(Long id){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Item item = manager.find(Item.class, id);
		manager.getTransaction().commit();
		manager.close();
		
		
		return item;
		/*
		String sql="select * from item where id=? ;";
		Item item = new Item();
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			item.setId(rs.getLong("id"));
			item.setTitulo(rs.getString("titulo"));
			item.setAutor(rs.getString("autor"));
			item.setTipo(rs.getString("tipo"));
			item.setDisponivel(rs.getBoolean("disponivel"));
			stmt.close();
			rs.close();
			return item;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return item;
		*/
	}
	public List<Item> consultar(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sb");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select i from Item as i");
		List<Item> itens = query.getResultList();
		return itens;
		/*
		String sql="select * from item; ";
		List<Item> seusItens= new ArrayList<Item>();
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();	//executa e colhe os dados da tabela
			while(rs.next()){	//insere uma a uma
				//if(rs.getBoolean("disponivel")){
					Item item= new Item();
				item.setId(rs.getLong("id"));
				item.setTitulo(rs.getString("titulo"));
				item.setAutor(rs.getString("autor"));
				item.setTipo(rs.getString("tipo"));
				item.setDisponivel(rs.getBoolean("disponivel"));
				seusItens.add(item);	
				//}
			}
			rs.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return seusItens;	//devolve uma lista de item
		*/
	}
}
