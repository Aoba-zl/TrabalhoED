package controller;

import PilhaObject.PilhaObject;
import controllerFila.FilaObject;

public interface IAtualizar {
	public void atualizarAluno (PilhaObject pilhaPrincipal) throws Exception;
	public void excluiSubarea (FilaObject filaSub) throws Exception;
	public void atualizarGrupos (String grupo, String iDAntigo, String iDNovo) throws Exception;
}
