package servlet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import model.MemberForm;

public class Validator {
	public List<String> check(MemberForm memberForm, HttpServletRequest request) {
		String path = request.getServletPath();
		List<String> errorList = new ArrayList<>();
		if (!path.equals("/createConfirm")) {
			if (memberForm.getId() == 0) {
				errorList.add("IDが不正です");
			}
		}
		if (isNull(memberForm.getName())) {
			errorList.add("名前が未入力です");
		}
		if (!isDate(memberForm.getBirthday())) {
			errorList.add("日付が不正です");
		}
		return errorList;
	}  // checkCreate end
	
	public boolean isNull(String text) {
		if (text == null || text.length() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isDate(String dateTxt) {
		String pattern = "yyyy/MM/dd";
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern(pattern);
		try {
			LocalDate.parse(dateTxt, formatter);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	
} // class end
