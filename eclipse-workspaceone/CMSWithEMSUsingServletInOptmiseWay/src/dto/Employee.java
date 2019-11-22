package dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class Employee extends Person {
	private String salary;
	private String dateOfJoining;

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Map<String, String> getDataOfEmployee(Employee employee) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", employee.getUid());
		map.put("fname", employee.getFname());
		map.put("lname", employee.getLname());
		map.put("mobileNumber", employee.getMobileNumber());
		map.put("email", employee.getEmail());
		map.put("dateOfJoining", employee.getDateOfJoining());
		map.put("salary", employee.getSalary());
		return map;
	}
}
