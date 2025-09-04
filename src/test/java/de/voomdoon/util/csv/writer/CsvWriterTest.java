package de.voomdoon.util.csv.writer;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import de.voomdoon.testing.file.TempFileExtension;
import de.voomdoon.testing.file.TempOutputFile;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@ExtendWith(TempFileExtension.class)
class CsvWriterTest {

	/**
	 * DOCME add JavaDoc for CsvWriterTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	abstract static class CsvWriterTestBase extends TestBase {

		/**
		 * @since 0.1.0
		 */
		private CsvWriter instance;

		/**
		 * DOCME add JavaDoc for method afterEach_closeInstance
		 * 
		 * @throws IOException
		 * @since 0.1.0
		 */
		@AfterEach
		void afterEach_closeInstance() throws IOException {
			instance.close();
		}

		/**
		 * DOCME add JavaDoc for method get
		 * 
		 * @param fileName
		 * @return
		 * @throws IOException
		 * @since 0.1.0
		 */
		CsvWriter get(String fileName) throws IOException {
			instance = getInstance(fileName);

			return instance;
		}

		/**
		 * DOCME add JavaDoc for method getInstance
		 * 
		 * @param fileName
		 * @return
		 * @throws IOException
		 * @since 0.1.0
		 */
		abstract CsvWriter getInstance(String fileName) throws IOException;
	}

	/**
	 * DOCME add JavaDoc for CsvWriterTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	abstract static class FlushTest extends CsvWriterTestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test(@TempOutputFile String file) throws Exception {
			logTestStart();

			CsvWriter instance = get(file);

			instance.writeRow(List.of("a", "b"));
			instance.flush();

			List<String> lines = Files.readAllLines(Path.of(file));

			assertThat(lines).containsExactly("a\tb");
		}
	}

	/**
	 * DOCME add JavaDoc for CsvWriterTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	abstract static class WriteRow_List_Test extends CsvWriterTestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test(@TempOutputFile String file) throws Exception {
			logTestStart();

			CsvWriter instance = get(file);

			instance.writeRow(List.of("a", "b"));

			instance.close();

			List<String> lines = Files.readAllLines(Path.of(file));

			assertThat(lines).containsExactly("a\tb");
		}
	}
}