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
	 * Creates a builder for the supplied file.
	 * 
	 * @param fileName
	 *            file name as {@link String}
	 * @since 0.1.0
	 */
	public CsvWriterBuilder(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Builds the CSV writer.
	 * 
	 * @return {@link CsvWriter}
	 * @throws IOException
	 *             if the writer cannot be created
	 * @since 0.1.0
	 */
	public CsvWriter build() throws IOException {
		return new DefaultCsvWriter(fileName);
	}
}
