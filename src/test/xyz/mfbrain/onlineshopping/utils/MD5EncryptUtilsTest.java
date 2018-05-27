package xyz.mfbrain.onlineshopping.utils;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class MD5EncryptUtilsTest {

    @Test
    public void validPassword() {
        try {
            System.out.println(MD5EncryptUtils.getEncryptedPwd("123456"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEncryptedPwd() {
        try {
            System.out.println(MD5EncryptUtils.validPassword("123456","6D065CB37F9518D60CA414920E7B83FC5FF6DB78444700CFBA5F08E0"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}