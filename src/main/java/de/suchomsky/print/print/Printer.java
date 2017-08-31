package de.suchomsky.print.print;

import de.dietzm.gcodes.GCode;

public interface Printer {

	boolean addToPrintQueue(GCode code, boolean manual);

	void setPrintMode(boolean isprinting, boolean interrupt);

	boolean isPrinting();

	boolean isPause();

	GCode getCurrentGCode();

	int getCurrentLine();

	int getPrintSpeed();


}
