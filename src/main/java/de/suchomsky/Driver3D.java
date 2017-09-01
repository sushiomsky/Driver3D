package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;

/**
 * Driver3D
 * Copyright (c) 2017 Dennis Suchomsky <dennis.suchomsky@gmail.com>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class Driver3D {

	private static Driver3D driver3D = null;
	private SerialPort[] serialPorts = null;

	private Driver3D() {
		driver3D = this;
		probePorts();
	}

	public static Driver3D getInstance() {
		if (driver3D == null)
			driver3D = new Driver3D();
		return driver3D;
	}

	public SerialPort[] getSerialPorts() {
		return serialPorts;
	}

	private void probePorts() {
		serialPorts = SerialPort.getCommPorts();
	}
	
}

