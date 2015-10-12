package org.elsysbg.ip.java;

public class ControlFlowStatements {

		public static void main(String[] args) {
			if (true) {
				System.out.println("ohaaa");
			}
			
			ifExample();			
			forExample();
			
		}

		private static void ifExample() {
			if (1>2) {
				System.out.println("Ehee");
			} else {
				System.out.println("hahha");
			}
		}
		
		private static void forExample() {
			for (int i = 0; i < 9; i++) {
				System.out.println(i + "\n");
			}

		}
	
}