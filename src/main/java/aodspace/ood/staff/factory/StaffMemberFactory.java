package aodspace.ood.staff.factory;

import aodspace.ood.exception.StaffMemberNotFoundException;
import aodspace.ood.staff.Employee;
import aodspace.ood.staff.Manager;
import aodspace.ood.staff.Sales;
import aodspace.ood.staff.base.StaffMember;

/**
 * Factory to create staff members
 * 
 * (factory method design pattern)
 * 
 * @author Gevorg
 */
public final class StaffMemberFactory {

	public enum StaffMemberType {
		EMPLOYEE, MANAGER, SALES
	}

	/**
	 * To have utility class
	 */
	private StaffMemberFactory() {
	}

	/**
	 * check if given type equals any reference else throw exception
	 * 
	 * @param memberType
	 * @param name
	 * @param joinDate
	 * @return
	 */
	public static StaffMember createStaffMember(StaffMemberType memberType) {
		switch (memberType) {
		case EMPLOYEE: {
			return new Employee();
		}

		case MANAGER: {
			return new Manager();
		}

		case SALES: {
			return new Sales();
		}
		}

		throw new StaffMemberNotFoundException("Staff member not found. Type = " + memberType);
	}
}
