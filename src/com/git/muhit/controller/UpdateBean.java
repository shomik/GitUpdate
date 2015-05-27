package com.git.muhit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class UpdateBean {
	public String all() {
		try {
			Process p = Runtime.getRuntime().exec("whoami");
//			System.out.println(getProcessOutput(p));
			
//			String gitPathCommand = "git -C /home/grs/jboss-as-7.1.1.Final/welcome-content pull origin develop";
//			Process p = Runtime.getRuntime().exec(gitPathCommand);
			
			return getProcessOutput(p);
		} catch(IOException io) {
			System.out.println(io);
			io.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	private String getProcessOutput(Process p) {
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
	    BufferedReader success = new BufferedReader(new InputStreamReader(p.getInputStream()));
	 
	    String line = "";			
	    try {
			while ((line = success.readLine())!= null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	    try {
			while ((line = error.readLine())!= null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return sb.toString();
	}
}
