package br.com.biblioteca.model;

import java.util.Calendar;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
@SecondaryTables({
	@SecondaryTable(name="item", pkJoinColumns={@PrimaryKeyJoinColumn(name="id_item")}),
	@SecondaryTable(name="usuario", pkJoinColumns={@PrimaryKeyJoinColumn(name="id_usuario")})
})
public class Solicitacao {
	//variaveis do item
	private long id_item;
	private String titulo;
	private String tipoItem;
	//variaveis do usuario
	private long id_usuario;
	private String login;
	private String tipoUsuario;
	//variaveis do emprestimo
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private boolean Solicitacao;
	private boolean devolucao;
	
	public Solicitacao(){
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	public long getId_item() {
		return id_item;
	}
	public void setId_item(long id_item) {
		this.id_item = id_item;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Solicitacao popular(Item i, Usuario u){
		Solicitacao s = new Solicitacao();
		
		return s;
	}
}
