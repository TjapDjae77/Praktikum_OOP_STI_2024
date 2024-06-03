// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 02/06/2024

import java.util.ArrayList;
import java.util.List;

public class Cart extends Exception{
    /**
     * Tambahkan atribut kelas disini
     */ 
    private List<Item> items;
    private Account account;

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    public Cart(Account account) {
        this.account = account;
        items = new ArrayList<>();
    }
    
    /**
     * Implementasi
     * return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Implementasi
     * return list item
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Implementasi
     * menambahkan item ke dalam list item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Implementasi
     * menghapus semua item yang memiliki nama sesuai dengan parameter name
     * 
     * Apabila keranjang kosong, lempar exception "Tidak ada barang di dalam keranjang"
     * Apabila barang tidak ditemukan, lempar exception "Barang tidak ditemukan di dalam keranjang"
     */
    public void removeItem(String name) throws Exception {
        if(items.isEmpty()){
            throw new Exception("Tidak ada barang di dalam keranjang");
        }
        else{
            boolean found = false;
            List<Item> itemsWillBeRemoved = new ArrayList<>();
            for(Item listitem : items){
                if(listitem.getName().equals(name)){
                    itemsWillBeRemoved.add(listitem);
                    found = true;
                }
            }
            if (!found) {
                throw new Exception("Barang tidak ditemukan di dalam keranjang");
            }
            else {
                items.removeAll(itemsWillBeRemoved);
            }
        }
    }

    /**
     * Implementasi
     * mengembalikan total harga semua barang di dalam keranjang
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for(Item listitem : items){
            totalPrice += listitem.getTotalPrice();
        }
        return totalPrice;
    }

    /**
     * Implementasi
     * mengurangi saldo sejumlah total harga semua barang
     * mengosongkan keranjang
     * 
     * Apabila keranjang kosong, lempar exception "Keranjang kosong"
     * Apabila saldo tidak mencukupi, lempar exception "Saldo tidak mencukupi untuk melakukan pembayaran"
     */
    public void checkout() throws Exception {
        if(items.isEmpty()){
            throw new Exception("Keranjang kosong");
        }
        else if(account.getSaldo() < getTotalPrice()){
            throw new Exception("Saldo tidak mencukupi untuk melakukan pembayaran");
        }
        else{
            account.reduceSaldo(getTotalPrice());
            items.clear();
        }
    }
}