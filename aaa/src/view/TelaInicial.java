package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
public class TelaInicial {
	public void Inicial(JTabbedPane tabbedPane){
		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Inicio", null, Inicio, null);
		Inicio.setLayout(null);
		JLabel lblNewLabel = new JLabel("Bom Dia Professor! \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 677, 180);
		Inicio.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("O que gostaria de fazer?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 182, 677, 158);
		Inicio.add(lblNewLabel_1);
	}
}
