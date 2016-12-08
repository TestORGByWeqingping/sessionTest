package com.my.contorller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/session")
public class TestContorller {
	
  @RequestMapping("/create")
  public @ResponseBody String create(HttpServletRequest request,HttpServletResponse response) throws UnknownHostException{
	  request.getSession().setAttribute("UUID", UUID.randomUUID());
	  String name=(String)request.getSession().getAttribute("UUID");
	  return " create:HOST:"+request.getLocalAddr()+":"+request.getLocalPort()+"session"+ name;
  }
  
  @RequestMapping("/get")
  public @ResponseBody String get(HttpServletRequest request,HttpServletResponse response) throws UnknownHostException{
	  String UUID=(String)request.getSession().getAttribute("UUID");
	  return "get:HOST:"+request.getLocalAddr()+":"+request.getLocalPort()+"session"+ UUID;
  }
}
