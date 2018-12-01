package aodspace.ood;

import java.time.LocalDate;
import java.time.Month;

import aodspace.ood.staff.base.StaffMember;
import aodspace.ood.staff.base.Supervisor;
import aodspace.ood.staff.factory.StaffMemberFactory.StaffMemberType;
import aodspace.ood.util.MathUtil;

/**
 * Demonstrate the task.
 * 
 * @author Gevorg
 */
public class CompanyDemo {

	public static void main(String[] args) {
		Company company = new Company("AOD Space");
		
		StaffMember emp = company.addMember("Employee1", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		StaffMember man = company.addMember("Manager1", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		StaffMember sales = company.addMember("Sales1", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		
		emp.initSupervisor((Supervisor)man);
		man.initSupervisor((Supervisor)sales);
		
		LocalDate payDay = LocalDate.now();
		for(StaffMember member : company.getMembers()) {
			double salary = MathUtil.round(member.calculateSalary(payDay));
			
			System.out.println("Member: " + member.getName() + " Salary: " + salary);
		}
	}
}
