package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController{

	public ArquivosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readDir(String path) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File f : files) {
				if(f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
			}
		} else {
			throw new IOException("Diretório inválido");
		}
	}

	@Override
	public void createFile(String path, String nome, String extensao, String conteudo) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(path);
		File arq = new File(path, nome + extensao);
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			FileWriter escritor = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(escritor);
			print.write(conteudo);
			print.flush();
			print.close();
			escritor.close();
		} else {
			throw new IOException("Diretório inválido");
		}
	}
	
	//como o conteúdo está entrando como parâmetro, o que estaria no geraTXT() está no principal
	
	@Override
	public StringBuffer readFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			StringBuffer saida = new StringBuffer();
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) { //procurando EOF - end of file
				System.out.println(linha);
				saida.append(linha + "\r\n");
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return saida;
		}else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo inválido");
		}
	}
	
	

}
