package com.shopping.daliyShop.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512 {
    public static String encrypt(String password) {
        String salt = "DaliyShop"+password;
        String hex = null;

        try {

            MessageDigest msg = MessageDigest.getInstance("SHA-512");
            msg.update(salt.getBytes());

            hex = String.format("%128x", new BigInteger(1, msg.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hex;
    }
}
