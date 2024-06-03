public class Server {
    // nWorkers menyatakan jumlah maximum threads yang tersedia pada server a.k.a thread pool
    private int workers;

    Server(int workers) {
        // Lengkapi kode berikut
    }

    public Integer[] process(String[] requests) throws InterruptedException {
        // process akan membuat threads dan memetakan elemen-elemen requests kepada threads tersebut
        // setiap thread kemudian memanggil method count
        // main thread (thread yang invoked method ini) akan menunggu semua thread selesai
        // terakhir main thread akan mengembalikan hasil penghitungan kata untuk setiap elemen requests
        // Lengkapi kode berikut

    }

    protected int count(String request) {
        // Lengkapi kode berikut
    }
}