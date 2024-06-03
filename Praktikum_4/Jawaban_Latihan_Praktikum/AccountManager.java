// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 31/05/2024

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    /**
     * AccountManager constructor
     * 
     * Menginisiasi ArrayList Account
     */
    public AccountManager() {
        accounts = new ArrayList<Account>();
    }

    /**
     * Mengecek apakah format username valid
     * Username dikatakan valid jika:
     * 1. Terdiri minimal dari 5 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     * 
     * @param username username yang akan dicek
     * @return true jika sesuai ketentuan username yang valid
     */
    private static boolean isValidUsername(String username) {
        boolean valid = false;

        if (username.length() >= 5){
            for (char c : username.toCharArray()) {
                if (!Character.isLetterOrDigit(c)){
                    return false;
                }
            }
            valid = true;

        }

        return valid;
    }

    /**
     * Mengecek apakah password merupakan password yang kuat
     * Password dikatakan kuat jika:
     * 1. Terdiri minimal dari 8 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     * 3. Minimal terdiri dari 1 huruf dan 1 angka
     * 
     * @param password password yang akan dicek
     * @return true jika sesuai ketentuan password yang kuat
     */
    private static boolean isStrongPassword(String password) {
        boolean strong = false;

        if (password.length() >= 8){
            boolean hasLetter = false;
            boolean hasDigit = false;
            for (char c : password.toCharArray()) {
                if (!Character.isLetterOrDigit(c)){
                    return false;
                }
                else {
                    if (Character.isLetter(c)) {
                        hasLetter = true;
                    }
                    else if (Character.isDigit(c)) {
                        hasDigit = true;
                    }
                }
            }
            if (hasLetter && hasDigit) {
                return true;
            }
        }


        return strong;
    }

    /**
     * Menambahkan akun baru ke dalam atribut accounts
     * 
     * Akun dapat ditambahkan jika:
     * 1. Username valid, jika tidak valid maka
     * mencetak pesan "Username tidak valid"
     * 2. Username belum terdaftar, jika terdaftar maka
     * mencetak pesan "Username telah digunakan"
     * 3. Password kuat, jika tidak kuat maka
     * mencetak pesan "Password tidak cukup kuat"
     * 
     * Pengecekan dilakukan berurut berdasarkan penjelasan di atas
     * Apabila memenuhi syarat di atas, maka akun ditambahkan
     * dan password disimpan dalam format hash,
     * kemudian mencetak pesan "Akun berhasil didaftarkan"
     * 
     * @param username username dari akun baru
     * @param password password dari akun baru dalam format tidak dihash
     */
    public void addAccount(String username, String password) {
        boolean stop = false;
        if (AccountManager.isValidUsername(username)) {
            for (Account acc : accounts) {
                if (acc.getUsername().equals(username)) {
                    System.out.println("Username telah digunakan");
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                if (AccountManager.isStrongPassword(password)) {
                    String hashedPassword = Ucrypt.hash(password).toString();
                    Account newAccount = new Account(username, hashedPassword);
                    accounts.add(newAccount);
                    System.out.println("Akun berhasil didaftarkan");
                }
                else {
                    System.out.println("Password tidak cukup kuat");
                }
            }
        }
        else {
            System.out.println("Username tidak valid");
        }
    }

    /**
     * Masuk ke akun yang telah didaftarkan
     * 
     * Apabila username akun tidak terdaftar
     * maka akan mencetak pesan "Akun tidak terdaftar"
     * 
     * Apabila password akun salah
     * maka akan mencetak pesan "Password yang dimasukkan salah"
     * 
     * Apabila username dan password sesuai
     * maka akan mencetak pesan "Berhasil masuk"
     * 
     * @param username username dari akun
     * @param password password dari akun dalam format tidak dihash
     */
    public void login(String username, String password) {
        boolean found = false;
        Account thisAccount = null;
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)){
                found = true;
                thisAccount = acc;
                break;
            }
        }
        if (found) {
            if (Ucrypt.compare(password, thisAccount.getPassword())) {
                System.out.println("Berhasil masuk");
            }
            else {
                System.out.println("Password yang dimasukkan salah");
            }
        }
        else {
            System.out.println("Akun tidak terdaftar");
        }
    }
}
