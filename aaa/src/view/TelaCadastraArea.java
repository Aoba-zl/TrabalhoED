package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controller.Buscar;
import controller.Salvar;
import controllerFila.FilaObject;
import model.Area;
import modelObject.ISetObject;
import modelObject.SetObject;
import telaController.ControllerTelaCadastraArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
// COMBOBOX NAO ATUALIZA SOZINHO MAIS!!!!! ATUALIZAR
public class TelaCadastraArea {
	private JComboBox comboBoxArea;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void cadastraSubarea(JTabbedPane tabbedPane) {
		Buscar B = new Buscar();
		ControllerTelaCadastraArea controller = new ControllerTelaCadastraArea();
		ISetObject SetArea = new SetObject();
		
		
		JPanel Subarea = new JPanel();
		tabbedPane.addTab("Cadastrar Subárea", null, Subarea, null);
		Subarea.setLayout(null);
		try {
			ISetObject SetAreaAtual = B.buscarArea(SetArea);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JLabel lblSubarea = new JLabel("Subárea:");
		lblSubarea.setBounds(10, 142, 91, 49);
		lblSubarea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubarea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Subarea.add(lblSubarea);
		
		JTextPane textPaneSubarea = new JTextPane();
		textPaneSubarea.setBounds(111, 142, 511, 49);
		Subarea.add(textPaneSubarea);
		
		comboBoxArea = new JComboBox();
		comboBoxArea.setModel(new DefaultComboBoxModel(new String[] {" "}));
		comboBoxArea.setEditable(true);
		comboBoxArea.setBounds(111, 46, 511, 49);
		Subarea.add(comboBoxArea);
		
		JButton btnSalvarSubarea = new JButton("Salvar");
		btnSalvarSubarea.setBounds(392, 246, 177, 56);
		btnSalvarSubarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.SalvarSubarea(textPaneSubarea,comboBoxArea,SetArea);
			}
		});
		adiciona(SetArea);
		btnSalvarSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		Subarea.add(btnSalvarSubarea);
		
		JButton btnExcluirSubarea = new JButton("Excluir");
		btnExcluirSubarea.setBounds(131, 246, 177, 56);
		btnExcluirSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		Subarea.add(btnExcluirSubarea);
		
		JLabel lblArea = new JLabel("Área:");
		lblArea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArea.setBounds(10, 43, 91, 49);
		Subarea.add(lblArea);
		
		
	}
	private void adiciona(ISetObject setArea) {
		int tam = setArea.size();
		for(int J=0; J<tam; J++){
			try {
				comboBoxArea.addItem(setArea.get(J));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
