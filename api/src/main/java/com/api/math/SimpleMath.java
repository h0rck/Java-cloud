package com.api.math;

import com.api.exeception.UnsupportedMathOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    public  Double sum(
            Double numberOne,
            Double numberTwo
    ) throws Exception {
        return numberOne + numberTwo;
    }

    public  Double subtract(
           Double numberOne,
           Double numberTwo
    ) throws Exception {
        return numberOne - numberTwo;
    }

    public  Double multiplication(
           Double numberOne,
           Double numberTwo
    ) throws Exception {
        return numberOne * numberTwo;
    }


    public  Double division(
           Double numberOne,
           Double numberTwo
    ) throws Exception {
       return numberOne / numberTwo;
    }

    public  Double squareRoot(
            Double number
    ) throws Exception {
        return Math.sqrt(number);
    }

}
