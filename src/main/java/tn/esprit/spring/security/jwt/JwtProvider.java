package tn.esprit.spring.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import tn.esprit.spring.security.services.UserPrinciple;
import tn.esprit.spring.utils.StringsConstants;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Value("${kindergarten.app.jwtSecret}")
	private String jwtSecret;

	@Value("${kindergarten.app.jwtExpiration}")
	private int jwtExpiration;

	public String generateJwtToken(Authentication authentication) {

		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error(StringsConstants.JWT_INVALID_SIGN, e);
		} catch (MalformedJwtException e) {
			logger.error(StringsConstants.JWT_INVALID_TOKEN, e);
		} catch (ExpiredJwtException e) {
			logger.error(StringsConstants.JWT_EXPIRED_TOKEN, e);
		} catch (UnsupportedJwtException e) {
			logger.error(StringsConstants.JWT_UNSUPPORTED_TOKEN, e);
		} catch (IllegalArgumentException e) {
			logger.error(StringsConstants.JWT_EMPTY_CLAIMS, e);
		}

		return false;
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
}