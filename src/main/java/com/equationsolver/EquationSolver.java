package com.equationsolver;

import java.util.List;
import java.util.Random;

import exceptions.MaxTryCountExceededException;
import exceptions.NoSolutionException;
import model.Variable;

public class EquationSolver {

	//probability of mutation which is less than 100. 1 means 1%. usage is same with genetic algorithms.  
	private static final int MUTATION=1;
	private static final double LEARNING_RATE=0.6;
	private static final String EQUALS = "=";
	private int maxTry;
	public EquationSolver(int maxTry){
		this.maxTry=maxTry;
	}
	
	public EquationSolver(){
		//try until the solution is found.
		maxTry=-1;
	}
	
	public List<Variable> solve(String equation) throws NoSolutionException, MaxTryCountExceededException{
		
		int expected = Integer.parseInt(equation.substring(equation.indexOf(EQUALS)+1));
		EquationConverter mathEquation=new EquationConverter();
		List<Variable>variables=mathEquation.convertVariables(equation, expected);
		EquationValidator validator= new EquationValidator();
		validator.isFeasible(variables, expected);
		
		
		
		Random random= new Random();
		int tryCount=0;
		int result=validator.getResult(variables);
		while(true){
			int error=expected- result;
			if(error==0){
				break;
			}
			
			
			for(Variable variable:variables){
				//change value of the variable less or equal to error.
				int change=random.nextInt(Math.abs(error));
				//if learning rate is low, we will take small steps. 
				int effect=(int) ((Math.max(change * LEARNING_RATE,1)));
				//we will increase or decrease the multipliers regarding the error.
				int direction= error > 0 ? 1 : -1;
				effect=effect*direction;
				//we need mutation with low probability. algorithm may stuck with same values.
				if(MUTATION >random.nextInt(1000)){
					effect=effect*-1;
				}
				variable.setValue((int) (Math.max(variable.getValue()+effect,1)));
			}
			
			result=validator.getResult(variables);
			tryCount++;
			if(maxTry!=-1 && tryCount>=maxTry){
				throw new MaxTryCountExceededException();
			}
		}
		
		
		return variables;
	}

	
}
