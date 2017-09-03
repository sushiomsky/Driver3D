package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


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
	private OutputStreamWriter outputStreamWriter;
	private InputStreamReader inputStreamReader;

	public SerialConnection(SerialPort serialPort){
		this.serialPort = serialPort;
		connect();
		this.serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
		inputStreamReader = new InputStreamReader(serialPort.getInputStream());
		outputStreamWriter = new OutputStreamWriter(serialPort.getOutputStream());
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
	public void send(PrinterCommand printerCommand) throws IOException {
		outputStreamWriter.write(printerCommand.toString());
	}

	@Override
	public String recieve() throws IOException {
		return new BufferedReader(inputStreamReader).readLine();
	}

	@Override
	public void close() throws IOException {
		outputStreamWriter.close();
		inputStreamReader.close();
		serialPort.closePort();
	}
}
