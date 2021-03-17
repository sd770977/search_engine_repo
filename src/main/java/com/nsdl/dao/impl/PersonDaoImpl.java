package com.nsdl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsdl.dao.PersonDao;
import com.nsdl.entity.Person;
import com.nsdl.util.DaoGenric;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Person> fethcAllDetails(String searchText) {
		Session session = null;
		Transaction transaction = null;
		List<Person> plist = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String hql = "select distinct p.country from Person p where lower(p.country) like lower(:country) order by p.country asc";
			Query<Person> query = session.createQuery(hql);
			query.setParameter("country", searchText + "%");
			query.setMaxResults(10);

			plist = query.getResultList();
			System.out.println(plist);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			DaoGenric.cleanUp(session, transaction);
		}
		return plist;
	}

}
