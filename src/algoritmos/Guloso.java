package algoritmos;

public class Guloso {

	public String resolver(String entrada) {
		
		String [] sDimSplit = entrada.split(" ");
		int[] dim= new int [sDimSplit.length];
		
		for (int i = 0; i < sDimSplit.length; i++) {
			dim[i] = Integer.parseInt(sDimSplit[i]);
		}
		
		//return metodoGuloso(dim,0,dim.length-1);
		System.out.println(algoritmoGuloso(dim,1,dim.length-1));
		return "";
	}

		
	private int algoritmoGuloso(int[] p, int i, int j) {
        Retorno r = new Retorno();
		if (i == j) {
        	System.out.print("A" + i);
            return 0;
        }
        int valor = Integer.MAX_VALUE;
        int auxK = -1;

        for (int k = i; k < j; k++) {
            int x = p[i - 1] * p[k] * p[j];
            if (x < valor){
                valor = x;
                auxK = k;
            }
        }

        System.out.print("(");
        valor += algoritmoGuloso(p, i, auxK);
        valor += algoritmoGuloso(p, auxK + 1, j);
        System.out.print(")");

        return valor;
    }
	
	
	class Retorno{
		int custo;
		String cadeia;
		
		public void set(int custo, String Cadeia) {
			this.custo = custo;
			this.cadeia = cadeia;
		}
	}
	
	
	
	
	
	
	
	
	private String metodoGuloso(int[] p, int x, int y) {
		// TODO Auto-generated method stub`
		String resposta = "";
		int pKey = Integer.MAX_VALUE;
		int key = 0;
		if(x==y-1) {
			System.out.println("Soma1");
			return "A"+y;
		}else if (x==(y-2)){
			System.out.println("Soma");
			return "("+"A"+(x+1)+"A"+y+")";
		}else {
			for (int i = x+1; i < y-1; i++) {
				if(pKey>p[i]) {
					pKey=p[i];
					key=i;
				}
			}
			
			if(p[x]!=p[y]) {
				if(p[x]<pKey) {
					key=x;
				}
			}
			
			if(p[y]<pKey) {
				key=y;
			}
			
			if(key==x) {
				resposta += "(";
				resposta += metodoGuloso(p, x, y-1);
				resposta += metodoGuloso(p, y, y);
				resposta += ")";
			}else if(key==y) {
				resposta += "(";
				resposta += metodoGuloso(p, x, x+1);
				resposta += metodoGuloso(p, x+1, y);
				resposta += ")";
			}else {
				resposta += "(";
				resposta += metodoGuloso(p, x, key);
				resposta += metodoGuloso(p, key, y);
				resposta += ")";
			}
		}
		return resposta;
	}
	

	
}
