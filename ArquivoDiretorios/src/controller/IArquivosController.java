package controller;

import java.io.IOException;

public interface IArquivosController {

	public void readDir(String path) throws IOException;
	public void createFile(String path, String nome, String extensao, String conteudo) throws IOException;
	public StringBuffer readFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
	
}
