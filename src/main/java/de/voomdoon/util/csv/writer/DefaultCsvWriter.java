package de.voomdoon.util.csv.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class DefaultCsvWriter implements CsvWriter {

	/**
	 * @since 0.1.0
	 */
	private ICSVWriter writer;

	/**
	 * DOCME add JavaDoc for constructor DefaultCsvWriter
	 * 
	 * @param fileName
	 * @throws IOException
	 * @since 0.1.0
	 */
	public DefaultCsvWriter(String fileName) throws IOException {
		writer = new CSVWriterBuilder(new FileWriter(fileName)).withSeparator('\t')
				.withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER).build();
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void close() throws IOException {
		try {
			writer.close();
		} catch (IOException e) {
			if (!"Stream closed".equals(e.getMessage())) {
				throw e;
			}
		}
	}

	/**
	 * @throws IOException
	 * @since 0.1.0
	 */
	@Override
	public void flush() throws IOException {
		writer.flush();
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void writeRow(List<String> row) {
		writer.writeNext(row.toArray(new String[0]));
	}
}
