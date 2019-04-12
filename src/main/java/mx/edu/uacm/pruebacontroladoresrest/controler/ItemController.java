package mx.edu.uacm.pruebacontroladoresrest.controler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uacm.pruebacontroladoresrest.domain.Item;
import mx.edu.uacm.pruebacontroladoresrest.domain.ItemMocksRespository;

//Es un controlador de de servicio REST
@RestController
public class ItemController {
	
	private Logger log = (Logger) LogManager.getLogger(ItemController.class);
	@Autowired
	private ItemMocksRespository itemsRepository;
	
	//@GetMapping
	//Lo que esta regresando es un Json
	@RequestMapping("/item/all")
	public List<Item> getAllTopics(){
		log.debug("Entrar a aqui-----------------------");
		return itemsRepository.findAll();
	}
	@RequestMapping("/item/{id}")
	public Item getTopic(@PathVariable("id") Integer id) {
		return itemsRepository.find(id);
	}
}
