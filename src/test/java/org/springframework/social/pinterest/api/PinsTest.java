package org.springframework.social.pinterest.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.pinterest.api.impl.PinterestTemplate;

public class PinsTest {

	// insert token
	String token = "";

	Pinterest pinterest = null;

	@Before
	public void before() {
		pinterest = new PinterestTemplate(token);
	}

	@Test
	public void createTest() {
		PinsData pinsData = new PinsData();
		pinsData.setBoard("174303516767217394");
		pinsData.setNote("pin create");
		pinsData.setLink("http://google.co.kr");
		pinsData.setImage_url("http://www.menucool.com//slider/jsImgSlider/images/image-slider-2.jpg");
//		Resource resource = new FileSystemResource("C:\\Users\\Public\\Pictures\\Sample Pictures\\apple_PNG13.png");
//		pinsData.setImage(resource);
		Data<Pins> pin = pinterest.pinsOperations().create(pinsData);
		System.out.println(pin);
	}

	@Test
	public void deleteTest() {
		// pinterest.pinsOperations().delete("174303448056164828");
	}

	@Test
	public void patchTest() {
		PinsData pinsData = new PinsData();
		pinsData.setNote("pin patch u000");
//		pinsData.setLink("http://google.co.kr");
		final Data<Pins> patch = pinterest.pinsOperations().patch("174303448056273433", pinsData);
		System.out.println(patch);

	}

	@Test
	public void get() {
		Data<Pins> pin = pinterest.pinsOperations().get("174303448056164842");
		System.out.println(pin.getData().getNote());
		System.out.println(pin);
	}

}
