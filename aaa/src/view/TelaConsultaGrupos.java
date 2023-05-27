package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DebugGraphics;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaConsultaGrupos {
	private JTextField textField_1;
	private JComboBox<Object> comboBox_1;
	private JTable table;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void TelaConsulta(JTabbedPane tabbedPane) {
		FilaObject filaSub = new FilaObject();
		JPanel Consulta = new JPanel();
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 28, 98, 23);
		Consulta.add(textField_1);
		
		comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {" "}));
		comboBox_1.setMaximumRowCount(9999);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		adiciona(filaSub);
		comboBox_1.setBounds(71, 29, 131, 22);
		Consulta.add(comboBox_1);
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
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 62, 345, 278);
		Consulta.add(scrollPane_3);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblTemaMostra.setText(table.getValueAt(table.getSelectedRow(),1).toString());
				lblIDMostra.setText(table.getValueAt(table.getSelectedRow(),0).toString());
				lblSubareaMostra.setText(table.getValueAt(table.getSelectedRow(),2).toString());
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
		addTable(table);
	}
	private void adiciona(FilaObject filaSub) {

		while (!filaSub.filaVazia()) {
			try {
				comboBox_1.addItem(filaSub.remove());;
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
	private void addTable(JTable table) {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		FilaObject filaGrupo = new FilaObject();
		Buscar busca = new Buscar();
		FilaObject filaSub = new FilaObject();
		try {
			busca.buscarSubarea(filaSub);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int tam = filaSub.size();
		for (int J =0;J<tam;J++) {
			try {
				busca.buscarGrupo(J,filaGrupo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (!filaGrupo.filaVazia()) {
				try {
					model.addRow(new Object [] {filaGrupo.remove(),filaGrupo.remove(),filaGrupo.remove(),filaGrupo.remove() });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
