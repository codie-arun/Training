package week7day3complex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
//import javax.xml.bind.annotation.XmlRootElement;


@WebService(endpointInterface = "week7day3complex.ComplexService")
@HandlerChain(file="Handler-chain.xml")
public class ComplexServiceImpl implements ComplexService {

		Employee emp;
		List<Employee> list = new ArrayList<>();
		
		public ComplexServiceImpl() {
			emp=new Employee(1,"ramu",1000);
			list.add(emp);
			emp=new Employee(2,"somu",2000);
			list.add(emp);
			emp=new Employee(3,"raju",3000);
			list.add(emp);
		}
		
		@WebMethod
		public void setEmployee(Employee emp) {
			System.out.println(emp);
			this.emp = emp;
			list.add(emp);
		}
		
		
		@WebMethod
		public Employee getEmployee(String eid) {
			Iterator<Employee> iter = list.iterator();
			
			int eidnum = Integer.parseInt(eid);
			
			while(iter.hasNext()) {
				Employee e=iter.next();
				if(e.getEid()==eidnum) {
					return e;
				}
			}
			return null;
					
		}
		
		
		@WebMethod
		public List<Employee> getAllEmployees(){
			return this.list;
		}
		
		@WebMethod
		public void setAllEmployees(List<Employee> list){
			System.out.println(list);
			this.list = list;
		}
			
		

}


//@XmlRootElement(name="employee")
class Employee{
	
	private int eid;
	private String ename;
	private int esal;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int eid, String ename, int esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	public final int getEid() {
		return eid;
	}
	public final void setEid(int eid) {
		this.eid = eid;
	}
	public final String getEname() {
		return ename;
	}
	public final void setEname(String ename) {
		this.ename = ename;
	}
	public final int getEsal() {
		return esal;
	}
	public final void setEsal(int esal) {
		this.esal = esal;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
	
	
	
}