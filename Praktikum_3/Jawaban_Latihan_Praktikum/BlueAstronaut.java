// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 04/06/2024
import java.util.Arrays;


public class BlueAstronaut extends Player implements Crewmate {
    // Atribut jumlah task yang harus diselesaikan (integer)
    private int numTasks;

    // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
    private int taskSpeed;

    // Atribut untuk mengecek apakah task sudah selesai pertama kali
    private boolean firstCompletedTask = false;

    // Atribut DEFAULT_NUM_TASKS bertipe data int dengan nilai 6
    private static final int DEFAULT_NUM_TASKS = 6;

    // Atribut DEFAULT_TASK_SPEED bertipe data int dengan nilai 10
    private static final int DEFAULT_TASK_SPEED = 10;

    public BlueAstronaut(String name) {
        // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, dan DEFAULT_TASK_SPEED
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        // Panggil constructor dari superclass dengan parameter name dan susLevel
        super(name, susLevel);
        // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    /*

    */
    public void emergencyMeeting() {
        if (isFrozen()){
            return; // Tidak melakukan apapun kalau frozen
        }

        Player[] players = Player.getPlayers();
        int indexPemainTerSus = -1;
        int maxSusLevel = 0;
        boolean seri = false;

        for (int i = 0; i < players.length; i++){
            Player currentPlayer = players[i];
            // Cek currentPlayer gak frozen, bukan yang manggil, dan level sus nya paling tinggi.
            if (!currentPlayer.isFrozen() && currentPlayer != this && currentPlayer.getSusLevel() > maxSusLevel) {
                maxSusLevel = currentPlayer.getSusLevel();
                indexPemainTerSus = i;
                seri = false; // Reset variabel seri karena ada yang paling tinggi.
            }
            else if (currentPlayer.getSusLevel() == maxSusLevel && currentPlayer != this) {
                seri = true; // Ketemu level sus tertinggi lebih dari satu.
                break; // Keluar dari loop soalnya kalo seri, gak ada aksi yang dilakuin.
            }
        }

        // Freeze player ter-Sus kalo engga seri.
        if (!seri && indexPemainTerSus != -1) {
            players[indexPemainTerSus].setFrozen(true);
        }
    
        gameOver(); // Cek kalo emergency meeting kali ini bakal selesaiin permainan.
    }

    /*
        * BlueAstronaut yang frozen tidak dapat menyelesaikan tugas.
        * Jika taskSpeed lebih besar dari 20, kurangi numTasks sebanyak 2. Jika tidak, kurangi 1 dari numTasks.
            * Jika numTasks turun di bawah 0, tetapkan menjadi 0
        * Setelah BlueAstronaut selesai dengan tugas mereka, yang berarti numTasks sama dengan 0 (hanya untuk pertama kali),
            * Cetak `"I have completed all my tasks"`
            * Kemudian kurangi susLevel BlueAstronaut sebesar 50% (dibulatkan ke bawah)
        * Tidak mengembalikan apapun.
    */
    public void completeTask() {
        if (this.isFrozen()) {
            return; // Tidak melakukan apapun kalau frozen
        }
        
        if(this.taskSpeed > 20){
            this.numTasks -= 2;
        }
        else{
            this.numTasks--;
        }
        this.numTasks = Math.max(0, this.numTasks);

        if((!this.firstCompletedTask) && (this.numTasks == 0)){
            this.firstCompletedTask = true;
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int) (getSusLevel()*0.5));
        }
        
    }

    /*
        * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen, susLevel, numTasks, dan taskSpeed
        * Mengembalikan sebuah boolean.
    */
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueplayer = (BlueAstronaut)o;
            return super.equals(blueplayer) && (this.numTasks == blueplayer.numTasks) && (this.taskSpeed == blueplayer.taskSpeed);
        }
        return false;
    }

    /*
        Mengembalikan String yang menggambarkan BlueAstronaut sebagai berikut:
        * `"My name is [name], and I have a `susLevel` of [susLevel]. I am currently (frozen / not frozen). I have [numTasks] left over."`
            * Jika susLevel lebih besar dari 15, kembalikan keluaran dalam huruf kapital semua. (Hint: toUppercase)
            * (Note: gantikan nilai dalam tanda kurung [] dengan nilai sebenarnya)
        * Anda harus menggunakan metode toString() dari kelas Player.
    */
    public String toString() {
        String blueString = super.toString() + " I have " + this.numTasks + " left over.";
        return this.getSusLevel() > 15 ? blueString.toUpperCase() : blueString;
    }
}
