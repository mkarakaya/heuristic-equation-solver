package com.equationsolver;

import java.util.List;

import exceptions.NoSolutionException;
import junit.framework.TestCase;
import model.Variable;

public class EquationExistingTest extends TestCase
{
  
    public void testAppFourVariables() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+2b-3c+4d=30");
       EquationValidator validator = new EquationValidator();
       assertEquals(30, validator.getResult(solve));
    }
    public void testAppTenVariables() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+2b+3c+4d+5e+6f+7g+8h+9i+10j=1000");
       EquationValidator validator = new EquationValidator();
       assertEquals(1000, validator.getResult(solve));
    }
    public void testAppSeventeenVariables() throws NoSolutionException
    {
       EquationSolver solver= new EquationSolver();
       List<Variable> solve = solver.solve("a+2b+3c+4d+5e+6f+7g+8h+9i+10j+11k+5l+4m+6n+2o-7p+q=1000");
       EquationValidator validator = new EquationValidator();
       assertEquals(1000, validator.getResult(solve));
    }
}
