// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 23/03/2024

import java.lang.System;
import java.util.Scanner;

public class SusAmong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskCompleted = 0;
        int playersFrozen = 0;
        int emergencyMeetingCalled = 0;

        int totalPlayers = Integer.parseInt(scanner.nextLine());
        int totalImpostor = Integer.parseInt(scanner.nextLine());
        Player[] pemain = new Player[totalPlayers];
        int i = 0;

        while(i < totalImpostor){
            pemain[i] = new RedAstronaut("Impostor " + String.valueOf(i+1));
            i++;
        }
        while(i < totalPlayers){
            pemain[i] = new BlueAstronaut("Crewmate " + String.valueOf(i+1-totalImpostor));
            i++;
        }

        // Looping Operation
        int operationChoice;
        do {
            operationChoice = Integer.parseInt(scanner.nextLine());
            if(operationChoice == 1){ // Complete Task
                int indexCrew = Integer.parseInt(scanner.nextLine());
                if (pemain[indexCrew] instanceof BlueAstronaut){
                    BlueAstronaut crewTask = (BlueAstronaut)pemain[indexCrew];
                    crewTask.completeTask();
                    taskCompleted++;
                }
            }
            else if(operationChoice == 2){ // Freeze
                int indexImpostor = Integer.parseInt(scanner.nextLine());
                int indexCrew = Integer.parseInt(scanner.nextLine());
                if(pemain[indexImpostor] instanceof RedAstronaut){
                    RedAstronaut impostorFreeze = (RedAstronaut)pemain[indexImpostor];
                    impostorFreeze.freeze(pemain[indexCrew]);
                    playersFrozen++;
                }
            }
            else if(operationChoice == 3){ // Emergency Meeting
                for(Player p : pemain){
                    p.emergencyMeeting();
                }
                emergencyMeetingCalled++;
            }
            if (pemain[0].gameOver()){
                break;
            }
        } while(operationChoice != 4);

        System.out.printf("Task completed: %d\n", taskCompleted);
        System.out.printf("Players frozen: %d\n", playersFrozen);
        System.out.printf("Emergency meetings called: %d\n", emergencyMeetingCalled);
        System.out.println("Game Over. Thanks for playing!");

        scanner.close();
    }
}
