package telaController;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Salvar;
import model.Aluno;

public class ControllerTelaCadastraAluno {
	public void btnSalvarAluno(JTextField textFieldNome, JTextField textFieldRA) {
		Salvar Save = new Salvar();
		Aluno A = new Aluno();
		A.setNomeA(textFieldNome.getText());
		A.setRA(textFieldRA.getText());
		if (A.getRA().length() == 13 && A.getNomeA().length() > 1) {
			try {
				Save.SalvarAluno(A);
				textFieldNome.setText("");
				textFieldRA.setText("");
			} catch (Exception e1) {
				e1.printStackTrace();	
			}
		}else if (A.getRA().length()!=13) {
			JOptionPane.showMessageDialog(null, "O RA deve conter exatos 13 digitos");
		}else {
			JOptionPane.showMessageDialog(null, "As areas devem ser preenchidas");
		}
	}
}
