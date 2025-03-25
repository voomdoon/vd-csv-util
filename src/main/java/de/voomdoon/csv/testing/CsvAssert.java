package de.voomdoon.csv.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.voomdoon.util.csv.reader.CsvReader;
import de.voomdoon.util.csv.reader.CsvReaderBuilder;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 * @deprecated TODO move to vd-csv-testing
 */
@Deprecated
public class CsvAssert {

	/**
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	public static record Column(String... cells) {

	}

	/**
	 * DOCME add JavaDoc for method assertCsv
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	public static CsvAssert assertCsv(String fileName) throws IOException {
		return new CsvAssert(fileName);
	}

	/**
	 * DOCME add JavaDoc for method column
	 * 
	 * @param cells
	 * @return
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
	 * DOCME add JavaDoc for constructor CsvAssert
	 * 
	 * @param fileName
	 * @throws IOException
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
	 * DOCME add JavaDoc for method assertColumns
	 * 
	 * @param columns
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
