package br.com.hyperclass.onauction.restapi;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PreAuthorize("isAuthenticated()")
	@PreFilter("principal.name == Nick")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(final HttpServletResponse response) throws IOException {
		System.out.println("hello " + response.getContentType());
	}
	
}
