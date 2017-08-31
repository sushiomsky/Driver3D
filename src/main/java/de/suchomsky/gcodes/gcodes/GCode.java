package de.suchomsky.gcodes.gcodes;

import de.dietzm.Constants;
import de.dietzm.Position;

public interface GCode {

	String getComment();

	/**
	 * Is printable, returns false for comments only and unknown GCODES
	 *
	 * @return
	 */
	boolean isComment();

	/**
	 * Is printable, returns false for comments only and unknown GCODES
	 *
	 * @return
	 */
	boolean isPrintable();

	MemoryEfficientString getCodeline();

	/**
	 * get codeline into the provided buffer. Save memory allocations
	 *
	 * @param buffer
	 * @return len, how much data is written to buffer,-1 if buffer is too small
	 */
	int getCodeline(byte[] buffer);

	Constants.GCDEF getGcode();

	short getGcodeId();

	/**
	 * Is it a gcode which is buffered by the firmware
	 *
	 * @return boolean true if buffered gcodes
	 */
	boolean isBuffered();

	/**
	 * Is it a gcode which is long running and should not cause a timeout
	 *
	 * @return boolean true if buffered gcodes
	 */
	boolean isLongRunning();

	boolean isInitialized(int mask);

	void setInitialized(short mask, float value);

	String toCSV();

	String toString();

	float getExtrusionSpeed();

	float getTimeAccel();

	void setTimeAccel(float time);

	void setCurrentPosition(Position currentPosition);

	//public void setTime(float time);

	boolean isExtruding();

	boolean isExtrudeOrRetract();

	float getZ();

	float getY();

	float getR();

	float getKz();

	float getJy();

	float getIx();

	float getX();

	String getUnit();

	void setUnit(String unit);

	// protected String getIfInit(String prefix, float val, int digits, int
	// mask);
	float getSpeed();

	Position getPosition(Position reference);

	//public float getTime();

	float getS_Fan();

	float getF();

	float getExtrusion();

	void setExtrusion(float extrusion);

	float getS_Ext();

	float getE();

	float getDistance();

	void setDistance(float distance);

	Position getCurrentPosition(Position pos);

	float getS_Bed();

	float getBedtemp();

	float getExtemp();

	short getFanspeed();

	void setFanspeed(float fanspeed);

}