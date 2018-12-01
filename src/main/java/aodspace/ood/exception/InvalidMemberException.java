package aodspace.ood.exception;

/**
 * Exception when staff member not exist in company
 * 
 * @author Gevorg
 */
public class InvalidMemberException extends RuntimeException {

	private static final long serialVersionUID = -2424163804838711722L;

	/**
	 * method for call base class constructor
	 */
	public InvalidMemberException() {
		super();
	}

	/**
	 * method for call base class constructor whit parameter
	 * 
	 * @param message
	 */
	public InvalidMemberException(String message) {
		super(message);
	}
}
