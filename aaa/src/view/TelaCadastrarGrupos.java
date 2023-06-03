package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import PilhaObject.PilhaObject;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import PilhaObject.PilhaObject;
import controller.Buscar;
import controller.Salvar;
import controllerFila.FilaObject;
import model.Grupo;
import telaController.ControllerCadastrarGrupos;
import telaController.Listas;
import telaController.Seleciona;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TelaCadastrarGrupos {
	private JPanel panelGrupo_1;
	private JCheckBox chckbx1;
	protected JCheckBox chckbx2;
	protected JCheckBox chckbx3;
	protected JCheckBox chckbx4;
	private JTextField textAluno1;
	private JButton btnAluno3;
	protected JTextField textoAluno;
	protected JTextField textAluno3;
	protected JButton btnBuscar;
	protected JButton btnVoltar;
	private JTextField textAluno2;
	private JButton btnAluno4;
	protected JTextField textAluno4;
	private JButton btnAluno1;
	private JButton btnAluno2;
	protected JList list;
	private JTextField textTema;
	private JTextField textFieldID;
	public JComboBox comboBox;
	private JPanel Buscar;
	private JScrollPane scrollPane;

	/**
	 * 
	 * @param cONG 
	 * @wbp.parser.entryPoint
	 */
	public void cadastrarGrupos(JTabbedPane tabbedPane, TelaConsultaGrupos cONG) {
		ControllerCadastrarGrupos controll = new ControllerCadastrarGrupos();
		Listas geraListaAluno = new Listas();
		Grupo grupo = new Grupo();
		Buscar B = new Buscar();
		JPanel Grupo = new JPanel();
		tabbedPane.addTab("Cadastrar Grupos", null, Grupo, null);
		Grupo.setLayout(null);
		
		
		panelGrupo_1 = new JPanel();
		panelGrupo_1.setBounds(0, 0, 679, 340);
		Grupo.add(panelGrupo_1);
		panelGrupo_1.setLayout(null);
		
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(0, 0, 310, 36);
		panelGrupo_1.add(lblQuantidade);
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		grupo.setQuantidade(0);
		chckbx1 = new JCheckBox("1");
		chckbx1.setBounds(20, 43, 43, 23);
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx1.isSelected()) {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, true,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
					
				}else {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
				}
			}
		});
		panelGrupo_1.add(chckbx1);
		
		chckbx2 = new JCheckBox("2");
		chckbx2.setBounds(92, 43, 43, 23);
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx2.isSelected()) {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2,  true,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
				}else {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
				}
			}
		});
		panelGrupo_1.add(chckbx2);
		
		chckbx3 = new JCheckBox("3");
		chckbx3.setBounds(171, 43, 41, 23);
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx3.isSelected()) {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3,  true,chckbx4,textAluno4, btnAluno4, false));
				}else {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
				}
			}
		});
		panelGrupo_1.add(chckbx3);
		
		chckbx4 = new JCheckBox("4");
		chckbx4.setBounds(245, 43, 43, 23);
		chckbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx4.isSelected()) {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4,  true));
				}else {
					grupo.setQuantidade(controll.quantidade(chckbx1,textAluno1, btnAluno1, false,chckbx2,textAluno2, btnAluno2, false,chckbx3,textAluno3, btnAluno3, false,chckbx4,textAluno4, btnAluno4, false));
				}
			}
		});
		panelGrupo_1.add(chckbx4);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(309, 0, 1, 340);
		separator.setOrientation(SwingConstants.VERTICAL);
		panelGrupo_1.add(separator);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(0, 80, 310, 23);
		lblAlunos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		panelGrupo_1.add(lblAlunos);
		
		textAluno1 = new JTextField();
		textAluno1.setVisible(false);
		textAluno1.setEditable(false);
		textAluno1.setBounds(10, 114, 211, 20);
		panelGrupo_1.add(textAluno1);
		textAluno1.setColumns(10);
		
		btnAluno3 = new JButton("Buscar");
		btnAluno3.setVisible(false);
		btnAluno3.setBounds(224, 225, 78, 23);
		btnAluno3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geraListaAluno.listaAluno(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				GeraLista(textAluno3,geraListaAluno);
			}
		});
		panelGrupo_1.add(btnAluno3);
		
		textAluno2 = new JTextField();
		textAluno2.setVisible(false);
		textAluno2.setEditable(false);
		textAluno2.setBounds(10, 171, 211, 20);
		textAluno2.setColumns(10);
		panelGrupo_1.add(textAluno2);
		
		btnAluno4 = new JButton("Buscar");
		btnAluno4.setVisible(false);
		btnAluno4.setBounds(224, 281, 78, 23);
		btnAluno4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraLista(textAluno4,geraListaAluno);
			}
		});
		panelGrupo_1.add(btnAluno4);
		
		textAluno3 = new JTextField();
		textAluno3.setVisible(false);
		textAluno3.setEditable(false);
		textAluno3.setBounds(10, 226, 211, 20);
		textAluno3.setColumns(10);
		panelGrupo_1.add(textAluno3);
		
		textAluno4 = new JTextField();
		textAluno4.setVisible(false);
		textAluno4.setEditable(false);
		textAluno4.setBounds(10, 282, 211, 20);
		textAluno4.setColumns(10);
		panelGrupo_1.add(textAluno4);
		
		btnAluno2 = new JButton("Buscar");
		btnAluno2.setVisible(false);
		btnAluno2.setBounds(224, 170, 78, 23);
		btnAluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geraListaAluno.listaAluno(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				GeraLista(textAluno2,geraListaAluno);
			}
		});
		panelGrupo_1.add(btnAluno2);
		
		btnAluno1 = new JButton("Buscar");
		btnAluno1.setVisible(false);
		btnAluno1.setBounds(224, 113, 78, 23);
		btnAluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraLista(textAluno1,geraListaAluno);
			}
		});
		panelGrupo_1.add(btnAluno1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 73, 310, 2);
		panelGrupo_1.add(separator_1);
		
		JLabel lblSubareaG = new JLabel("Subárea:");
		lblSubareaG.setBounds(361, 24, 253, 23);
		lblSubareaG.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubareaG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblSubareaG);
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setBounds(361, 91, 253, 23);
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblTema);
		
		textTema = new JTextField();
		textTema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				 if (Character.isWhitespace(c) || Character.isISOControl(c) || Character.isAlphabetic(c)|| Character.isDigit(c))
	                {
					 	textTema.setEditable(true);
	                }
	                else
	                {
	                	textTema.setEditable(false);
	                }
			}
		});
		textTema.setBounds(361, 125, 253, 20);
		
		textTema.setColumns(10);
		panelGrupo_1.add(textTema);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(361, 156, 253, 23);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(361, 186, 253, 20);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		panelGrupo_1.add(textFieldID);
		
		JButton btnSalvarGrupo = new JButton("Salvar");
		btnSalvarGrupo.setBounds(411, 248, 148, 56);
		btnSalvarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.setTema(textTema.getText());
				controll.salvar(grupo,textAluno1,textAluno2,textAluno3,textAluno4,textTema,comboBox,textFieldID);
				comboBox.setSelectedIndex(comboBox.getSelectedIndex());
				cONG.addTable(cONG.table, "", "");
			}
		});
		btnSalvarGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelGrupo_1.add(btnSalvarGrupo);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(999999);
		comboBox.setBounds(361, 58, 253, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"   "}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.iD(grupo,comboBox,textFieldID,B);
			}
		});
		addBox();

			
		panelGrupo_1.add(comboBox);
		
		
		Buscar = new JPanel();
		Buscar.setEnabled(false);
		Buscar.setBounds(0, 0, 679, 340);
		Grupo.add(Buscar);
		Buscar.setLayout(null);
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setEnabled(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.voltar(panelGrupo_1,btnBuscar,btnVoltar,list,scrollPane);
				
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBounds(447, 203, 193, 74);
		Buscar.add(btnVoltar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.buscar(textoAluno,list);
				controll.voltar(panelGrupo_1,btnBuscar,btnVoltar,list,scrollPane);
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
	private void adiciona(FilaObject filaSub) {

		while (!filaSub.filaVazia()) {
			try {
				comboBox.addItem(filaSub.remove());;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	private void GeraLista (JTextField textAluno, Listas geraListaAluno) {
		try {
			geraListaAluno.listaAluno(list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		textoAluno = textAluno;
		panelGrupo_1.setVisible(false);
		panelGrupo_1.setEnabled(false);
		btnBuscar.setEnabled(true);
		btnVoltar.setEnabled(true);
		list.setEnabled(true);	
		btnBuscar.setVisible(true);
	}
	public void addBox() {
		Buscar buscaSub = new Buscar();
		FilaObject filaSub = new FilaObject();
		try {
			buscaSub.buscarSubarea(filaSub);
			adiciona(filaSub);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
