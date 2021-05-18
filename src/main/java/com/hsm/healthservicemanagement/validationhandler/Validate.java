package com.hsm.healthservicemanagement.validationhandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hsm.healthservicemanagement.entity.User;

public class Validate {
	public static boolean validateEmailId(String email) {
		{
			String emailRegex = "^(.+)@+(.+)$";

			Pattern pat = Pattern.compile(emailRegex);
			if (email == null)
				return false;
			return pat.matcher(email).matches();
		}

	}

	public static boolean validateMobilNo(String mobileno) {
		String regex = "^[0-9]{10}$";
		Pattern p = Pattern.compile(regex);
		if (mobileno == null) {
			return false;
		}
		Matcher m = p.matcher(mobileno);
		return m.matches();
	}

	public static boolean validateUserId(String userid) {
		String regex = "[A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		if (userid == null) {
			return false;
		}
		Matcher m = p.matcher(userid);
		return m.matches();
	}

	public static boolean validateFirstName(String firstname) {
		String regex = "[A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		if (firstname == null) {
			return false;
		}
		Matcher m = p.matcher(firstname);
		return m.matches();
	}

	public static boolean validateLastName(String lastname) {
		String regex = "[A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		if (lastname == null) {
			return false;
		}
		Matcher m = p.matcher(lastname);
		return m.matches();

	}

	public static boolean validatePassword(String password) {
		String regex = "[A-Za-z0-9]+";
		Pattern p = Pattern.compile(regex);
		if (password == null) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public static void validateUser(User register) throws Exception {
		if (!validateEmailId(register.getEmail())) {
			throw new Exception("Invalid EmailId");
		} else if (!validateMobilNo(register.getMobile_no())) {
			throw new Exception("Invalid MobileNo");
		} else if (!validateUserId(register.getUserid())) {
			throw new Exception("Invalid UserId");
		} else if (!validateFirstName(register.getFirstname())) {
			throw new Exception("Invalid FirstName");
		} else if (!validateLastName(register.getLastname())) {
			throw new Exception("Invalid LastName");
		} else if (!validatePassword(register.getPassword())) {
			throw new Exception("Invalid Password");

		}
	}
}
