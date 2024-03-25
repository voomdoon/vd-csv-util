package de.voomdoon.util.csv.reader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class CsvReaderTest {

	/**
	 * DOCME add JavaDoc for CsvReaderTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	abstract static class CsvReaderTestBase extends TestBase {

		/**
		 * DOCME add JavaDoc for method getInstance
		 * 
		 * @param fileName
		 * @return
		 * @throws Exception
		 * @since 0.1.0
		 */
		abstract CsvReader getInstance(String fileName) throws Exception;
	}

	/**
	 * DOCME add JavaDoc for CsvReaderTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	abstract static class ReadRowArrayTest extends CsvReaderTestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test() throws Exception {
			logTestStart();

			CsvReader reader = getInstance("src/test/resources/csv/tab.csv");

			String[] row = reader.readRowAsArray();

			assertThat(row).containsExactly("a", "b");
		}
	}
}
