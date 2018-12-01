package aodspace.ood;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import aodspace.ood.staff.base.StaffMember;
import aodspace.ood.staff.base.Supervisor;
import aodspace.ood.staff.factory.StaffMemberFactory;
import aodspace.ood.staff.factory.StaffMemberFactory.StaffMemberType;
import aodspace.ood.util.MathUtil;

/**
 * Test salary calculations
 * 
 * @author gevorg
 *
 */
public class StaffMemberTest {

	@Test
	public void testEmployeeSalary() {
		StaffMember emp1 = initMember("Employee", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		double salary = MathUtil.round(emp1.calculateSalary(LocalDate.now()));
		
		//salary 1 year
		assertEquals(103000, salary, 0);
		
		StaffMember emp2 = initMember("EmployeeMaxSalary", LocalDate.of(1017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		salary = MathUtil.round(emp2.calculateSalary(LocalDate.now()));
		
		//max salary
		assertEquals(130000, salary, 0);
	}
	
	@Test
	public void testManagerSalary() {
		StaffMember man1 = initMember("Manager", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		double salary = MathUtil.round(man1.calculateSalary(LocalDate.now()));
		
		//salary 1 year
		assertEquals(105000, salary, 0);
		
		StaffMember man2 = initMember("ManagerMaxSalary", LocalDate.of(1017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		salary = MathUtil.round(man2.calculateSalary(LocalDate.now()));
		
		//max salary
		assertEquals(140000, salary, 0);
		
		StaffMember emp3 = initMember("EmployeeMan2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		emp3.initSupervisor((Supervisor)man2);
		
		StaffMember man3 = initMember("ManagerMan2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		man3.initSupervisor((Supervisor)man2);
		
		StaffMember sales3 = initMember("SalesMan2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		sales3.initSupervisor((Supervisor)man2);
		
		salary = MathUtil.round(man2.calculateSalary(LocalDate.now()));
		
		//manager with subordinates salary
		// 140000 + 515 + 525 + 505
		assertEquals(141545, salary, 0);
	}
	
	@Test
	public void testSalesSalary() {
		StaffMember sales1 = initMember("Sales", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		double salary = MathUtil.round(sales1.calculateSalary(LocalDate.now()));
		
		//salary 1 year
		assertEquals(101000, salary, 0);
		
		StaffMember sales2 = initMember("ManagerMaxSalary", LocalDate.of(1017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		salary = MathUtil.round(sales2.calculateSalary(LocalDate.now()));
		
		//max salary
		assertEquals(135000, salary, 0);
		
		StaffMember emp3 = initMember("EmployeeSales2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		emp3.initSupervisor((Supervisor)sales2);
		
		StaffMember man3 = initMember("ManagerSales2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		man3.initSupervisor((Supervisor)sales2);
		
		StaffMember sales3 = initMember("SalesSales2Subordinate", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		sales3.initSupervisor((Supervisor)sales2);
		
		salary = MathUtil.round(sales2.calculateSalary(LocalDate.now()));
		
		//sales with subordinates salary
		// 135000 + 309 + 315 + 303
		assertEquals(135927, salary, 0);
	}
	
	/**
	 * Add new member with type
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public StaffMember initMember(String name, LocalDate joinDate, StaffMemberType type) {
		StaffMember member = StaffMemberFactory.createStaffMember(type);

		member.setName(name);
		member.setJoinDate(joinDate);

		return member;
	}
}
