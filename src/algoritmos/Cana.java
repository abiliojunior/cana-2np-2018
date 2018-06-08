package algoritmos;

import utils.ArquivoHandler;

public class Cana {

	public static void main(String[] args) {
		
		String arquivoEntrada = "C:\\Desenvolvimento\\CANA\\entrada.txt";
		String arquivoSaida = "C:\\Desenvolvimento\\CANA\\saida.txt";

		if (false) {
			Dinamico(arquivoEntrada,arquivoSaida);
		}else {
			Guloso(arquivoEntrada,arquivoSaida);
		}
		
	   }

	private static void Guloso(String arquivoEntrada, String arquivoSaida) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		System.out.println("****CHAMADO METODO DINAMICO****");
		
		//Lendo arquivos
		
		int quantidadeInstancias = ArquivoHandler.quatidadeInstancias(arquivoEntrada);
		
		//System.out.println("lendo quantidade instancias = "+quantidadeInstancias);
		
		int instanciasProcessadas= 0;
		while (instanciasProcessadas<quantidadeInstancias) {
			String entrada = ArquivoHandler.lerInstancia(arquivoEntrada,instanciasProcessadas);
			String saida = new Dinamico().resolver(entrada);
			ArquivoHandler.escreverSaida(saida,arquivoSaida);
			instanciasProcessadas ++;
		}
		
				
	} 

	}
