package com.nsdl.dao;

import java.util.List;

import com.nsdl.entity.Person;

public interface PersonDao {

	public List<Person> fethcAllDetails(String searchText);
}
