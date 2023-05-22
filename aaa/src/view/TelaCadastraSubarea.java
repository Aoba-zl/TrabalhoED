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

import controller.Salvar;
import model.Subarea;
// COMBOBOX NAO ATUALIZA SOZINHO MAIS!!!!! ATUALIZAR
public class TelaCadastraSubarea {
	public void cadastraSubarea(JTabbedPane tabbedPane) {
		Salvar Save = new Salvar();
		JPanel Subarea = new JPanel();
		tabbedPane.addTab("Cadastrar Subárea", null, Subarea, null);
		Subarea.setLayout(null);
		
		JLabel lblSubarea = new JLabel("Subárea:");
		lblSubarea.setBounds(10, 106, 91, 49);
		lblSubarea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubarea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Subarea.add(lblSubarea);
		
		JTextPane textPaneSubarea = new JTextPane();
		textPaneSubarea.setBounds(111, 106, 511, 49);
		Subarea.add(textPaneSubarea);
		
		JButton btnSalvarSubarea = new JButton("Salvar");
		btnSalvarSubarea.setBounds(392, 246, 177, 56);
		btnSalvarSubarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subarea Sub = new Subarea();
				Sub.setTitulo(textPaneSubarea.getText());
				if (Sub.getTitulo().length() >= 1) {
					try {
						Save.SalvarSubarea(Sub);
						textPaneSubarea.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "A area deve ser preenchida");
				}
			}
		});
		btnSalvarSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		Subarea.add(btnSalvarSubarea);
		
		JButton btnExcluirSubarea = new JButton("Excluir");
		btnExcluirSubarea.setBounds(131, 246, 177, 56);
		btnExcluirSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		Subarea.add(btnExcluirSubarea);
	}
}
