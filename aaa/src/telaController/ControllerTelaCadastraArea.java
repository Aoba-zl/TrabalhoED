package telaController;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JComboBox;

import controller.Atualizar;
import controller.Salvar;
import controllerFila.FilaObject;
import model.Area;
import modelObject.ISetObject;
import view.TelaCadastrarGrupos;

public class ControllerTelaCadastraArea {
	/**
	 * @param cG 
	 * @wbp.parser.entryPoint
	 */
	public void SalvarSubarea (JTextPane textPaneSubarea,JComboBox comboBox, ISetObject SetArea, TelaCadastrarGrupos cG)  {
		Salvar Save = new Salvar();
		Area Sub = new Area();
		Sub.setSubarea(textPaneSubarea.getText());
		if (Sub.getSubarea().length() >= 1 && comboBox.getSelectedItem().toString().length() >= 1) {
			cG.comboBox.addItem(textPaneSubarea.getText());
			try {
				int tam = SetArea.size();
				SetArea.addFirst(comboBox.getSelectedItem());
				if (SetArea.size()> tam){
					comboBox.addItem(SetArea.get(0));
				}
				Save.SalvarSubarea(Sub,comboBox);
				textPaneSubarea.setText("");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "As areas devem ser preenchidas");
		}
	}
	public int btnExcluir (String indesejado) throws Exception {
		FilaObject filaSub = new FilaObject();
		Atualizar A = new Atualizar();
		File arq = new File("C:\\TEMP", "Subarea.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			int cont = 1;
			int contFinal = 1;
			while (linha != null) {
				
					String[] vetLinha = linha.split(";");
					if (!vetLinha[1].contains(indesejado)) {
						filaSub.insert(linha);
						cont++;
					}else {
						contFinal = cont;
					}
					linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			A.excluiSubarea(filaSub);
			return contFinal;
		}
		return 0;
	}
}
