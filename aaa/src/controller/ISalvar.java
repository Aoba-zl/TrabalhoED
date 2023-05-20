package controller;

import model.Aluno;
import model.Subarea;

public interface ISalvar {
	public void SalvarAluno(Aluno A) throws Exception;
	public void SalvarSubarea(Subarea S) throws Exception;
}
