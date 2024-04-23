package de.voomdoon.util.csv.writer;

import java.io.IOException;

import org.junit.jupiter.api.Nested;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class DefaultCsvWriterTest extends CsvWriterTest {

	/**
	 * DOCME add JavaDoc for DefaultCsvWriterTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class FlushTest extends CsvWriterTest.FlushTest {

		/**
		 * @since 0.1.0
		 */
		@Override
		CsvWriter getInstance(String fileName) throws IOException {
			return new DefaultCsvWriter(fileName);
		}
	}

	/**
	 * DOCME add JavaDoc for DefaultCsvWriterTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class WriteRow_List_Test extends CsvWriterTest.WriteRow_List_Test {

		/**
		 * @since 0.1.0
		 */
		@Override
		CsvWriter getInstance(String fileName) throws IOException {
			return new DefaultCsvWriter(fileName);
		}
	}
}
