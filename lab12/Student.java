public class Student{
    public Student(){}
    public Student(String imie, String nazwisko, int wiek){
        this.m_imie = imie;
        this.m_nazwisko = nazwisko;
        this.m_wiek = wiek;
    }

    public void setImie(String imie){
        this.m_imie =  imie;
    }

    public void setNazwisko(String nazwisko){
        this.m_nazwisko = nazwisko;
    }

    public void setWiek(int wiek){ 
        this.m_wiek = wiek;
    } 

    public String getImie(){
        return this.m_imie;
    }

    public String getNazwisko(){
        return this.m_nazwisko;
    }

    public int getWiek(){
        return this.m_wiek;
    }

    private String m_imie;
    private String m_nazwisko;
    private int m_wiek;

}