package de.suchomsky.gcodes.gcodes;

import java.io.IOException;
import java.io.InputStream;


public interface GCodeFactoryImpl {

	GCodeStore loadGcodeModel(InputStream in, long fsize) throws IOException;

	GCodeStore createStore(int size);

	long getReadBytes();

	long getReadLines();

	long getFilesize();

	GCode parseGcode(String arg0, int linenr) throws Exception;

}