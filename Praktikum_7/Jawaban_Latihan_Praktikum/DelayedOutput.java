/**
 * DelayedOutput.java 
 * Class ini berguna untuk melakukan print berdasarkan delay yang ditentukan
 * @author 18222105 Rajendra Farras Rayhan
 */
public class DelayedOutput extends Thread {
    private int delayMillisec;
    private String output;

    public DelayedOutput(int delayMillisec, String output){
        this.delayMillisec = delayMillisec;
        this.output = output;
    }

    public void run(){
        try{
            Thread.sleep(delayMillisec);
            System.out.println(output);
        }
        catch (Exception e){

        }
    }

    public static void printDelayed(int delayMillisec, String output) {
        
      // TODO print output setelah di delay selama delayMillisec
      // PENTING: gunakan threading agar tidak blocking
      (new Thread(new DelayedOutput(delayMillisec, output))).start();
    }
    
}
