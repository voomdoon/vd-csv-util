package de.vooomdoon.util.csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import de.voomdoon.util.test.tests.TestBase;

/**
 * Test class for {@link CsvUtil}
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
public class CsvUtilTest {

	/**
	 * DOCME add JavaDoc for CsvUtilTest
	 *
	 * @author André Schulz
	 *
	 * @since DOCME add inception version number
	 */
	public static class GetCsvReader_String_Test extends TestBase {

		/**
		 * @since DOCME add inception version number
		 */
		private String input;

		/**
		 * @since DOCME add inception version number
		 */
		private CSVReader reader;

		/**
		 * @throws IOException
		 * 
		 * @since DOCME add inception version number
		 */
		public GetCsvReader_String_Test() throws IOException {
			input = getTempDirectory() + "/input.csv";
		}

		@AfterEach
		void tearDown() throws IOException {
			IOUtils.close(reader);
		}

		/**
		 * @throws Exception
		 * @since DOCME add inception version number
		 */
		@Test
		void test_empty() throws Exception {
			logTestStart();

			copy(CsvUtilTest.class.getResourceAsStream("/csv/empty.csv"), new FileOutputStream(input));

			CSVReader actual = getCsvReader(input);
			assertThat(actual).isNotNull();
		}

		@Test
		void test_error_IllegalArgumentException_directory() throws Exception {
			logTestStart();

			File directory = new File(getTempDirectory() + File.pathSeparator + "directory");
			directory.mkdir();
			String input = directory.toString();

			assertThrows(IllegalArgumentException.class, () -> CsvUtil.getCsvReader(input));
		}

		@Test
		void test_error_IOException_fileNotFound() throws Exception {
			logTestStart();

			assertThrows(IOException.class, () -> CsvUtil.getCsvReader("something"));
		}

		/**
		 * @throws Exception
		 * @since DOCME add inception version number
		 */
		@Test
		void test_separator_semicolon() throws Exception {
			logTestStart();

			runSeparatorTest("semicolon");
		}

		/**
		 * @throws Exception
		 * @since DOCME add inception version number
		 */
		@Test
		void test_separator_tab() throws Exception {
			logTestStart();

			runSeparatorTest("tab");
		}

		/**
		 * DOCME add JavaDoc for method copy
		 * 
		 * @param input
		 * @param output
		 * @throws IOException
		 * @since DOCME add inception version number
		 */
		private void copy(InputStream input, FileOutputStream output) throws IOException {
			IOUtils.copy(input, output);
			input.close();
			output.close();
		}

		/**
		 * @param input
		 * @return
		 * @throws IOException
		 * @since DOCME add inception version number
		 */
		private CSVReader getCsvReader(String input) throws IOException {
			reader = CsvUtil.getCsvReader(input);

			return reader;
		}

		/**
		 * @param string
		 * @throws IOException
		 * @throws FileNotFoundException
		 * @throws CsvValidationException
		 * @since DOCME add inception version number
		 */
		private void runSeparatorTest(String string) throws FileNotFoundException, IOException, CsvValidationException {
			copy(CsvUtilTest.class.getResourceAsStream("/csv/" + string + ".csv"), new FileOutputStream(input));

			CSVReader actual = getCsvReader(input);
			assertThat(actual.readNext()).isEqualTo(new String[] { "a", "b" });

		}
	}
}
