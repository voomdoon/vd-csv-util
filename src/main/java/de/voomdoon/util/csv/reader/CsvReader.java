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
	 * Reads the next row.
	 * 
	 * @return next row or {@code null} at the end of the input
	 * @throws IOException
	 *             if the row cannot be read
	 * @since 0.1.0
	 */
	String[] readRowAsArray() throws IOException;
}
