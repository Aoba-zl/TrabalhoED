package model;

public class Orientaçoes {
	private int data;
	private String descricao;
	private String[] instrucoes;
	
	
	
	public void setData(int data) {
		this.data = data;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setInstrucoes(String[] instrucoes) {
		this.instrucoes = instrucoes;
	}
	public int getData() {
		return data;
	}
	public String getDescrição() {
		return descricao;
	}
	
	public String[] getInstruçoes() {
		return instrucoes;
	}
	
}
