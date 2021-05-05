package com.jungseokyung.makepost.model;

import java.util.List;

public class ApiFrameInfo {
	private List<ApiParamInfo> paramInfos;
	private ApiFileInfo fileInfo;
	
	public List<ApiParamInfo> getParamInfos() {
		return paramInfos;
	}
	public void setParamInfos(List<ApiParamInfo> paramInfos) {
		this.paramInfos = paramInfos;
	}
	public ApiFileInfo getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(ApiFileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	
}
