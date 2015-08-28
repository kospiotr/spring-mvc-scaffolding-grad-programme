package com.gft.grad.app.repository;

import com.gft.grad.app.model.Loan;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository {

	private List<Loan> loans = new ArrayList<>();

	public LoanRepository() {
		loans.add(new Loan(0, "For the journey", "Piotr Kosmowski", new BigDecimal(10000)));
		loans.add(new Loan(1, "For the car", "Piotr Kosmowski", new BigDecimal(30000)));
		loans.add(new Loan(2, "For the books", "Piotr Kosmowski", new BigDecimal(300)));
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public Loan getById(Integer id) {
		for (Loan loan : loans) {
			if (id.equals(loan.getId())) {
				return loan;
			}
		}
		return null;
	}

	public Loan add(Loan loan) {
		loan.setId(loans.size());
		loans.add(loan);
		return loan;
	}

	public void remove(Integer id) {
		Loan foundRecord = getById(id);
		if (foundRecord != null) {
			loans.remove(foundRecord);
		}
	}

	public Loan save(Loan loan) {
		if (loan.getId() == null) {
			return add(loan);
		} else {
			return update(loan);
		}
	}

	private Loan update(Loan loan) {
		int index = loans.indexOf(loan);
		loans.set(index, loan);
		return loan;
	}
}
