package telaController;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import PilhaObject.PilhaObject;
import controller.Buscar;
import controllerFila.FilaObject;

public class Listas {
	public void listaAluno(JList list) throws Exception {
		PilhaObject aluno = new PilhaObject();
		Buscar busca = new Buscar();
		aluno = busca.buscarAluno(aluno);
		DefaultListModel DLM = new DefaultListModel();
		while(!aluno.isEmpty()) {
			DLM.addElement("RA:"+aluno.pop()+";"+"Aluno:"+aluno.pop());
		}
		list.setModel(DLM);
	}
	public void listaGrupo(JList list) throws Exception {
		
		FilaObject filaGrupo = new FilaObject();
		FilaObject filaSub = new FilaObject();
		Buscar busca = new Buscar();
		
		busca.buscarSubarea(filaSub);
		int tam = filaSub.size();
		DefaultListModel DLM = new DefaultListModel();
		for (int J=0;J<tam;J++) {
			busca.buscarGrupo(J, filaGrupo);
			while(!filaGrupo.filaVazia()) {
				
					DLM.addElement("ID: "+filaGrupo.remove()+"; "+"Tema: "+filaGrupo.remove()+"; Subarea: "+filaGrupo.remove()+"; Quantidade: "+filaGrupo.remove());
			}
		}
		list.setModel(DLM);
	}
}
