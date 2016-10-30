package br.com.hyperclass.onauction.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A classe <code>UserNotFoundException</code> representa a exceção
 *  de que nenhum usuário foi encontrado nos registros do leilão.
 *  
 * @author Marcelo
 *
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends AuctionException {

	private static final long serialVersionUID = 1L;
	private final String username;
	
	public UserNotFoundException(final String username) {
		super();
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

}
