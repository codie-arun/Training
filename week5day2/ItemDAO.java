package week5day2;

import java.util.Set;

public interface ItemDAO {

	public int insertItem(ItemDTO itemDTO);
	public int updateItem(ItemDTO itemDTO);
	public int deleteItem(int item_no);
	public ItemDTO getItem(int item_no);
	public Set<ItemDTO> getAllItem();

}
