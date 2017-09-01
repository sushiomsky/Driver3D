package de.suchomsky.gcode.gcode.movement;

import de.suchomsky.gcode.gcode.GCode;

/**
 * Java-Gcode
 * Created by Matthew Wood on 12/05/2017.
 */
public class G4_Dwell extends GCode {
	public G4_Dwell(GCode gCode) {
		super(gCode);
	}

	@Override
	public boolean process() throws Exception {
		if (arguments.containsKey('P')) {
			Thread.sleep(Integer.parseInt(arguments.get('P')));
		} else if (arguments.containsKey('S')) {
			Thread.sleep((long) Math.floor(1000 * Double.parseDouble(arguments.get('S'))));
		} else return false;
		return true;
	}

	@Override
	public String toString() {
		return "G4_Dwell{" +
				"code='" + code + '\'' +
				", arguments=" + arguments +
				'}';
	}
}
