package com.equationsolver;

import java.util.List;

import exceptions.NoSolutionException;
import junit.framework.TestCase;
import model.Variable;

public class EquationBigNumbersTest extends TestCase
{
  
    public void testApp() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+2b=300000000");
       EquationValidator validator = new EquationValidator();
       assertEquals(300000000, validator.getResult(solve));
    }
    
    public void testAppBigMultiplier() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("-2a+12b=300785408");
       EquationValidator validator = new EquationValidator();
       assertEquals(300785408, validator.getResult(solve));
    }
    
    public void testAppManyVariables() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+2b+3c+4d+5e+6f+7g+8h+9i+10j+11k+5l+4m+6n+2o-7p+q+7z=300785408");
       EquationValidator validator = new EquationValidator();
       assertEquals(300785408, validator.getResult(solve));
    }
    
 }
