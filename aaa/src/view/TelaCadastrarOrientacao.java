package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import PilhaJCheckBox.PilhaJ;
import PilhaTextField.PilhaTextField;
import controller.Salvar;
import model.Orientaçoes;
import telaController.AdicionarTela;

public class TelaCadastrarOrientacao {
	private JTextField textFieldData; 
	private PilhaJ pilhaRdbtn = new PilhaJ();
	private PilhaTextField pilhaField = new PilhaTextField();
	private JTextField textFieldGrupo;
	protected int local;
	protected JTextField textFieldInstrucao;
	protected JCheckBox rdbtnInstrucao;

	public void cadastrarOrientacao(JTabbedPane tabbedPane) {
		JPanel Orientacoes = new JPanel();
		tabbedPane.addTab("Cadastrar Orientações", null, Orientacoes, null);
		Orientacoes.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(292, 0, 1, 340);
		Orientacoes.add(separator_2);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(10, 25, 272, 20);
		Orientacoes.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(10, 0, 272, 25);
		Orientacoes.add(lblData);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrupo.setBounds(10, 56, 272, 25);
		Orientacoes.add(lblGrupo);
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setColumns(10);
		textFieldGrupo.setBounds(10, 81, 190, 20);
		Orientacoes.add(textFieldGrupo);
		
		JButton btnGrupo = new JButton("Buscar");
		btnGrupo.setBounds(204, 80, 78, 23);
		Orientacoes.add(btnGrupo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 137, 272, 192);
		Orientacoes.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescricao.setBounds(10, 112, 272, 25);
		Orientacoes.add(lblDescricao);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(292, 0, 385, 267);
		Orientacoes.add(scrollPane_2);
		
		JLabel lbInstrucao = new JLabel("Instruções:");
		lbInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
		lbInstrucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_2.setColumnHeaderView(lbInstrucao);
		
		JPanel panelOrientacao = new JPanel();
		scrollPane_2.setViewportView(panelOrientacao);
		panelOrientacao.setLayout(null);
		
		JButton btnAdiciona = new JButton("+");
		btnAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarTela adicionar = new AdicionarTela();
				if (pilhaRdbtn.size() <10) {
					local = local +22;
					adicionar.AdicionaOrientação(panelOrientacao, pilhaRdbtn, pilhaField, local, textFieldInstrucao, rdbtnInstrucao);
				}else {
					JOptionPane.showMessageDialog(null, "Limite Atingido");
				}
			}
		});
		btnAdiciona.setBounds(0, 0, 193, 11);
		panelOrientacao.add(btnAdiciona);
		
		JButton btnTira = new JButton("-");
		btnTira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pilhaRdbtn.isEmpty()) {
					try {
						local = local -22;
						pilhaRdbtn.top().setVisible(false);
						pilhaField.top().setVisible(false);
						panelOrientacao.remove(pilhaRdbtn.pop());
						panelOrientacao.remove(pilhaField.pop());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Sem oritações para serem removidas");
				}
			}
		});
		btnTira.setBounds(190, 0, 193, 11);
		panelOrientacao.add(btnTira);
		

		
		
		
		JButton btnSalvarOrientacao = new JButton("Salvar");
		btnSalvarOrientacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar SalvarOrientacao = new Salvar();
				try {
				Orientaçoes orientacao = new Orientaçoes();
				orientacao.setData(Integer.parseInt(textFieldData.getText()));
				orientacao.setDescricao(textArea.getText());
				int tam = pilhaField.size();
				String[] instrucoes = new String[tam]; 
				for (int J = 0;J<tam;J++) {
					try {
						instrucoes[J] = pilhaField.pop().getText();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				orientacao.setInstrucoes(instrucoes);
					SalvarOrientacao.SalvarOrientacao(orientacao,textFieldGrupo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvarOrientacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvarOrientacao.setBounds(505, 270, 148, 56);
		Orientacoes.add(btnSalvarOrientacao);
		
		JButton btnAtualizarOrientacao = new JButton("Atualizar");
		btnAtualizarOrientacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtualizarOrientacao.setBounds(317, 270, 148, 56);
		Orientacoes.add(btnAtualizarOrientacao);
	}
}
