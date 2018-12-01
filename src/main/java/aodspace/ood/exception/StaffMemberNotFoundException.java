package aodspace.ood.exception;

/**
 * Exception when staff member not found
 * 
 * @author Gevorg
 */
public class StaffMemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2424163804838711722L;

	/**
	 * method for call base class constructor
	 */
	public StaffMemberNotFoundException() {
		super();
	}

	/**
	 * method for call base class constructor whit parameter
	 * 
	 * @param message
	 */
	public StaffMemberNotFoundException(String message) {
		super(message);
	}
}
