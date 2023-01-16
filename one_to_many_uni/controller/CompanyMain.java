package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dao.CompanyDao;
import one_to_many_uni.dto.Company;
import one_to_many_uni.dto.Employee;

public class CompanyMain {
	public static void main(String[] args) {
		Employee e1= new Employee();
		e1.setName("Raj");
		e1.setAddress("Bangalore");
		e1.setPhone(7741852);
		
		Employee e2= new Employee();
		e2.setName("Suresh");
		e2.setAddress("Gadag");
		e2.setPhone(852369);
		
		Employee e3= new Employee();
		e3.setName("Ram");
		e3.setAddress("Dvg");
		e3.setPhone(789456);
		
		Company company= new Company();
//		company.setName("TY");
//		company.setGst("XYZ123");
		
//		List<Employee> list= new ArrayList<Employee>();
//		list.add(e1);
//		list.add(e2);
//		list.add(e3);
//		
//		company.setList(list);
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		company.setName("TESTYANTRA");
		company.setGst("abc123");
		
		CompanyDao companyDao= new CompanyDao();
		companyDao.updateCompany(1, company);
		
//		entityTransaction.begin();
//		entityManager.persist(e1);
//		entityManager.persist(e2);
//		entityManager.persist(e3);
//		entityManager.persist(company);
		
//		entityManager.merge(company);
		
//		entityTransaction.commit();
	
		
	}
}

