package testesdev;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class testesdev {

	public static void main(String[] args) {
		
		
		Options options = new Options();
	      options.addOption("d", "dinamico", false, "Usando metodo dinamico")
	         .addOption("g", "guloso", false, "Usando metodo guloso")
	         .addOption("gt", "guloso top - botton", false, "Usando metodo guloso botton");

	      HelpFormatter formatter = new HelpFormatter();
	      
	  
	      CommandLineParser parser = new DefaultParser();
	      try {
			CommandLine cmd = parser.parse( options, args);
			if(cmd.hasOption("d")) {
				System.out.println(1);
			}
			else {
				formatter.printHelp("Opcao nao existe, Opcoes possiveis", options);
			}
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
