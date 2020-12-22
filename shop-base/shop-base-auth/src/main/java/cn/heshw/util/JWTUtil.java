package cn.heshw.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private static final String ROLES_CLAIMS = "role";

  @Value("#{${token.timeout}?:1000 * 60 * 60}")
  private Long tokenTimeout;

  @Value("${token.key}")
  private String tokenSecretKey;

  /**
   * 对应 Header：
   * {
   *   "alg": "HS256"
   * }
   * 对应 Payload:
   * {
   *   "role": "admin,user",
   *   "exp": 1608455281,
   *   "iat": 1608455271,
   *   "username": "heshw"
   * }
   * 对应 Verify Signature生成方法，用于验证是否被修改:
   * HMACSHA256(
   *   base64UrlEncode(header) + "." +
   *   base64UrlEncode(payload),
   *   token_secret_key
   *  )
   * @param args
   */
  public static void main(String[] args) throws Exception {
    final JWTUtil jwtUtil = new JWTUtil();
    System.out.println(jwtUtil.generateToken("heshw", "admin,user"));
  }

  public void setTokenTimeout(Long tokenTimeout) {
    this.tokenTimeout = tokenTimeout;
  }

  public void setTokenSecretKey(String tokenSecretKey) {
    this.tokenSecretKey = tokenSecretKey;
  }

  public String generateToken(String username, String roles) throws Exception {
    try {
      Map<String, Object> map = new HashMap<>();
      map.put(ROLES_CLAIMS, roles);
      map.put("username", username);

      return Jwts.builder()
          .setSubject(username)
          .setClaims(map)
          .setIssuedAt(new Date())
          .setExpiration(new Date(System.currentTimeMillis() + tokenTimeout))
          .signWith(SignatureAlgorithm.HS256, tokenSecretKey)
          .compact();
    } catch (Exception e) {
      throw new Exception("生成token发生异常！");
    }
  }

  public void checkTokenValid(String token) throws Exception {
    Claims body = Jwts.parser().setSigningKey(tokenSecretKey).parseClaimsJws(token).getBody();
    if (StringUtils.isBlank((String) body.get("username")) || StringUtils
        .isBlank(body.get("roles").toString())) {
      throw new Exception("登陆信息异常，请重新登陆！");
    }
    if (body.getExpiration().before(new Date())) {
      throw new Exception("登陆凭证已过期，请重新登陆！");
    }
  }
}