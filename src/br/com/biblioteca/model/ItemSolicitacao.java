package br.com.biblioteca.model;

public class ItemSolicitacao {
	private long id_usuario;
	private long id_item;
	private String tipoLivro;
	private boolean status;
	public ItemSolicitacao(){
		
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public long getId_item() {
		return id_item;
	}
	public void setId_item(long id_item) {
		this.id_item = id_item;
	}
	public String getTipoLivro() {
		return tipoLivro;
	}
	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
