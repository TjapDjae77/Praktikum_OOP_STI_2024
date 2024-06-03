/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac ArraySum.java ArraySumDriver.java
   $ java -ea ArraySumDriver
 */
public class ArraySumDriver {
    public static void main(String[] args) throws InterruptedException {
       int nWorkers = 2;
       Integer[] arr = {1, 2, 3, 4, 5};

       ArraySum arraySum = new ArraySum(nWorkers, arr);

       Integer expectedArraySum = 15;
       Integer actualArraySum = arraySum.sum();
       System.out.println(expectedArraySum);
       System.out.println(actualArraySum);

       assert expectedArraySum == actualArraySum;

       System.out.println("Yeay! Program berhasil :D");
    }
}
