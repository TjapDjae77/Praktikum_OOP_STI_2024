// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 31/05/2024



public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
    public static String toUmandana(String words) {
        StringBuilder sb1 = new StringBuilder(words);
        StringBuilder sb2 = new StringBuilder();

        int len = words.length();
        int i = 0;

        while (i < len){
            if (Character.isLetter(sb1.charAt(i))){
                if (sb1.charAt(i) == 'a') {
                    sb2.append("aiden");
                }
                else if (sb1.charAt(i) == 'i') {
                    sb2.append("ipri");
                }
                else if (sb1.charAt(i) == 'u') {
                    sb2.append("upru");
                }
                else if (sb1.charAt(i) == 'e') {
                    sb2.append("epre");
                }
                else if (sb1.charAt(i) == 'o') {
                    sb2.append("opro");
                }
                else if ((i + 2) < len) {
                    if (sb1.charAt(i) == 'n' && sb1.charAt(i+1) == 'g' && "aiueo".indexOf(sb1.charAt(i+2)) == -1) {
                        sb2.append("strengen");
                        i++;
                    }
                    else {
                        if ("aiueo".indexOf(sb1.charAt(i+1)) == -1) {
                            if (sb1.charAt(i) == 'n' && sb1.charAt(i+1) == 'g'){
                                sb2.append("ng");
                                i++;
                            }
                            else if (sb1.charAt(i) == 'n' && sb1.charAt(i+1) == 'y'){
                                sb2.append("ny");
                                i++;
                            }
                            else {
                                sb2.append(sb1.charAt(i) + "es");
                            }
                        }
                        else {
                            sb2.append(sb1.charAt(i));
                        }
                    }
                }
                else if ((i+1) < len) {
                    if (sb1.charAt(i) == 'n' && sb1.charAt(i+1) == 'g'){
                        sb2.append("strengen");
                        i++;
                    }
                    else {
                        if ("aiueo".indexOf(sb1.charAt(i+1)) == -1) {
                            sb2.append(sb1.charAt(i) + "es");
                        }
                        else {
                            sb2.append(sb1.charAt(i));
                        }
                    }
                }
                else {
                    sb2.append(sb1.charAt(i) + "es");
                }
            }
            else {
                sb2.append(sb1.charAt(i));
            }
            i++;
        }
        return sb2.toString();
    }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        StringBuilder sb1 = new StringBuilder(words);
        StringBuilder sb2 = new StringBuilder();

        int len = words.length();
        int i = 0;

        while (i < len) {
            int indexForward = partitionDeUmandana(sb1, sb2, i, len);
            i += indexForward;
        }

        return sb2.toString();
    }

    public static int partitionDeUmandana (StringBuilder sb1, StringBuilder sb2, int i, int len) {
        if ((i + 7) < len && sb1.substring(i, i+8).equals("strengen")) {
            sb2.append("ng");
            return 8;
        }
        else if ((i + 4) < len && sb1.substring(i, i+5).equals("aiden")){
            sb2.append("a");
            return 5;
        }
        else if ((i+3) < len && sb1.substring(i, i+4).equals("ipri")){
            sb2.append("i");
            return 4;
        }
        else if ((i+3) < len && sb1.substring(i, i+4).equals("upru")){
            sb2.append("u");
            return 4;
        }
        else if ((i+3) < len && sb1.substring(i, i+4).equals("epre")){
            sb2.append("e");
            return 4;
        }
        else if ((i+3) < len && sb1.substring(i, i+4).equals("opro")){
            sb2.append("o");
            return 4;
        }
        else if ((i+2) < len && sb1.substring(i+1, i+3).equals("es") && "aiueo".indexOf(sb1.charAt(i)) == -1){
            sb2.append(sb1.charAt(i));
            return 3;
        }
        else {
            sb2.append(sb1.charAt(i));
            return 1;
        }
    }

}