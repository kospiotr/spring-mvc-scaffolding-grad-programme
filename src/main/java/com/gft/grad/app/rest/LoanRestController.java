package com.gft.grad.app.rest;

import com.gft.grad.app.model.Loan;
import com.gft.grad.app.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/loan")
public class LoanRestController {

	private Logger logger = Logger.getLogger(LoanRestController.class.getName());

	@Autowired
	private LoanService loanService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Loan> findAll() {
		return loanService.findAllLoans();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Loan getById(@PathVariable("id") Integer id) {
		return loanService.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Loan create(@RequestBody Loan loan) {
		loan.setId(null);
		return loanService.save(loan);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Loan put(@PathVariable("id") Integer id, @RequestBody Loan loan) {
		loan.setId(id);
		return loanService.save(loan);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		loanService.delete(id);
	}

}
