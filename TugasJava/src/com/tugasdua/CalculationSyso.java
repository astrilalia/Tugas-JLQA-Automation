package com.tugasdua;

public class CalculationSyso {	
		
		public void add(int value1, int value2) {
			System.out.println(String.format("Hasil penjumlahan %1$d + %2$d = %3$d", value1, value2, (value1 + value2)));
		}
		
		public void substract(int value1, int value2) {
			System.out.println(String.format("Hasil pengurangan %1$d - %2$d = %3$d", value1, value2, (value1 - value2)));
		}
		
		public void divide(int value1, int value2) {
			System.out.println(String.format("Hasil pembagian %1$d / %2$d = %3$d", value1, value2, (value1 / value2)));
		}
		
		public void multiply(int value1, int value2) {
			System.out.println(String.format("Hasil perkalian %1$d * %2$d = %3$d", value1, value2, (value1 * value2)));
		}

}
