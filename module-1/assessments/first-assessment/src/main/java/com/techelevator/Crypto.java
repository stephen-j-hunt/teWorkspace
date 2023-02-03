package com.techelevator;

/**
 * Crypto encrypts strings using a substitution cypher. In a substitution
 * cypher, every letter is replaced with a different letter.
 *
 * For this exercise, use the following substitution cypher:
 *
 *   Letter -> Encrypts To
 *     A    ->    N
 *     B    ->    J
 *     C    ->    F
 *     D    ->    Q
 *     E    ->    A
 *     F    ->    P
 *     G    ->    S
 *     H    ->    R
 *     I    ->    X
 *     J    ->    G
 *     K    ->    D
 *     L    ->    O
 *     M    ->    T
 *     N    ->    E
 *     O    ->    U
 *     P    ->    H
 *     Q    ->    M
 *     R    ->    V
 *     S    ->    B
 *     T    ->    C
 *     U    ->    W
 *     V    ->    K
 *     W    ->    Z
 *     X    ->    I
 *     Y    ->    L
 *     Z    ->    Y
 */
public class Crypto {


    /**
     * Encrypts and returns "strToEncrypt" using the substitution cypher above
     *
     * @param strToEncrypt The String to encrypt
     * @return The encrypted String
     */
    public String encrypt(String strToEncrypt) {
        String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] newLetters = new String[]{"N", "J", "F", "Q", "A", "P", "S", "R", "X", "G", "D", "O", "T", "E", "U", "H", "M", "V", "B", "C", "W", "K", "Z", "I", "L", "Y"};
        for (int i = 0; i < letters.length; i++) {
            newLetters[i]=strToEncrypt;
        }
       return strToEncrypt;
    }

    /**
     * Decrypts and returns "strToDecrypt" using the cypher above
     *
     * @param strToDecrypt The String to decrypt
     * @return The decrypted String
     */
    public String decrypt(String strToDecrypt) {




        return null;
    }
}
