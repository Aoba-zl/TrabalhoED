package model;

public class Orientaçoes {
	private int data;
	private String descricao;
	private String instrucoes;
	
	public Orientaçoes(int data, String descricao, String instrucoes) {
		this.data = data;
		this.descricao = descricao;
		this.instrucoes = instrucoes;
	}
	
	public int getData() {
		return data;
	}
	public String getDescrição() {
		return descricao;
	}
	
	public String getInstruçoes() {
		return instrucoes;
	}
	
}
