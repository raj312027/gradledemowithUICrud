package com.demogradle.gradledemo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demogradle.gradledemo.custom.exceptions.CustomValidationEx;
import com.demogradle.gradledemo.custom.exceptions.CustomerException;
import com.demogradle.gradledemo.customer.service.CustomerService;
import com.demogradle.gradledemo.customer.service.SecurityUserService;
import com.demogradle.gradledemo.customer.service.TransactionUserService;
import com.demogradle.gradledemo.model.BudgetMaster;
import com.demogradle.gradledemo.model.Customer;
import com.demogradle.gradledemo.model.ProductDetails;
import com.demogradle.gradledemo.model.SecurityUser;
import com.demogradle.gradledemo.model.TransactionEntity;
import com.demogradle.gradledemo.product.service.ProductService;
import com.demogradle.gradledemo.ui.beans.UserBean;

@RestController
public class HomeController {

	@Autowired
	private CustomerService custService;

	@Autowired
	private TransactionUserService txUser;

	@Autowired
	private SecurityUserService securityUserService;

	@Autowired
	private ProductService prdService;

	@PostMapping("/saveCustomer")
	public Customer createCustomer(@RequestBody Customer cust) throws Exception {

		custService.createCustomer(cust);
		return cust;
	}

	@GetMapping(value = "/getCustomerById/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {

		Optional<Customer> cust = custService.findCustomerById(id);
		if (!cust.isPresent())
			throw new CustomerException();

		return ResponseEntity.ok().body(cust.get());
	}

	@GetMapping(value = "/getCustomerByXml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserBean> getCustomerAsXml() {

		return ResponseEntity.ok().body(new UserBean());
	}

	@PostMapping("/createUser")
	public String createUser(@Valid @RequestBody SecurityUser user, BindingResult rs, HttpSession session)
			throws Exception {

		if (!rs.hasErrors()) {
			if (securityUserService.createUser(user)) {
				return "User created successfully";
			}

			throw new CustomerException();
		} else {
			session.setAttribute("bindingRs", rs);
			throw new CustomValidationEx();
		}
	}

	@PostMapping(value = "/maketransaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String makeTransaction(@RequestBody TransactionEntity txn) {
		txUser.makeTransaction(txn);
		return "Transaction successfully";
	}

	@PostMapping(value = "/creaeprod", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createProduct(@RequestBody ProductDetails prd) {
		prdService.createProductDetails(prd);
		return prd.toString();
	}

	@GetMapping("/getById/{id}")
	public ProductDetails getProductById(@PathVariable int id) {

		return prdService.findByProductId(id);

	}

	@GetMapping("/getAllProducts")
	public Page<ProductDetails> findAllProducts() // @PageableDefault(value=2,page=2)
													// Pageable pageable) {
	{
		Pageable pageable = PageRequest.of(0, 4);
		return prdService.findAll(pageable);
	}

	@GetMapping("/getByProductName")
	// @RequestParam("sort") String sort,
	public Page<ProductDetails> findByProductName(
			@SortDefault(sort = "productName", direction = Direction.DESC) Pageable pageable) {
		return prdService.getProdRepo().findAll(pageable);
	}

	@PostMapping(value = "/checkJSONResponse", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ProductDetails checkJsonResponse(@RequestBody ProductDetails prd) {
		return prd;
	}
	
	@PostMapping("/saveBudget")
	public String saveBudget() {
		custService.saveBudget();
		return "budget saved successfull";
	}
	
	@GetMapping("/getBudgetById")
	public  BudgetMaster getBudget(@RequestParam String budgetId){
		return custService.getBudgetMaster(budgetId);
	}
	
	@GetMapping("/getAllBudgets")
	public List<BudgetMaster> getBudgetList(){
		return custService.getBudgetList();
	}
}
