public class lab4{
    public static void main(String[] args){
          int size_x = new Integer(args[0]).intValue();
          int size_y = new Integer(args[1]).intValue();
          int steps = new Integer(args[2]).intValue();
          int preset = new Integer(args[3]).intValue();

        if(args.length != 4){
            System.out.print("Niepoprawna liczba argumentow (!=4).");
            System.exit(1);
        }
        Game start = new Game(size_x, size_y, steps, preset);

        for(int i = 0; i < steps; i++){
            Game.printBoard();
        }

        
    }

    
}