package de.voomdoon.util.csv.writer;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

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
class CsvWriterBuilderTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private CsvWriterBuilder builder;

	/**
	 * @since 0.1.0
	 */
	private CsvWriter writer;

	/**
	 * @since 0.1.0
	 */
	@AfterEach
	void afterEach_closeWriter() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testBuild(@TempOutputFile String file) throws Exception {
		logTestStart();

		builder = new CsvWriterBuilder(file);

		CsvWriter actual = build();

		assertThat(actual).isNotNull();
	}

	/**
	 * DOCME add JavaDoc for method build
	 * 
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	private CsvWriter build() throws IOException {
		writer = builder.build();

		return writer;
	}
}