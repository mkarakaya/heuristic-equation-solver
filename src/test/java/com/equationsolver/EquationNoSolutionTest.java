package com.equationsolver;

import exceptions.GCDNotFitsException;
import exceptions.LessThanMinResultException;
import exceptions.NoSolutionException;
import junit.framework.TestCase;

public class EquationNoSolutionTest extends TestCase
{
  
    public void testApp() throws NoSolutionException
    {
    	Exception exception = null;
    	try {
    		EquationSolver solver= new EquationSolver();
    	    solver.solve("a+2b+c=3");	
		} catch (NoSolutionException e) {
			exception=e;
		}finally {
			assertEquals(LessThanMinResultException.class, exception.getClass());	
		}
    	
    }
    
    public void testGcd() throws NoSolutionException
    {
    	Exception exception = null;
    	try {
    		EquationSolver solver= new EquationSolver();
    	    solver.solve("30a+9b+15c=1000");	
		} catch (NoSolutionException e) {
			exception=e;
		}finally {
			assertEquals(GCDNotFitsException.class, exception.getClass());	
		}
    	
    }
}
