package com.radiance.ai.assistant.common.utils;

import com.radiance.ai.assistant.common.constant.EncryptConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * 加密工具类
 *
 * @author juncong.sh
 * @date 2022/12/7 02:06
 * @since 1.0.0
 */
public class EncryptUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptUtils.class);
    public static final String DEFAULT_CODING = "utf-8";

    public EncryptUtils() {
    }

    public static String aesDecrypt(String content, String key) {
        String data = null;

        try {
            byte[] bKey = key.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] mdKey = messageDigest.digest(bKey);
            SecretKeySpec secretKeySpec = new SecretKeySpec(mdKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            byte[] result = cipher.doFinal(toByte(content));
            data = new String(result, "utf-8");
        } catch (Exception var9) {
            LOGGER.warn(var9.getMessage(), var9);
        }

        return data;
    }

    public static String aesEncrypt(String content, String key) {
        String data = null;

        try {
            byte[] input = content.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] mdKey = messageDigest.digest(key.getBytes("utf-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(mdKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
            int length = cipher.update(input, 0, input.length, cipherText, 0);
            cipher.doFinal(cipherText, length);
            System.out.println(new String());
            data = parseByte2HexStr(cipherText);
        } catch (Exception var10) {
            LOGGER.warn(var10.getMessage(), var10);
        }

        return data;
    }

    public static String aesDecryptNoMd5(String content, String key) {
        String data = null;
        if (content == null) {
            return data;
        } else {
            try {
                byte[] mKey = key.getBytes("utf-8");
                SecretKeySpec secretKeySpec = new SecretKeySpec(mKey, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(2, secretKeySpec);
                byte[] result = cipher.doFinal(toByte(content));
                data = new String(result, "gb18030");
            } catch (Exception var7) {
                LOGGER.warn(var7.getMessage(), var7);
            }

            return data;
        }
    }

    public static String aesEncryptNoMd5(String content, String key) {
        String data = null;

        try {
            byte[] input = content.getBytes("utf-8");
            byte[] mdKey = key.getBytes("utf-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(mdKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
            int length = cipher.update(input, 0, input.length, cipherText, 0);
            cipher.doFinal(cipherText, length);
            data = parseByte2HexStr(cipherText);
        } catch (Exception var9) {
            LOGGER.warn(var9.getMessage(), var9);
        }

        return data;
    }

    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];

        for(int i = 0; i < len; ++i) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }

        return result;
    }

    private static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(aesEncrypt("HelloWorld", "Ca6m4E1f26G91Nad"));
        System.out.println("===");
        System.out.println(aesDecrypt("cccad192c59907cd059dbfb230d933e7", EncryptConstant.TSINGHUA_MEM_KEY));
    }

}
