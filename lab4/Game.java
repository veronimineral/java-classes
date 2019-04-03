public class Game{

     static char[][] new_board;
     int Size_X;
     int Size_Y;
     int Steps;
     int Preset;


    public Game(int size_x, int size_y, int steps, int preset){
        Size_X = size_x;
        Size_Y = size_y;
        Steps = steps;
        Preset = preset;
        new_board = new char[size_x][size_y];
        //tworzenie plansz dla wartosci presetu 0
        if(preset == 0){
            for(int i = 0; i < new_board.length; i++){
                for(int j = 0; j < new_board[i].length; j++){
                    double los = Math.random();
                    if(los > 0.5) new_board[i][j] = 'X';
                    else new_board[i][j] = '.';
                }
            }
        }

        //tworzenie plansz dla wartosci presetu 1-3
        
        char[][] board_1 = {{'.','.','.','.','.'},{'.','X','X','.','.'},
        {'.','X','.','X','.'},{'.','.','X','.','.'},{'.','.','.','.','.'}};
        char[][] board_2 = {{'.','.','.','.','.'},{'.','.','X','.','.'},
        {'.','.','X','.','.'},{'.','.','X','.','.'},{'.','.','.','.','.'}};
        char[][] board_3 = {{'.','.','.','.','.'},{'.','X','X','X','.'},
        {'.','X','.','.','.'},{'.','.','X','.','.'},{'.','.','.','.','.'}};

        switch (preset) {
            case 1:  preset = 1;
                for(int i = 0; i < new_board.length; i++){
                    for(int j = 0; j < new_board[i].length; j++){
                        new_board[i][j] = board_1[i][j];
                    }
                }
                break;
                    
            case 2:  preset = 2;
                for(int i = 0; i < new_board.length; i++){
                    for(int j = 0; j < new_board[i].length; j++){
                        new_board[i][j] = board_2[i][j];
                    }
                }
                break;
                     
            case 3:  preset = 3;
                for(int i = 0; i < new_board.length; i++){
                    for(int j = 0; j < new_board[i].length; j++){
                        new_board[i][j] = board_3[i][j];
                    }
                }
                break;

            default: break;         
        }
    }

    void Next(){
        //tworzę nową planszę dla kolejnego ruchu
        char[][] next_board = new char[Size_X][Size_Y];
        //kopiowanie zawartosci poprzedniej planszy do nowej
        for (int i = 0; i < new_board.length; i++) {
			for(int j = 0; j < new_board[i].length; j++){
	            next_board[i][j] = new_board[i][j];
            }
		}

        int alive = 0, dead = 0;

        for (int i = 0; i < new_board.length; i++){
            alive = 0; dead = 0;
            for(int j = 0; j < new_board.length; j++){            
            switch (new_board[i][j]) {
            case 1:  new_board[i][j] = 'X';
                
                break;
                    
            case 2:  new_board[i][j] = '.';
               
                break;

            default: break;         
        }
        }
        }
        


    }

    static void printBoard(){
        int step_nr = 1;
        System.out.println("----------" + step_nr + "----------");
        step_nr++;
       for (int i = 0; i < new_board.length; i++) {
			String s = new String();
            s = "";
			for (int j = 0; j < new_board[i].length; j++) {
                s += new_board[i][j];
			}
			System.out.println(s);
		}
        System.out.println("----------" + step_nr + "----------");
        step_nr++;
    }

    public int getSize_X() {
		return Size_X;
	}

	public int getSize_Y() {
		return Size_Y;
	}

    



    

}

