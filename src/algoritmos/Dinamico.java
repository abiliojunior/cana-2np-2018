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

	public String resolver(String string) {
		int[] dim = {30,35,15,5,10,20,25};
		ordem(dim);
		
//		imprimirMatriz(m);
//		System.out.println("****+*****");
//		imprimirMatriz(s);
		

		parentrizar(s,1,5);
		System.out.println("");
		return "*";
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
