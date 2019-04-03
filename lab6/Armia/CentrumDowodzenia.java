package Armia;

import java.util.ArrayList;
import java.util.List;
import Armia.Rozkaz;
import Armia.Czolg;

public class CentrumDowodzenia{

    private List<Czolg> czolgi;

    public CentrumDowodzenia(){
        czolgi = new ArrayList<Czolg>();
    }

    public void zarejestrujCzolg(Czolg nowy_czolg){
        czolgi.add(nowy_czolg);
    }

    public void wydajRozkaz(String rozkaz, Rozkaz tresc){
        czolgi.get(rozkaz.charAt(0) - 1 - '0').wydajRozkaz(tresc);
    }

    public String toString(){
        String tresc = "Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n";
        for(int i = 0; i < czolgi.size(); ++i){
            tresc += "Czolg nr " + (i + 1) + " otrzymal rozkazy: \n" + czolgi.get(i).drukujRozkazy();
            tresc += "\n";
        }
        return tresc;

    }

}