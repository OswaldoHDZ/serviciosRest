package mx.edu.uacm.pruebacontroladoresrest.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//@Componet es una anotacion de un bind de sringn, es un componente generico
//Es el es el estereotipo principal,indica que la clase
//Anotada es un componente (o bien un bin de spring)
@Component
public class ItemMocksRespository {
	
	private List<Item> items;
	
	public ItemMocksRespository() {
		init(); /*Simula la base de datos */
	}
	
	private void init() {
		items = new ArrayList<Item>();
		items.add(new Item(1L, "Sopa", 0.75f));
		items.add(new Item(2L, "Pan", 0.85f));
		items.add(new Item(3L, "Leche", 2.45f));
	}
	public List<Item> findAll(){
		return items;
	}
	public Item find(int id) {
		return items.get(id-1);
	}
	
}
