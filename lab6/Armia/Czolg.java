package Armia;

import java.util.ArrayList;
import java.util.List;
import Armia.Rozkaz;

public class Czolg{

    private List<Rozkaz> rozkazy;

    public Czolg(){
        rozkazy = new ArrayList<Rozkaz>();
    }

    public void wydajRozkaz(Rozkaz tresc){
        rozkazy.add(tresc);
    }

    public String ostatniRozkaz(){
        int value = rozkazy.size();
        if(value > 0)
            return "Ostatni rozkaz do mnie: " + rozkazy.get(rozkazy.size()-1).getRozkaz();
        else
            return "";
    }

    public String drukujRozkazy(){
        String tresc = "";
        for(int i = 0; i < rozkazy.size(); ++i)
            tresc += rozkazy.get(i).getRozkaz() + "\n";
        return tresc;
    }
}