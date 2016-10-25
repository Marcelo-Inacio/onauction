package br.com.hyperclass.onauction.authentication;

import java.io.IOException;

import javax.servlet.ServletException;

public interface AuthenticationListener {
	
	/**
     * Executa uma ação após a autenticação com sucesso na aplicação.
     * 
     * @param event
     *            O evento de autenticação.
     * @throws IOException
     *             Caso ocorra algum problema de I/O, como ao enviar um dado ao
     *             usuário por meio do <code>OutputStream</code> do objeto
     *             <code>HttpServletResponse</code>, presente no evento.
     * @throws ServletException
     *             Caso ocorra algum problema ao lidar com os objetos de
     *             requisição do usuário.
     */
    public void onAuthenticationSuccess(final AuthenticationEvent event) throws IOException, ServletException;

}
