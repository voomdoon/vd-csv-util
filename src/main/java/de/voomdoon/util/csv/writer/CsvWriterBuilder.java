package de.voomdoon.util.csv.writer;

import java.io.IOException;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class CsvWriterBuilder {

	/**
	 * @since 0.1.0
	 */
	private String fileName;

	/**
	 * DOCME add JavaDoc for constructor CsvWriterBuilder
	 * 
	 * @param string
	 * @since 0.1.0
	 */
	public CsvWriterBuilder(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * DOCME add JavaDoc for method build
	 * 
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	public CsvWriter build() throws IOException {
		return new DefaultCsvWriter(fileName);
	}
}
