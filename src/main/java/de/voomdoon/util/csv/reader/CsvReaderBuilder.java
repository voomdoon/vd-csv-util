package de.voomdoon.util.csv.reader;

import java.io.IOException;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class CsvReaderBuilder {

	/**
	 * @since 0.1.0
	 */
	private String fileName;

	/**
	 * Creates a builder for the supplied file.
	 * 
	 * @param fileName
	 *            file name as {@link String}
	 * @since 0.1.0
	 */
	public CsvReaderBuilder(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Builds the CSV reader.
	 * 
	 * @return {@link CsvReader}
	 * @throws IOException
	 *             if the reader cannot be created
	 * 
	 * @since 0.1.0
	 */
	public CsvReader build() throws IOException {
		return new DefaultCsvReader(fileName);
	}
}
