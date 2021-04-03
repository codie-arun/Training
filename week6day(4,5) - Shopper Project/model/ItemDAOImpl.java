package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;



public class ItemDAOImpl implements ItemDAO,Cloneable{

	private static ItemDAOImpl itemdao;
	private Properties prop;
	private ItemDAOImpl(Properties prop) {
		this.prop = prop;
	}
	
	
	
	
	synchronized public static ItemDAOImpl getItemDAOImpl(Properties prop) {
		
		if(itemdao==null) {
			itemdao=new ItemDAOImpl(prop);
			return itemdao;
		}
		else {
			return itemdao.createClone();
		}
		
	}
	
	
	public ItemDAOImpl createClone() {
		try {
			itemdao = (ItemDAOImpl)super.clone();
			return itemdao;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public int insertItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(int item_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemDTO getItem(int item_no) {

		try {
			ItemDTO itemDTO = new ItemDTO();
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("select * from item where item_no=?");
			ps.setInt(1, item_no);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				itemDTO.setItem_no(rs.getInt(1));
				itemDTO.setItem_name(rs.getString(2));
				itemDTO.setItem_unit(rs.getInt(3));
				itemDTO.setItem_price(rs.getInt(4));
				itemDTO.setItem_category(rs.getString(5));
				
			}
			
			DBUtility.closeConnection(null);
			return itemDTO;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}

	@Override
	public Set<ItemDTO> getAllItem() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Set<ItemDTO> getAllItemOfCategory(String category) {
		try {
			ItemDTO itemDTO;
			Connection con=DBUtility.getConnection(prop);
			Set<ItemDTO> itemset =  new HashSet<ItemDTO>() ;
			PreparedStatement ps=con.prepareStatement("select * from item where item_category=?");
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				itemDTO= new ItemDTO();
				itemDTO.setItem_no(rs.getInt(1));
				itemDTO.setItem_name(rs.getString(2));
				itemDTO.setItem_unit(rs.getInt(3));
				itemDTO.setItem_price(rs.getInt(4));
				itemDTO.setItem_category(rs.getString(5));
				itemset.add(itemDTO);
			}
			
			DBUtility.closeConnection(null);
			return itemset;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}





	

}
