package week7day3complex;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface ComplexService{
	
	public void setEmployee(Employee emp);
	public void setAllEmployees(List<Employee> list);
	public Employee getEmployee(String eid);
	public List<Employee> getAllEmployees();
	
}