package telaController;

public class Seleciona {
	public String nomeAluno (String aluno) {
		String[] vetAluno= aluno.split(":");
		return vetAluno[2];
	}
	public String idGrupo (String aluno) {
		String[] vetgrupo= aluno.split(":");
		String[] vetId = vetgrupo[1].split(";");
		return vetId[0];
	}
}
