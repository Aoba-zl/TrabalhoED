package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import controller.Atualizar;
import controller.Buscar;
import controller.Salvar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import PilhaObject.PilhaObject;
import model.Aluno;
import telaController.ControllerTelaCadastraAluno;

public class TelaCadastraAluno {
	private JTextField textFieldNome;
	private JTextField textFieldRA;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void CadastraAluno(JTabbedPane tabbedPane) {
		Salvar Save = new Salvar();
		ControllerTelaCadastraAluno controller = new ControllerTelaCadastraAluno();
		
		JPanel Aluno = new JPanel();
		tabbedPane.addTab("Cadastrar Aluno", null, Aluno, null);
		Aluno.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(20, 33, 91, 49);
		Aluno.add(lblNome);
		
		JLabel lblRA = new JLabel("RA:");
		lblRA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRA.setBounds(20, 99, 91, 49);
		Aluno.add(lblRA);
		
		JButton btnAtualizarAluno = new JButton("Atualizar");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar B = new Buscar();
				ControllerTelaCadastraAluno C = new ControllerTelaCadastraAluno ();
				PilhaObject pilha = new PilhaObject();
				try {
					B.buscarAluno(pilha);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				int cont = 0;
				while (!pilha.isEmpty()) {
					try {
						if (pilha.pop().toString().contains(textFieldRA.getText())) {
							C.btnAtualizar(B,textFieldNome.getText(),textFieldRA.getText(),1);
							cont = 1;
							textFieldNome.setText("");
							textFieldRA.setText("");
							break;
						}else if (pilha.pop().toString().contains(textFieldNome.getText())) {
							C.btnAtualizar(B,textFieldRA.getText(),textFieldNome.getText(),0);
							cont = 1;
							textFieldNome.setText("");
							textFieldRA.setText("");
							break;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (cont == 0) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				}
			}
		});
		btnAtualizarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizarAluno.setBounds(138, 210, 165, 80);
		Aluno.add(btnAtualizarAluno);
		
		JButton btnSalvarAluno = new JButton("Salvar");
		btnSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnSalvarAluno(textFieldNome, textFieldRA);
			}
		});
		btnSalvarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarAluno.setBounds(396, 210, 165, 80);
		Aluno.add(btnSalvarAluno);
		
		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
	
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				 if (Character.isWhitespace(c) || Character.isISOControl(c) || Character.isAlphabetic(c))
	                {
					 	textFieldNome.setEditable(true);
	                }
	                else
	                {
	                	textFieldNome.setEditable(false);
	                }
			}
		});
		textFieldNome.setBounds(121, 43, 490, 35);
		Aluno.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldRA = new JTextField();
		textFieldRA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				 if (Character.isWhitespace(c) || Character.isISOControl(c) || Character.isDigit(c))
	                {
					 	textFieldRA.setEditable(true);
	                }
	                else
	                {
	                	textFieldRA.setEditable(false);
	                }
			}
		});
		textFieldRA.setColumns(10);
		textFieldRA.setBounds(121, 113, 490, 35);
		Aluno.add(textFieldRA);
	}
}
