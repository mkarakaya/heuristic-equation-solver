package com.equationsolver;

import java.util.ArrayList;
import java.util.List;

import exceptions.GCDNotFitsException;
import exceptions.LessThanMinResultException;
import exceptions.NoSolutionException;
import junit.framework.TestCase;
import model.Variable;

public class ValidatorTest extends TestCase
{
	
	
    public void testSolutionExists() throws NoSolutionException 
    {
       
    	EquationValidator validator= new EquationValidator();
    	List<Variable> variables=new ArrayList<Variable>();
    	Variable var= new Variable("a", 3, 3);
    	variables.add(var);
    	Variable var2= new Variable("b", 2, 2);
    	variables.add(var2);
    	assertTrue(validator.isFeasible(variables, 10));
    }
    
    public void testSolutionExistsMinus() throws NoSolutionException 
    {
       
    	EquationValidator validator= new EquationValidator();
    	List<Variable> variables=new ArrayList<Variable>();
    	Variable var= new Variable("a", 3, 3);
    	variables.add(var);
    	Variable var2= new Variable("b", -9, 2);
    	variables.add(var2);
    	assertTrue(validator.isFeasible(variables, 10));
    }
    
    public void testNoSolutionExists() throws NoSolutionException 
    {
    	Exception exception = null;
    	try {
	    	EquationValidator validator= new EquationValidator();
	    	List<Variable> variables=new ArrayList<Variable>();
	    	Variable var= new Variable("a", 3, 3);
	    	variables.add(var);
	    	Variable var2= new Variable("b", 9, 2);
	    	variables.add(var2);
	    	validator.isFeasible(variables, 10);
    	} catch (NoSolutionException e) {
			exception=e;
		}finally {
			assertEquals(LessThanMinResultException.class, exception.getClass());	
		}
    }
    
    public void testNoSolutionExistsGCD() throws NoSolutionException 
    {
    	Exception exception = null;
    	try {
	    	EquationValidator validator= new EquationValidator();
	    	List<Variable> variables=new ArrayList<Variable>();
	    	Variable var= new Variable("a", 5, 3);
	    	variables.add(var);
	    	Variable var2= new Variable("b", 15, 2);
	    	variables.add(var2);
	    	validator.isFeasible(variables, 102);
	    } catch (NoSolutionException e) {
			exception=e;
		}finally {
			assertEquals(GCDNotFitsException.class, exception.getClass());	
		}
    }
    
   
    
}

