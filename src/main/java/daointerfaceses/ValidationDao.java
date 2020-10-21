package daointerfaceses;

import pojoclasses.Validation;

public interface ValidationDao {
	
	// use for the done user validation for login ....
	public int userValidation(Validation v);
	
	// user for the done service provider validation for login
    public int serviceProviderValidation(Validation v);
    
	// user for the  done  admin validation for login...
    public int adminValidation(Validation v);
    
    //generate otp
    public String getOtp();
    
    //validation of email  id and username for forget password
    public int getValidUserEmail(Validation v);
    
    //validate of email and usernamme of spservice provider for forget password
    public int getValidSpEmailUname(Validation v);

    // validate of email and username of admin for forget password
    public int getValidAdminEmailUname(Validation v);
}
