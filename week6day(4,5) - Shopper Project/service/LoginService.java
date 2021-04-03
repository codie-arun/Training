package service;

import model.CustomerDTO;

public interface LoginService {

	public boolean checkUser(String uname,String upass);
	public boolean checkFlag(String uname);
	public int updateFlag(String uname,int flag);
	public int registerUser(int uno,String uname,String uaddress,String umail,int phone,String upass);
	
}
