package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Crypto {

    private Map<String, String> encryptKey = new HashMap<>();
    private Map<String, String> decryptKey = new HashMap<>();

    public Crypto() {
        encryptKey.put("A", "B");
        encryptKey.put("B", "C");
        // ....

        // build the decrypt lookup key from the encrypt lookup
        for(String key : encryptKey.keySet()) {
            // value becomes the key. key becomes the value
            decryptKey.put(encryptKey.get(key), key);
        }

    }

    public String encrypt(String source) {
        return transform(source, encryptKey);
    }

    public String decrypt(String source) {
        return transform(source, decryptKey);
    }

    private String transform(String source, Map<String, String> lookupKey) {
        if (source == null || source.isEmpty()) {
            return source;
        }

        final StringBuilder result = new StringBuilder();
        for(int i=0; i<source.length();i++) {
            String letter = source.substring(i,i+1);
            if (lookupKey.containsKey(letter)) {
                result.append(lookupKey.get(letter));
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

}
