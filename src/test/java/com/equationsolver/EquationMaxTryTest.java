package com.equationsolver;

import exceptions.MaxTryCountExceededException;
import exceptions.NoSolutionException;
import junit.framework.TestCase;

public class EquationMaxTryTest extends TestCase
{
  
    public void testApp() throws NoSolutionException
    {
    	Exception exception = null;
    	try {
    		EquationSolver solver= new EquationSolver(2);
    	    solver.solve("a+2b+c+5d+100e=31000000");	
		} catch (MaxTryCountExceededException e) {
			exception=e;
		}finally {
			assertNotNull(exception);	
		}
    	
    }
}
