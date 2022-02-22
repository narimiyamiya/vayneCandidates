package com.example.hunter.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesUtil {

    /**
     * 將傳入的明文轉換為密文
     * @param str
     * @param pwd
     * @return
     */
    public String encode(String str,String pwd) {
        byte[] result = null;
        try {
            DESKeySpec keySpec = new DESKeySpec(pwd.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = str.getBytes();
            result = cipher.doFinal(byteContent);

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

        return parseByte2HexStr(result);
    }

    /**
     * 將傳入的密文轉換為明文
     * @param str
     * @param pwd
     * @return
     */
    public String decode(String str,String pwd) {
        byte[] result = null;
        byte[] content = parseHexStr2Byte(str);
        try {
            DESKeySpec keySpec = new DESKeySpec(pwd.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(content);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return new String(result);
    }

    /**
     * 將二進位制轉換成十六進位制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 將十六進位制轉換為二進位制
     *
     * @param hexStr
     * @return
     */
    private byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        DesUtil des = new DesUtil();
        String content = "測試test";
        // DES的金鑰長度必須是8位(小於8位則會報錯，8位之後對加密結果不會產生影響)
        String pwd = "javayznb";
        // 加密
        System.out.println("加密前：" + content);
        String encodeResultStr = des.encode(content,pwd);
        System.out.println("加密後：" + encodeResultStr);
        //解密
        String decodeResultStr = des.decode("FC147EC0A76ABC1D","chloe123");
        System.out.println("解密後：" + decodeResultStr);
    }

}
