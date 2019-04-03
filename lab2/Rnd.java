public class Rnd{
    double arr[];
    int m_size, m_elements;
    public Rnd(int size, int elements){
        m_size = size;
        m_elements = elements;
        arr = new double[m_size];
        for(int i = 0; i < m_size; i++){
            arr[i] = 0.0;
            for(int j = 0; j < m_elements; j++){
                arr[i] += Math.random();
            }
        }
    }

    void Print(){
        for(int i = 0; i < m_size; i++){
            System.out.println("[" + i + "] = " + arr[i]);
        }
    }

   double Min(){
       double min_value = arr[0];
       for(int i = 0; i < m_size; i++){
           if(min_value > arr[i]) min_value = arr[i];
       }
       return min_value;
    }

    double Max(){
        double max_value = arr[0];
        for(int i = 0; i < m_size; i++){
            if(max_value < arr[i]) max_value = arr[i];
        }
        return max_value;
    }

    double Average(){
        double average = 0.0;
        double sum = 0.0;
        for(int i = 0; i < m_size; i++){
            sum += arr[i];
        }
        average = sum/m_size;
        return average;
    }

    void Draw(){
        double count_stars;
        double diff1 = Max() - Min();    
        double diff2;
        String str;
        for(int i = 0; i < m_size; i++){
            str = "";
            diff2 = arr[i] - Min();
            count_stars = Math.round(diff2/(diff1 / 50.0));
            for(int j = 0; j < count_stars; j++){
                str += '*';
            }
           System.out.println("[" + i + "]: " + str + "(" + count_stars + ")" ); 
        }
        
    }

  

}