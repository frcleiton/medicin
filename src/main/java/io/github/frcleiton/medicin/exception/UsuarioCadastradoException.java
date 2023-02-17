package io.github.frcleiton.medicin.exception;

public class UsuarioCadastradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5635816691716968723L;

	public UsuarioCadastradoException(String login) {
		super("Usuário já cadastrado para o login " + login);
	}

}
