package telaController;

import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import controller.Buscar;
import controller.Salvar;
import listaObject.ListaObject;

public class ControllerConsultaGrupo {
	public void salvar(String iD,ListaObject listaNova) {
		Salvar S = new Salvar();
		try {
			S.SalvarOrientacaoConsulta(iD, listaNova);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selecionaOrientacao (JLabel lblDataView, JLabel lblIDMostra, ListaObject lista, JTextPane textPaneDescricao, int cont, JLabel[] labels, JCheckBox[] checkBox,int Perm) throws Exception {
		Buscar B = new Buscar();
		if (Perm ==0) {
			B.buscarOrientacaoExpecifica(lblIDMostra.getText(), lista);
		}
		
		if (!lista.isEmpty()) {
			
			String[] vetLinha = (lista.get(cont).toString().split(";"));
			boolean[]estado = new boolean[(vetLinha.length-3)/2];
			int N = 0;
			for (int J=3; J<vetLinha.length;J=J+2) {
				if (vetLinha[J].toString().contains("true")) {
					estado[N] = true;
				}else {
					estado[N] = false;
				}
				N++;
			}
			N = 4;
			for (int J=0;J<labels.length;J++) {
				labels[J].setVisible(false);
				checkBox[J].setVisible(false);
				if (J<estado.length) {
					labels[J].setVisible(true);
					labels[J].setText(vetLinha[N].toString());
					checkBox[J].setVisible(true);
					checkBox[J].setSelected(estado[J]);
				}
				N=N+2;
			}
			
			lblDataView.setText(vetLinha[0].toString());
			textPaneDescricao.setText(vetLinha[2].toString());
			
		}else {
			lblDataView.setText("");
			textPaneDescricao.setText("");
		}
	}
	
	public void ajustaNovaLista (ListaObject listaNova,int cont,int posicao,JCheckBox checkBox) {
		
		try {
			String[] vetLinha = listaNova.get(cont).toString().split(";");
			if (checkBox.isSelected()) {
				vetLinha[posicao] = "true";
			}else {
				vetLinha[posicao] = "false";
			}
			listaNova.remove(cont);
			int tam = vetLinha.length;
			String juntar = vetLinha[0];
			for (int J=1;J<tam;J++) {
				juntar = juntar+";"+vetLinha[J];
			}
			
			listaNova.add(juntar, cont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
