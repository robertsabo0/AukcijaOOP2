package beans;

public class PostojiUsernameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostojiUsernameException(){
		super();
	}
	
	public PostojiUsernameException (String message){
		super(message);
	}
	
	public PostojiUsernameException (Throwable ex){
		super(ex);
	}
}
