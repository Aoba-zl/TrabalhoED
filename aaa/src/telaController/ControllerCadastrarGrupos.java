package telaController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Atualizar;
import controller.Buscar;
import controller.Salvar;
import controllerFila.FilaObject;
import model.Grupo;

public class ControllerCadastrarGrupos {
	public int quantidade(JCheckBox chckbx1, JTextField textAluno1, JButton btnAluno1, boolean a, JCheckBox chckbx2, JTextField textAluno2, JButton btnAluno2, boolean b, JCheckBox chckbx3, JTextField textAluno3, JButton btnAluno3, boolean c, JCheckBox chckbx4, JTextField textAluno4, JButton btnAluno4, boolean d) {
			chckbx1.setSelected(a);
			chckbx2.setSelected(b);
			chckbx3.setSelected(c);
			chckbx4.setSelected(d);
			int cont = 0;
			if (a ==true) {
				cont = 1;
			}else if (b==true) {
				a = true;
				cont = 2;
			}else if (c==true) {
				a = true;
				b = true;
				cont = 3;
			}else if (d==true) {
				a = true;
				b = true;
				c = true;
				cont = 4;
			}
			textAluno1.setVisible(a);;
			textAluno2.setVisible(b);
			textAluno3.setVisible(c);
			textAluno4.setVisible(d);
			btnAluno1.setVisible(a);
			btnAluno2.setVisible(b);
			btnAluno3.setVisible(c);
			btnAluno4.setVisible(d);
			return cont;
	}
	public void salvar (Grupo grupo, JTextField textAluno1, JTextField textAluno2, JTextField textAluno3, JTextField textAluno4, JTextField textTema, JComboBox comboBox, JTextField textFieldID) {
		Salvar save = new Salvar();
		JTextField[] vt = {textAluno1,textAluno2,textAluno3,textAluno4};
		if (grupo.getQuantidade() !=0 && grupo.getID() != 00 && grupo.getTema().length()>1) {
			try {
				save.SalvarGrupo(grupo,comboBox.getSelectedItem().toString(),vt,textFieldID);
				textAluno1.setText("");
				textAluno2.setText("");
				textAluno3.setText("");
				textAluno4.setText("");
				textTema.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (grupo.getQuantidade() == 0) {
			JOptionPane.showMessageDialog(null, "Deve-se selelecionar a quantidade do grupo");
		}else if (grupo.getID() == 00) {
			JOptionPane.showMessageDialog(null, "Deve-se selelecionar uma subárea");
		}else {
			JOptionPane.showMessageDialog(null, "Deve-se escrever o tema");
		}
	}
	public void voltar (JPanel panelGrupo_1, JButton btnBuscar, JButton btnVoltar, JList list, JScrollPane scrollPane) {
		panelGrupo_1.setVisible(true);
		btnBuscar.setEnabled(false);
		btnBuscar.setVisible(false);
		btnVoltar.setEnabled(false);
		list.setEnabled(false);
		scrollPane.setEnabled(false);
	}
	
	public void buscar (JTextField textoAluno, JList list) {
		Seleciona seleciona = new Seleciona();
		textoAluno.setText(seleciona.nomeAluno(list.getSelectedValue().toString()));
	}
	public void iD(Grupo grupo, JComboBox comboBox, JTextField textFieldID, Buscar B) {
		try {
			grupo.setID(comboBox.getSelectedItem().toString());
			FilaObject filaSub = new FilaObject();
			B.buscarSubarea(filaSub);
			if (grupo.getID() < 10) {
				textFieldID.setText("0"+grupo.getID()+secID(grupo.getID()));
			}else {
				textFieldID.setText(grupo.getID()+""+secID(grupo.getID()));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void btnAtualizar (Grupo grupo, JTextField textAluno1, JTextField textAluno2, JTextField textAluno3, JTextField textAluno4, JTextField textTema, JComboBox comboBox, String iD, JTextField IDNovo) throws Exception {
		JTextField[] vt = {textAluno1,textAluno2,textAluno3,textAluno4};
			int idGrupo = 0;
			Buscar B = new Buscar();
			String alunos = "";
			for (int J=0;J<4;J++) {
				if (vt[J].isVisible()) {
					alunos = alunos+";"+vt[J].getText();
				}
			}
			int idArq = Integer.parseInt(iD.charAt(0)+""+iD.charAt(1));
			if (iD.length() == 3) {
				idGrupo = Integer.parseInt(iD.charAt(2)+"");
			}else {
				idGrupo = Integer.parseInt(iD.charAt(2)+""+iD.charAt(3));
			}
			
		String[]antigoGrupo = B.buscarGrupoExpecifico(idGrupo, idArq);
		String NovoGrupo = "";
		Atualizar A = new Atualizar();
		if (antigoGrupo[1].contains(comboBox.getSelectedItem().toString())) {
			NovoGrupo = textTema.getText()+";"+comboBox.getSelectedItem()+";"+idGrupo+";"+grupo.getQuantidade()+alunos;
			A.atualizarGrupos(NovoGrupo, iD, iD);
		} else {
			NovoGrupo = textTema.getText()+";"+comboBox.getSelectedItem()+";"+IDNovo.getText().toString()+";"+grupo.getQuantidade()+alunos;
			A.atualizarGrupos(NovoGrupo, iD, IDNovo.getText());
		}
		
	}
	private int secID(int iD) throws IOException {
		String arquivo = iD+"Grupo.csv";
		File arq = new File("C:\\TEMP", arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			int cont = 0;
			while (linha != null) {
				cont++;
				if (linha == ".") {
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			return cont;
		}else {
			return 0;
		}
	}
}
											