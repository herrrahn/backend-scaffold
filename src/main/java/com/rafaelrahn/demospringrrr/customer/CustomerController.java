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
//        for (int i = 0; i < 2000000000; i++) { }
        return customers;
    }

    @GetMapping(value = "/{id}")
    CustomerDTO find(@PathVariable(value = "id") Integer id) {
        return this.customers
                .stream()
                .filter(c -> c.getCust_id().equals(id))
                .findAny()
                .orElse(null);
    }

    @PostMapping
    void add(@RequestBody CustomerDTO customer) {
        customers.add(customer);
    }

    @GetMapping(value = "validate")
    Boolean validate(@RequestParam(value = "old_password") String oldPassword, @RequestParam(value = "new_password") String newPassword) {
        for (int i = 0; i < newPassword.length() - 2; i++) {
            String fragment = newPassword.substring(i, i + 3);
            if (oldPassword.contains(fragment)) {
                return false;
            }
        }

        return true;
    }
}
