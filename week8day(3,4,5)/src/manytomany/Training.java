package manytomany;

import java.time.LocalDate;
import java.util.Set;

public class Training {

	public Training() {
		// TODO Auto-generated constructor stub
	}

	private int tid;
	private String tname;
	private LocalDate tstartdate;
	private Set<Student> students;
	
	public final Set<Student> getStudents() {
		return students;
	}
	public final void setStudents(Set<Student> students) {
		this.students = students;
	}
	public final int getTid() {
		return tid;
	}
	public final void setTid(int tid) {
		this.tid = tid;
	}
	public final String getTname() {
		return tname;
	}
	public final void setTname(String tname) {
		this.tname = tname;
	}
	public final LocalDate getTstartdate() {
		return tstartdate;
	}
	public final void setTstartdate(LocalDate tstartdate) {
		this.tstartdate = tstartdate;
	}
	
	
	
}
