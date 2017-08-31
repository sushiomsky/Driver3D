package de.suchomsky.gcodes.gcodes.lowmemfactory;

import de.dietzm.Constants;
import de.dietzm.Constants.GCDEF;
import de.dietzm.Position;
import de.suchomsky.gcodes.gcodes.GCodeAbstract;


public class GCodeXYE extends GCodeAbstract {

	private float x = Float.MAX_VALUE;//will be initalitzed with current pos x
	private float y = Float.MAX_VALUE;//will be initalitzed with current pos y
	private float e = Float.MAX_VALUE; //will be initalitzed with absolut extrusion

	//Dynamic values updated by analyse	 (7MB for 300000 gcodes)
	private float timeaccel;
	private float distance;


	public GCodeXYE(String line, GCDEF code) {
		super(line, code);
	}


	@Override
	public void setInitialized(short mask, float value) {
		switch (mask) {
			case Constants.E_MASK:
				e = value;
				break;
			case Constants.X_MASK:
				x = value;
				break;
			case Constants.Y_MASK:
				y = value;
				break;
			default:
				break;
		}

	}

	@Override
	public String toCSV() {
		String var = String.valueOf(getSpeed());
		var += ";" + e;
		var += ";" + distance;
		var += ";" + timeaccel;
		return var;
	}


	@Override
	public String toString() {
		//String var = lineindex+":  "+toStringRaw();
		String var = ":  ";
		var += "\tExtrusion:" + e;
		var += "\tDistance:" + distance;
		var += "\tPosition:" + x + "x" + y;
		var += "\tTime:" + timeaccel;
		return var;
	}


	@Override
	public float getS_Fan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getF() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public float getS_Ext() {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * @param pos pass a position object to avoid object creation
	 * @return
	 */
	@Override
	public Position getCurrentPosition(Position pos) {
		pos.x = x;
		pos.y = y;
		return pos;
	}


	@Override
	public float getS_Bed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getBedtemp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getExtemp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getDistance() {
		return distance;
	}

	@Override
	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public float getE() {
		return e;
	}


	@Override
	public float getExtrusion() {
		if (!isInitialized(Constants.E_MASK)) return 0;
		return e;
	}

	@Override
	public void setExtrusion(float extrusion) {
		e = extrusion; //overwrite to save memory
	}

	/**
	 * Get Extrusion speed (mm/min)
	 *
	 * @return
	 */
	@Override
	public float getExtrusionSpeed() {
		return (e / getTimeAccel()) * 60f;
	}

	//private float extemp,bedtemp;
	@Override
	public short getFanspeed() {
		return Short.MAX_VALUE;
	}

	/**
	 * Set the fanspeed to remember how long the fan is turned on.
	 * This does NOT change the s_fan variable and will not written to gcode on save
	 *
	 * @param fanspeed
	 */
	@Override
	public void setFanspeed(float fanspeed) {

	}

	@Override
	public Position getPosition(Position reference) {
		return new Position(isInitialized(Constants.X_MASK) ? x : reference.x, isInitialized(Constants.Y_MASK) ? y : reference.y);
	}

	/**
	 * Speed in mm/s based on distance/time
	 *
	 * @return
	 */
	@Override
	public float getSpeed() {
		return Constants.round2digits((distance / timeaccel));
	}

	@Override
	public float getTimeAccel() {
		if (timeaccel == 0) return 0;
		return distance / (((Math.min(40 * 60, distance * 60 / timeaccel) + distance * 60 / timeaccel) / 2) / 60);
	}

	@Override
	public void setTimeAccel(float time) {
		timeaccel = time;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}


	//	/**
	//	 * Set the bedtemp to remember the configured temp.
	//	 * This does NOT change the s_bed variable and will not written to gcode on save
	//	 * @param fanspeed
	//	 */
	//	public void setBedtemp(float bedtemp) {
	//		this.bedtemp = bedtemp;
	//	}

	/**
	 * Is filament getting extruded or restract
	 *
	 * @return true is extruding
	 */
	@Override
	public boolean isExtrudeOrRetract() {
		return (isInitialized(Constants.E_MASK) && e != 0);
	}

	/**
	 * Is filament getting extruded (no incl. retract)
	 *
	 * @return true is extruding
	 */
	@Override
	public boolean isExtruding() {
		return (isInitialized(Constants.E_MASK) && e > 0);
	}

	/**
	 * check if a particular field is initialized
	 * Only check one field at once
	 *
	 * @param mask
	 * @return boolean
	 */
	@Override
	public boolean isInitialized(int mask) {
		switch (mask) {
			case Constants.E_MASK:
				return e != Float.MAX_VALUE;
			case Constants.X_MASK:
				return x != Float.MAX_VALUE;
			case Constants.Y_MASK:
				return y != Float.MAX_VALUE;
			default:
				break;
		}
		return false;
	}

	@Override
	public void setCurrentPosition(Position currentPosition) {
		x = currentPosition.x; //overwrite to save memory
		y = currentPosition.y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getKz() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getJy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getIx() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnit(String unit) {
		// TODO Auto-generated method stub

	}

}
