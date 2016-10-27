package br.com.hyperclass.onauction.restapi;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.onauction.restapi.wrapper.LoginWrapper;

//@RestController
public class LoginController {
	
	@PreAuthorize("isAuthenticated()")
	@PreFilter("principal.name == Nick")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void hello(@RequestBody final LoginWrapper login,
			final HttpServletResponse response) throws IOException {
		System.out.println("username: " + login.getUsername() + " password: " + login.getPassword());
		response.addHeader("token", "valorDoTokenGeradoAqui#0000");
	}
	
}
