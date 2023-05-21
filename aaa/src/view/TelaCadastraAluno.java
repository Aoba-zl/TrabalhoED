package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import controller.Salvar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Aluno;

public class TelaCadastraAluno {
	private JTextField textFieldNome;
	private JTextField textFieldRA;
	public void CadastraAluno(JTabbedPane tabbedPane) {
		Salvar Save = new Salvar();
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
		btnAtualizarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizarAluno.setBounds(138, 210, 165, 80);
		Aluno.add(btnAtualizarAluno);
		
		JButton btnSalvarAluno = new JButton("Salvar");
		btnSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno A = new Aluno();
				A.setNomeA(textFieldNome.getText());
				A.setRA(textFieldRA.getText());
				if (A.getRA().length() == 13 && A.getNomeA().length() > 1) {
					try {
						Save.SalvarAluno(A);
					} catch (Exception e1) {
						e1.printStackTrace();	
					}
				}else if (A.getRA().length()!=13) {
					JOptionPane.showMessageDialog(null, "O RA deve conter exatos 13 digitos");
				}else {
					JOptionPane.showMessageDialog(null, "As areas devem ser preenchidas");
				}
			}
		});
		btnSalvarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarAluno.setBounds(396, 210, 165, 80);
		Aluno.add(btnSalvarAluno);
		
		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
	
		});
		textFieldNome.setBounds(121, 43, 490, 35);
		Aluno.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldRA = new JTextField();
		textFieldRA.setColumns(10);
		textFieldRA.setBounds(121, 113, 490, 35);
		Aluno.add(textFieldRA);
	}
}
