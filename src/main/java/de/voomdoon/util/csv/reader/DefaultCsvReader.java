package de.voomdoon.util.csv.reader;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvValidationException;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class DefaultCsvReader implements CsvReader {

	/**
	 * @since 0.1.0
	 */
	private CSVReader reader;

	/**
	 * DOCME add JavaDoc for constructor DefaultCsvReader
	 * 
	 * @param fileName
	 * @throws IOException
	 * @since 0.1.0
	 */
	public DefaultCsvReader(String fileName) throws IOException {
		CSVParser parser = new CSVParserBuilder()//
				.withSeparator('\t')//
				.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)//
				.build();

		reader = new CSVReaderBuilder(new FileReader(fileName))//
				.withCSVParser(parser).build();
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void close() throws IOException {
		reader.close();
	}

	/**
	 * @throws IOException
	 * @throws
	 * @since 0.1.0
	 */
	@Override
	public String[] readRowAsArray() throws IOException {
		try {
			return reader.readNext();
		} catch (CsvValidationException e) {
			// TODO implement error handling
			throw new IOException("CsvValidationException: " + e.getMessage(), e);
		}
	}
}
