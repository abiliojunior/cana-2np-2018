package algoritmos;

public class Guloso {

	public String resolver(String entrada) {
		
		String [] sDimSplit = entrada.split(" ");
		int[] dim= new int [sDimSplit.length];
		
		for (int i = 0; i < sDimSplit.length; i++) {
			dim[i] = Integer.parseInt(sDimSplit[i]);
		}
		
		metodoGMCM(dim,0,dim.length-1);
		//metodoGuloso(dim,0,dim.length-1);
		
		return "metodo resolver guloso ";
	}

	private int metodoGuloso(int[] p,int i, int j) {
		// TODO Auto-generated method stub
		if (i==j-1) {
			System.out.print("A"+(i+1));
			return 0;
		}else {
			System.out.print("(");
			int q = Integer.MAX_VALUE;
			int ind = i;
			int aux = 0;
			for (int k = i+1; k < j-1; k++) {
				if(p[k-1]*p[k]*p[k+1]<q) {
					q = p[k-1]*p[k]*p[k+1];
					ind = k;
				}
				aux = q + metodoGuloso(p, i, k)+metodoGuloso(p, k+1, j);
				
			}
			System.out.print(")");
			return aux;
			
		}
			
	}
	
	private String metodoGMCM(int[] p, int x, int y) {
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
				System.out.print("(");
				metodoGMCM(p, x, y-1);
				metodoGMCM(p, y, y);
				System.out.print(")");
			}else if(key==y) {
				System.out.print("(");
				metodoGMCM(p, x, x+1);
				metodoGMCM(p, x+1, y);
				System.out.print(")");
			}else {
				System.out.print("(");
				metodoGMCM(p, x, key);
				metodoGMCM(p, key, y);
				System.out.print(")");
			}
		}
		return resposta;
	}

}
