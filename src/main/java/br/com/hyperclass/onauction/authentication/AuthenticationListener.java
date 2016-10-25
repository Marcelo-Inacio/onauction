package br.com.hyperclass.onauction.authentication;

import java.io.IOException;

import javax.servlet.ServletException;

public interface AuthenticationListener {
	
	/**
     * Executa uma a��o ap�s a autentica��o com sucesso na aplica��o.
     * 
     * @param event
     *            O evento de autentica��o.
     * @throws IOException
     *             Caso ocorra algum problema de I/O, como ao enviar um dado ao
     *             usu�rio por meio do <code>OutputStream</code> do objeto
     *             <code>HttpServletResponse</code>, presente no evento.
     * @throws ServletException
     *             Caso ocorra algum problema ao lidar com os objetos de
     *             requisi��o do usu�rio.
     */
    public void onAuthenticationSuccess(final AuthenticationEvent event) throws IOException, ServletException;

}
