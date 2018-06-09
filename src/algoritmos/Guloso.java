package algoritmos;

public class Guloso {

	public String resolver(String entrada) {
		
		String [] sDimSplit = entrada.split(" ");
		int[] dim= new int [sDimSplit.length];
		
		for (int i = 0; i < sDimSplit.length; i++) {
			dim[i] = Integer.parseInt(sDimSplit[i]);
		}
		
		return metodoGuloso(dim,0,dim.length-1);
	}

		
	private String metodoGuloso(int[] p, int x, int y) {
		// TODO Auto-generated method stub`
		String resposta = "";
		int pKey = Integer.MAX_VALUE;
		int key = 0;
		if(x==y-1) {
			//System.out.print("A"+y);
			return "A"+y;
		}else if (x==(y-2)){
			//System.out.print("("+"A"+(x+1)+"A"+y+")");
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
