package algoritmos;

public class Dinamico {
	
	int [][]m;
	int [][]s;
	
	public void ordem(int [] dims) {
		
		int n = dims.length-1;
		m = new int[n][n];
        s = new int[n][n];

        for (int L = 1; L < n; L++) {
            for (int i = 0; i < n - L; i++) {
                int j = i + L;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int custo = m[i][k] + m[k+1][j] + dims[i]*dims[k+1]*dims[j+1];
                    if (custo < m[i][j]) {
                        m[i][j] = custo;
                        s[i][j] = k+1;
                    }
                }
            }
        }
    }
	
	
	
	public void parentizar(int[][]s, int i, int j) {
		//String resposta = "";
		if(i==j) {
			System.out.print("A"+j);
		}else {
			System.out.print("(");
			parentizar(s, i, s[i-1][j-1]);
			parentizar(s, s[i-1][j-1]+1,j);
			System.out.print(")");
		}
		
		//return resposta;
	}

	public void resolver(String sDim) {
		String [] sDimSplit = sDim.split(" ");
		int[] dim= new int [sDimSplit.length];
		
		for (int i = 0; i < sDimSplit.length; i++) {
			dim[i] = Integer.parseInt(sDimSplit[i]);
		}
		
		ordem(dim);
		
		parentizar(s,1,dim.length-1);
		
		//TODO cRIAR METODO DE CALCULAR ESCALAR
		System.out.print(" "+456321);
		System.out.println("");
	}
	
	
	public void imprimirMatriz(int n [][]) {
		for (int i=0; i<n.length;i++) {
			for (int j = 0; j < n.length; j++) {
				System.out.print(" "+n[i][j]+" ");
			}
			System.out.println(" ");
		}
	}

	
}
