// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 03/06/2024

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        Set<String> list = new TreeSet<String>();
        
        for (int i = 0; i < N; i++) {
            // Masukin kata
            String word = sc.next();
            // Pisah-pisah jadi Array per char
            char ch[] = word.toCharArray();
            // Urutin arraynya
            Arrays.sort(ch);
            // Jadiin kalimat baru yang isinya string per char terurut
            String sorted = new String(ch);
            // Masukin ke list set
            list.add(sorted);
        }

        System.out.println(list.size());
        sc.close();
    }
}