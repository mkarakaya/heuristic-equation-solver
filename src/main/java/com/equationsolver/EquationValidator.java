package com.equationsolver;

import java.math.BigInteger;
import java.util.List;

import exceptions.GCDNotFitsException;
import exceptions.LessThanMinResultException;
import exceptions.NoSolutionException;
import model.Variable;

/**
 * checks min result and GCD
 * @author p.bell
 *
 */
public class EquationValidator {
	
	
	/**
	 * returns the result of the variables in list.
	 * @param variables
	 * @return
	 */
	public int getResult(List<Variable> variables) {
		int result=0;
		for(Variable variable : variables){
			result+= variable.getValue()*variable.getMultiplier();
		}
		return result;
	}
	
	public boolean isFeasible(List<Variable> variables,int expected) throws NoSolutionException{
		if(isAllPositive(variables)){
			if(lessThanMinResult(variables,expected)){
				throw new LessThanMinResultException();
			}
			if(!greatestCommonDivisorFits(variables,expected)){
				throw new GCDNotFitsException();
			}
		}
		return true;
	}

	/**
	 * greatestCommonDivisor for multipliers of variables should be divided by result (expected)
	 * ex: 3x + 6y = 20 should return false since gcd(3,6)=3 and 20/3 is not an integer.  
	 *  gcd(a,b,c)=gcd(a,(gcd(b,c))
	 * @param variables
	 * @param expected
	 * @return
	 */
	private boolean greatestCommonDivisorFits(List<Variable> variables, int expected) {
		if(variables.size()>=2){
			int gcd=variables.get(0).getMultiplier();
			for(int i=1;i<variables.size();i++){
				Variable var=variables.get(i);
				gcd=getGcd(gcd, var.getMultiplier());
			}
			return expected % gcd==0;
		}
		return true;
	}

	private int getGcd(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	/**
	 * assumes that value of variables are 1 and multipliers are positive 
	 * @param variables
	 * @param expected
	 * @return
	 */
	private boolean lessThanMinResult(List<Variable> variables, int expected) {
		int minResult=0;
		for(Variable var: variables){
			minResult+=var.getMultiplier();
		}
		return minResult>expected;
	}

	private boolean isAllPositive(List<Variable> variables) {
		for(Variable var: variables){
			if(var.getMultiplier()<0){
				return false;
			}
		}
		return true;
	}
}
