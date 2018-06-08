package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ArquivoHandler {
	
	public static List<String> lerArquivo(String nomeArquivo) {
		
		File arquivo = new File(nomeArquivo);
		String[] linhas = null;
		List<String> linhasArray = new ArrayList<String>();
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(arquivo));
			String linha = null;
			while((linha=leitor.readLine())!=null) {
				linhasArray.add(linha);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return linhasArray;
		
	}
	
	/*
	 * Metodo
	 */

	public static int quatidadeInstancias(String nomeArquivo) {
		List<String> linhasArray = new ArrayList<String>();
		linhasArray= lerArquivo(nomeArquivo);

		return Integer.parseInt(linhasArray.get(0));
	}

	public static String lerInstancia(String nomeArquivo,int instancia) {
		List<String> linhasArray = new ArrayList<String>();
		linhasArray= lerArquivo(nomeArquivo);

		return linhasArray.get(instancia+1);
	}

	
	public static void escreverSaida(String saida, String arquivoSaida) {
		File arquivo = new File(arquivoSaida);
		try {
			FileWriter escritor = new FileWriter(arquivo,true);
			
			escritor.write(saida);
			escritor.write("\n");
			escritor.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(saida);
	}



}
