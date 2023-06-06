package controller;

import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listaObject.ListaObject;
import model.Aluno;
import model.Grupo;
import model.Orientaçoes;
import model.Area;

public interface ISalvar {
	public void SalvarAluno(Aluno A) throws Exception;
	public void SalvarSubarea(Area S,JComboBox comboBox) throws Exception;
	public void SalvarGrupo (Grupo grupo, String subarea, JTextField[] vt, JTextField textFieldID) throws IOException;
	public int SalvarOrientacao (Orientaçoes orientacao, JTextField textFieldGrupo, String[] botao, JPanel panelOrientacao) throws Exception;
	public void SalvarOrientacaoConsulta (String iD ,ListaObject ListaNova) throws Exception;
}
