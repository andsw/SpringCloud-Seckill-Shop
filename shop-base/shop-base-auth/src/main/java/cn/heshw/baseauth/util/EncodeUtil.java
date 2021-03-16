package cn.heshw.baseauth.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class EncodeUtil {

  public static String encode(String password) {
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("MD5");//利用哈希算法，MD5
      //面向字节处理，所以可以处理字节的东西，如图片，压缩包。。
      byte[] input = password.getBytes();
      byte[] output = md.digest(input);
      //将md5处理后的output结果利用Base64转成原有的字符串,不会乱码
      return Base64.encodeBase64String(output);
    } catch (NoSuchAlgorithmException e) {
      System.out.println("密码加密失败");
      return "";
    }
  }
}