package servlet.util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsNotExistIdLogic;

public class Validator {
	public void checkName(String name, 
			        List<String> errorList) {
		if (name == null || name.length() == 0) {
			errorList.add("文字が未入力です");
		}		
	}
	
	public int checkAge(String ageTxt, 
			        List<String> errorList) {
		if (ageTxt == null || ageTxt.length() == 0) {
			errorList.add("年齢が未入力です");
			return 0;
		}
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			errorList.add("数字ではない");
		}
		return age;
	}
	
	public int checkAge(String ageTxt) {
		List<String> errorList = new ArrayList<>();
		return checkAge(ageTxt, errorList);
	}
	
	public void check(Employee emp, List<String> errorList) {
		// id形式チェック
		emp.setId(emp.getId().toUpperCase());
		if (!emp.getId().matches("EMP[0-9]{3}")) {
			errorList.add("IDの形式が違います");
		}
		
		// id重複チェック
		IsNotExistIdLogic logic = new IsNotExistIdLogic();
		if (!logic.execute(emp.getId())) {
			errorList.add("そのIDは既に存在しています");
		}
		// nameチェック
		this.checkName(emp.getName(), errorList);
	}
}
