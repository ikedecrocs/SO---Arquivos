package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//----VIDEO----
		IArquivosController arqCont = new ArquivosController();
		String dirWin = "C:\\Windows";
		String dir = "C:\\temp";
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		String nome = "teste.txt";
		//receber conteudo para o createFile
		/*
		while(!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "digite uma frase", "entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if(!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha + "\r\n");
			}
		}
		*/
		
		/*
		try {
			//arqCont.readDir(dirWin);
			//arqCont.createFile(dir, "teste", ".txt", buffer.toString());
			//arqCont.openFile(dir, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//----TXT PARA EXCEL----
		String caminhoTXT = "C:\\Users\\Mateus\\Documents\\SO";
		String nomeTXT = "relatorio.txt";
		String nomeCSV = "relatorio";
		try {
			StringBuffer txt = arqCont.readFile(caminhoTXT, nomeTXT);
			arqCont.createFile(caminhoTXT, nomeCSV, ".csv", txt.toString());
			arqCont.openFile(caminhoTXT, nomeCSV + ".csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
