package com.rafaelrahn.demospringrrr.customer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class CustomerController {
  private List<CustomerDTO> customers = new ArrayList<>();

  CustomerController() {
      customers.add(new CustomerDTO(1, "Rafael", "rafael.rahn@live.com"));
      customers.add(new CustomerDTO(2, "Ronaldo", "ronaldo.rahn@live.com"));
  }

  @GetMapping
  List<CustomerDTO> findAll() {
      return customers;
  }

  @PostMapping
  void add(@RequestBody CustomerDTO customer) {
      customers.add(customer);
  }
}
