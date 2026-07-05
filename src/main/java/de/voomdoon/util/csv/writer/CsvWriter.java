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
	 * Flushes buffered output.
	 * 
	 * @throws IOException
	 *             if the output cannot be flushed
	 * @since 0.1.0
	 */
	void flush() throws IOException;

	/**
	 * Writes a row.
	 * 
	 * @param row
	 *            cells to write
	 * @throws IOException
	 *             if the row cannot be written
	 * @since 0.1.0
	 */
	void writeRow(List<String> row) throws IOException;
}
