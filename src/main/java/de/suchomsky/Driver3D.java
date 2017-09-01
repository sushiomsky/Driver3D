package de.suchomsky;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;

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

	public static void main(String[] args) {
		//get SerialPorts
		//Test each if we get a M115 version response
		//transfer local file to SD card
		//start print

		SerialPort[] comPorts = SerialPort.getCommPorts();
		/*
		for(SerialPort comPort: comPorts) {
			System.out.println(comPort.getDescriptivePortName() + " " + comPort.getSystemPortName());
			comPort.openPort();
			comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 100);
			InputStream in = comPort.getInputStream();
			try {
				for (int j = 0; j < 1000; ++j)
					System.out.print((char) in.read());
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			comPort.closePort();
		}
		*/
		while (true) {
			comPorts = SerialPort.getCommPorts();
			for (SerialPort comPort : comPorts) {

				System.out.println(comPort.getDescriptivePortName() + " " + comPort.getSystemPortName());
				if (comPort.openPort()) {
					comPort.addDataListener(new SerialPortPacketListener() {
						@Override
						public int getPacketSize() {
							return 0;
						}

						@Override
						public int getListeningEvents() {
							return 0;
						}

						@Override
						public void serialEvent(SerialPortEvent event) {
							SerialPort serialPort = event.getSerialPort();
							int bytesAvailable = serialPort.bytesAvailable();

							if (bytesAvailable > 0) {
								byte[] byteBuffer = new byte[bytesAvailable];
								serialPort.readBytes(byteBuffer, bytesAvailable);
							}
							if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
							}
							if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
							}
						}
					});
				}
			}
		}
				/*
				if (comPort.openPort()) {
					try {
						if (comPort.bytesAvailable() == 0) {
							Thread.sleep(3000);
						}else {
							byte[] readBuffer = new byte[comPort.bytesAvailable()];
							int numRead = comPort.readBytes(readBuffer, readBuffer.length);
							System.out.println("Read " + numRead + " bytes.");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					comPort.closePort();
				}
			}
		}
		//play a song
		/**
		 * M300 - Play Tone
		 lcd  Play a single tone, buzz, or beep. SPEAKER
		 Add a tone to the tone queue.

		 Usage
		 M300 [P<ms>] [S<Hz>]
		 Argument	Description
		 [P<ms>]
		 Duration (1s)

		 [S<Hz>]
		 Frequency (260Hz)

		 Notes
		 Requires SPEAKER to play tones (not just beeps).

		 In Marlin 1.0.2, playing tones block the command queue. Marlin 1.1.0 uses a tone queue and background tone player to keep the command buffer from being blocked by playing tones.

		 Examples
		 Play a tune.

		 M300 S440 P200
		 M300 S660 P250
		 M300 S880 P300
		 */
		/**
		 *M666
		 */

	}
}


