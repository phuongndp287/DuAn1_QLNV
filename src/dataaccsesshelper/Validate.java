package dataaccsesshelper;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isDateValid(String date) {

		String dateRegex = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
		Pattern pat = Pattern.compile(dateRegex);
		if (date == null)
			return false;
		if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") || date.matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")
				|| date.matches("([0-9]{2})/([1-9]{1})/([0-9]{4})")
				|| date.matches("([1-9]{1})/([0-9]{1})/([0-9]{4})")) {
			return true;
		} else
			return false;
	}

	public static String ConvertDate(String date) {
		if (date == null) {
			return "";
		} else {
			return date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4);
		}

	}

	public static String ConvertDatetoDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date dateconver = formatter.parse(date);

			String dateFormat = formatter.format(dateconver);
			return dateFormat;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static String ConverDatetoSQL(String date) {
		return date.substring(6, 10) + date.substring(3, 5) + date.substring(0, 2);
	}

	public static int checkNumberPhone(String number) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(number);
		if (!matcher.matches()) {
			return -1;
		} else if (number.length() == 10 || number.length() == 11) {
			if (number.length() == 10) {
				if (number.substring(0, 2).equals("09")) {
					return 1;
				} else {
					return 0;
				}
			} else if (number.substring(0, 2).equals("01")) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 2;
		}
	}

	public static void main(String args[]) {

		isDateValid("1/1/1994");
		System.out.println(ConvertDatetoDate("1/1/1994"));
		String date = ConverDatetoSQL(ConvertDatetoDate("1/1/1994"));
		System.out.println(date);

	}

	public static String md5(String input) {
		MessageDigest md;
		StringBuffer sB;
		String output = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] digest = md.digest();
			sB = new StringBuffer();
			for (byte b : digest) {
				sB.append(String.format("%02x", b & 0xff));
			}
			output = sB.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return output;
	}

}
