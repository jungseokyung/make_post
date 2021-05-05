package com.jungseokyung.makepost.model;

import java.util.ArrayList;
import java.util.List;

public class ApiParamInfo {
	private int methodNum;
	private String dataType;
	private int columnNum;
	private String Delimiter;
	private String[] datas;
// 	private List<String> datas;
	
	public String[] getDatas() {
		return datas;
	}
	
	public int getMethodNum() {
		return methodNum;
	}

	public void setMethodNum(int methodNum) {
		this.methodNum = methodNum;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getColumnNum() {
		return columnNum;
	}
	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}
	public String getDelimiter() {
		return Delimiter;
	}
	public void setDelimiter(String delimiter) {
		Delimiter = delimiter;
	}

	public ApiParamInfo() {
		List<String> datas = new ArrayList<String>();
		this.datas = datas.toArray(new String[datas.size()]);
	}
}
