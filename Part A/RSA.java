import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CR{

    private static final int PRIVATE_KEY = 35;
    private static final int PUBLIC_KEY = 11;
    private static final int N = 221;  // N = p * q, where p =17and q=13 (P-1)*(Q-1)=192 

    public static List<Integer> encrypt(String message) {
        List<Integer> ciphertext = new ArrayList<>();
        for (char c : message.toCharArray()) {
            ciphertext.add(modularExp((int) c, PUBLIC_KEY, N));
        }
        return ciphertext;
    }

    public static String decrypt(List<Integer> ciphertext) {
        List<Integer> decryption = new ArrayList<>();
        for (int c : ciphertext) {
            decryption.add(modularExp(c, PRIVATE_KEY, N));
        }
        System.out.println("Decrypted Ciphertext: " + decryption);

        StringBuilder decryptedText = new StringBuilder();
        for (int value : decryption) {
            decryptedText.append((char) value);
        }
        return decryptedText.toString();
    }

    public static int modularExp(int b, int e, int m) {
        int res = 1;
        while (e > 0) {
            if (e % 2 == 1) {
                res = (res * b) % m;
            }
            e /= 2;
            b = (b * b) % m;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.println("Plaintext: " + plaintext);

        List<Integer> ciphertext = encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}

Enter plaintext: hello
Plaintext: hello
Ciphertext: [195, 186, 192, 192, 15]
Decrypted Ciphertext: [104, 101, 108, 108, 111]
Decrypted Text: hello
