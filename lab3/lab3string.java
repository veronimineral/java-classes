public class lab3string {

    static int dlugosc(String s){
        return s.length();
    }

    static int ile_razy_literka_wystepuje(String s, char znak){
        int licz = 0;
        for(int i = 0; i < s.length() -1; i++){
            if(znak == s.charAt(i)) licz++;
        }
        return licz;
    }

    static boolean czy_takie_same(String s1, String s2){
        return s1.equals(s2);
    }
    
    static String wspak(String s){
        String gnirts = "";
        for(int i = s.length() - 1; i >=0; i--){
            gnirts += s.charAt(i);
        }
        return gnirts;
    }

    static boolean czy_plaindrom(String s){
		String s1 = new String();
		String s2 = new String();

        if(s.length() % 2 == 0){
            for(int i = 0; i < s.length()/2; i++){ s1 += s.charAt(i); }}
        else 
            for(int i = 0; i <= s.length()/2; i++){ s1 += s.charAt(i); }

		for(int i = s.length()-1; i >= (s.length()/2); i--)	{
			s2 += s.charAt(i);}
        return s1.equals(s2);
	}
 

    static boolean czy_abecadlowe(String s){
        char znak;
        for(int i = 1; i < s.length(); i++){
            znak = s.charAt(i);
            if(znak < s.charAt(i-1)) return false;
        }
        return true;
    }

    static String rot13(String s){
        String kod = "";
        char znak;
        for(int i = 0; i < s.length(); i++){
            znak = s.charAt(i);
            if(znak >= 'a' && znak <= 'z'){
                znak = (char)('a' + (znak - 'a' + 13) % 26);
            }
            else if(znak >= 'A' && znak <= 'Z'){
                znak = (char)('A' + (znak - 'A' + 13) % 26);
            }
            kod += znak;
        }
        return kod;
    }

}




