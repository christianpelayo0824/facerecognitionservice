package com.web.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteResource {

	@GetMapping(value = { "/", "/index" })
	public String getIndex() {
		return "/index";
	}

}
