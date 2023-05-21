package controller;

import java.io.IOException;

import javax.swing.JTextField;

import model.Aluno;
import model.Grupo;
import model.Subarea;

public interface ISalvar {
	public void SalvarAluno(Aluno A) throws Exception;
	public void SalvarSubarea(Subarea S) throws Exception;
	public void SalvarGrupo (Grupo grupo, String subarea, JTextField[] vt) throws IOException;
	
}
