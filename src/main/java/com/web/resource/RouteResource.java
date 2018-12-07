package com.web.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteResource {

	// Route mapping to go index template
	@RequestMapping(value = { "/", "/index" })
	public String getIndex() {
		return "/index";
	}
}
