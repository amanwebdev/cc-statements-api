package com.statements.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cc_holder")

public class CcHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private Integer limitBal;
	private Integer sex;
	private Integer education;
	private Integer marriage;
	private Integer age;
	private Integer repaySep;
	private Integer repayAug;
	private Integer repayJul;
	private Integer repayJun;
	private Integer repayMay;
	private Integer repayApril;
	private Integer billAmtSep;
	private Integer billAmtAug;
	private Integer billAmtJul;
	private Integer billAmtJun;
	private Integer billAmtMay;
	private Integer billAmtApril;
	private Integer paymentSep;
	private Integer paymentAug;
	private Integer paymentJul;
	private Integer paymentJun;
	private Integer paymentMay;
	private Integer paymentApril;
	private Integer defaultPaymentNextMonth;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLimitBal() {
		return limitBal;
	}
	public void setLimitBal(Integer limitBal) {
		this.limitBal = limitBal;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getRepaySep() {
		return repaySep;
	}
	public void setRepaySep(Integer repaySep) {
		this.repaySep = repaySep;
	}
	public Integer getRepayAug() {
		return repayAug;
	}
	public void setRepayAug(Integer repayAug) {
		this.repayAug = repayAug;
	}
	public Integer getRepayJul() {
		return repayJul;
	}
	public void setRepayJul(Integer repayJul) {
		this.repayJul = repayJul;
	}
	public Integer getRepayJun() {
		return repayJun;
	}
	public void setRepayJun(Integer repayJun) {
		this.repayJun = repayJun;
	}
	public Integer getRepayMay() {
		return repayMay;
	}
	public void setRepayMay(Integer repayMay) {
		this.repayMay = repayMay;
	}
	public Integer getRepayApril() {
		return repayApril;
	}
	public void setRepayApril(Integer repayApril) {
		this.repayApril = repayApril;
	}
	public Integer getBillAmtSep() {
		return billAmtSep;
	}
	public void setBillAmtSep(Integer billAmtSep) {
		this.billAmtSep = billAmtSep;
	}
	public Integer getBillAmtAug() {
		return billAmtAug;
	}
	public void setBillAmtAug(Integer billAmtAug) {
		this.billAmtAug = billAmtAug;
	}
	public Integer getBillAmtJul() {
		return billAmtJul;
	}
	public void setBillAmtJul(Integer billAmtJul) {
		this.billAmtJul = billAmtJul;
	}
	public Integer getBillAmtJun() {
		return billAmtJun;
	}
	public void setBillAmtJun(Integer billAmtJun) {
		this.billAmtJun = billAmtJun;
	}
	public Integer getBillAmtMay() {
		return billAmtMay;
	}
	public void setBillAmtMay(Integer billAmtMay) {
		this.billAmtMay = billAmtMay;
	}
	public Integer getBillAmtApril() {
		return billAmtApril;
	}
	public void setBillAmtApril(Integer billAmtApril) {
		this.billAmtApril = billAmtApril;
	}
	public Integer getPaymentSep() {
		return paymentSep;
	}
	public void setPaymentSep(Integer paymentSep) {
		this.paymentSep = paymentSep;
	}
	public Integer getPaymentAug() {
		return paymentAug;
	}
	public void setPaymentAug(Integer paymentAug) {
		this.paymentAug = paymentAug;
	}
	public Integer getPaymentJul() {
		return paymentJul;
	}
	public void setPaymentJul(Integer paymentJul) {
		this.paymentJul = paymentJul;
	}
	public Integer getPaymentJun() {
		return paymentJun;
	}
	public void setPaymentJun(Integer paymentJun) {
		this.paymentJun = paymentJun;
	}
	public Integer getPaymentMay() {
		return paymentMay;
	}
	public void setPaymentMay(Integer paymentMay) {
		this.paymentMay = paymentMay;
	}
	public Integer getPaymentApril() {
		return paymentApril;
	}
	public void setPaymentApril(Integer paymentApril) {
		this.paymentApril = paymentApril;
	}
	public Integer getDefaultPaymentNextMonth() {
		return defaultPaymentNextMonth;
	}
	public void setDefaultPaymentNextMonth(Integer defaultPaymentNextMonth) {
		this.defaultPaymentNextMonth = defaultPaymentNextMonth;
	}
	
	

	
}
