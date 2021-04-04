package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ItemDAOimpl implements ItemDAO{

	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	
	
	public ItemDAOimpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost/purchase","root","arun");
		this.st = st = con.createStatement();
	}
	
	
	public ItemDTO createItemDTO(int item_no,String item_name,int item_unit,int item_price) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_no(item_no);
		itemDTO.setItem_name(item_name);
		itemDTO.setItem_unit(item_unit);
		itemDTO.setItem_price(item_price);
		
		return itemDTO;
	}
	
	
	@Override
	public int insertItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		try {
			
//			System.out.println(customerDTO.getCustomer_no());
//			System.out.println(customerDTO.getCustomer_name());
//			System.out.println(customerDTO.getCustomer_address());
//			System.out.println(customerDTO.getCustomer_email());
//			System.out.println(customerDTO.getCustomer_phone());
//			System.out.println("insert into customer values("+itemDTO.getItem_no()
//					+",'"+itemDTO.getItem_name()
//					+"',"+itemDTO.getItem_unit()
//					+","+itemDTO.getItem_price()
//					+")");
			st.execute("insert into item values("+itemDTO.getItem_no()
					+",'"+itemDTO.getItem_name()
					+"',"+itemDTO.getItem_unit()
					+","+itemDTO.getItem_price()
					+")");
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		
		try {
			st.executeUpdate("update item set "
					+"item_name ='"+itemDTO.getItem_name()
					+"',item_unit ="+itemDTO.getItem_unit()
					+",item_price ="+itemDTO.getItem_price()
					+" where item_no="+itemDTO.getItem_no());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteItem(int item_no) {
		// TODO Auto-generated method stub
		try {
			st.execute("delete from item where item_no="+item_no);
			System.out.println("deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ItemDTO getItem(int item_no) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs=st.executeQuery("select * from item where item_no="+item_no);
			while(rs.next()) {
				//System.out.println("cool");
				return createItemDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
			//System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getItemNo(String item_name) {
		// TODO Auto-generated method stub
		try {
			System.out.println("this fun");
			ResultSet rs=st.executeQuery("select item_no from item where item_name='"+item_name+"'");
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Set<ItemDTO> getAllItem() {
		// TODO Auto-generated method stub
		
		Set<ItemDTO> itemset =  new HashSet<ItemDTO>() ;
		
		try {
			ResultSet rs=st.executeQuery("select * from item");
			while(rs.next()) {
				itemset.add( createItemDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemset;
		
	}

	

}
