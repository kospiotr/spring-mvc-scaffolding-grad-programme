package com.gft.grad.app.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

public class Loan {

	private Integer id;

	@Length(max = 255)
	private String purpose;

	@Length(max = 128)
	private String requester;

	@Range(min = 10, max = 1000000)
	private BigDecimal amount;

	public Loan() {
	}

	public Loan(Integer id, String purpose, String requester, BigDecimal amount) {
		this.id = id;
		this.purpose = purpose;
		this.requester = requester;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Loan loan = (Loan) o;

		return !(id != null ? !id.equals(loan.id) : loan.id != null);

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Loan{" +
				"id=" + id +
				", requester='" + requester + '\'' +
				", purpose='" + purpose + '\'' +
				", amount=" + amount +
				'}';
	}
}
