package database;

import java.util.Set;

public interface ItemDAO {

	public int insertItem(ItemDTO itemDTO);
	public int updateItem(ItemDTO itemDTO);
	public int deleteItem(int item_no);
	public ItemDTO getItem(int item_no);
	public int getItemNo(String item_name);
	public Set<ItemDTO> getAllItem();

}
