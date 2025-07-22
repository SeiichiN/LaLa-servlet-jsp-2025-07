package servlet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import model.MemberForm;

public class Validator {
	public List<String> check(MemberForm memberForm, 
			HttpServletRequest request) {
		String path = request.getServletPath();
		switch (path) {
		case "/createConfirm":
			return checkCreate(memberForm);
		case "/updateConfirm":
			// checkUpdate(memberForm);
			break;
		}
		return null;
	}
	
	public List<String> checkCreate(MemberForm memberForm) {
		List<String> errorList = new ArrayList<>();
		if (memberForm.getName() == null ||
				memberForm.getName().length() == 0) {
			errorList.add("名前が未入力です");
		}
		if (!isDate(memberForm.getBirthday())) {
			errorList.add("日付が不正です");
		}
		return errorList;
	}  // checkCreate end
	
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
