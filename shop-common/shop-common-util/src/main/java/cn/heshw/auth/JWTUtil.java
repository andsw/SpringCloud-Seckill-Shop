package cn.heshw.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class JWTUtil {

  private static final String ROLES_CLAIMS = "role";

  private static final String USERNAME_CLAIMS = "username";

  private static final String JWT_SECRET = "heshw-fighting";

  private static final Long TOKEN_TIMEOUT = 3600000L;

  public static String generateToken(String username, String roles) throws Exception {
    try {
      Map<String, Object> map = new HashMap<>();
      map.put(ROLES_CLAIMS, roles);
      map.put(USERNAME_CLAIMS, username);

      final Date expireDate = new Date(System.currentTimeMillis() + TOKEN_TIMEOUT);

      return Jwts.builder()
          .setSubject(username)
          .setClaims(map)
          .setIssuedAt(new Date())
          .setExpiration(expireDate)
          .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
          .compact();
    } catch (Exception e) {
      throw new Exception("生成token发生异常！");
    }
  }

  public static void checkTokenValid(String token) throws Exception {
    Jws<Claims> claimsJws = null;
    try {
      claimsJws = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
    } catch (ExpiredJwtException eje) {
      throw new Exception("登陆凭证已过期，请重新登陆！");
    } catch (Exception e) {
      throw new Exception("登陆凭证校验发生异常，请重新登录！");
    }
    Claims body = claimsJws.getBody();
    if (StringUtils.isBlank((String) body.get(USERNAME_CLAIMS)) || StringUtils
        .isBlank(body.get(ROLES_CLAIMS).toString())) {
      throw new Exception("登陆信息异常，请重新登陆！");
    }
  }

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
}