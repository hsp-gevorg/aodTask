package aodspace.ood.staff;

import aodspace.ood.staff.base.StaffMember;

/**
 * class that init percent of employee
 * 
 * @author Gevorg
 *
 */
public class Employee extends StaffMember {

	private static final int EMPLOYEE_SALARY_UP_PERCENT = 3;
	private static final int EMPLOYEE_MAX_SALARY_UP_PERCENT = 30;

	public Employee() {
		yearlySalaryUpPercent = EMPLOYEE_SALARY_UP_PERCENT;
		maxSalaryUpPercent = EMPLOYEE_MAX_SALARY_UP_PERCENT;
	}
}
