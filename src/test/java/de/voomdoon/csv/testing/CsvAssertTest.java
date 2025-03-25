package de.voomdoon.csv.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.csv.testing.CsvAssert.Column;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 * @deprecated TODO move to vd-csv-testing
 */
@Deprecated
class CsvAssertTest extends TestBase {

	/**
	 * DOCME add JavaDoc for CsvAssertTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class AssertColumns_Test extends TestBase {

		/**
		 * @throws IOException
		 * @since 0.1.0
		 */
		@Test
		void test_1column() throws IOException {
			logTestStart();

			CsvAssert asserter = CsvAssert.assertCsv("src/test/resources/csv/tab.csv");

			assertDoesNotThrow(() -> asserter.assertColumns(CsvAssert.column("a")));
		}

		/**
		 * @throws IOException
		 * @since 0.1.0
		 */
		@Test
		void test_2columns() throws IOException {
			logTestStart();

			CsvAssert asserter = CsvAssert.assertCsv("src/test/resources/csv/tab.csv");

			assertDoesNotThrow(() -> asserter.assertColumns(CsvAssert.column("a"), CsvAssert.column("b")));
		}

		/**
		 * @throws IOException
		 * @since 0.1.0
		 */
		@Test
		void test_AssertionError_missing() throws IOException {
			logTestStart();

			CsvAssert asserter = CsvAssert.assertCsv("src/test/resources/csv/tab.csv");
			Column column = CsvAssert.column("c");

			AssertionError error = assertThrows(AssertionError.class, () -> asserter.assertColumns(column));

			assertThat(error).hasMessageContaining("c");
		}

		/**
		 * @throws IOException
		 * @since 0.1.0
		 */
		@Test
		void test_columnOrderDoesNotMatter() throws IOException {
			logTestStart();

			CsvAssert asserter = CsvAssert.assertCsv("src/test/resources/csv/tab.csv");

			assertDoesNotThrow(() -> asserter.assertColumns(CsvAssert.column("b"), CsvAssert.column("a")));
		}
	}

	/**
	 * DOCME add JavaDoc for CsvAssertTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class AssertCsv_Test extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_AssertionError_rowWithLessColumnsThanFirstRow() {
			logTestStart();

			AssertionError error = assertThrows(AssertionError.class,
					() -> CsvAssert.assertCsv("src/test/resources/csv/invalid/rowWithLessColumnsThanFirstRow.csv"));

			assertThat(error).hasMessageContaining("Row 1", "1", "column", "expect", "2");
		}
	}

	/**
	 * DOCME add JavaDoc for method testAssertCsv
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAssertCsv() throws Exception {
		logTestStart();

		CsvAssert asserter = CsvAssert.assertCsv("src/test/resources/csv/tab.csv");

		assertThat(asserter).isNotNull();
	}
}
