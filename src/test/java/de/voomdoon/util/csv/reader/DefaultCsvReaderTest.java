package de.voomdoon.util.csv.reader;

import org.junit.jupiter.api.Nested;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class DefaultCsvReaderTest extends CsvReaderTest {

	/**
	 * DOCME add JavaDoc for DefaultCsvReaderTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class ReadRowArrayTest extends CsvReaderTest.ReadRowArrayTest {

		/**
		 * @since 0.1.0
		 */
		@Override
		CsvReader getInstance(String fileName) throws Exception {
			return new DefaultCsvReader(fileName);
		}
	}
}
