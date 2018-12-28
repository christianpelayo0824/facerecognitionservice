package com.web.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Root Controller link from thymeleaf template
*/
@Controller
public class RouteResource {

	/*
	 * Ridect to the index
	 */
	@GetMapping(value = { "/", "/index" })
	public String getIndex() {
		return "/index";
	}

}
