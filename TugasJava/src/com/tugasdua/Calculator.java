package com.tugasdua;

public class Calculator {

	public static void main(String[] args) throws Exception {
		
		try {
			CalculatorGetterSetter calculator = new CalculatorGetterSetter(9, 3);
			CalculationSyso calculate = new CalculationSyso();
			
//			Ubah comment val1 di bawah ini untuk mengganti case string ke angka
			
			String valString = ""; 
			int val1 = Integer.parseInt(valString); //Value untuk test input string
//			int val1 = calculator.getValue1(); //Value untuk test input integer
			int val2 = calculator.getValue2();
			
			// Add
			calculate.add(val1, val2);
			
			// Substract
			calculate.substract(val1, val2);
			
			// Divide
			calculate.divide(val1, val2);
			
			// Multiply
			calculate.multiply(val1, val2);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Sorry you aren't number!");
			
		}
		
		
	}

}
