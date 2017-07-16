package com.statements.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface CcHolderDao extends CrudRepository<CcHolder, Long> {
	
	@Query(nativeQuery=true, value="SELECT * FROM cc_holder cc WHERE cc.id like :ID limit :start,:end")
	public List<CcHolder> findAllFor(@Param(value="ID") String id,@Param("start") Long start, @Param("end") Long end);

	public Page<CcHolder> findByNameLikeIgnoreCase(String name, Pageable pageable);

	public Page<CcHolder> findAll(Pageable pageable);

	public Page<CcHolder> findByRepaySepGreaterThanOrderById(int repaySep, Pageable pageable);
	
	@Query(nativeQuery=true, value="SELECT SUM(payment_april) AS paymentApril, SUM(payment_may) AS paymentMay, SUM(payment_jun) AS paymentJun,"
			+ "SUM(payment_jul) AS paymentJul, SUM(payment_aug) AS paymentAug, SUM(payment_sep) AS paymentSep FROM cc_holder where marriage=:maritalStatus")
	public String findPaymentsSum(@Param("maritalStatus") int maritalStatus);
	
	@Query(nativeQuery=true, value="SELECT SUM(payment_april) AS paymentApril, SUM(payment_may) AS paymentMay, SUM(payment_jun) AS paymentJun,"
			+ "SUM(payment_jul) AS paymentJul, SUM(payment_aug) AS paymentAug, SUM(payment_sep) AS paymentSep FROM cc_holder where education=:education")
	public String findPaymentsEducationSum(@Param("education") int education);
	
	@Query(nativeQuery=true, value="SELECT age, SUM(payment_sep) AS paymentSep, SUM(payment_aug) AS paymentAug, SUM(payment_jul) AS paymentJul,"
			+ " SUM(payment_jun) AS paymentJun, SUM(payment_may) AS paymentMay, SUM(payment_april) AS paymentApril FROM cc_holder GROUP BY age")
	public List<Object[]> findPaymentsAgeSum();

}
