package controller;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Etiquetas {

	private String abrir;
	private String salvar;
	private String linha;
	boolean sucesso = false;

	public String getAbrir() {
		return abrir;
	}

	public void setAbrir(String abrir) {
		this.abrir = abrir;
	}

	public String getSalvar() {
		return salvar;
	}

	public void setSalvar(String salvar) {
		this.salvar = salvar;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public boolean SalvarEtiquetas(String abrir, String salvar) throws HeadlessException, IOException {

		this.salvar = salvar;
		this.abrir = abrir;

		File file = new File(this.salvar.toString() + ".txt");
		FileReader arq = new FileReader(this.abrir);

		OutputStream out = new FileOutputStream(file);
		BufferedReader lerArq = new BufferedReader(arq);

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bf = new BufferedWriter(outputStreamWriter);

		int contador = 1;
		//int contadorEtiqueta = 1;
		String numeroAnterior = " ";
		bf.append("Número " + ";" + "Nome " + ";" + "Seq Arquivo"+ ";" + "Seq Etiqueta");
		bf.newLine();

		try {

			while ((linha = lerArq.readLine()) != null) {
				
				
				String numero = linha.substring(6, 20);
				
				
				
				String linhaAnterior = numero.replace(" ", "") + ";" + linha.substring(75, 110).toUpperCase() + ";"
						+ contador;

				if (!numeroAnterior.equals(linha.substring(6, 16))) {

					System.out.println(linhaAnterior);

					bf.append(linhaAnterior);

					bf.newLine();

					sucesso = true;
					

				}

				numeroAnterior = linha.substring(6, 16);
				contador++;

			}

		} catch (Exception e) {

			bf.close();
			lerArq.close();
			return sucesso;

		}

		bf.close();
		lerArq.close();
		return sucesso;

	}

}
