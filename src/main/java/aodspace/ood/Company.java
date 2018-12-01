package aodspace.ood;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aodspace.ood.exception.InvalidMemberException;
import aodspace.ood.staff.base.StaffMember;
import aodspace.ood.staff.base.Supervisor;
import aodspace.ood.staff.factory.StaffMemberFactory;
import aodspace.ood.staff.factory.StaffMemberFactory.StaffMemberType;

/**
 * Class company, have some data related companies. There is a company; the
 * company can have staff members.
 * 
 * @author Gevorg
 */
public class Company {

	private String name;
	private List<StaffMember> members = new ArrayList<>();

	/**
	 * default constructor
	 */
	public Company() {
	}

	/**
	 * constructor for init name
	 * 
	 * @param name
	 */
	public Company(String name) {
		this.name = name;
	}

	/**
	 * Add new member with type
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public StaffMember addMember(String name, LocalDate joinDate, StaffMemberType type) {
		StaffMember member = StaffMemberFactory.createStaffMember(type);

		member.setName(name);
		member.setJoinDate(joinDate);

		members.add(member);

		return member;
	}

	/**
	 * Add new member with type
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public StaffMember addMember(String name, LocalDate joinDate, Supervisor supervisor, StaffMemberType type) {
		validateSupervisor(supervisor);
		
		StaffMember member = StaffMemberFactory.createStaffMember(type);

		member.setName(name);
		member.setJoinDate(joinDate);
		member.initSupervisor(supervisor);

		members.add(member);

		return member;
	}

	/**
	 * Validate supervisor exist in members or not
	 * @param supervisor
	 */
	private void validateSupervisor(Supervisor supervisor) {
		if(supervisor == null || memberNotExist(supervisor)) {
			throw new InvalidMemberException("Invalid supervisor");
		}
	}

	/**
	 * Check member exist in company members
	 * @param member
	 * @return
	 */
	private boolean memberNotExist(StaffMember member) {
		for(StaffMember companyMember: members) {
			if(companyMember.equals(member)) {
				return false;
			}
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
	 * @return the members
	 */
	public List<StaffMember> getMembers() {
		return members;
	}

	/**
	 * @param members
	 *            the members to set
	 */
	public void setMembers(List<StaffMember> members) {
		this.members = members;
	}
}
