package service;

import java.util.Properties;
import java.util.Set;


import model.ItemDAO;
import model.ItemDAOImpl;
import model.ItemDTO;

public class ProductServiceImpl implements ProductService,Cloneable{

	
	Properties prop;
	private static ProductServiceImpl productServiceImpl;
	
		
	
	public ProductServiceImpl(Properties prop) {
		
		this.prop = prop;
	}
	
	public static ProductServiceImpl getProductServiceImpl(Properties prop) {
		if(productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl(prop);
			return productServiceImpl;
		}else {
			return productServiceImpl.getClone();
		}
	}
	
	public ProductServiceImpl getClone() {
		try {
			return (ProductServiceImpl)super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	
	
	@Override
	public Set<ItemDTO> showItems(String category) {
		
		ItemDAO itemdao = ItemDAOImpl.getItemDAOImpl(prop);
		Set<ItemDTO> itemdto = itemdao.getAllItemOfCategory(category);
		
		return itemdto;
	}

	

}
