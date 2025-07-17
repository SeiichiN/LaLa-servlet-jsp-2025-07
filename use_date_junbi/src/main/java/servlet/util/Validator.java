package servlet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import model.MemberForm;

public class Validator {
	public void check(MemberForm memberForm, List<String> errorList) {
		if (memberForm.getName() == null ||
				memberForm.getName().length() == 0) {
			errorList.add("名前が未入力です");
		} else if (memberForm.getName().length() > 30) {
			errorList.add("名前が長すぎます");
		}
		
		if (!isDate(memberForm.getBirthday())) {
			errorList.add("日付が不正です");
		}
		
	}
	
	public static boolean isDate(String dateTxt) {
		String pattern = "yyyy/MM/dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		try {
			LocalDate.parse(dateTxt, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
}
