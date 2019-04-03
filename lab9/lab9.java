
public class lab9{
    public static void main(String args[]){
        if(args.length != 1 ) {
			System.err.println("Niepoprawna liczba argumentow wejsciowych.");
		}
	    FileProcessing.readFile(args[0]);
    }
}