package com.equationsolver;

import java.util.ArrayList;
import java.util.List;

import model.Variable;

public class EquationConverter {

	
	
	/**
	 * convert actual equation string to list of variables.
	 * @param equation
	 * @param expected
	 * @return
	 */
	public List<Variable>convertVariables(String equation,int expected){
		List<Variable> list= new ArrayList<Variable>();
		equation=equation.substring(0, equation.indexOf("="));
		equation=equation.replaceAll("\\+", ",+");
		equation=equation.replaceAll("\\-", ",-");
		String[] split = equation.split(",");
		for(String var: split){
			String name=var.replaceAll("-?\\d+(\\.\\d+)?", "");
			name=name.replaceAll("\\+", "");
			name=name.replaceAll("\\-", "");
			String multiplier=var.replaceAll("[^-?0-9]+", "");
			if("".equals(multiplier) || "-".equals(multiplier) || "+".equals(multiplier)){
				multiplier=multiplier+"1";
			}
			if(!"".equals(name)){
				list.add(new Variable(name,Integer.parseInt(multiplier),expected));
			}
		}
		return list;
	}
	
	
}
