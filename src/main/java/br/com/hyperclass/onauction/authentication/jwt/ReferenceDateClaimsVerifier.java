package br.com.hyperclass.onauction.authentication.jwt;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;

@Component
public class ReferenceDateClaimsVerifier implements JwtVerifier {

	/** {@inheritDoc} */
    @Override
    public void verify(final JWT jwt) {
        final JWTClaimsSet claims;
        try {
            claims = jwt.getJWTClaimsSet();
        } catch (final ParseException exception) {
            throw new JwtTokenException("Invalid JWT.");
        }
        final Date referenceTime = new Date();
        final Date expirationTime = claims.getExpirationTime();

        if (expirationTime == null || expirationTime.before(referenceTime)) {
            throw new JwtTokenException("The token is expired");
        }
    }

}
