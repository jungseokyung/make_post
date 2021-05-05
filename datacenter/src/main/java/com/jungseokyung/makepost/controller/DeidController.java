package com.jungseokyung.makepost.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.jungseokyung.makepost.model.FileInfo;
import com.jungseokyung.makepost.service.CollectDataManager;

@Controller
@RequestMapping("/UPAPI")
public class DeidController {

	@Autowired
	private CollectDataManager collectDataManager;

	private static final Logger logger = LoggerFactory.getLogger(DeidController.class);

	@RequestMapping(value = "/regService", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> workDeidRequest(HttpServletRequest request) throws UnsupportedEncodingException {
		Gson gson = new Gson();
		String result = "";
		FileInfo fileInfo = null;

		request.setCharacterEncoding("UTF-8");
		
		List<Map<String, Object>> list = collectDataManager.selectCollectDataCheck();
		PGobject pg = new PGobject();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);

			pg = (PGobject) map.get("file_info");
			result = pg.getValue();
			fileInfo = gson.fromJson(result, FileInfo.class);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		return new ResponseEntity<String>(fileInfo.getFilepath(), responseHeaders, HttpStatus.OK);
	}
}
