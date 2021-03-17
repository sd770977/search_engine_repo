package com.nsdl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsdl.dao.PersonDao;
import com.nsdl.entity.Person;
import com.nsdl.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao persondao;

	@Override
	public List<Person> fetchAllDetails(String searchText) {
		return persondao.fethcAllDetails(searchText);
	}

}