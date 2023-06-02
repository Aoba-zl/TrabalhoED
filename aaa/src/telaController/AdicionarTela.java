package telaController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PilhaJCheckBox.PilhaJ;
import PilhaTextField.PilhaTextField;

public class AdicionarTela {
	public void AdicionaOrientação(JPanel panel, PilhaJ pilhaRdbtn, PilhaTextField pilhaField, int local,JTextField textFieldInstrucao,JCheckBox rdbtnInstrucao) {
		
		textFieldInstrucao = new JTextField();
		textFieldInstrucao.setBounds(37, local, 336, 20);
		panel.add(textFieldInstrucao);
		textFieldInstrucao.setColumns(10);
		textFieldInstrucao.setVisible(false);
		textFieldInstrucao.setVisible(true);
		
		
		pilhaField.push(textFieldInstrucao);
		rdbtnInstrucao = new JCheckBox("");
		rdbtnInstrucao.setBounds(10, local, 21, 23);
		
		panel.add(rdbtnInstrucao);
		pilhaRdbtn.push(rdbtnInstrucao);
		
	}
}
