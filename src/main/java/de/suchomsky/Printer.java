package de.suchomsky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
public class Printer {
	private PrinterConnection printerConnection;

	Printer(PrinterConnection printerConnection) {
		this.printerConnection = printerConnection;
	}

	public VersionCommandResponse getFirmwareVersion(){
		return new VersionCommandResponse();
	}

	protected void sendCommand(PrinterCommand printerCommand){}

	public void startPrint(){}

	String[] listSdFiles() {
		String[] gcodeFiles = null;
		return gcodeFiles;
	}

	public void transferToSd(File localeFile) throws IOException {
		//get filename
		//send M28 filename command
		sendCommand(new PrinterCommand("M28 " + localeFile.getName()));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(localeFile));
		String line = null;
		try {
			while (!(line = bufferedReader.readLine()).isEmpty()){
				sendCommand(new PrinterCommand(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			sendCommand(new PrinterCommand("M29 "));
		}
	}

	void printFromSd(String filename) {

	}
}
