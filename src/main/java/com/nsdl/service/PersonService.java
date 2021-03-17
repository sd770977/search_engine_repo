package com.nsdl.service;

import java.util.List;

import com.nsdl.entity.Person;

public interface PersonService {
	List<Person> fetchAllDetails(String searchText);
}
