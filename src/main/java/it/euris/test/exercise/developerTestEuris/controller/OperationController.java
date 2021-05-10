package it.euris.test.exercise.developerTestEuris.controller;

import it.euris.test.exercise.developerTestEuris.dao.IOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private IOperations operation;

    @GetMapping("/{values}")
    public String operation(@PathVariable String values){
        String doing = "";
        if (values.contains("+")) {
            doing = operation.sum(values);
        } else if (values.contains("-")) {
            doing = operation.subtraction(values);
        } else if (values.contains("*")) {
            doing = operation.moltiplication(values);
        }
        return doing;
    }

    @GetMapping("/{firstOperand} / {secondOperand}")
    public String operation(@PathVariable String firstOperand, @PathVariable String secondOperand){
        return operation.division(firstOperand, secondOperand);
    }

}
