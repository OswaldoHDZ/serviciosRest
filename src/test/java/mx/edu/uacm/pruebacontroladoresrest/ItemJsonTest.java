package mx.edu.uacm.pruebacontroladoresrest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import mx.edu.uacm.pruebacontroladoresrest.controler.ItemController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= PruebaControladoresRestApplication.class)
@AutoConfigureMockMvc
public class ItemJsonTest {
	

	private Logger log = LogManager.getLogger(ItemController.class);
	
	@Autowired
	private MockMvc mvc;
	
	//Vamos a fingir que somos el cliente para consumir el sercicio REST
	//@Test
	public void deberiaTraerTodosItems() {
		log.debug("------------deberiaTraerTodosItems");
		//MockRestServiceServer esta fingiendo que es un servidor donde ya se publico la claseItemMocksRespository 
		RestTemplate restTemplate = new RestTemplate();
		MockRestServiceServer mockServer =
				MockRestServiceServer.bindTo(restTemplate).build();
		mockServer.expect(requestTo("/item/all")).
		andRespond(withSuccess());
	}
	@Test
	public void deberiATodos() throws Exception{
		log.debug("Entrando a deberiATodos");
		mvc.perform(get("/item/all")).andDo(print());
	}
}
