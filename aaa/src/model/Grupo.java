package model;

import PilhaObject.PilhaObject;
import controller.Buscar;
import controllerFila.FilaObject;

public class Grupo {
	private int quantidade;
	private String tema;
	private int id;
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public void setID(String subarea) throws Exception {
		this.id = geraID(subarea);
	}
	public int getQuantidade() {
		return quantidade;
	}

	public String getTema() {
		return tema;
	}
	
	
	public int getID() {
		return id;
	}
	
	private int geraID(String subarea) throws Exception {
		Buscar busca = new Buscar();
		
		FilaObject fila = new FilaObject();
		busca.buscarSubarea(fila);
		int id=0;
		while (!fila.filaVazia()) {
			String topo = (String) fila.remove();
			if(topo !=("") && topo!=(" ") && topo!=(null)) {
				id++;
			}
			if (topo.contains(subarea)) {
				break;
			}else if (subarea == "   ") {
				id = 0;
				break;
			}
		}
		return id;
		
	}
	
}
