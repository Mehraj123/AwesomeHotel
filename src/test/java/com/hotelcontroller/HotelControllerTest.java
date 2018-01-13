/*package com.hotelcontroller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ah.controller.HotelController;
import com.ah.repository.HotelRepository;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment =
// WebEnvironment.RANDOM_PORT,classes=MongoWithBootApplication.class) //Loads
// whole application
@WebMvcTest(controllers = HotelController.class, secure = false) // loads only given controller
public class HotelControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private HotelRepository hotelRepository;

	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void Should_ReturnAllHotels() throws Exception {

		Mockito.when(hotelRepository.findAll()).thenReturn(HotelUtil.mockHotel());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hotels/all").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedResponse = "";
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false); // false -> No
																										// strict
																										// checking
		assertThat(HttpStatus.FOUND.value()).isEqualTo(result.getResponse().getStatus());
	}
	
	
	@Test
	public void Should_ReturnHotelByID() throws Exception{
		Mockito.when(hotelRepository.findById(Mockito.anyString())).thenReturn(HotelUtil.getOneHotel());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hotels/someID").accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Result : "+result.getResponse().getContentAsString());
		String expectedResponse = "{\"name\":\"My Hotel\",\"pricePerNight\": 800}";
		JSONAssert.assertEquals(expectedResponse,result.getResponse().getContentAsString(),false); //false -> No strict checking
		assertThat(HttpStatus.FOUND.value()).isEqualTo(result.getResponse().getStatus());
	}

	@Test
	public void Should_CreateHotel() throws Exception{
		Mockito.when(hotelRepository.insert(Mockito.any(Hotel.class))).thenReturn(HotelUtil.getOneHotel());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hotels/")
															.content(HotelUtil.getHotelJson())
															.accept(MediaType.APPLICATION_JSON)
														    .contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertThat(HttpStatus.CREATED.value()).isEqualTo(result.getResponse().getStatus());
	}

	@Test
	public void Should_UpdateHotel() throws Exception{
		Mockito.when(hotelRepository.save(Mockito.any(Hotel.class))).thenReturn(HotelUtil.getOneHotel());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/hotels/")
															.content(HotelUtil.getHotelJson())
															.accept(MediaType.APPLICATION_JSON)
														    .contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());
	}

}
*/