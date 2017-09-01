package de.suchomsky.gcode.gcode.movement;

import gcode.GCode;
import model.Printer3D;

/**
 * Java-GCode
 * Created by Matthew Wood on 12/05/2017.
 */
public class G1_LinearMove extends GCode {

	public G1_LinearMove(GCode gCode) {
		super(gCode);
	}

	@Override
	public boolean process() throws Exception {
		Double x = arguments.containsKey('X') ? Double.parseDouble(arguments.get('X')) : null;
		Double y = arguments.containsKey('Y') ? Double.parseDouble(arguments.get('Y')) : null;
		Double z = arguments.containsKey('Z') ? Double.parseDouble(arguments.get('Z')) : null;
		Double e = arguments.containsKey('E') ? Double.parseDouble(arguments.get('E')) : null;
		Double f = arguments.containsKey('F') ? Double.parseDouble(arguments.get('F')) : null;
		Integer s = arguments.containsKey('S') ? Integer.parseInt(arguments.get('S')) : null;

		if (s != null) Printer3D.MOVEMENT_SYSTEM.setEndstopMode(s);
		if (f != null) Printer3D.MOVEMENT_SYSTEM.setFeedRate(f);
		Printer3D.MOVEMENT_SYSTEM.moveToPos(x, y, z, e);

		return true;
	}

	@Override
	public String toString() {
		return "G1_LinearMove{" +
				"code='" + code + '\'' +
				", arguments=" + arguments +
				'}';
	}
}
