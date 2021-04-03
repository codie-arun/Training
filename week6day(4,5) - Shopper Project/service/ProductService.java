package service;

import java.util.Set;

import model.ItemDTO;

public interface ProductService {

	public Set<ItemDTO> showItems(String category);

	public boolean isNumeric(String name);

}
