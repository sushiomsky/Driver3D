package de.suchomsky.print.print;

import de.dietzm.Temperature;

public interface ConsoleIf {
	void appendText(CharSequence... txt);

	void appendTextNoCR(CharSequence... txt);

	void setTemp(Temperature temp);

	void clearConsole();

	int chooseDialog(final String[] items, final String[] values, int type);

	void setWakeLock(boolean active);

	void setPrinting(boolean printing);

	void log(String tag, String value, ReceiveBuffer buf);

	void log(String tag, String value);

	boolean hasWakeLock();

	void updateState(int statemsg, CharSequence detail, int progressPercent);

	void updateState(int msgtype, int msgnr, int progressPercent);
}
