package de.voomdoon.util.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import de.voomdoon.util.csv.reader.CsvReaderBuilder;
import lombok.experimental.UtilityClass;

/**
 * Utility for CSV.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class CsvUtil {

	/**
	 * DOCME add JavaDoc for method getCsvReader
	 * 
	 * @param input
	 *            {@link String} file name
	 * @return {@link CSVReader}
	 * @throws IOException
	 * @since 0.1.0
	 * @deprecated use {@link CsvReaderBuilder}
	 */
	@Deprecated(forRemoval = true)
	public static CSVReader getOpenCsvCsvReader(String input) throws IOException {
		String firstLine;

		try {
			firstLine = Files.lines(new File(input).toPath()).findFirst().orElse(null);
		} catch (AccessDeniedException e) {
			if (!new File(input).isFile()) {
				throw new IllegalArgumentException("No file: " + input);
			} else {
				throw e;// TESTME
			}
		}

		CSVReaderBuilder builder = new CSVReaderBuilder(new FileReader(input));

		if (firstLine == null) {
			return builder.build();
		}

		char separator = '\t';

		for (char s : new char[] { '\t', ';' }) {
			if (firstLine.contains(Character.toString(s))) {
				separator = s;
			}
		}

		return builder.withCSVParser(new CSVParserBuilder()//
				.withSeparator(separator)//
				.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)//
				.build()).build();
	}
}
