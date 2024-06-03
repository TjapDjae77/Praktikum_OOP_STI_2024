// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 31/05/2024

public class Ucrypt {

    /**
     * Mengembalikan string yang telah dihash
     * 
     * Hash dilakukan dengan cara:
     * 1. Mengubah kata menjadi bahasa Umandana
     * 2. Menggeser karakter sebanyak huruf vokal pada kata awal
     * 3. Apabila karakter merupakan digit angka maka:
     * 3.1 Digit diubah menjadi huruf kecil sesuai urutan alfabet (a urutan ke-0)
     * 3.2 Karakter kemudian digeser sebanyak huruf vokal pada kata awal
     * Contoh: hash(tes123) = tepreses123 -> ufqsftftcde
     * 
     * @param word kata yang akan dihash
     * @return kata yang telah dihash
     */
    public static StringBuilder hash(String word) {
        // 1. Ubah jadi bahasa Umandana
        String bahasaMuthe = Umandana.toUmandana(word);
        
        // 2. Hitung huruf vokal
        int vowelShift = countVowels(word);

        // 3. Geser karakter yang dipengen sama Ella
        return shiftCharacter(bahasaMuthe, vowelShift);
    }

    private static int countVowels(String word){
        int count = 0;

        for (char c : word.toCharArray()){
            if ("aiueo".indexOf(c) != -1){
                count++;
            }
        }

        return count;
    }

    private static StringBuilder shiftCharacter(String str, int shift){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()){
            if (Character.isDigit(c)){
                char convertedChar = (char) ('a' + (c - '0'));
                char newChar = caesarCipher(convertedChar, shift);

                sb.append(newChar);
            }
            else {
                char newChar = caesarCipher(c, shift);

                sb.append(newChar);
            }
        }
        return sb;
    }

    private static char caesarCipher(char c, int shift) {
        if (Character.isLetter(c)){
            return (char) ((c - 'a' + shift) % 26 + 'a');
        }
        return c;
    }

    /**
     * Mengecek apakah parameter hashed merupakan parameter plain yang telah dihash
     * 
     * @param plain  kata sebelum dihash
     * @param hashed kata setelah dihash
     * @return true apabila hashed merupakan plain yang telah dihash
     */
    public static boolean compare(String plain, String hashed) {
        String sb1 = Ucrypt.hash(plain).toString();
        
        return sb1.equals(hashed);

    }
}
