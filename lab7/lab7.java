import java.util.Scanner;

public class lab7{
    public static void main(String[] args){
        Scanner odczyt = new Scanner(System.in);
        int n, m;
        int[][] dane;
        n = odczyt.nextInt();
        m = odczyt.nextInt();
        dane = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j <  n; j++){
                dane[i][j] = odczyt.nextInt();
            }
        }

        System.out.println("\n------- Wprowadzone dane -------\n");    
		Test wykonaj = new Test(n, m, dane);
        wykonaj.wypisz();
        wykonaj.czyOk();
        wykonaj.alert();
  }
}
