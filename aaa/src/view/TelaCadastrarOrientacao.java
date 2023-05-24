package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import PilhaJCheckBox.PilhaJ;
import PilhaTextField.PilhaTextField;
import controller.Salvar;
import model.Orientaçoes;
import telaController.AdicionarTela;
import telaController.SelecionaAluno;

public class TelaCadastrarOrientacao {
	private JTextField textFieldData; 
	private PilhaJ pilhaRdbtn = new PilhaJ();
	private PilhaTextField pilhaField = new PilhaTextField();
	private JTextField textFieldGrupo;
	protected int local;
	protected JTextField textFieldInstrucao;
	protected JCheckBox rdbtnInstrucao;
	private JButton btnVoltar;
	private JList list;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JPanel Buscar;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void cadastrarOrientacao(JTabbedPane tabbedPane) {
		JPanel Orientacoes = new JPanel();
		tabbedPane.addTab("Cadastrar Orientações", null, Orientacoes, null);
		Orientacoes.setLayout(null);
		
		JPanel CadastrarOrientaçao = new JPanel();
		CadastrarOrientaçao.setBounds(10, 0, 667, 340);
		Orientacoes.add(CadastrarOrientaçao);
		CadastrarOrientaçao.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(282, 0, 1, 340);
		CadastrarOrientaçao.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(0, 25, 272, 20);
		CadastrarOrientaçao.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(0, 0, 272, 25);
		CadastrarOrientaçao.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(0, 56, 272, 25);
		CadastrarOrientaçao.add(lblGrupo);
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setBounds(0, 81, 190, 20);
		CadastrarOrientaçao.add(textFieldGrupo);
		textFieldGrupo.setColumns(10);
		
		JButton btnGrupo = new JButton("Buscar");
		btnGrupo.setBounds(194, 80, 78, 23);
		CadastrarOrientaçao.add(btnGrupo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 137, 272, 192);
		CadastrarOrientaçao.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(0, 112, 272, 25);
		CadastrarOrientaçao.add(lblDescricao);
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(282, 0, 385, 267);
		CadastrarOrientaçao.add(scrollPane_2);
		
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
		btnSalvarOrientacao.setBounds(495, 270, 148, 56);
		CadastrarOrientaçao.add(btnSalvarOrientacao);
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
		
		JButton btnAtualizarOrientacao = new JButton("Atualizar");
		btnAtualizarOrientacao.setBounds(307, 270, 148, 56);
		CadastrarOrientaçao.add(btnAtualizarOrientacao);
		btnAtualizarOrientacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		Buscar = new JPanel();
		Buscar.setEnabled(false);
		Buscar.setBounds(0, 0, 679, 340);
		Orientacoes.add(Buscar);
		Buscar.setLayout(null);
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setEnabled(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarOrientaçao.setVisible(true);
				btnBuscar.setEnabled(false);
				btnVoltar.setEnabled(false);
				list.setEnabled(false);
				scrollPane.setEnabled(false);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBounds(447, 203, 193, 74);
		Buscar.add(btnVoltar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionaAluno seleciona = new SelecionaAluno();
				CadastrarOrientaçao.setVisible(true);
				btnBuscar.setEnabled(false);
				btnBuscar.setVisible(false);
				btnVoltar.setEnabled(false);
				list.setEnabled(false);
				scrollPane.setEnabled(false);
			}
		});
		btnBuscar.setEnabled(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnBuscar.setBounds(447, 41, 193, 74);
		Buscar.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(27, 0, 311, 340);
		Buscar.add(scrollPane);
		
		list = new JList();
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(9999);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}