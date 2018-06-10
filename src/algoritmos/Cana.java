package algoritmos;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import utils.ArquivoHandler;

public class Cana {

	public static void main(String[] args) {
				
		String arquivoEntrada = "C:\\Desenvolvimento\\CANA\\entrada.txt";
		String arquivoSaida = "C:\\Desenvolvimento\\CANA\\saida.txt";

		Options options = new Options();
	      options.addOption("d", "dinamico", false, "Usando metodo dinamico")
	         .addOption("g", "guloso", false, "Usando metodo guloso")
	         .addOption("gt", "guloso top-botton", false, "Usando metodo guloso botton");

	      HelpFormatter formatter = new HelpFormatter();
	      
	  
	      CommandLineParser parser = new DefaultParser();
	      try {
	    	  
			CommandLine cmd = parser.parse( options, args);
			
			if(cmd.hasOption("d")) {
				Dinamico(arquivoEntrada,arquivoSaida);
			}else if(cmd.hasOption("g")) {
				Guloso(arquivoEntrada,arquivoSaida);
			}else if(cmd.hasOption("gt")) {
				System.out.println("METODO NÃO IMPLEMENTADO");
			}else {
				formatter.printHelp("Opcao nao existe, Opcoes possiveis:", options);
			}
			
						
		} catch (ParseException e) {
			
			formatter.printHelp("Opcao nao existe, Opcoes possiveis:", options);
		}
		
		
		
		
	   }

	private static void Guloso(String arquivoEntrada, String arquivoSaida) {
		
		System.out.println("****CHAMADO METODO GULOSO****");
		//Lendo arquivos
		
				int quantidadeInstancias = ArquivoHandler.quatidadeInstancias(arquivoEntrada);
				
				System.out.println("lendo quantidade instancias = "+quantidadeInstancias);
				
				int instanciasProcessadas= 0;
				while (instanciasProcessadas<quantidadeInstancias) {
					String entrada = ArquivoHandler.lerInstancia(arquivoEntrada,instanciasProcessadas);
					String saida = new Guloso().resolver(entrada);
					ArquivoHandler.escreverSaida(saida,arquivoSaida);
					instanciasProcessadas ++;
				}
				
	}
	

	private static void Dinamico(String arquivoEntrada, String arquivoSaida) {
		
		System.out.println("****CHAMADO METODO DINAMICO****");
		
		//Lendo arquivos
		
		int quantidadeInstancias = ArquivoHandler.quatidadeInstancias(arquivoEntrada);
		
		int instanciasProcessadas= 0;
		while (instanciasProcessadas<quantidadeInstancias) {
			String entrada = ArquivoHandler.lerInstancia(arquivoEntrada,instanciasProcessadas);
			String saida = new Dinamico().resolver(entrada);
			ArquivoHandler.escreverSaida(saida,arquivoSaida);
			instanciasProcessadas ++;
		}
		
				
	} 

	}
