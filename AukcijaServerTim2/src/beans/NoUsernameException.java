package beans;

public class NoUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoUsernameException (){
		super();
	}
	
	public NoUsernameException (String message){
		super(message);
	}
	
	public NoUsernameException (Throwable ex){
		super(ex);
	}

}
