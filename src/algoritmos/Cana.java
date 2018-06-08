package algoritmos;

import utils.ArquivoHandler;

public class Cana {

	public static void main(String[] args) {
		
		String arquivoEntrada = "C:\\Desenvolvimento\\CANA\\entrada.txt";
		String arquivoSaida = "C:\\Desenvolvimento\\CANA\\saida.txt";

		if (true) {
			Dinamico(arquivoEntrada,arquivoSaida);
		}else {
			Guloso();
		}
		
	   }

	private static void Guloso() {
		// TODO Auto-generated method stub
		System.out.println("****CHAMADO METODO GULOSO****");
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
