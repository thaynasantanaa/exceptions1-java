package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
// RuntimeException - compilador nao obriga a tratar
//Exception compilador obriga a tratar
	
/*declaro esse construtor pra permitir que eu possa instanciar
	a minha exc person. passando uma msg pra ela */
	 public DomainException (String msg) {
		 super(msg);
	 }
}
