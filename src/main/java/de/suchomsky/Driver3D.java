package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;

import java.io.File;
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
public class Driver3D {
	public static void main(String[] args){
		if (args.length != 2)
			printUsage();

		File f = new File(args[1]);
		if (!(f.exists() && !f.isDirectory()))
			printUsage();

		Printer printer = new Printer(new SerialConnection(SerialPort.getCommPort(args[2])));

		if (!printer.isConnected())
			printComError();

		try {
			printer.transferToSd(f);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			printer.printFromSd(f.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printUsage() {
		System.out.println("Usage: driver3d filename.gco /dev/ttyAMC*");
	}

	public static void printComError() {
		System.out.println("Error opening com port");
	}
}


