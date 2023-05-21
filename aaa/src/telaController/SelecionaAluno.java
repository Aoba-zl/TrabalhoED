package telaController;

public class SelecionaAluno {
	public String nomeAluno (String aluno) {
		String[] vetAluno= aluno.split(":");
		return vetAluno[2];
	}
}
