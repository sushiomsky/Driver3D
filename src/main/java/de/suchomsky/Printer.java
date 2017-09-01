package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
public abstract class Printer {
	private SerialPort serialPort;

	Printer(SerialPort serialPort) {
		this.serialPort = serialPort;
	}

	public void print(Path localFile) throws IOException {
		Files.newBufferedReader(localFile);
	}

	String[] listSdFiles() {
		String[] gcodeFiles = null;
		return gcodeFiles;
	}

	public void transferToSd(Path gcodeFile) {

	}

	void printFromSd(String filename) {

	}
}