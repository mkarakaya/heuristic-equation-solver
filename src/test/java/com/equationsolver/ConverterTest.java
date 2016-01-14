package com.equationsolver;

import java.util.List;

import junit.framework.TestCase;
import model.Variable;

public class ConverterTest extends TestCase
{
	
	 public void test() 
	    {
	       EquationConverter converter= new EquationConverter();
	       List<Variable> list = converter.convertVariables("7a+1b=", 7);
	       String[] names= {"a","b"};
	       int[]multipiers={7,1};
	       assertEquals(2, list.size());
	       for(int i=0;i<list.size();i++){
	    	   Variable var= list.get(i);
	    	   assertEquals(names[i], var.getName());
	    	   assertEquals(multipiers[i], var.getMultiplier());
	       }
	    }
    
    public void testOne() 
    {
       EquationConverter converter= new EquationConverter();
       List<Variable> list = converter.convertVariables("a+b=", 7);
       String[] names= {"a","b"};
       int[]multipiers={1,1};
       assertEquals(2, list.size());
       for(int i=0;i<list.size();i++){
    	   Variable var= list.get(i);
    	   assertEquals(names[i], var.getName());
    	   assertEquals(multipiers[i], var.getMultiplier());
       }
    }
    
    public void testMinus() 
    {
       EquationConverter converter= new EquationConverter();
       List<Variable> list = converter.convertVariables("-7a+2b-3c=", 7);
       String[] names= {"a","b","c"};
       int[]multipiers={-7,2,-3};
       assertEquals(3, list.size());
       for(int i=0;i<list.size();i++){
    	   Variable var= list.get(i);
    	   assertEquals(names[i], var.getName());
    	   assertEquals(multipiers[i], var.getMultiplier());
       }
    }
    
    public void testMinusOne() 
    {
       EquationConverter converter= new EquationConverter();
       List<Variable> list = converter.convertVariables("-a+2b-3c=", 7);
       String[] names= {"a","b","c"};
       int[]multipiers={-1,2,-3};
       assertEquals(3, list.size());
       for(int i=0;i<list.size();i++){
    	   Variable var= list.get(i);
    	   assertEquals(names[i], var.getName());
    	   assertEquals(multipiers[i], var.getMultiplier());
       }
    }
    
}

