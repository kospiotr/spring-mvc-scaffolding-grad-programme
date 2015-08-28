package com.gft.grad.app.controllers;

import com.gft.grad.app.model.Loan;
import com.gft.grad.app.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class LoanController {

	private Logger logger = Logger.getLogger(LoanController.class.getName());

	@Autowired
	private LoanService loanService;

	@RequestMapping(value = "/loan-list.html", method = RequestMethod.GET)
	public String showAllLoans(Model model) {
		model.addAttribute("loans", loanService.findAllLoans());
		return "loans";
	}

	@RequestMapping(value = "/loan-new.html", method = RequestMethod.GET)
	public String showNewLoan(Model model) {
		Loan loan = new Loan();
		model.addAttribute("loan", loan);
		return "loan";
	}

	@RequestMapping(value = "/loan-new.html", method = RequestMethod.POST)
	public String saveLoan(@Valid @ModelAttribute("loan") Loan loan,
	                       BindingResult bindingResult,
	                       Model model,
	                       RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "loan";
		} else {
			Loan createdLoan = loanService.save(loan);
			redirectAttributes.addFlashAttribute("msg", "Record saved successfully!");
			return "redirect:loan-edit.html?id=" + createdLoan.getId();
		}
	}

	@RequestMapping(value = "/loan-edit.html", method = RequestMethod.GET)
	public String showEditLoan(@RequestParam(value = "id") Integer loanId, Model model) {
		Loan loan = loanService.getById(loanId);
		model.addAttribute("loan", loan);
		return "loan";
	}

	@RequestMapping(value = "/loan-delete.html", method = RequestMethod.POST)
	public String deleteLoan(@RequestParam(value = "id", required = true) Integer loanId, Model model) {
		loanService.delete(loanId);
		return "redirect:loan-list.html";
	}

}
