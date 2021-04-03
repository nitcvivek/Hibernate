package com.nitc.hibernate.orphanremoval;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nitc.hibernate.orphanremoval.model.Student;
import com.nitc.hibernate.orphanremoval.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class OrphanRemovalApp 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try 
		{
			txn.begin();
	
			Student student = (Student) session.get(Student.class, 2L);
			session.delete(student);

			txn.commit();
		}	
		catch(Exception e) 
		{
    			if(txn != null) { txn.rollback(); }
    			e.printStackTrace();
		}	
		finally 
		{
				if(session != null) { session.close(); }
		}

    }
}
