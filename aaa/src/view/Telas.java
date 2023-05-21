package view;
//LALALALALAL
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import telaController.*;
import PilhaJCheckBox.PilhaJ;
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
import PilhaTextField.PilhaTextField;
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
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DebugGraphics;
import javax.swing.DropMode;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

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
	private JComboBox<Object> comboBox;
	private Grupo grupo = new Grupo();
	private JTextField textFieldData;
	private JTextField textFieldGrupo;
	private JTextField textFieldInstrucao;
	private int local = 0;
	private JCheckBox rdbtnInstrucao;
	private PilhaJ pilhaRdbtn = new PilhaJ();
	private PilhaTextField pilhaField = new PilhaTextField();
	private JTextField textField_1;
	private JComboBox<Object> comboBox_1;
	private JList list;
	private Listas geraListaAluno = new Listas();
	private JScrollPane scrollPane;
	private JTextField textoAluno;
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
		tabbedPane.setBounds(0, 0, 692, 368);
		contentPane.add(tabbedPane);
		//INICIO
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
				A.setRA(textFieldRA.getText());
				if (A.getRA().length() == 13 && A.getNomeA().length() > 1) {
					try {
						Save.SalvarAluno(A);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else if (A.getRA().length()!=13) {
					JOptionPane.showMessageDialog(null, "O RA deve conter exatos 13 digitos");
				}else {
					JOptionPane.showMessageDialog(null, "As areas devem ser preenchidas");
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
						comboBox.addItem(textPaneSubarea.getText());
						comboBox_1.addItem(textPaneSubarea.getText());
						textPaneSubarea.setText("");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "A area deve ser preenchida");
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
		// GRUPO
		JPanel Grupo = new JPanel();
		tabbedPane.addTab("Cadastrar Grupos", null, Grupo, null);
		Grupo.setLayout(null);
		PilhaObject pilhaAluno = new PilhaObject();
		Buscar B = new Buscar();
		try {
			 pilhaAluno = B.buscarAluno(pilhaAluno);
		}catch(Exception e1){
			
		}
		try {
			String Nome = pilhaAluno.pop().toString();
			String RA = pilhaAluno.pop().toString();
		}catch(Exception e1){
			
		}
		
		
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
					selecionar(true,false,false,false);
					chckbx2.setSelected(false);
					chckbx3.setSelected(false);
					chckbx4.setSelected(false);
					grupo.setQuantidade(1);
				}else {
					selecionar(false,false,false,false);
					grupo.setQuantidade(0);
				}
			}
		});
		panelGrupo_1.add(chckbx1);
		
		chckbx2 = new JCheckBox("2");
		chckbx2.setBounds(92, 43, 43, 23);
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
					grupo.setQuantidade(0);
				}
			}
		});
		panelGrupo_1.add(chckbx2);
		
		chckbx3 = new JCheckBox("3");
		chckbx3.setBounds(171, 43, 41, 23);
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
					grupo.setQuantidade(0);
				}
			}
		});
		panelGrupo_1.add(chckbx3);
		
		chckbx4 = new JCheckBox("4");
		chckbx4.setBounds(245, 43, 43, 23);
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
					grupo.setQuantidade(0);
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
		textAluno1.setEditable(false);
		textAluno1.setBounds(10, 114, 211, 20);
		panelGrupo_1.add(textAluno1);
		textAluno1.setColumns(10);
		
		btnAluno3 = new JButton("Buscar");
		btnAluno3.setBounds(224, 225, 78, 23);
		btnAluno3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geraListaAluno.listaAluno(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textoAluno = textAluno3;
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		panelGrupo_1.add(btnAluno3);
		
		textAluno2 = new JTextField();
		textAluno2.setEditable(false);
		textAluno2.setBounds(10, 171, 211, 20);
		textAluno2.setColumns(10);
		panelGrupo_1.add(textAluno2);
		
		btnAluno4 = new JButton("Buscar");
		btnAluno4.setBounds(224, 281, 78, 23);
		btnAluno4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoAluno = textAluno4;
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
			}
		});
		panelGrupo_1.add(btnAluno4);
		
		textAluno3 = new JTextField();
		textAluno3.setEditable(false);
		textAluno3.setBounds(10, 226, 211, 20);
		textAluno3.setColumns(10);
		panelGrupo_1.add(textAluno3);
		
		textAluno4 = new JTextField();
		textAluno4.setEditable(false);
		textAluno4.setBounds(10, 282, 211, 20);
		textAluno4.setColumns(10);
		panelGrupo_1.add(textAluno4);
		
		btnAluno2 = new JButton("Buscar");
		btnAluno2.setBounds(224, 170, 78, 23);
		btnAluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geraListaAluno.listaAluno(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textoAluno = textAluno2;
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
				list.setEnabled(true);
			}
		});
		panelGrupo_1.add(btnAluno2);
		
		btnAluno1 = new JButton("Buscar");
		btnAluno1.setBounds(224, 113, 78, 23);
		btnAluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					geraListaAluno.listaAluno(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textoAluno = textAluno1;
				panelGrupo_1.setVisible(false);
				panelGrupo_1.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnVoltar.setEnabled(true);
				list.setEnabled(true);
				
			}
		});
		panelGrupo_1.add(btnAluno1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 73, 310, 2);
		panelGrupo_1.add(separator_1);
		
		JLabel lblSubareaG = new JLabel("Subárea:");
		lblSubareaG.setBounds(361, 7, 253, 23);
		lblSubareaG.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubareaG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblSubareaG);
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setBounds(361, 80, 253, 23);
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblTema);
		
		textTema = new JTextField();
		textTema.setBounds(361, 114, 253, 20);
		
		textTema.setColumns(10);
		panelGrupo_1.add(textTema);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(361, 145, 253, 23);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelGrupo_1.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(361, 171, 253, 20);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		panelGrupo_1.add(textFieldID);
		
		JButton btnSalvarGrupo = new JButton("Salvar");
		btnSalvarGrupo.setBounds(499, 248, 148, 56);
		btnSalvarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.setTema(textTema.getText());
				Salvar save = new Salvar();
				JTextField[] Vt = {textAluno1,textAluno2,textAluno3,textAluno4};
				if (grupo.getQuantidade() !=0 && grupo.getID() != 00 && grupo.getTema().length()>1) {
					try {
						save.SalvarGrupo(grupo,comboBox.getSelectedItem().toString(),Vt);
						textAluno1.setText("");
						textAluno2.setText("");
						textAluno3.setText("");
						textAluno4.setText("");
						textTema.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if (grupo.getQuantidade() == 0) {
					JOptionPane.showMessageDialog(null, "Deve-se selelecionar a quantidade do grupo");
				}else if (grupo.getID() == 00) {
					JOptionPane.showMessageDialog(null, "Deve-se selelecionar uma subárea");
				}else {
					JOptionPane.showMessageDialog(null, "Deve-se escrever o tema");
				}
			}
		});
		btnSalvarGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelGrupo_1.add(btnSalvarGrupo);
		JButton btnAtualizarGrupo = new JButton("Atualizar");
		btnAtualizarGrupo.setBounds(341, 248, 148, 56);
		btnAtualizarGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelGrupo_1.add(btnAtualizarGrupo);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(999999);
		comboBox.setBounds(361, 43, 253, 22);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(27, 0, 311, 340);
		Buscar.add(scrollPane);
		
		list = new JList();
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(9999);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ORIENTAÇÃO
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
		// CONSULTA
		JPanel Consulta = new JPanel();
		tabbedPane.addTab("Consulta Grupos", null, Consulta, null);
		Consulta.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 62, 345, 278);
		Consulta.add(scrollPane_3);
		
		JTable table = new JTable();
		table.setEnabled(false);
		table.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		scrollPane_3.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ca", "ca", "da", "ba"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
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
		adiciona(pilhaSub);
		comboBox_1.setBounds(71, 29, 131, 22);
		Consulta.add(comboBox_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(345, 0, 1, 340);
		Consulta.add(separator_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 56, 345, 2);
		Consulta.add(separator_1_1);	
		
	}
	private void selecionar(boolean a,boolean b,boolean c,boolean d) {
		textAluno1.setVisible(a);;
		textAluno2.setVisible(b);
		textAluno3.setVisible(c);
		textAluno4.setVisible(d);
		btnAluno1.setVisible(a);
		btnAluno2.setVisible(b);
		btnAluno3.setVisible(c);
		btnAluno4.setVisible(d);
	}

	private void adiciona(PilhaObject pilhaSub) {

		while (!pilhaSub.isEmpty()) {
			try {
				comboBox_1.addItem(pilhaSub.top());
				comboBox.addItem(pilhaSub.pop());;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}