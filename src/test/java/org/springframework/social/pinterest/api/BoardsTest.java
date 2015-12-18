package org.springframework.social.pinterest.api;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.pinterest.api.BoardPin;
import org.springframework.social.pinterest.api.Boards;
import org.springframework.social.pinterest.api.Data;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.api.PinterestError;
import org.springframework.social.pinterest.api.impl.PinterestTemplate;

public class BoardsTest {

	String key = "4807113954438426320";
	String token = "AZNTDA3sbdXlTuq7EmVWV-A2Sx29FCAfWKqyZWlCtluhkKAsGwAAAAA";

	Pinterest pinterest = null;

	@Before
	public void before() {
		pinterest = new PinterestTemplate(token, key);
	}

	@Test
	public void createTest() {
		final Data<Boards> me = pinterest.boardsOperations().create("개발 테스트 보드","");
		System.out.println(me.getData().getCreated_at());
		System.out.println(me.getData().getCounts());
		System.out.println(me.getData().getPrivacy());
		System.out.println(me.getData().getId());
		System.out.println(me);
	}
	@Test
	public void deleteTest() {
		pinterest.boardsOperations().delete("174303516767217598");
	}
	@Test
	public void patchTest() {
		final Data<Boards> data = pinterest.boardsOperations().patch("174303516767217601", "변경", "ggg", "");
		System.out.println(data);
	}
	
	@Test
	public void getTest() {
		final Data<Boards> data = pinterest.boardsOperations().getBoard("174303516767217394");
		System.out.println(data.getData().getName());
		System.out.println(data.getData().getDescription());
		System.out.println(data);
	}
	
	@Test
	public void getPinTest() {
		final Data<List<BoardPin>> data = pinterest.boardsOperations().getPin("174303516767217394");
		System.out.println(data);
		System.out.println(data.getData().get(0).getMetadata().getLink());
	}
	
	@Test
	public void getPinCursor() {
		final Data<List<BoardPin>> data1 = pinterest.boardsOperations().getPinCursor("174303516767217394","LT4xNzQzMDM0NDgwNTYxNjE1NDk6MXxiNzc1NWM2MmZiMTc4MzdiY2M3ZjhlN2YwMTdjMjM0NDViZDBiZDZmOTJkNmJjM2JkNGEzZDBhYmMxMzdiMDQ5",2);
		System.out.println(data1);
		System.out.println(data1.getData().get(0).getMetadata().getLink());
	}
	
	@Test
	public void getPinNext() {
		final Data<List<BoardPin>> data1 = pinterest.boardsOperations().getPinNext("https://api.pinterest.com/v1/boards/174303516767217394/pins/?cursor=LT4xNzQzMDM0NDgwNTYxNjE1NDk6MXxiNzc1NWM2MmZiMTc4MzdiY2M3ZjhlN2YwMTdjMjM0NDViZDBiZDZmOTJkNmJjM2JkNGEzZDBhYmMxMzdiMDQ5&access_token=AQu5e3Fi7rzQIqdXHBHYHAZDTrpyFCBUdEkqCahCtpUcQ6AsowAAAAA&limit=1&fields=id%2Clink%2Cnote%2Curl%2Cmedia%2Cmetadata%2Ccolor%2Ccounts%2Ccreated_at%2Ccreator%2Coriginal_link%2Cboard%2Cattribution%2Cimage");
		System.out.println(data1);
		System.out.println(data1.getData().get(0).getMetadata().getLink());
	}
}
