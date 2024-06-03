/**
* ArraySum.java 
* @author 18222105 Rajendra Farras Rayhan
*/

/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

 public class ArraySum extends Thread{
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 
    

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        int length = arr.length;
        int load = (int) Math.floor((double) length / nWorkers);
        int[] total = new int[length];
        Thread[] threads = new Thread[nWorkers];

        for (int i = 0; i < nWorkers; i++) {
            int start, end;
            start = i*load;
            if (i < nWorkers-1) {
                end = Math.min(start+load, length);
            }
            else {
                end = length;
            }

            final int threadindex = i;
            threads[i] = new Thread(new Runnable() {
               public void run() {
                    synchronized (this) {
                        total[threadindex] += partialSum(start, end);
                    }
               } 
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int sum = 0;
        for (int index : total) {
            sum += index;
        }

        return sum;
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}