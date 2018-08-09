package com.carthurnau.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carthurnau.relationships.models.License;
import com.carthurnau.relationships.models.Person;
import com.carthurnau.relationships.services.LicenseService;
import com.carthurnau.relationships.services.PersonService;

@Controller
public class homeController {
	
	private final PersonService personService;
	
	private final LicenseService licenseService;

	public homeController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		
		// get all people from the database for the table
		List<Person> allPersons = personService.findAll();
		model.addAttribute("allPersons",allPersons);
		
		return "index.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		
		// get the person object
		Person person = personService.findById(id);
		model.addAttribute("person",person);
		
		return "showPerson.jsp";
		
	}
	
	@RequestMapping("/persons/new")
	public String showNewPersonForm(Model model) {
		Person person = new Person();
		model.addAttribute("person",person);
		return "newPersonForm.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String showNewLicenseForm(Model model) {
		
		// get all people from the database for the drop down menu
		List<Person> allPersons = personService.findAll();
		model.addAttribute("allPersons",allPersons);
		
		// create a license object for the binding
		License license = new License();
		model.addAttribute("license",license);
		
		return "newLicenseForm.jsp";
	}
	
	@RequestMapping(value="/processNewPerson", method=RequestMethod.POST)
	public String processNewPerson(Model model, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("person",person);
			return "newPersonForm.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/processNewLicense", method=RequestMethod.POST)
	public String processNewLicense(Model model, @Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			
			System.out.println("has errors: " + license.getState() );
			
			// get all people from the database for the drop down menu
			List<Person> allPersons = personService.findAll();
			model.addAttribute("allPersons",allPersons);
			
			// create a license object for the binding			
			model.addAttribute("license",license);
			return "newLicenseForm.jsp";
			
		} else {
			
			licenseService.createLicense(license);
			
			System.out.println("Completed call to create License");
			return "redirect:/";
		}

	}
}
