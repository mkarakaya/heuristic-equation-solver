package com.equationsolver;

import java.util.List;

import exceptions.NoSolutionException;
import junit.framework.TestCase;
import model.Variable;

/**
 * these equations have unique solutions.
 * @author p.bell
 *
 */
public class EquationUniqueTest extends TestCase
{
  
	 public void testApp() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a-2b=1");
       EquationValidator validator=new EquationValidator();
       assertEquals(1, validator.getResult(solve));
    }
    
    public void testAppUnique() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+b=2");
       EquationValidator validator=new EquationValidator();
       assertEquals(2, validator.getResult(solve));
    }
    
    public void testAppWithMultipliers() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+7b=12");
       EquationValidator validator=new EquationValidator();
       assertEquals(12, validator.getResult(solve));
    }
    
    public void testAppUniqueMoreThanTwo() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+b+3c+d+2e=8");
       EquationValidator validator=new EquationValidator();
       assertEquals(8, validator.getResult(solve));
    }
    
    
}
