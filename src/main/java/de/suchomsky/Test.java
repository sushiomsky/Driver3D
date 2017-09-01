package de.suchomsky;

import gcode.GCode;
import gcode.reserved.UnclassifiedGCode;

/**
 * Java-Gcode
 * Created by Matthew Wood on 12/05/2017.
 */
public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("Before typing:");
		GCode testCode = new UnclassifiedGCode("G0 X1");
		System.out.println(testCode);
		testCode = testCode.getPacketTyped();
		System.out.println();

		System.out.println("After typing:");
		System.out.println(testCode.getPacketTyped());
		System.out.println();

		testCode = new UnclassifiedGCode("G4 P500");
		testCode = testCode.getPacketTyped();
		System.out.println(testCode);
		System.out.println();

		testCode = new UnclassifiedGCode("G1 X1");
		testCode = testCode.getPacketTyped();
		System.out.println(testCode);
		System.out.println();

		testCode = new UnclassifiedGCode("G5");
		testCode = testCode.getPacketTyped();
		System.out.println(testCode);

	}
}
