package one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.hql.internal.ast.tree.SelectExpressionList;

import one_to_many_uni.dto.Company;

public class CompanyDao {

	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();

	}

	public void saveCompany(Company company) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(company);
		entityTransaction.commit();
	}

	public void updateCompany(int id, Company company) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company recievedcompany = entityManager.find(Company.class, id);
		if (recievedcompany != null) {
			company.setId(id);
			company.setList(recievedcompany.getList());
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
		} else
			System.out.println("company doesn't exists");
	}

	public void deleteCompany(int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company company = entityManager.find(Company.class, id);
		entityTransaction.begin();

		entityManager.remove(company);
		entityTransaction.commit();

	}

	public void getCompanyById(int id) {
		EntityManager entityManager = geEntityManager();

		Company company = entityManager.find(Company.class, id);
		System.out.println(company);

	}

	public void getAllCompany() {
		EntityManager entityManager = geEntityManager();
		Query query = entityManager.createQuery("select c from Company c");
		List<Company> list = query.getResultList();
		System.out.println(list);

	}
}
