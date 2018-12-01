package aodspace.ood.staff;

import aodspace.ood.staff.base.Supervisor;

/**
 * class that init percent of sales
 * 
 * @author Gevorg
 */
public class Sales extends Supervisor {

	private static final int SALES_SALARY_UP_PERCENT = 1;
	private static final int SALES_MAX_SALARY_UP_PERCENT = 35;
	private static final double SALES_SUBORDINATE_UP_PERCENT = 0.3;

	public Sales() {
		yearlySalaryUpPercent = SALES_SALARY_UP_PERCENT;
		maxSalaryUpPercent = SALES_MAX_SALARY_UP_PERCENT;
		subordinatesUpPercent = SALES_SUBORDINATE_UP_PERCENT;
	}
}
