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
public class CsvReaderBuilderTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	@Test
	void testBuild() throws Exception {
		logTestStart();

		CsvReaderBuilder builder = new CsvReaderBuilder("src/test/resources/csv/tab.csv");

		CsvReader actual = builder.build();

		assertThat(actual).isNotNull();
	}
}
