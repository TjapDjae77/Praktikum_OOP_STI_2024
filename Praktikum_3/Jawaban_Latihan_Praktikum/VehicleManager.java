// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 23/03/2024

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> list = new ArrayList<Vehicle>();

    /**
     * Menambahkan kendaraan ke array
     * 
     * @param vehicle objek Vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        // Tambahkan kendaraan ke list
        list.add(vehicle);
    }

    /**
     * Memarkirkan semua kendaraan pada list menggunakan method park pada Vehicle
     */
    public void parkAllVehicles() {
        for (Vehicle vehicle : this.list){
            vehicle.park();
        }
    }

    /**
     * Membuka semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * openDoor pada Door
     */
    public void openAllDoors() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car mobil = (Car)vehicle;
                mobil.openDoor();
            }
            else if (vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter)vehicle;
                heli.openDoor();
            }
        }
    }

    /**
     * Menutup semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * closeDoor pada Door
     */
    public void closeAllDoors() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car mobil = (Car)vehicle;
                mobil.closeDoor();
            }
            else if(vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter)vehicle;
                heli.closeDoor();
            }
        }
    }

    /**
     * Menyalakan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * startEngine pada Engine
     */
    public void startAllEngines() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car mobil = (Car)vehicle;
                mobil.startEngine();
            }
            else if (vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter)vehicle;
                heli.startEngine();
            }
            else if (vehicle instanceof Motorcycle){
                Motorcycle motor = (Motorcycle)vehicle;
                motor.startEngine();
            }
        }
    }

    /**
     * Mematikan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * stopEngine pada Engine
     */
    public void stopAllEngines() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car mobil = (Car)vehicle;
                mobil.stopEngine();
            }
            else if (vehicle instanceof Helicopter){
                Helicopter heli = (Helicopter)vehicle;
                heli.stopEngine();
            }
            else if (vehicle instanceof Motorcycle){
                Motorcycle motor = (Motorcycle)vehicle;
                motor.stopEngine();
            }
        }
    }

    /**
     * Mengganti semua ban pada kendaraan yang memiliki ban menggunakan method
     * changeTyre pada Tyre
     */
    public void changeAllTyres() {
        for (Vehicle vehicle : this.list){
            if(vehicle instanceof Car){
                Car mobil = (Car)vehicle;
                mobil.changeTyre();
            }
            else if(vehicle instanceof Bicycle){
                Bicycle sepeda = (Bicycle)vehicle;
                sepeda.changeTyre();
            }
            else if (vehicle instanceof Motorcycle){
                Motorcycle motor = (Motorcycle)vehicle;
                motor.changeTyre();
            }
        }
    }
}
