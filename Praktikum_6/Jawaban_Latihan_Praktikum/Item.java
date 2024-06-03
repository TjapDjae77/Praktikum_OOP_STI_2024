// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 02/06/2024

public class Item extends Exception{
    /**
     * Tambahkan atribut kelas disini
     */ 
    private String name;
    private int price;
    private int discount;
    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     * Atribut nama harus memiliki panjang karakter antara 3-20 karakter (inklusif)
     * Apabila nama tidak memenuhi ketentuan tersebut, akan dilempar exception "Nama barang harus terdiri dari 3-20 karakter"
     * Atribut harga barang tidak boleh bernilai negatif
     * Apabila tidak memenuhi ketentuan tersebut, akan dilempar exception "Harga barang tidak boleh bernilai negatif"
     * Atribut diskon tidak boleh bernilai negatif dan tidak boleh melebihi harga barang
     * Apabila tidak memenuhi ketentuan tersebut, akan dilempar exception "Diskon tidak boleh bernilai negatif atau melebihi harga barang"
     */
    public Item(String name, int price, int discount) throws Exception {
        if(name.length() < 3 || name.length() > 20){
            throw new Exception("Nama barang harus terdiri dari 3-20 karakter");
        }
        else{
            if (price < 0) {
                throw new Exception("Harga barang tidak boleh bernilai negatif");
            }
            else {
                if (discount < 0 || discount > price){
                    throw new Exception("Diskon tidak boleh bernilai negatif atau melebihi harga barang");
                }
                else {
                    this.name = name;
                    this.price = price;
                    this.discount = discount;
                }
            }
        }
    }

    /**
     * Implementasi
     * return nama
     */
    public String getName() {
        return name;
    }

    /**
     * Implementasi
     * return harga barang
     */
    public int getPrice() {
        return price;
    }

    /**
     * Implementasi
     * return diskon
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Implementasi
     * return total harga setelah dikurangi diskon
     */
    public int getTotalPrice() {
        return price-discount;
    }   
}