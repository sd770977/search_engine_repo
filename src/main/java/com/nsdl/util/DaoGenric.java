package com.nsdl.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoGenric {
	public static void cleanUp(Session session, Transaction tr) {
		if (session != null) {
			if (tr != null) {
				tr.commit();
			}
			session.close();
		}
	}
}
