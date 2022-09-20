package org.TourishManagement.GenericUtilities;

public enum WelcomePageLinks {

	ADMINLOGIN("Admin Login"),SIGNUP("Sign Up"),
	SIGNIN("/ Sign In"),HOME("Home"),ABOUT("About"),
	TOURPACKAGES("Tour Packages"),PRIVACYPOLICY("Privacy Policy"),
	TERMSOFUSE("Terms of Use"),CONTACTUS("Contact Us"),
	ENQUIRY(" Enquiry "),TOURISM("Tourism "),
	VIEWMOREPACKAGES("View More Packages");

	private String linkName;
	private WelcomePageLinks(String linkName)
	{
		this.linkName=linkName;
	}
	public String getLinkName() {
		return linkName;
	}

}

