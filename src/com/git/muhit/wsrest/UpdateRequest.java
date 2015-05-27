package com.git.muhit.wsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.muhit.controller.UpdateBean;

@RestController
@RequestMapping("/update")
public class UpdateRequest implements UpdateInterface {
	@Autowired
	private UpdateBean updateBean;
	
	@RequestMapping("/all")
	public String all() {
		return updateBean.all();
	}
}