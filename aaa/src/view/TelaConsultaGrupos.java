package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controllerFila.FilaObject;
import javax.swing.ListSelectionModel;

public class TelaConsultaGrupos {
	private JTextField textField_1;
	private JComboBox<Object> comboBox_1;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void TelaConsulta(JTabbedPane tabbedPane) {
		FilaObject filaSub = new FilaObject();
		JPanel Consulta = new JPanel();
		tabbedPane.addTab("Consulta Grupos", null, Consulta, null);
		Consulta.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 62, 345, 278);
		Consulta.add(scrollPane_3);
		
		JTable table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		scrollPane_3.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ca", "ca", "da", "ba"},
				{null, null, null, null},

			},
			new String[] {
				"ID", "Tema", "Sub\u00E1rea", "Quantidade"
			}
		));
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
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
}
