package com.egeo.utils.excel;

/**
 * MyRow
 * 
 * @date 2014-10-30 16:31:53
 * @version 1.0
 */
public class ExcelRow {
	private int index = 0;
	private Integer startRow;
	private ExcelCell[] keys;

	public ExcelRow(int startRow, int cells) {
		this.startRow = startRow;
		this.keys = new ExcelCell[cells];
	}

	public void addCellKey(int index, ExcelCell key) {
		if (key == null || "".equals(keys))
			return;
		keys[index] = key;
	}

	public ExcelCell[] getKeys() {
		return keys;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public int nextIndex() {
		return ++index;
	}
}
