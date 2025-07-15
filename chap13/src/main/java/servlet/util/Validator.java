package servlet.util;

import java.util.List;

import model.Employee;
import model.IsNotExistIdLogic;

public class Validator {
	// 名前検索でのチェック
	public void checkName(String name, 
			        List<String> errorList) {
		if (name == null || name.length() == 0) {
			errorList.add("文字が未入力です");
		}		
	}
	// 年齢検索用
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
	
	// create, update のとき用
	// ageTxtに誤りがあれば、ゼロにする
	public int checkAge(String ageTxt) {
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			age = 0;
		}
		return age;
	}
	
	public void checkId(Employee emp, List<String> errorList) {
		if (emp.getId() == null || emp.getId().length() == 0) {
			errorList.add("IDが入力されていません");
		}
		// id形式チェック
		emp.setId(emp.getId().toUpperCase());
		if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			errorList.add("IDの形式が違います");
		}
		// id重複チェック
		IsNotExistIdLogic logic = new IsNotExistIdLogic();
		if (!logic.execute(emp.getId())) {
			errorList.add("そのIDは存在しています");
		}		
	}
	
	public void checkAge(Employee emp, 
			     List<String> errorList) {
		if (emp.getAge() == 0) {
			errorList.add("年齢が不正です");
		}
	}
	
	public void checkName(Employee emp, 
			     List<String> errorList) {
		checkName(emp.getName(), errorList);
	}
	
	public void checkCreate(Employee emp, List<String> errorList) {
		checkId(emp, errorList);
		checkName(emp, errorList);
		checkAge(emp, errorList);
	}
	public void checkUpdate(Employee emp, List<String> errorList) {
		checkName(emp, errorList);
		checkAge(emp, errorList);
	}
}
