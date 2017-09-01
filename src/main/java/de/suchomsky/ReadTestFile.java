package de.suchomsky;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.stream.Stream;

import gcode.InvalidGCodeException;
import gcode.reserved.UnclassifiedGCode;

/**
 * Java-Gcode
 * Created by Matthew Wood on 12/05/2017.
 */
public class ReadTestFile {
	public static void main(String[] args) throws IOException {
		Long time = System.currentTimeMillis();
		try (Stream<String> stream = Files.lines(new File("Resources/test.gcode").toPath())) {
			// For each line
			stream.forEach(line ->
			{
				if (line.length() > 1) {
					if (line.charAt(0) != ';') {
						try {
							System.out.println(new UnclassifiedGCode(line).getPacketTyped());
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | InvalidGCodeException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		System.out.println("Time taken: " + (System.currentTimeMillis() - time) + "ms");
	}
}
