package basic.crud.app.enitity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Password {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String password;
	
	@OneToOne(cascade= {CascadeType.REMOVE})
	private Employee employ;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
	}
}
