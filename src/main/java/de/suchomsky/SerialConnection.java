package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;

/**
 * driver3d
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
public class SerialConnection implements PrinterConnection {
	private boolean connected = false;
	private SerialPort serialPort;

	public SerialConnection(SerialPort serialPort){
		this.serialPort = serialPort;
		connect();
	}
	@Override
	public boolean isConnected() {
		return connected;
	}

	@Override
	public void connect() {
		if(serialPort.openPort())
			connected = true;
	}

	@Override
	public void send(PrinterCommand printerCommand) {

	}
}
