package de.suchomsky.print.print;


public interface PrinterConnection {

	int BLUETOOTH = 1;
	int USBOTG = 0;
	int DUMMY = 2;
	int OCTO = 3;

	void reset() throws Exception;

	/**
	 * 1st time initialize the connection
	 *
	 * @throws Exception
	 */
	boolean init(boolean reset) throws Exception;

	boolean enumerate();

	void requestDevice(String device);

	void closeDevice() throws Exception;

	void writeBuffer(ReceiveBuffer wbuf);

	void read(ReceiveBuffer rbuf, int timeout);

	int getType();


}