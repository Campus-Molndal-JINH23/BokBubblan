package se.samer.bokbubblan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanControllerTest {

    @Test
    public void testShowLoanInfo() {
        //arrange
        LoanController loanController = new LoanController();
        //act
        String viewName = loanController.showLoanInfo();
        //assert
        assertEquals("loan_info", viewName);
    }

    @Test
    public void testShowLoanConfirmation() {
        //arrange
        LoanController loanController = new LoanController();
        //act
        String viewName = loanController.showLoanConfirmation();
        //assert
        assertEquals("loan_confirmation", viewName);
    }
    // processLoanRequest() testas manuellt
}
