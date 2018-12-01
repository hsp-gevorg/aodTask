package aodspace.ood.staff;

import aodspace.ood.staff.base.Supervisor;

/**
 * class that init percent of manager
 * 
 * @author Gevorg
 */
public class Manager extends Supervisor {

	private static final int MANAGER_SALARY_UP_PERCENT = 5;
	private static final int MANAGER_MAX_SALARY_UP_PERCENT = 40;
	private static final double MANAGER_SUBORDINATE_UP_PERCENT = 0.5;

	public Manager() {
		yearlySalaryUpPercent = MANAGER_SALARY_UP_PERCENT;
		maxSalaryUpPercent = MANAGER_MAX_SALARY_UP_PERCENT;
		subordinatesUpPercent = MANAGER_SUBORDINATE_UP_PERCENT;
	}
}
