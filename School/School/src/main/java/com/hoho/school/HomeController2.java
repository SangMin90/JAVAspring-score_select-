package com.hoho.school;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoho.school.DB2;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController2.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @RequestParam("student_no") int student_no) {
		model.addAttribute("student_no", student_no);
		
		DB2 db = new DB2("c:\\tomcat\\users.db", "students_info") ;
		db.open();
		try {
			Student student = db.selectData(student_no); // 오버라이드해서 하나 만들자
			model.addAttribute("name", student.name);
			model.addAttribute("kor", student.kor);
			model.addAttribute("eng", student.eng);
			model.addAttribute("math", student.math);
		} catch (Exception e) {
			// TODO: handle exception
		}
		db.close();
		
		return "update";
	}
	
	@RequestMapping(value = "/select_score", method = RequestMethod.GET)
	public String select_socre(Locale locale, Model model) {
		DB2 db = new DB2("c:\\tomcat\\users.db", "students_score");
		db.open();
		try {
			ArrayList<Student> result = db.selectData();
			StringBuffer result2 =  new StringBuffer();
			for (int i = 0; i < result.size(); i++) {
				result2.append("<tr>");
//				result2.append("<td>" + result.get(i).student_no + "</td>");
				result2.append("<td>" + result.get(i).name + "</td>");
				result2.append("<td>" + result.get(i).kor + "</td>");
				result2.append("<td>" + result.get(i).eng + "</td>");
				result2.append("<td>" + result.get(i).math + "</td>");
//				result2.append("<td>" + result.get(i). + "</td>");
				result2.append("<td>" + "<a href = '/school/update?student_no=" + result.get(i).student_no +"'>수정하기</a>"+ "</td>");
				result2.append("</tr>");
			}
			
//			String result = db.selectData1();
			model.addAttribute("html",result2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		db.close();
		
		
		
		return "select_score";
	}
	@RequestMapping(value = "/update_action", method = RequestMethod.POST)
	public String updateAction(Locale locale, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		DB2 db = new DB2("c:\\tomcat\\users.db", "students_score");
		db.open();
		try {
			int student_no = Integer.parseInt(request.getParameter("student_no"));
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor")); // 사용자가 string으로 보낸다 할지라도 int로 변경하기 때문에 오류가 안남
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			Student student = new Student(student_no, name, kor, eng, math);
			db.updateData(student);
		} catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		return "redirect:/select_score";
	}
	
	
	@RequestMapping(value = "/insert_score", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {
		return "insert_score";
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.POST)
	public String insertAction(Locale locale, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
//		int student_no = Integer.parseInt(request.getParameter("student_no"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		if (kor <= 100 && eng <= 100 && math <= 100) {
			Student student = new Student( name, kor, eng, math);
			DB2 dbReader = new DB2("c:\\tomcat\\users.db", "students_score");
			dbReader.open();
			try {
				dbReader.insertData(student);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			dbReader.close();
			
			return "redirect:/select_score";
		} else {
			String htmlText = "<script>alert('점수 100점 초과')</script>";
			model.addAttribute("alert", htmlText);
			return "insert_score";
		}
		
		
	}
	
	
	
	
	
	
	
	
}
