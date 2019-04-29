package com.javacore.steve.db.misc;


import com.javacore.steve.db.DBApplication;

import java.math.BigInteger;

public class MainDataEncryptor implements DataEncryptor {
    @Override
    public String encrypt(String text) {
        if (DBApplication.DATA_ENCRYPTION_LEVEL.equals("LOW")){
            return encryptLOW(text);
        }
        if (DBApplication.DATA_ENCRYPTION_LEVEL.equals("MED"))
            return encryptMED(text);
        return null;
    }

    private String encryptLOW(String text) {
        return String.format("%x",new BigInteger(1,text.getBytes()));
    }

    private String encryptMED(String text) {
        char[] word = text.toCharArray();
        int k = 5;
        if (k>26) k=k%26;


        for (int i = 0; i < word.length; i++) {
            if ((int)word[i]<=90&& (int)word[i]>=65){
                word[i] = (char) ((int)word[i] +k);
                if ((int)word[i]>90)
                    word[i] = (char) ((int)word[i]-26);
            }

            if ((int)word[i]<=122&& (int)word[i]>=97){
                word[i] = (char) ((int)word[i] +k);
                if ((int)word[i]>122)
                    word[i] = (char) ((int)word[i]-26);
            }
        }

        return String.valueOf(word);
    }

    private String encryptHIGH(String text) {
        return null;
    }

}
