package se.samer.bokbubblan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoanController {

    @GetMapping("/loan_info")
    public String showLoanInfo() {
        return "loan_info";
    }

    @PostMapping("/loan")
    public String processLoanRequest(@RequestParam("email") String email) {
        //låtsas skicka ett mail
        return "redirect:/loan_confirmation";
    }

    @GetMapping("/loan_confirmation")
    public String showLoanConfirmation() {
        return "loan_confirmation";
    }
}
