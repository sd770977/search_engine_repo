package com.nsdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsdl.entity.Person;
import com.nsdl.exception.SearchTextCannotBeNullOrEmptyException;
import com.nsdl.service.PersonService;

@Controller
@RequestMapping("/load")
public class SerachController {
	@Autowired
	private PersonService personService;

	static {
		System.out.println("inside controller");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fetch")
	public @ResponseBody List<Person> getView(@RequestParam("searchText") String searchText) {
		if (searchText == null || searchText.isEmpty()) {
			throw new SearchTextCannotBeNullOrEmptyException();
		} else {
			List<Person> plist = personService.fetchAllDetails(searchText);
			return plist;
		}
	}
}
