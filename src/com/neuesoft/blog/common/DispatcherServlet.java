package com.neuesoft.blog.common;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuesoft.blog.annotation.Controller;
import com.neuesoft.blog.annotation.RequestMapping;

public class DispatcherServlet extends HttpServlet{
	 //�ع�  servlet��������    init    service  destroy
	  //��servlet�ճ�ʼ����ʱ�� ��init����     
	  //���е����󶼻���service  ������get ������post����  ����ȥ��service����
	    HashMap <String,Class>  map=new HashMap<String,Class>();
		@Override
		public void init() throws ServletException {
			 System.out.println("====init=======");
			 String  pack="com.neuesoft.blog.controller";
			 Set<Class<?>>  set=ScanUtil.getClasses(pack);
			 for (Class<?>  c : set) {
				if(c.isAnnotationPresent(Controller.class)){
					 Method[] methods=c.getMethods();
					 for (Method   m : methods) {
						if(m.isAnnotationPresent(RequestMapping.class)){
							RequestMapping  obj=m.getAnnotation(RequestMapping.class);
							map.put(obj.value(),c);
							System.out.println(obj.value()+"*"+c);
						}
					}
				}
			}
		}
		
		
		
	    @Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String uri=resolveUri(request);
			if(map.containsKey(uri)){
			  Class  c=	map.get(uri);
			  Method[]  methods=c.getMethods();
			  for (Method  m : methods) {
				  if(m.isAnnotationPresent(RequestMapping.class)){
				     RequestMapping  anno=m.getAnnotation(RequestMapping.class);
				     if(anno.value().equals(uri)){
				    	 try {
							m.invoke(c.newInstance(),request,response);
						  }catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     }
				  }
			}
			}
		}
		
		
		
		public  String  resolveUri(HttpServletRequest  request){
			 String  uri=request.getRequestURI();
			 uri=uri.replace("/blog", "");
			 uri=uri.replace("/prev", "");
			 return  uri;
		}
}
