package telaController;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import controller.Salvar;
import model.Area;
import modelObject.ISetObject;

public class ControllerTelaCadastraArea {
	public void SalvarSubarea (JTextPane textPaneSubarea,JComboBox comboBox, ISetObject SetArea) {
		Salvar Save = new Salvar();
		Area Sub = new Area();
		Sub.setSubarea(textPaneSubarea.getText());
		if (Sub.getSubarea().length() >= 1 && comboBox.getSelectedItem().toString().length() >= 1) {
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
}
