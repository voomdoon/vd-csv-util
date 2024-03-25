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
	 * DOCME add JavaDoc for constructor CsvReaderBuilder
	 * 
	 * @param fileName
	 * @since 0.1.0
	 */
	public CsvReaderBuilder(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * DOCME add JavaDoc for method build
	 * 
	 * @return
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public CsvReader build() throws IOException {
		return new DefaultCsvReader(fileName);
	}
}
