package br.com.biblioteca.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Emprestimo {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(targetEntity=Item.class)
	@JoinColumn(name="id_item")
	private Item item;
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	private Calendar dataEmprestimo;
	@Temporal(TemporalType.DATE)
	private Calendar dataDevolucao;
	private boolean Solicitacao;
	private boolean devolucao;
	
	public Emprestimo(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public boolean isSolicitacao() {
		return Solicitacao;
	}
	public void setSolicitacao(boolean solicitacao) {
		Solicitacao = solicitacao;
	}
	public boolean isDevolucao() {
		return devolucao;
	}
	public void setDevolucao(boolean devolucao) {
		this.devolucao = devolucao;
	}

	
}
