package aodspace.ood.staff.base;

import java.time.LocalDate;

import aodspace.ood.exception.InvalidMemberException;
import aodspace.ood.util.DateUtil;
import aodspace.ood.util.MathUtil;

/**
 * Staff members are characterized by their name, date when they joined the
 * company, and base salary (to keep it simple, consider this value to be equal
 * for all staff member types by default.)
 * 
 * @author Gevorg
 */
public abstract class StaffMember {

	private static final double DEFAULT_BASE_SALARY = 100000;

	protected String name;
	protected LocalDate joinDate;
	protected Double salary;

	protected int yearlySalaryUpPercent;
	protected int maxSalaryUpPercent;

	protected Supervisor supervisor;

	public StaffMember() {
		salary = DEFAULT_BASE_SALARY;
	}

	/**
	 * base salary plus 'yearlySalaryUpPercent' for each year they have worked with
	 * the company, but not more than 'maxSalaryUpPercent' of the base salary.
	 * 
	 * @param payDay
	 * @return
	 */
	public Double calculateSalary(LocalDate payDay) {
		long yearsWorked = DateUtil.getYearsDifference(joinDate, payDay);

		Double salaryForPayDay = DEFAULT_BASE_SALARY;
		for (int i = 0; i < yearsWorked; i++) {
			Double salaryUp = salaryForPayDay + MathUtil.calculatePercent(salaryForPayDay, yearlySalaryUpPercent);
			if (isMaxSalary(salaryUp)) {
				return calculateBaseMaxSalary();
			}

			salaryForPayDay = salaryUp;
		}

		return salaryForPayDay;
	}

	/**
	 * Check is given money greater then permissible border
	 * 
	 * @param money
	 * @return
	 */
	private boolean isMaxSalary(Double money) {
		return money > calculateBaseMaxSalary();
	}

	/**
	 * Calculation of base max salary
	 * 
	 * @return
	 */
	private Double calculateBaseMaxSalary() {
		return DEFAULT_BASE_SALARY + MathUtil.calculatePercent(DEFAULT_BASE_SALARY, maxSalaryUpPercent);
	}

	/**
	 * Add supervisor in staff member. Also add this staff member to subordinates of
	 * supervisor
	 * 
	 * @param supervisor
	 */
	public void initSupervisor(Supervisor supervisor) {
		validateSupervisor(supervisor);
		
		this.supervisor = supervisor;
		this.supervisor.addSubordinate(this);
	}
	
	/**
	 * Validate supervisor not null
	 * @param supervisor
	 */
	private void validateSupervisor(Supervisor supervisor) {
		if(supervisor == null) {
			throw new InvalidMemberException("Invalid supervisor - it is null");
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		StaffMember other = (StaffMember) obj;
		if (joinDate == null) {
			if (other.joinDate != null) {
				return false;
			}
		} else if (!joinDate.equals(other.joinDate)) {
			return false;
		}
		
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		
		if (salary == null) {
			if (other.salary != null) {
				return false;
			}
		} else if (!salary.equals(other.salary)) {
			return false;
		}
		
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the joinDate
	 */
	public LocalDate getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the supervisor
	 */
	public Supervisor getSupervisor() {
		return supervisor;
	}
}
