package de.voomdoon.util.csv.writer;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public interface CsvWriter extends Closeable {

	/**
	 * DOCME add JavaDoc for method flush
	 * 
	 * @throws IOException
	 * @since 0.1.0
	 */
	void flush() throws IOException;

	/**
	 * DOCME add JavaDoc for method writeRow
	 * 
	 * @param row
	 * @throws IOException
	 * @since 0.1.0
	 */
	void writeRow(List<String> row) throws IOException;
}
