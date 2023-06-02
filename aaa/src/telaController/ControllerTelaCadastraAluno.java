package telaController;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import PilhaObject.PilhaObject;
import controller.Atualizar;
import controller.Buscar;
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
	public void btnAtualizar(Buscar b, String Substituto, String Comparativo,int modo) {
		Atualizar A = new Atualizar ();
		PilhaObject pilhaPrincipal = new PilhaObject();
		PilhaObject pilhaSecundaria = new PilhaObject();
		try {
			
			b.buscarAluno(pilhaPrincipal);
			int cont = 0;
			if (modo == 1){
				while (cont !=1) {
					if (pilhaPrincipal.top().toString().contains(Comparativo)) {
						pilhaSecundaria.push(pilhaPrincipal.pop());
						pilhaPrincipal.pop();
						pilhaPrincipal.push(Substituto);
						while (!pilhaSecundaria.isEmpty()) {
							pilhaPrincipal.push(pilhaSecundaria.pop());
						}
						cont = 1;
					}else {
						pilhaSecundaria.push(pilhaPrincipal.pop());
					}
				}
			}else {
				while (cont !=1) {
					if (pilhaPrincipal.top().toString().contains(Comparativo)) {
						pilhaSecundaria.pop();
						pilhaPrincipal.push(Substituto);
						
						while (!pilhaSecundaria.isEmpty()) {
							pilhaPrincipal.push(pilhaSecundaria.pop());
						}
						cont = 1;
					}else {
						pilhaSecundaria.push(pilhaPrincipal.pop());
					}
				}
			}
			A.atualizarAluno(pilhaPrincipal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
