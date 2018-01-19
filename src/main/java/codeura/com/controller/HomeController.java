package codeura.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import codeura.com.model.Customer;
import codeura.com.repository.CustomerRepository;

@Controller
public class HomeController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/init-data")
	@ResponseBody
	public String init(Model model) {
		for(int i=0; i<10; i++){
			Customer customer = new Customer("CC" + i,"Customer" + i, "012345678" + i, "customer" + i + "@codeura.com", new Date());
			customerRepository.save(customer);
		}
        return "Inserted";
    }
	@RequestMapping("/list")
    public String home(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }
	@RequestMapping("/view")
    public String view(@ModelAttribute Customer customer, @RequestParam(defaultValue="1") String customerId, Model model) {
		customer = customerRepository.findOneByCid(customerId);
		model.addAttribute("customer", customer);
		return "view";
	}
	@RequestMapping(value = {"/update", "/new"})
    public String update(@RequestParam(defaultValue="") String customerId, Model model) {
		model.addAttribute("customer", new Customer());
		if(customerId.isEmpty()){
			return "update";
		}
		model.addAttribute("customer", customerRepository.findOneByCid(customerId));
		return "update";
	}
	@RequestMapping(value ="/update/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute Customer customer, Model model) {
		if(customer.getId()!=0){
			customer.setDate(customerRepository.findById(customer.getId()).getDate());
		}
		customerRepository.save(customer);
		return "redirect:/update?customerId=" + customer.getCid();
	}
}
	
