package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.*;

public class Salvar {
	public void SalvarAluno(Aluno A) throws Exception {
		File arq = new File("C:\\TEMP", "Aluno.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arq.exists() && arq.isFile()) {
			String nome = A.getNomeA();
			String RA = A.getRA();
			try {
				escreveArq.write(nome+";"+RA+"\r\n");
				System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
			}else {
				throw new IOException("Diretório Inválido");
			}
	}
	public void SalvarSubarea(Subarea S) throws Exception {
		File arq = new File("C:\\TEMP", "Subarea.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arq.exists() && arq.isFile()) {
			String titulo = S.getTitulo();
			try {
				escreveArq.write(titulo+"\r\n");
				System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
			}else {
				throw new IOException("Diretório Inválido");
			}
	}
	public void SalvarGrupo (Grupo grupo, String subarea, JTextField[] vt) throws IOException {
		String nomeGrupo = grupo.getID()+"Grupo.csv";
		File arq = new File("C:\\TEMP", nomeGrupo);
		boolean Campo = false;
		String nomes="";
		for(int J=0;J<4;J++) {
			if (vt[J].isVisible()) {
				if (vt[J].getText().length() > 1) {
					nomes = nomes+";"+vt[J].getText();
				}else {
					JOptionPane.showMessageDialog(null, "O campo aluno deve ser preenchido");
					Campo = true;
					break;
				}
			}
		}
		if (Campo == false) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			FileWriter abreArq = new FileWriter(arq, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			if (arq.exists() && arq.isFile()) {
				try {
					escreveArq.write(grupo.getTema()+";"+subarea+";"+grupo.getID()+";"+grupo.getQuantidade()+nomes+"\r\n");
					System.out.println();
					} catch (Exception e) {
						e.printStackTrace();
					}
				escreveArq.flush();
				escreveArq.close();
				abreArq.close();
				}else {
					throw new IOException("Diretório Inválido");
				}
		}
	}
	public void SalvarOrientacao (Orientaçoes orientacao, JTextField textFieldGrupo) throws IOException {
		File arq = new File("C:\\TEMP", "Orientaçoes.csv");
		int tam = orientacao.getInstruçoes().length;
		String ori = "";
		for (int J=0;J<tam;J++) {
			ori = ori+";"+orientacao.getInstruçoes()[J];
		}
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arq.exists() && arq.isFile()) {
			try {
				escreveArq.write(orientacao.getData()+";"+textFieldGrupo.getText()+";"+orientacao.getDescrição()+ori+"\r\n");
				System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
			}else {
				throw new IOException("Diretório Inválido");
			}
	}
}