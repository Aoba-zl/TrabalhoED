package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PilhaObject.PilhaObject;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.*;
import model.*;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Telas extends JFrame {
	private Salvar Save = new Salvar();
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRA;
	private JTextField textAluno1;
	private JTextField textAluno2;
	private JTextField textAluno3;
	private JTextField textAluno4;
	private JButton btnAluno1;
	private JButton btnAluno2;
	private JButton btnAluno3;
	private JButton btnAluno4;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JCheckBox chckbx4;
	private JTextField textTema;
	private JTextField textFieldID;
	private JPanel panelGrupo_1;
	private JPanel Buscar;
	private JButton btnVoltar;
	private JButton btnBuscar;
	private JList<?> list;
	private JComboBox<Object> comboBox;
	private Grupo grupo = new Grupo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telas frame = new Telas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Telas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 765, 368);
		contentPane.add(tabbedPane);
		//INICIO
		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Inicio", null, Inicio, null);
		//ALUNO
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
				A.setRA(Integer.parseInt(textFieldRA.getText()));
				try {
					Save.SalvarAluno(A);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarAluno.setBounds(396, 210, 165, 80);
		Aluno.add(btnSalvarAluno);
		
		textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
			
			}
		});
		textFieldNome.setBounds(121, 43, 490, 35);
		Aluno.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldRA = new JTextField();
		textFieldRA.setColumns(10);
		textFieldRA.setBounds(121, 113, 490, 35);
		Aluno.add(textFieldRA);
		//SUBAREA
		JPanel Subarea = new JPanel();
		tabbedPane.addTab("Cadastrar Subárea", null, Subarea, null);
		Subarea.setLayout(null);
		
		JLabel lblSubarea = new JLabel("Subárea:");
		lblSubarea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubarea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubarea.setBounds(10, 106, 91, 49);
		Subarea.add(lblSubarea);
		
		JTextPane textPaneSubarea = new JTextPane();
		textPaneSubarea.setBounds(111, 106, 511, 49);
		Subarea.add(textPaneSubarea);
		
		JButton btnSalvarSubarea = new JButton("Salvar");
		btnSalvarSubarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subarea Sub = new Subarea();
				Sub.setTitulo(textPaneSubarea.getText());
				try {
					Save.SalvarSubarea(Sub);
					comboBox.addItem(textPaneSubarea.getText());
					textPaneSubarea.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "A area deve ser preenchida");
				}
			}
		});
		btnSalvarSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvarSubarea.setBounds(392, 246, 177, 56);
		Subarea.add(btnSalvarSubarea);
		
		JButton btnExcluirSubarea = new JButton("Excluir");
		btnExcluirSubarea.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirSubarea.setBounds(131, 246, 177, 56);
		Subarea.add(btnExcluirSubarea);
		// GRUPO
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
		
		chckbx1 = new JCheckBox("1");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx1.isSelected()) {
					selecionar(true,false,false,false);
					chckbx2.setSelected(false);
					chckbx3.setSelected(false);
					chckbx4.setSelected(false);
					grupo.setQuantidade(1);
				}else {
					selecionar(false,false,false,false);
				}
			}
		});
		chckbx1.setBounds(20, 43, 43, 23);
		panelGrupo_1.add(chckbx1);
		
		chckbx2 = new JCheckBox("2");
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx2.isSelected()) {
					selecionar(true,true,false,false);
					chckbx1.setSelected(false);
					chckbx3.setSelected(false);
					chckbx4.setSelected(false);
					grupo.setQuantidade(2);
				}else {
					selecionar(false,false,false,false);
				}
			}
		});
		chckbx2.setBounds(92, 43, 43, 23);
		panelGrupo_1.add(chckbx2);
		
		chckbx3 = new JCheckBox("3");
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx3.isSelected()) {
					selecionar(true,true,true,false);
					chckbx1.setSelected(false);
					chckbx2.setSelected(false);
					chckbx4.setSelected(false);
					grupo.setQuantidade(3);
				}else {
					selecionar(false,false,false,false);
				}
			}
		});
		chckbx3.setBounds(171, 43, 41, 23);
		panelGrupo_1.add(chckbx3);
		
		chckbx4 = new JCheckBox("4");
		chckbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx4.isSelected()) {
					selecionar(true,true,true,true);
					chckbx1.setSelected(false);
					chckbx2.setSelected(false);
					chckbx3.setSelected(false);
					grupo.setQuantidade(4);
				}else {
					selecionar(false,false,false,false);
				}
			}
		});
		chckbx4.setBounds(245, 43, 43, 23);
		panelGrupo_1.add(chckbx4);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(309, 0, 1, 340);
		panelGrupo_1.add(separator);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setBounds(0, 80, 310, 23);
		panelGrupo_1.add(lblAlunos);
		
		textAluno1 = new JTextField();
		textAluno1.setBounds(10, 114, 211, 20);
		panelGrupo_1.add(textAluno1);
		textAluno1.setColumns(10);
		
		btnAluno3 = new JButton("Buscar");
		btnAluno3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		btnAluno3.setBounds(224, 225, 78, 23);
		panelGrupo_1.add(btnAluno3);
		
		textAluno2 = new JTextField();
		textAluno2.setColumns(10);
		textAluno2.setBounds(10, 171, 211, 20);
		panelGrupo_1.add(textAluno2);
		
		btnAluno4 = new JButton("Buscar");
		btnAluno4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		btnAluno4.setBounds(224, 281, 78, 23);
		panelGrupo_1.add(btnAluno4);
		
		textAluno3 = new JTextField();
		textAluno3.setColumns(10);
		textAluno3.setBounds(10, 226, 211, 20);
		panelGrupo_1.add(textAluno3);
		
		textAluno4 = new JTextField();
		textAluno4.setColumns(10);
		textAluno4.setBounds(10, 282, 211, 20);
		panelGrupo_1.add(textAluno4);
		
		btnAluno2 = new JButton("Buscar");
		btnAluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		btnAluno2.setBounds(224, 170, 78, 23);
		panelGrupo_1.add(btnAluno2);
		
		btnAluno1 = new JButton("Buscar");
		btnAluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		btnAluno1.setBounds(224, 113, 78, 23);
		panelGrupo_1.add(btnAluno1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 73, 310, 2);
		panelGrupo_1.add(separator_1);
		
		JLabel lblSubareaG = new JLabel("Subárea:");
		lblSubareaG.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubareaG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubareaG.setBounds(361, 7, 253, 23);
		panelGrupo_1.add(lblSubareaG);
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTema.setBounds(361, 80, 253, 23);
		panelGrupo_1.add(lblTema);
		
		textTema = new JTextField();
		
		textTema.setColumns(10);
		textTema.setBounds(361, 114, 253, 20);
		panelGrupo_1.add(textTema);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(361, 145, 253, 23);
		panelGrupo_1.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(361, 171, 253, 20);
		panelGrupo_1.add(textFieldID);
		
		JButton btnSalvarSubarea_1 = new JButton("Salvar");
		btnSalvarSubarea_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.setTema(textTema.getText());
				Salvar save = new Salvar();
				JTextField[] Vt = {textAluno1,textAluno2,textAluno3,textAluno4};
				try {
					save.SalvarGrupo(grupo,comboBox.getSelectedItem().toString(),Vt);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvarSubarea_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvarSubarea_1.setBounds(499, 248, 148, 56);
		panelGrupo_1.add(btnSalvarSubarea_1);
		
		JButton btnAtualizarAluno_1 = new JButton("Atualizar");
		btnAtualizarAluno_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtualizarAluno_1.setBounds(341, 248, 148, 56);
		panelGrupo_1.add(btnAtualizarAluno_1);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"   "}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					grupo.setID(comboBox.getSelectedItem().toString());
					textFieldID.setText("0"+grupo.getID());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
			controller.Buscar buscaSub = new Buscar();
			PilhaObject pilhaSub = new PilhaObject();
			try {
				buscaSub.buscarSubarea(pilhaSub);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			while (!pilhaSub.isEmpty()) {
				try {
					comboBox.addItem(pilhaSub.pop());;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		comboBox.setBounds(361, 43, 253, 22);
		panelGrupo_1.add(comboBox);
		
		
		Buscar = new JPanel();
		Buscar.setEnabled(false);
		Buscar.setBounds(0, 0, 679, 340);
		Grupo.add(Buscar);
		Buscar.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(93, 0, 324, 340);
		Buscar.add(scrollPane);
		
		list = new JList<Object>();
		scrollPane.setViewportView(list);
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setEnabled(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGrupo_1.setVisible(true);
				btnBuscar.setEnabled(false);
				btnVoltar.setEnabled(false);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBounds(447, 203, 193, 74);
		Buscar.add(btnVoltar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuscar.setBounds(447, 41, 193, 74);
		Buscar.add(btnBuscar);
		// ORIENTAÇÃO
		JPanel Orientacoes = new JPanel();
		tabbedPane.addTab("Cadastrar Orientações", null, Orientacoes, null);
		// CONSULTA
		JPanel Consulta = new JPanel();
		tabbedPane.addTab("Consulta Grupos", null, Consulta, null);
		Consulta.setLayout(null);
		
		
		
		
	}
	private void selecionar(boolean a,boolean b,boolean c,boolean d) {
		textAluno1.setVisible(a);
		textAluno2.setVisible(b);
		textAluno3.setVisible(c);
		textAluno4.setVisible(d);
		btnAluno1.setVisible(a);
		btnAluno2.setVisible(b);
		btnAluno3.setVisible(c);
		btnAluno4.setVisible(d);
	}
}
