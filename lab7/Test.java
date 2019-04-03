import java.util.LinkedList;

public class Test{
    public int m_n, m_m;
    public int[][] m_dane;

   public Test(int n, int m, int[][] dane){
		m_n = n;
		m_m = m;
		m_dane = new int[m_m][m_n];

		for(int i = 0; i < m_m; i++){
			for(int j = 0; j < m_n; j++){
				m_dane[i][j] = dane[i][j];
			}
		}
	}

    public void wypisz(){
        for(int i = 0; i < m_m; i++){
            for(int j = 0; j < m_n; j++){
                System.out.print(m_dane[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int czyOk(){
        for(int i = 1; i < m_n + 1; i++){
            LinkedList<Integer> liczby = new LinkedList<Integer>();
			liczby.add(i);
            for(int j = 0; j < m_m; j++){
                int k = 0;
                int value = -1;
            while(value < 0){
                	if(m_dane[j][k] == i) value = k;
						k++;
            }

            if(value > (m_n/2)){
                for(int p = 0; p < (m_n/2); p++){
                    if(!liczby.contains(m_dane[j][p])) liczby.add(m_dane[j][p]);
                }
            }

            else{
                for(int p = (m_n/2); p < m_n; p++){
                    if(!liczby.contains(m_dane[j][p])) liczby.add(m_dane[j][p]);
                }
            }
        }

            int rozmiar = liczby.size();
            if(rozmiar == m_n) return 1;
            else return 2;
    	}


		return 0;
}

   public void alert(){
     	if(czyOk() == 1)
			System.out.println("-> TAK");
		else if(czyOk() == 2)
			System.out.println("-> NIE");
	}

}