package com.api.controllers;

import com.api.exeception.UnsupportedMathOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {


    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public  Double sum(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public  Double subtract(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public  Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public  Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/squareRoot/{number}")
    public  Double squareRoot(
            @PathVariable("number") String number
    ) throws Exception {
        if(!isNumeric(number)) throw new UnsupportedMathOperation("Please set a numeric value!");

        double n = convertToDouble(number);
        if (n < 0) throw new UnsupportedMathOperation("n must be >= 0");

        return Math.sqrt(n);
    }


    private Double convertToDouble(String strNumber) throws IllegalAccessException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperation("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return  false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
