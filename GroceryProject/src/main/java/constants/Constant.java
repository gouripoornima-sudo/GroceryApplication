package constants;

public class Constant {
	//"C:\Users\LENOVO\git\GroceryApplication\GroceryProject\src\main\resources\config.properties"
	public static final String testDatafile = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestDataGRO.xlsx";
	public static final String ConfigFile=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	
	// Assertion Error Message
		// Login
		public static final String ValidCredsError = "User was unable to login with valid credentials";
		public static final String InvalidUsernameError = "User was able to login with invalid username";
		public static final String InvalidPasswordError = "User was able to login with invalid password";
		public static final String InvalidCredsError = "User was able to login with invalid credentials";

		// Home
		public static final String UnsuccessfulLogoutError = "User was unable to logout";

		// AdminUsers
		public static final String UserEntryError = "New user entry has failed";
		public static final String UserSearchError = "User search has failed";
		public static final String UserResetError = "Users list reset has failed";

		// Manage News
		public static final String NewsEntryError = "New news entry has failed";
		public static final String NewsSearchError = "News search has failed";
		public static final String NewsResetError = "News reset has failed";
}
