package de.voomdoon.util.csv.reader;

import java.io.Closeable;
import java.io.IOException;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public interface CsvReader extends Closeable {

	/**
	 * DOCME add JavaDoc for method readRowArray
	 * 
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	String[] readRowAsArray() throws IOException;
}
