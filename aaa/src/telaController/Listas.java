package telaController;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import PilhaObject.PilhaObject;
import controller.Buscar;

public class Listas {
	public void listaAluno(JList list) throws Exception {
		int cont = 0;
		PilhaObject aluno = new PilhaObject();
		Buscar busca = new Buscar();
		aluno = busca.buscarAluno(aluno);
		DefaultListModel DLM = new DefaultListModel();
		while(!aluno.isEmpty()) {
			DLM.addElement("RA:"+aluno.pop()+";"+"Aluno:"+aluno.pop());
			cont ++;
		}
		list.setModel(DLM);
	}
}
