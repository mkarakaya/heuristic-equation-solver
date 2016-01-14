package com.equationsolver;

import java.util.List;

import exceptions.NoSolutionException;
import junit.framework.TestCase;
import model.Variable;

public class EquationPrimeTest extends TestCase
{
  
    
    
   
    
    public void testApp() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+b=7");
       EquationValidator validator=new EquationValidator();
       assertEquals(7, validator.getResult(solve));
    }
    
    public void testAppPrime() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("2a+7b=51");
       EquationValidator validator=new EquationValidator();
       assertEquals(51, validator.getResult(solve));
    }
    
    public void testAppPrimeSeven() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a-7b=1");
       EquationValidator validator=new EquationValidator();
       assertEquals(1, validator.getResult(solve));
    }
    public void testAppPrimeMinus() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a-7b=51");
       EquationValidator validator=new EquationValidator();
       assertEquals(51, validator.getResult(solve));
    }
}
