package com.egeo.utils.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * ExcelTemplate
 * 
 * @date 2014-9-16 15:16:03
 * @version 1.0
 */
public class ExcelTemplate {
	private static Logger logger = LoggerFactory.getLogger(ExcelTemplate.class);
	private Map<String, Object> data;
	private Map<String, ExcelRow> varMap = new HashMap<String, ExcelRow>();
	private Workbook wb;
	private String suffix;

	private ExcelTemplate() {
	}

	/**
	 * 获取一个工具类实例<br>
	 * 代码示例<br>
	 * <code>
		List<Map<String, Object>> users = new ArrayList<Map<String, Object>>(1);<br>
		Map<String, Object> user = new HashMap<String, Object>();<br>
		user.put("userName", "张三");<br>
		user.put("dept", "技术部");<br>
		user.put("type", null);<br>
		user.put("mobile", "13703787018");<br>
		users.add(user);<br>
		user = new HashMap<String, Object>();<br>
		user.put("userName", "李四");<br>
		user.put("dept", "市场部");<br>
		user.put("type", 1);<br>
		user.put("mobile", "13703787020");<br>
		users.add(user);<br>
	<br>
		Map<String, Object> data = new HashMap<String, Object>();<br>
		data.put("user", users);<br>
		ExcelTemplate excel = ExcelTemplate.getInstance(template, data);<br>
		excel.write(new FileOutputStream(filePath));<br>
	 *            </code> <br>
	 * ${user.userName} ${user.dept} ${user.type} ${user.mobile}
	 * 
	 * @param template
	 *            excel模板文件的路径
	 * @param data
	 *            需要导入excel的数据<br>
	 *            默认初始化的参数<br>
	 *            ${default.year}-->2016<br>
	 *            <code>
		map.put("year", calendar.get(Calendar.YEAR));<br>
		map.put("month", calendar.get(Calendar.MONTH) + 1);<br>
		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));<br>
		map.put("hour", calendar.get(Calendar.HOUR));<br>
		map.put("hour24", calendar.get(Calendar.HOUR_OF_DAY));<br>
		map.put("minute", calendar.get(Calendar.MINUTE));<br>
		map.put("second", calendar.get(Calendar.MILLISECOND));<br>
		map.put("millisecond", calendar.get(Calendar.MILLISECOND));<br>
		map.put("time", calendar.getTime());<br>
	 *  </code>
	 * @return
	 * @throws IOException
	 */
	public static ExcelTemplate getInstance(String template, Map<String, Object> data) throws IOException {
		if (template == null) {
			throw new IllegalArgumentException("template is null");
		} else if (!template.toLowerCase().endsWith(".xls") && !template.toLowerCase().endsWith(".xlsx")) {
			throw new IllegalArgumentException("suffix of template file is not '.xls' or '.xlsx'");
		}
		ExcelTemplate excel = new ExcelTemplate();
		FileInputStream file = new FileInputStream(template);
		if (template.toLowerCase().endsWith(".xls")) {
			excel.suffix = ".xls";
			excel.wb = new HSSFWorkbook(file);
		} else {
			excel.suffix = ".xlsx";
			excel.wb = new XSSFWorkbook(file);
		}
		data.put("default", getDefaultVariable());
		excel.data = data;
		return excel;
	}

