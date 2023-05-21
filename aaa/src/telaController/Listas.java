package telaController;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import PilhaObject.PilhaObject;
import controller.Buscar;

public class Listas {
	public void listaAluno(JList list) throws Exception {
		int cont = 0;
		PilhaObject auno = new PilhaObject();
		Buscar busca = new Buscar();
		auno = busca.buscarAluno(auno);
		DefaultListModel DLM = new DefaultListModel();
		while(!auno.isEmpty()) {
			DLM.addElement("RA:"+auno.pop()+";"+"Aluno:"+auno.pop());
			cont ++;
		}
		list.setModel(DLM);
	}
}
