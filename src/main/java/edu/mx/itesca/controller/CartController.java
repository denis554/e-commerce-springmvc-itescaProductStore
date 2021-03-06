package edu.mx.itesca.controller;

import edu.mx.itesca.model.Customer;
import edu.mx.itesca.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dario on 08/11/2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User active_user) {
        Customer customer = customerService.getCustomerByUsername(active_user.getUsername());
        int cart_id = customer.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }

    @RequestMapping("/{cart_id}")
    public String getCartRedirect(@PathVariable(value = "cart_id")int cart_id, Model model) {
        model.addAttribute(cart_id);

        return "carroCompras";
    }

}