	private static Map<String, Object> getDefaultVariable() {
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		map.put("year", calendar.get(Calendar.YEAR));
		map.put("month", calendar.get(Calendar.MONTH) + 1);
		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));
		map.put("hour", calendar.get(Calendar.HOUR));
		map.put("hour24", calendar.get(Calendar.HOUR_OF_DAY));
		map.put("minute", calendar.get(Calendar.MINUTE));
		map.put("second", calendar.get(Calendar.MILLISECOND));
		map.put("millisecond", calendar.get(Calendar.MILLISECOND));
		map.put("time", calendar.getTime());
		return map;
	}

	/**
	 * 获取excel后缀,xls or xlsx
	 * 
	 * @return
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * 创建工作簿
	 * 
	 * @return 工作簿对象
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private Workbook create() {
		int number = wb.getNumberOfSheets();
		int i = 0;
		while (i++ < number) {
			Sheet sheet = wb.getSheetAt(i - 1);
			// 执行第二个sheet时，一定要把第一个的旧数据清掉。
			varMap = new HashMap<String, ExcelRow>();
			importFirst(sheet);
			importSecond(sheet);
		}
		return wb;
	}

	/**
	 * 执行第二步，插入list数据
	 * 
	 * @param sheet
	 */
	private void importSecond(Sheet sheet) {
		if (varMap.keySet().size() > 0) {
			for (String key : varMap.keySet()) {
				ExcelRow myRow = varMap.get(key);
				@SuppressWarnings("unchecked")
				List<Object> list = (List<Object>) data.get(key);
				if (list == null || list.size() == 0) {
					importNullRow(sheet, myRow);
				} else {
					insertRow(sheet, myRow, list);
				}
			}
		}
	}

	/**
	 * 给第一行设置空值，因为没有数据
	 * 
	 * @param sheet
	 * @param myRow
	 */
	private void importNullRow(Sheet sheet, ExcelRow myRow) {
		Row sourceRow = sheet.getRow(myRow.getStartRow());
		for (int k = 0; k < myRow.getKeys().length; k++)
			setValue(sourceRow.getCell(k), null);
	}

	/**
	 * 插入行数据
	 * 
	 * @param sheet
	 * @param myRow
	 * @param list
	 */
	private void insertRow(Sheet sheet, ExcelRow myRow, List<Object> list) {
		int startRow = myRow.getStartRow();
		int endRow = sheet.getLastRowNum();
		// 如果已经是最后 一行，则不用 移动
		// 如果list只有一行数据，也不需要移动
		if (list.size() > 1 && endRow > startRow)
			sheet.shiftRows(startRow + 1, endRow, list.size() - 1, true, true);
		// 记录源行，以便复制此行的格式到后面
		Row sourceRow = sheet.getRow(startRow++);
		for (int k = 0; k < list.size(); k++) {
			Object obj = list.get(k);
			if (k == 0) {
				importFirstRowValue(sourceRow, myRow, obj);
			} else {
				// 后面的要复制源行的格式
				Row row = sheet.getRow(startRow++);
				if (row == null)
					row = sheet.createRow(startRow - 1);
				copyRow(myRow, row, sourceRow, obj);
				row.setHeight(sourceRow.getHeight());
			}
		}
	}

	/**
	 * 填入list中第一行的值
	 * 
	 * @param sheet
	 * @param myRow
	 */
	private void importFirstRowValue(Row sourceRow, ExcelRow myRow, Object obj) {
		// 第一行直接填值
		for (int i = 0; i < myRow.getKeys().length; i++) {
			if (myRow.getKeys() == null)
				continue;
			ExcelCell excelCell = myRow.getKeys()[i];
			if (excelCell == null)
				continue;
			String key = excelCell.getKey();
			Cell cell = sourceRow.getCell(i);
			if (key == null)
				continue;
			if (key.equals("rowIndex"))
				setValue(cell, myRow.nextIndex() + "");
			else
				importCellValue(obj, myRow.getKeys()[i], cell);
		}
	}

	/**
	 * 从指定源数据行，复制格式到新行，并填入数据
	 * 
	 * @param myRow
	 *            数据对象的属性来源(来自于变量)
	 * @param row
	 *            新行
	 * @param sourceRow
	 *            源行
	 * @param obj
	 *            数据对象
	 */
	private void copyRow(ExcelRow myRow, Row row, Row sourceRow, Object obj) {
		for (int i = 0; i < myRow.getKeys().length; i++) {
			if (myRow.getKeys() == null)
				continue;
			Cell cell = row.createCell(i);
			Cell srcCell = sourceRow.getCell(i);
			copyCell(cell, srcCell);
			ExcelCell excelCell = myRow.getKeys()[i];
			if (excelCell == null)
				continue;
			String key = excelCell.getKey();
			if (key == null)
				continue;
			if (key.equals("rowIndex"))
				setValue(cell, myRow.nextIndex() + "");
			else
				importCellValue(obj, myRow.getKeys()[i], cell);
		}
	}

	/**
	 * 复制单元格
	 * 
	 * @param cell
	 * @param srcCell
	 */
	private void copyCell(Cell cell, Cell srcCell) {
		cell.setCellStyle(srcCell.getCellStyle());
		switch (srcCell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			cell.setCellValue(srcCell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cell.setCellValue(srcCell.getNumericCellValue());
			break;
		default:
			cell.setCellValue(srcCell.getStringCellValue());
			break;
		}
	}

	private void importCellValue(Object obj, ExcelCell excelCell, Cell cell) {
		String key = excelCell.getKey();
		Object curValue = getValue(obj, key);
		curValue = transferValue(excelCell, obj, curValue);
		setValue(cell, curValue);
	}

	@SuppressWarnings("rawtypes")
	private Object getValue(Object obj, String key) {
		if (obj instanceof Map) {// 如果是map或者其他对象,则获取相应属性值
			return ((Map) obj).get(key);
		} else {
			try {
				String getter = "get" + firstCharUpperCase(key);
				Method method = obj.getClass().getMethod(getter);
				return method.invoke(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 根据obj的值,替换value中的变量
	 * 
	 * @param obj
	 * @param value
	 * @return
	 */
	private String replaceAllVariable(Object obj, String value) {
		String[] varNames = getVariables(value);
		if (varNames == null || varNames.length < 1)
			return value;
		for (String varName : varNames) {
			Object varValue = getValue(obj, varName);
			String strValue = varValue == null ? "null" : varValue.toString();
			value = value.replaceAll("\\$\\{" + varName + "\\}", strValue);
		}
		return value;
	}

	private Object transferValue(ExcelCell excelCell, Object obj, Object curValue) {
		if (excelCell.getDictMap() != null) {
			if (curValue != null)
				return excelCell.getDictMap().get(curValue.toString());
			return excelCell.getDictMap().get("NULL");
		}
		if (excelCell.getCondition() != null) {
			try {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("js");
				String script = excelCell.getCondition();
				script = replaceAllVariable(obj, script);
				return engine.eval(script);
			} catch (Exception e) {
				logger.error("", e);
			}
		}
		return curValue;
	}

	/**
	 * 执行第一步，填入非list javabean、map或者 Object.toString()
	 * 
	 * @param sheet
	 */
	private void importFirst(Sheet sheet) {
		Row row = null;
		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();
		// 遍历行
		int rowNum = firstRow;
		while (rowNum <= lastRow) {
			row = sheet.getRow(rowNum);
			if (row != null) {
				importRowFirst(row, rowNum);
			}
			rowNum++;
		}
	}

	/**
	 * 执行第一步，填入非list javabean、map或者 Object.toString()
	 * 
	 * @param row
	 * @param rowNum
	 */
	private void importRowFirst(Row row, int rowNum) {
		if (row != null) {
			int firstCell = row.getFirstCellNum();
			int lastCell = row.getLastCellNum();
			String value = null;
			// 遍历列
			int cellNum = firstCell;
			while (cellNum <= lastCell) {
				Cell cell = row.getCell(cellNum);
				value = getStringCellValue(cell);
				if (value != null && value.length() > 0) {
					if (isVariable(value))
						importCellFirst(cell, value, rowNum, cellNum, lastCell);
					// 如果是局部有变量,就处理掉
					else {
						importCellHasVariable(cell, value);
					}
				} else {
					if (cell != null && cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
						String formula = cell.getCellFormula();
						formula = transferValueHasVariable(formula);
						cell.setCellFormula(formula);
					}
				}
				cellNum++;
			}
		}
	}

	/**
	 * 处理存在变量的单元格
	 * 
	 * @param cell
	 * @param value
	 */
	private void importCellHasVariable(Cell cell, String value) {
		value = transferValueHasVariable(value);
		setValue(cell, value);
	}

	private String transferValueHasVariable(String value) {
		String[] varNames = getVariables(value);
		if (varNames == null || varNames.length < 1)
			return value;
		for (String varName : varNames) {
			if (varName.indexOf(".") < 0) {
				String varValue = data.get(varName) == null ? "" : data.get(varName).toString();
				value = value.replaceAll("\\$\\{" + varName + "\\}", varValue);
			} else {
				String[] vars = varName.split("\\.");
				// 加断言判断变量长度和值的正确性
				Object obj = data.get(vars[0]);
				if (!(obj instanceof List)) {
					String varValue = getValueByKey(obj, vars[1]);
					value = value.replaceAll("\\$\\{" + varName + "\\}", varValue);
				}
			}
		}
		return value;
	}

	/**
	 * 获取单元格的String值，不是字符类型的返回null
	 * 
	 * @param cell
	 * @return
	 */
	private String getStringCellValue(Cell cell) {
		if (cell != null && cell.getCellType() == Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		return null;
	}

	/**
	 * 给一个单元格填入数据,不填入list对象的值
	 * 
	 * @param cell
	 * @param value
	 * @param rowNum
	 * @param cellNum
	 * @param cells
	 */
	private void importCellFirst(Cell cell, String value, int rowNum, int cellNum, int cells) {
		String varName = getVariable(value);
		if (varName.indexOf(".") < 0) {
			setValue(cell, data.get(varName));
			return;
		}
		String[] vars = varName.split("\\.");
		// 加断言判断变量长度和值的正确性
		Object obj = data.get(vars[0]);
		if (obj instanceof List) {// 如果是list则记录，最后统一处理
			ExcelRow myRow = varMap.get(vars[0]);
			if (myRow == null)
				myRow = new ExcelRow(rowNum, cells);
			ExcelCell excelCell = getExcelCell(cell, vars);
			myRow.addCellKey(cellNum, excelCell);
			varMap.put(vars[0], myRow);
		} else {
			importCellValue(obj, vars[1], cell);
		}
	}

	private ExcelCell getExcelCell(Cell cell, String[] vars) {
		ExcelCell excelCell = new ExcelCell(vars[1]);
		Comment comment = cell.getCellComment();
		try {
			if (comment != null) {
				String str = comment.getString().getString();
				if (str != null) {
					if (str.startsWith("fn:")) {
						excelCell.setCondition(str.substring(3));
					} else {
						// 根据字段
						@SuppressWarnings("unchecked")
						Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(str),
								Map.class);
						excelCell.setDictMap(map);
					}
				}
				cell.setCellComment(null);
			}
		} catch (Exception e) {
			logger.error("", e);
			// 处理此处出错不应影响其他程序
		}
		return excelCell;
	}

	/**
	 * 填充单元格的值
	 * 
	 * @param obj
	 *            包含值的对象
	 * @param key
	 *            取值的key
	 * @param cell
	 *            需要填值的单元格
	 */
	private void importCellValue(Object obj, String key, Cell cell) {
		if (obj instanceof Map) {// 如果是map或者其他对象,则获取相应属性值
			@SuppressWarnings("rawtypes")
			Object curValue = ((Map) obj).get(key);
			setValue(cell, curValue);
		} else {
			try {
				String getter = "get" + firstCharUpperCase(key);
				Method method = obj.getClass().getMethod(getter);
				Object curValue = method.invoke(obj);
				setValue(cell, curValue);
			} catch (Exception e) {
				logger.error("", e);
			}
		}
	}

	/**
	 * @param cell
	 * @param curValue
	 */
	private void setValue(Cell cell, Object curValue) {
		if (curValue == null) {
			cell.setCellValue("");
		} else {
			if (curValue instanceof Number) {
				// 数字
				cell.setCellValue(((Number) curValue).doubleValue());
			} else if (curValue instanceof Date) {
				// 日期
				cell.setCellValue((Date) curValue);
			} else if (curValue instanceof Calendar) {
				// 日历
				cell.setCellValue((Calendar) curValue);
			} else if (curValue instanceof Boolean) {
				// 布尔
				cell.setCellValue((Boolean) curValue);
			} else {
				// 字符
				cell.setCellValue(curValue.toString());
			}
		}
	}

	/**
	 * 获取对象中指定字段的值
	 * 
	 * @param obj
	 * @param key
	 * @return
	 */
	private String getValueByKey(Object obj, String key) {
		if (obj == null)
			return "";
		try {
			if (obj instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) obj;
				if (map.get(key) != null) {
					return map.get(key).toString();
				}
			} else {
				String getter = "get" + firstCharUpperCase(key);
				Method method = obj.getClass().getMethod(getter);
				Object curValue = method.invoke(obj);
				if (curValue != null)
					return curValue.toString();
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return "";
	}

	/**
	 * 获取字符中包含的所有变量
	 * 
	 * @param value
	 * @return
	 */
	private String[] getVariables(String value) {
		String rexp = "(\\$\\{[a-z,A-Z,_,0-9\\.]+\\})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(value);
		List<String> list = new LinkedList<String>();
		while (m.find()) {
			String var = m.group(0);
			list.add(var);
		}
		if (list.size() < 1)
			return null;
		String[] vars = new String[list.size()];
		for (int i = 0; i < vars.length; i++)
			vars[i] = list.get(i).substring(2, list.get(i).length() - 1);
		return vars;
	}

	/**
	 * 判断是否是个变量
	 * 
	 * @param value
	 * @return
	 */
	private boolean isVariable(String value) {
		if (value == null)
			return false;
		if (value.startsWith("${") && value.endsWith("}")) {
			if (value.indexOf("{", 2) < 0)
				return true;
		}
		return false;
	}

	private static String firstCharUpperCase(String str) {
		char[] cs = str.toCharArray();
		cs[0] = upperCase(cs[0]);
		return String.valueOf(cs);
	}

	private static char upperCase(char c) {
		if (c >= 97 && c <= 122)
			c -= 32;
		return c;
	}

	/**
	 * 获取变量名
	 * 
	 * @param value
	 * @return
	 */
	private String getVariable(String value) {
		return value.substring(2, value.length() - 1);
	}

	/**
	 * 将excel写入文件流<br>
	 * with flush & close
	 * 
	 * @param outputStream
	 */
	public void write(OutputStream outputStream) {
		if (outputStream == null)
			return;
		try {
			create().write(outputStream);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				outputStream.flush();
				outputStream.close();
			} catch (Exception e2) {
				logger.error("关闭输出流异常", e2);
			}
		}
	}
}
