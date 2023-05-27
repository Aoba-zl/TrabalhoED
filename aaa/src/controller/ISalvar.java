package controller;

import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Aluno;
import model.Grupo;
import model.Area;

public interface ISalvar {
	public void SalvarAluno(Aluno A) throws Exception;
	public void SalvarSubarea(Area S,JComboBox comboBox) throws Exception;
	public void SalvarGrupo (Grupo grupo, String subarea, JTextField[] vt, JTextField textFieldID) throws IOException;
	
}
