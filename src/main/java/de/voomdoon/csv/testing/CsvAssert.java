package de.voomdoon.csv.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.voomdoon.util.csv.reader.CsvReader;
import de.voomdoon.util.csv.reader.CsvReaderBuilder;

/**
 * Assertions for tab-separated CSV files.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 * @deprecated TODO move to vd-csv-testing
 */
@Deprecated
public class CsvAssert {

	/**
	 * Expected values of a CSV column.
	 *
	 * @author André Schulz
	 *
	 * @param cells
	 *            expected cells
	 *
	 * @since 0.1.0
	 */
	public static record Column(String... cells) {

	}

	/**
	 * Creates assertions for a CSV file.
	 * 
	 * @param fileName
	 *            file to read
	 * @return assertions for the file
	 * @throws IOException
	 *             if the file cannot be read
	 * @since 0.1.0
	 */
	public static CsvAssert assertCsv(String fileName) throws IOException {
		return new CsvAssert(fileName);
	}

	/**
	 * Creates an expected column.
	 * 
	 * @param cells
	 *            expected cells
	 * @return expected column
	 * @since 0.1.0
	 */
	public static Column column(String... cells) {
		return new Column(cells);
	}

	/**
	 * @since 0.1.0
	 */
	private final List<String[]> rows = new ArrayList<>();

	/**
	 * Reads a CSV file for subsequent assertions.
	 * 
	 * @param fileName
	 *            file to read
	 * @throws IOException
	 *             if the file cannot be read
	 * @since 0.1.0
	 */
	public CsvAssert(String fileName) throws IOException {
		try (CsvReader reader = new CsvReaderBuilder(fileName).build()) {
			String[] headline = null;
			String[] row;
			int rowCount = 0;

			while ((row = reader.readRowAsArray()) != null) {
				if (headline == null) {
					headline = row;
				} else {
					if (headline.length != row.length) {
						throw new AssertionError("Invalid CSV: Row " + rowCount + " has " + row.length
								+ " columns, but expecting " + headline.length + "!");
					}
				}

				rowCount++;
				rows.add(row);
			}
		}
	}

	/**
	 * Asserts that all supplied columns exist.
	 * 
	 * @param columns
	 *            expected columns
	 * @since 0.1.0
	 */
	public void assertColumns(Column... columns) {
		for (Column column : columns) {
			assertColumnExists(column);
		}
	}

	/**
	 * DOCME add JavaDoc for method assertColumn
	 * 
	 * @param column
	 * @since 0.1.0
	 */
	private void assertColumnExists(Column column) {
		for (int iColumn = 0; iColumn < rows.get(0).length; iColumn++) {
			boolean columnMatch = true;

			// TODO rework
			rowProcessig: for (int iRow = 0; iRow < rows.size(); iRow++) {
				if (rows.get(iRow).length <= iColumn) {
					// TODO implement assertColumnExists
					throw new UnsupportedOperationException("Method 'assertColumnExists' not implemented yet");
				}

				if (!rows.get(iRow)[iColumn].equals(column.cells[iRow])) {
					columnMatch = false;
					break rowProcessig;
				}
			}

			if (columnMatch) {
				return;
			}
		}

		throw new AssertionError("Column not found: " + column);// TODO unify error message
	}
}
