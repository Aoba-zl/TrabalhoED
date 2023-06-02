package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame{
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaPrincipal() {
		super();
		int cont = 1;
		TelaInicial I = new TelaInicial();
		TelaCadastraAluno CA = new TelaCadastraAluno();
		TelaCadastraArea CS = new TelaCadastraArea();
		TelaCadastrarGrupos CG = new TelaCadastrarGrupos();
		TelaCadastrarOrientacao CO = new TelaCadastrarOrientacao();
		TelaConsultaGrupos CONG = new TelaConsultaGrupos ();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 692, 368);
		contentPane.add(tabbedPane);
		I.Inicial(tabbedPane);
		CA.CadastraAluno(tabbedPane);
		CS.cadastraSubarea(tabbedPane,CG);
		CG.cadastrarGrupos(tabbedPane,CONG);
		CO.cadastrarOrientacao(tabbedPane);
		CONG.TelaConsulta(tabbedPane);
	}
}
