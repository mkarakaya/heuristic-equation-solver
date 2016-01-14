package com.equationsolver;

import java.util.List;

import exceptions.MaxTryCountExceededException;
import exceptions.NoSolutionException;
import model.Variable;

public class App {

	public static void main(String[] args) throws MaxTryCountExceededException, NoSolutionException {
	   EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("-7a+2b-3c-4d+34e-17f+1000g=617");
       EquationValidator validator= new EquationValidator();
       System.out.println(validator.getResult(solve));
       for(Variable var: solve){
    	   System.out.println(var.getMultiplier()+";"+var.getName()+";"+var.getValue());
       }

	}

}
