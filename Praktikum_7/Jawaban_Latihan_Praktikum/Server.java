// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 03/06/2024


public class Server {
    // nWorkers menyatakan jumlah maximum threads yang tersedia pada server a.k.a thread pool
    private int workers;

    Server(int workers) {
        // Lengkapi kode berikut
        this.workers = workers;
    }

    public Integer[] process(String[] requests) throws InterruptedException {
        // process akan membuat threads dan memetakan elemen-elemen requests kepada threads tersebut
        // setiap thread kemudian memanggil method count
        // main thread (thread yang invoked method ini) akan menunggu semua thread selesai
        // terakhir main thread akan mengembalikan hasil penghitungan kata untuk setiap elemen requests
        // Lengkapi kode berikut
        Integer[] count = new Integer[requests.length];
        Thread[] threads = new Thread[workers];
        for (int i = 0; i < workers; i++) {
            final int checkIndex = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = checkIndex; j < requests.length; j++) {
                        count[j] = count(requests[j]);
                    }
                } 
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            if (thread != null) {
                thread.join();
            }
        }

        return count;
    }

    protected int count(String request) {
        // Lengkapi kode berikut
        request = request.trim();
        if (request.length() == 0) {
            return 0;
        }
        else {
            int sum = 1;
            for (int i = 1; i < request.length(); i++) {
                if (request.charAt(i) == ' ' && request.charAt(i-1) != ' '){
                    sum++;
                } 
            }
            return sum;
        }
    }
}