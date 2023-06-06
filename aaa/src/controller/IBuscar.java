package controller;

import java.io.IOException;

import PilhaObject.PilhaObject;
import controllerFila.FilaObject;
import listaObject.ListaObject;
import modelObject.ISetObject;

public interface IBuscar {
	public PilhaObject buscarAluno(PilhaObject pilhaAluno) throws IOException;
	public void buscarSubarea(FilaObject filaSub) throws Exception;
	public ISetObject buscarArea(ISetObject setArea) throws Exception;
	public void buscarGrupo (int grupo, FilaObject filaGrupo) throws IOException;
	public String[] buscarGrupoExpecifico (int codGrupo, int codArquivo) throws IOException;
	public void buscarOrientacaoMenosUma (String iD, ListaObject Lista) throws IOException;
	public void buscarOrientacaoExpecifica (String iD, ListaObject Lista) throws IOException;
}
