package aodspace.ood;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import aodspace.ood.staff.Employee;
import aodspace.ood.staff.Manager;
import aodspace.ood.staff.Sales;
import aodspace.ood.staff.base.StaffMember;
import aodspace.ood.staff.base.Supervisor;
import aodspace.ood.staff.factory.StaffMemberFactory.StaffMemberType;

/**
 * Tests for Company class methods
 * 
 * @author gevorg
 */
public class CompanyTest {
	
	@Test
	public void testAddMember() {
		Company company = new Company();
		
		company.addMember("Employee", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.EMPLOYEE);
		company.addMember("Manager", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		company.addMember("Sales", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.SALES);
		
		//test correct size
		assertEquals(3, company.getMembers().size());
		
		//test valid classes
		assertEquals(company.getMembers().get(0).getClass(), Employee.class);
		assertEquals(company.getMembers().get(1).getClass(), Manager.class);
		assertEquals(company.getMembers().get(2).getClass(), Sales.class);
	}

	@Test
	public void testAddMemberWithSupervisor() {								
		Company company = new Company();
		
		//member 1
		StaffMember manager = company.addMember("Manager", LocalDate.of(2017, Month.SEPTEMBER, 25), StaffMemberType.MANAGER);
		
		//member 2
		company.addMember("Employee", LocalDate.of(2017, Month.SEPTEMBER, 25), (Supervisor) manager, StaffMemberType.EMPLOYEE);
			
		// member 2 supervisor is member 1
		assertEquals(company.getMembers().get(0), company.getMembers().get(1).getSupervisor());
	}
}
