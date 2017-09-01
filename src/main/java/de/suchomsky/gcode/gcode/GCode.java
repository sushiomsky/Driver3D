package de.suchomsky.gcode.gcode;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Java-GCode
 * Created by Matthew Wood on 12/05/2017.
 */
public abstract class GCode {
	protected final int lineNumber;
	protected final String code;
	protected final HashMap<Character, String> arguments;
	protected volatile boolean completed = false;

	protected GCode(String command, int lineNumber) throws InvalidGCodeException {
		String[] parts = command.split("\\s+");
		if (parts.length < 1) throw new InvalidGCodeException("GCode has not arguments");
		this.code = parts[0].toUpperCase();
		parts = Arrays.copyOfRange(parts, 1, parts.length);
		arguments = new HashMap<>();
		for (String part : parts) {
			if (part.length() > 1) arguments.put(part.toUpperCase().charAt(0), part.substring(1));
		}
		this.lineNumber = lineNumber;
	}

	protected GCode(String command) throws InvalidGCodeException {
		this(command, -1);
	}

	public GCode(GCode gCode) {
		this.code = gCode.code;
		this.lineNumber = gCode.lineNumber;
		this.arguments = gCode.arguments;
	}

	public abstract boolean process() throws Exception;

	public boolean isCompleted() {
		return completed;
	}

	public boolean hasLineNumber() {
		return lineNumber > -1;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public GCodeType getPacketType() {
		return GCodeType.getById(code);
	}

	public GCode getPacketTyped() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		Class<?> gCodeClass = getPacketType().getGCodeClass();
		Constructor<?> ctor = gCodeClass.getConstructor(GCode.class);
		Object typedGCode = ctor.newInstance(this);
		return (GCode) typedGCode;
	}
}
