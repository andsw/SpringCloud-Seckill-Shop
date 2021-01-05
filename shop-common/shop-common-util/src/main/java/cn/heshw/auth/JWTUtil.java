package cn.heshw.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class JWTUtil {

  private static final String ROLES_CLAIMS = "role";

  private static final String JWT_SECRET = "heshw-fighting";

  private static final Long TOKEN_TIMEOUT = 3600L;

  public static String generateToken(String username, String roles) throws Exception {
    try {
      Map<String, Object> map = new HashMap<>();
      map.put(ROLES_CLAIMS, roles);
      map.put("username", username);

      return Jwts.builder()
          .setSubject(username)
          .setClaims(map)
          .setIssuedAt(new Date())
          .setExpiration(new Date(System.currentTimeMillis() + TOKEN_TIMEOUT))
          .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
          .compact();
    } catch (Exception e) {
      throw new Exception("生成token发生异常！");
    }
  }

  public static void checkTokenValid(String token) throws Exception {
    Claims body = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    if (StringUtils.isBlank((String) body.get("username")) || StringUtils
        .isBlank(body.get("roles").toString())) {
      throw new Exception("登陆信息异常，请重新登陆！");
    }
    if (body.getExpiration().before(new Date())) {
      throw new Exception("登陆凭证已过期，请重新登陆！");
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