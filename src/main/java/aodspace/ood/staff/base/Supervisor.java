package aodspace.ood.staff.base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aodspace.ood.util.MathUtil;

/**
 * Base class for all supervisor staff members (Manager, Sales)
 * 
 * @author Gevorg
 */
public abstract class Supervisor extends StaffMember {

	protected double subordinatesUpPercent;

	protected List<StaffMember> subordinates = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ood.staff.base.StaffMember#calculateSalary(java.time.LocalDate)
	 */
	public Double calculateSalary(LocalDate payDay) {
		Double salaryForPayDay = super.calculateSalary(payDay);

		/* plus 'subordinatesUpPercent' of salaries of their first level subordinates */
		for (StaffMember subordinate : subordinates) {
			salaryForPayDay += MathUtil.calculatePercent(subordinate.calculateSalary(payDay), subordinatesUpPercent);
		}

		return salaryForPayDay;
	}

	/**
	 * Add new subordinate
	 * 
	 * @param member
	 */
	public void addSubordinate(StaffMember member) {
		subordinates.add(member);
	}
}
