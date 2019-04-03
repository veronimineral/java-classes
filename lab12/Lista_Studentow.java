import java.util.*;

public class Lista_Studentow{
    private List<Student> studentList;
    
    public Lista_Studentow(){
        studentList = new ArrayList<Student>();
    }

    public void add(Student newStudent){
        studentList.add(newStudent);
    }

    public void add(String imie, String nazwisko, int wiek){
        studentList.add(new Student(imie, nazwisko, wiek));
    }

    public void wypisz_wszystkich(){
        for(Student student : studentList){
            System.out.println(student.getImie() + " " + student.getNazwisko() + " " + student.getWiek()); 
        }
    }

    public void sort_imie_rosnaca(){
        Collections.sort(studentList, new sortImieRosnaco());
    }

    public void sort_imie_malejaca(){
        Collections.sort(studentList, new sortImieMalejaco());
    }

    public void sort_nazwisko_rosnaca(){
        Collections.sort(studentList, new sortNazwiskoRosnaco());
    }

    public void sort_nazwisko_malejaca(){
        Collections.sort(studentList, new sortNazwiskoMalejaco());
    }

    public void sort_wiek_rosnaca(){
        Collections.sort(studentList, new sortWiekRosnaco());
    }

    public void sort_wiek_malejaca(){
        Collections.sort(studentList, new sortWiekMalejaco());
    }
}

class sortImieRosnaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        return stud1.getImie().compareTo(stud2.getImie());
    }
}

class sortImieMalejaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        return -stud1.getImie().compareTo(stud2.getImie());
    }
}

class sortNazwiskoRosnaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        return stud1.getNazwisko().compareTo(stud2.getNazwisko());
    }
}

class sortNazwiskoMalejaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        return -stud1.getNazwisko().compareTo(stud2.getNazwisko());
    }
}

class sortWiekRosnaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        if(stud1.getWiek() > stud2.getWiek()) return 1;
        else if(stud1.getWiek() < stud2.getWiek()) return -1;
        else return 0;
    }
}

class sortWiekMalejaco implements Comparator<Student>{
    public int compare(Student stud1, Student stud2){
        if(stud1.getWiek() > stud2.getWiek()) return -1;
        else if(stud1.getWiek() < stud2.getWiek()) return 1;
        else return 0;
    }
}

