package com.gft.grad.app.services;

import com.gft.grad.app.model.Loan;
import com.gft.grad.app.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;


	public List<Loan> findAllLoans() {
		return loanRepository.getLoans();
	}

	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}

	public Loan getById(Integer id) {
		return loanRepository.getById(id);
	}

	public void delete(Integer id) {
		loanRepository.remove(id);
	}
}
