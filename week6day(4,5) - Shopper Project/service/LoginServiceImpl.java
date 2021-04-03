package service;

import java.util.Properties;

import model.CustomerDAO;
import model.CustomerDAOImpl;
import model.CustomerDTO;
import model.DBUtility;

public class LoginServiceImpl implements LoginService,Cloneable{

	Properties prop;
	private static LoginServiceImpl loginServiceImpl;
	
		
	
	public LoginServiceImpl(Properties prop) {
		
		this.prop = prop;
	}
	
	public static LoginServiceImpl getLoginServiceImpl(Properties prop) {
		if(loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl(prop);
			return loginServiceImpl;
		}else {
			return loginServiceImpl.getClone();
		}
	}
	
	public LoginServiceImpl getClone() {
		try {
			return (LoginServiceImpl)super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkUser(String uname, String upass) {
		CustomerDAO cusdao = CustomerDAOImpl.getCustomerDAOImpl(prop);
		CustomerDTO cusdto = cusdao.getCustomerByName(uname);
		System.out.println(cusdto);
		if(cusdto.getCustomer_name()!=null) {
			if(cusdto.getCustomer_pass().equalsIgnoreCase(upass)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean checkFlag(String uname) {
		CustomerDAO cusdao = CustomerDAOImpl.getCustomerDAOImpl(prop);
		CustomerDTO cusdto = cusdao.getCustomerByName(uname);
		if(cusdto!=null) {
			if(cusdto.getCustomer_flag()==0) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public int updateFlag(String uname, int flag) {
		CustomerDAO cusdao = CustomerDAOImpl.getCustomerDAOImpl(prop);
		CustomerDTO cusdto = cusdao.getCustomerByName(uname);
		if(cusdto!=null) {
			int n = cusdao.setCustomerFlag(cusdto, flag);
			System.out.println(cusdao);
			return n;
		}else {
			return 0;
		}
		
	}

	@Override
	public int registerUser(int uno, String uname, String uaddress, String umail, int phone, String upass) {
		
		CustomerDAO cusdao = CustomerDAOImpl.getCustomerDAOImpl(prop);
		CustomerDTO cusdto = CustomerDTO.getCustomerDTO();
		
		cusdto.setCustomer_no(uno);
		cusdto.setCustomer_name(uname);
		cusdto.setCustomer_address(uaddress);
		cusdto.setCustomer_email(umail);
		cusdto.setCustomer_phone(phone);
		cusdto.setCustomer_pass(upass);
		cusdto.setCustomer_flag(0);
		
		return cusdao.insertCustomer(cusdto);
	}

	

	

}
