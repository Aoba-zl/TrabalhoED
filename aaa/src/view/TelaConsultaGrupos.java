package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Buscar;
import controllerFila.FilaObject;
import listaObject.ListaObject;
import telaController.ControllerConsultaGrupo;
import telaController.Listas;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class TelaConsultaGrupos {
	private JTextField textFieldID;
	private JComboBox<Object> comboBoxSubarea;
	private JTable table;
	private int cont = 0;
	private ListaObject Lista = new ListaObject();
	private ListaObject ListaNova = new ListaObject();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void TelaConsulta(JTabbedPane tabbedPane) {
		FilaObject filaSub = new FilaObject();
		Listas geraListaAluno = new Listas();
		JPanel Consulta = new JPanel();
		Buscar B = new Buscar();
		tabbedPane.addTab("Consulta Grupos", null, Consulta, null);
		Consulta.setLayout(null);
		
		
		
		JLabel lblPesquisa = new JLabel("Pesquisa"	);
		lblPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisa.setBounds(0, 0, 335, 30);
		Consulta.add(lblPesquisa);
		
		JLabel lblSubrea = new JLabel("Subárea:");
		lblSubrea.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubrea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubrea.setBounds(0, 28, 69, 23);
		Consulta.add(lblSubrea);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(192, 28, 69, 23);
		Consulta.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub = "";
				sub = comboBoxSubarea.getSelectedItem().toString();
				
				addTable(table,sub,textFieldID.getText().toString());
			}
		});
		textFieldID.setColumns(10);
		textFieldID.setBounds(241, 28, 98, 23);
		Consulta.add(textFieldID);
		
		comboBoxSubarea = new JComboBox<Object>();
		comboBoxSubarea.setModel(new DefaultComboBoxModel(new String[] {" \t "}));
		comboBoxSubarea.setMaximumRowCount(9999);
		comboBoxSubarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub = "";
				String id = "";
					sub = comboBoxSubarea.getSelectedItem().toString();
					id = textFieldID.getText().toString();
				addTable(table,sub,id);
			}
		});
		adiciona(filaSub);
		comboBoxSubarea.setBounds(71, 29, 131, 22);
		Consulta.add(comboBoxSubarea);
		addBox();
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(345, 0, 1, 340);
		Consulta.add(separator_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 56, 345, 2);
		Consulta.add(separator_1_1);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setBounds(678, 0, 1, 340);
		Consulta.add(separator_3_1);
		
		JTabbedPane tabbedPaneGrupos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneGrupos.setBounds(345, 0, 334, 340);
		Consulta.add(tabbedPaneGrupos);
		
		JPanel panelGeral = new JPanel();
		tabbedPaneGrupos.addTab("Geral", null, panelGeral, null);
		panelGeral.setLayout(null);
		
		JLabel lblMembros = new JLabel("Membros:");
		lblMembros.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMembros.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMembros.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembros.setBounds(0, 0, 104, 103);
		panelGeral.add(lblMembros);
		
		JLabel lblAluno1 = new JLabel("");
		lblAluno1.setForeground(new Color(0, 0, 0));
		lblAluno1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAluno1.setBounds(105, 0, 110, 53);
		panelGeral.add(lblAluno1);
		
		JLabel lblAluno2 = new JLabel("");
		lblAluno2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAluno2.setBounds(217, 0, 110, 53);
		panelGeral.add(lblAluno2);
		
		JLabel lblAluno3 = new JLabel("");
		lblAluno3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAluno3.setBounds(105, 50, 110, 53);
		panelGeral.add(lblAluno3);
		
		JLabel lblAluno4 = new JLabel("");
		lblAluno4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAluno4.setBounds(217, 50, 110, 53);
		panelGeral.add(lblAluno4);
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTema.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTema.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTema.setBounds(0, 105, 104, 74);
		panelGeral.add(lblTema);
		
		JLabel lblSubrea_1 = new JLabel("Subárea:");
		lblSubrea_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubrea_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubrea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSubrea_1.setBounds(0, 181, 104, 74);
		panelGeral.add(lblSubrea_1);
		
		JLabel lblTemaMostra = new JLabel("");
		lblTemaMostra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaMostra.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTemaMostra.setBounds(105, 105, 222, 74);
		panelGeral.add(lblTemaMostra);
		
		JLabel lblSubareaMostra = new JLabel("");
		lblSubareaMostra.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubareaMostra.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSubareaMostra.setBounds(105, 181, 222, 74);
		panelGeral.add(lblSubareaMostra);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblID.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblID.setBounds(0, 258, 104, 54);
		panelGeral.add(lblID);
		
		JLabel lblIDMostra = new JLabel("");
		lblIDMostra.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDMostra.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblIDMostra.setBounds(105, 258, 222, 54);
		panelGeral.add(lblIDMostra);
		
		JPanel panelOrientações = new JPanel();
		tabbedPaneGrupos.addTab("Orientações", null, panelOrientações, null);
		panelOrientações.setLayout(null);
		
		JTabbedPane Orientação = new JTabbedPane(JTabbedPane.TOP);
		Orientação.setBounds(0, 0, 329, 312);
		panelOrientações.add(Orientação);
		
		JPanel panelInformaçoes = new JPanel();
		Orientação.addTab("Informaçoes", null, panelInformaçoes, null);
		panelInformaçoes.setLayout(null);
		
		
		
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(0, 24, 108, 25);
		panelInformaçoes.add(lblData);
		
		JLabel lblDataView = new JLabel("");
		lblDataView.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDataView.setBounds(110, 24, 214, 25);
		panelInformaçoes.add(lblDataView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 324, 152);
		panelInformaçoes.add(scrollPane);
		
		JTextPane textPaneDescricao = new JTextPane();
		textPaneDescricao.setEditable(false);
		scrollPane.setViewportView(textPaneDescricao);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDescrio.setBounds(0, 56, 324, 25);
		panelInformaçoes.add(lblDescrio);
		
		
		JPanel panelBox = new JPanel();
		Orientação.addTab("Orientaçoes dadas", null, panelBox, null);
		panelBox.setLayout(null);
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerConsultaGrupo C = new ControllerConsultaGrupo();
				C.ajutaNovaLista(ListaNova,cont,3,chckbx1);
			}
		});
		chckbx1.setVisible(false);
		chckbx1.setBounds(6, 7, 21, 23);
		panelBox.add(chckbx1);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl1.setVisible(false);
		lbl1.setBounds(29, 7, 295, 23);
		panelBox.add(lbl1);
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.setVisible(false);
		chckbx2.setBounds(6, 33, 21, 23);
		panelBox.add(chckbx2);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl2.setVisible(false);
		lbl2.setBounds(29, 32, 295, 23);
		panelBox.add(lbl2);
		
		JCheckBox chckbx3 = new JCheckBox("");
		chckbx3.setVisible(false);
		chckbx3.setBounds(6, 59, 21, 23);
		panelBox.add(chckbx3);
		
		JCheckBox chckbx4 = new JCheckBox("");
		chckbx4.setVisible(false);
		chckbx4.setBounds(6, 85, 21, 23);
		panelBox.add(chckbx4);
		
		JCheckBox chckbx5 = new JCheckBox("");
		chckbx5.setVisible(false);
		chckbx5.setBounds(6, 111, 21, 23);
		panelBox.add(chckbx5);
		
		JCheckBox chckbx6 = new JCheckBox("");
		chckbx6.setVisible(false);
		chckbx6.setBounds(6, 137, 21, 23);
		panelBox.add(chckbx6);
		
		JCheckBox chckbx7 = new JCheckBox("");
		chckbx7.setVisible(false);
		chckbx7.setBounds(6, 163, 21, 23);
		panelBox.add(chckbx7);
		
		JCheckBox chckbx8 = new JCheckBox("");
		chckbx8.setVisible(false);
		chckbx8.setBounds(6, 189, 21, 23);
		panelBox.add(chckbx8);
		
		JCheckBox chckbx9 = new JCheckBox("");
		chckbx9.setVisible(false);
		chckbx9.setBounds(6, 215, 21, 23);
		panelBox.add(chckbx9);
		
		JCheckBox chckbx10 = new JCheckBox("");
		chckbx10.setVisible(false);
		chckbx10.setBounds(6, 241, 21, 23);
		panelBox.add(chckbx10);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl3.setVisible(false);
		lbl3.setBounds(29, 59, 295, 23);
		panelBox.add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl4.setVisible(false);
		lbl4.setBounds(29, 85, 295, 23);
		panelBox.add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl5.setVisible(false);
		lbl5.setBounds(29, 111, 295, 23);
		panelBox.add(lbl5);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl6.setVisible(false);
		lbl6.setBounds(29, 137, 295, 23);
		panelBox.add(lbl6);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl7.setVisible(false);
		lbl7.setBounds(29, 163, 295, 23);
		panelBox.add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl8.setVisible(false);
		lbl8.setBounds(29, 189, 295, 23);
		panelBox.add(lbl8);
		
		JLabel lbl9 = new JLabel("");
		lbl9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl9.setVisible(false);
		lbl9.setBounds(29, 215, 295, 23);
		panelBox.add(lbl9);
		
		JLabel lbl10 = new JLabel("");
		lbl10.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl10.setVisible(false);
		lbl10.setBounds(29, 241, 295, 23);
		panelBox.add(lbl10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 62, 345, 278);
		Consulta.add(scrollPane_3);
		
		JButton btnSalvarAlteracoes = new JButton("Salvar Alterações");
		btnSalvarAlteracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerConsultaGrupo C = new ControllerConsultaGrupo();
				C.salvar(Integer.parseInt(lblIDMostra.toString()),ListaNova);
			}
		});
		btnSalvarAlteracoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvarAlteracoes.setBounds(45, 237, 238, 47);
		panelInformaçoes.add(btnSalvarAlteracoes);
		JLabel[] labels = {lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10};
		JCheckBox[]checkBox = {chckbx1,chckbx2,chckbx3,chckbx4,chckbx5,chckbx6,chckbx7,chckbx8,chckbx9,chckbx10};
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cont = 0;

				try {
					String[] vt = new String[8];
					if (table.getValueAt(table.getSelectedRow(),0).toString().length()==4) {
						vt = B.buscarGrupoExpecifico(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString().charAt(2)+""+table.getValueAt(table.getSelectedRow(),0).toString().charAt(3)), Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString().charAt(0)+""+table.getValueAt(table.getSelectedRow(),0).toString().charAt(1)));
					}else {
						vt = B.buscarGrupoExpecifico(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString().charAt(2)+""),Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString().charAt(0)+""+table.getValueAt(table.getSelectedRow(),0).toString().charAt(1)));
					}
					JLabel[] alunos = {lblAluno1,lblAluno2,lblAluno3,lblAluno4};
					nomeGrupo(vt,alunos);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				lblTemaMostra.setText(table.getValueAt(table.getSelectedRow(),1 ).toString());
				lblIDMostra.setText(table.getValueAt(table.getSelectedRow(),0).toString());
				lblSubareaMostra.setText(table.getValueAt(table.getSelectedRow(),2).toString());
					ControllerConsultaGrupo C = new ControllerConsultaGrupo();
					try {
						Lista = new ListaObject();
						ListaNova = new ListaObject();
						C.selecionaOrientacao(lblDataView,lblIDMostra,Lista,textPaneDescricao,cont,labels,checkBox);
						ListaNova = Lista;
					} catch (Exception e1) {
						e1.printStackTrace();
					}

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tema", "Subárea", "Quantidade"
			}
		));
		
		scrollPane_3.setViewportView(table);
		addTable(table,"","");
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerConsultaGrupo C = new ControllerConsultaGrupo();
				try {
					if (cont >0) {
						cont--;
						C.selecionaOrientacao(lblDataView,lblIDMostra,Lista,textPaneDescricao,cont,labels,checkBox);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(0, 0, 160, 13);
		panelInformaçoes.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("->");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerConsultaGrupo C = new ControllerConsultaGrupo();
				if (cont < Lista.size()) {
					cont++;
					try {
						C.selecionaOrientacao(lblDataView,lblIDMostra,Lista,textPaneDescricao,cont,labels,checkBox);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(164, 0, 160, 13);
		panelInformaçoes.add(btnNewButton_1);
	}
	private void adiciona(FilaObject filaSub) {

		while (!filaSub.filaVazia()) {
			try {
				comboBoxSubarea.addItem(filaSub.remove());;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	private void addBox() {
		Buscar buscaSub = new Buscar();
		FilaObject filaSub = new FilaObject();
		try {
			buscaSub.buscarSubarea(filaSub);
			adiciona(filaSub);
		} catch (Exception e2) {	
			e2.printStackTrace();
		}
	}
	private void addTable(JTable table,String sub, String ID) {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		FilaObject filaGrupo = new FilaObject();
		Buscar busca = new Buscar();
		FilaObject filaSub = new FilaObject();
		int tam = model.getRowCount();
		for (int J=0; J<tam;J++) {
			model.removeRow(0);
		}
		try {
			busca.buscarSubarea(filaSub);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tam = filaSub.size();
		for (int J =0;J<tam;J++) {
			try {
				busca.buscarGrupo(J,filaGrupo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (sub.contains(" 	 ")) {
				sub = "";
			}
			while (!filaGrupo.filaVazia()) {
				try {
				String iD = filaGrupo.remove().toString();
				String tema = filaGrupo.remove().toString();
				String subArea = filaGrupo.remove().toString();
				String qnt = filaGrupo.remove().toString();
				if (iD.contains(ID) && subArea.contains(sub)) {
						model.addRow(new Object [] {iD,tema,subArea,qnt});
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private void nomeGrupo (String[] nomes, JLabel[] alunos) {
		for(int J=0;J<4;J++) {
			alunos[J].setText("");
	}
		int tam = nomes.length;
		for(int J=4;J<tam;J++) {
				alunos[J-4].setText(nomes[J]);
		}
	}
}
