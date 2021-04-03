package com.nitc.hibernate.component.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nitc.hibernate.component.model.Address;
import com.nitc.hibernate.component.model.Person;
import com.nitc.hibernate.component.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try 
		{
			txn.begin();
			//Person having 1 Address  
			/*
			Address address = new Address("200 E Main St", "Seattle", "85123");
			Person person = new Person("Ruby", address);	
			session.save(person);   */			
			//---------------------------------------------------------------------------------------

			//Person having 2 Address (homeAddress and billingAddress) using AttributeOverrides
			
			Address homeAddress = new Address("200 E Main St", "Seattle", "85123");
			
			Address billingAddress = new Address("2751  Sigley Road", "Charlotte", "28273");
			
			Person person = new Person("Ruby", homeAddress, billingAddress);      			
	
			session.save(person);
    		
    		txn.commit();
		}	
		catch(Exception e) 
		{
    			if(txn != null) 
    			{ 
    				txn.rollback(); 
    			}
    			e.printStackTrace();
		}	
		finally 
		{
				if(session != null) 
				{ 
					session.close(); 
				}
		}

    }
}
