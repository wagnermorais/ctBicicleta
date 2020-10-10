package br.desafio.ctbicicleta.resources.exception;

public class RegraDeNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RegraDeNegocioException(String msg) {
		super(msg);
	}
	
	public RegraDeNegocioException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
