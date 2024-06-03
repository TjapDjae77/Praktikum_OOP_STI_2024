import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Atribut jumlah task yang harus diselesaikan (integer)
    private int numTasks;

    // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
    private int taskSpeed;

    // Atribut untuk mengecek apakah task sudah selesai pertama kali
    private boolean completedTask;

    // Atribut DEFAULT_NUM_TASKS bertipe data int dengan nilai 6
    private static final int DEFAULT_NUM_TASKS = 6;

    // Atribut DEFAULT_TASK_SPEED bertipe data int dengan nilai 10
    private static final int DEFAULT_TASK_SPEED = 10;

    public BlueAstronaut(String name) {
        super(name, Player.DEFAULT_SUS_LEVEL);
        this.numTasks = DEFAULT_NUM_TASKS;
        this.taskSpeed = DEFAULT_TASK_SPEED;
        this.completedTask = false;
        // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, dan DEFAULT_TASK_SPEED
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        // Panggil constructor dari superclass dengan parameter name dan susLevel
        super(name, susLevel);
        // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
        this.completedTask = false;
    }

    /*

    */
    public void emergencyMeeting() {
        if(!this.isFrozen()){
            Player[] players = getPlayers();
            Player pemainTerSus = null;
            int maxSusLevel = Integer.MIN_VALUE;
            Player[] listPlayerTerSus = new Player[players.length];
            int count = 0;
            
            for (Player p : players){
                if((!p.isFrozen()) && (p.getSusLevel() >= maxSusLevel)){
                    if (p.getSusLevel() == maxSusLevel) {
                        listPlayerTerSus[count++] = p;
                    }
                    else {
                        Arrays.fill(listPlayerTerSus, null);
                        listPlayerTerSus[0] = p;
                        count = 1;
                        maxSusLevel = p.getSusLevel();
                        pemainTerSus = p;
                    }
                }
            }
            if (count == 1) {
                pemainTerSus.setFrozen(true);
                gameOver();
            }
        }
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
        if(!this.isFrozen()){
            if(this.taskSpeed > 20){
                this.numTasks -= 2;
            }
            else{
                this.numTasks--;
            }
            if(this.numTasks < 0){
                this.numTasks = 0;
            }
            if((!this.completedTask) && (this.numTasks == 0)){
                this.completedTask = true;
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int) Math.floor(this.getSusLevel() / 2.0));
            }
        }
    }

    /*
        * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen, susLevel, numTasks, dan taskSpeed
        * Mengembalikan sebuah boolean.
    */
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueplayer = (BlueAstronaut)o;
            return this.getName().equals(blueplayer.getName()) && this.isFrozen() == blueplayer.isFrozen()
                    && this.getSusLevel() == blueplayer.getSusLevel() && this.numTasks == blueplayer.numTasks
                    && this.taskSpeed == blueplayer.taskSpeed;
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
        if(this.getSusLevel() > 15){
            blueString.toUpperCase();
        }
        return blueString;
    }
}
