package daointerfaceses;

import pojoclasses.Validation;

public interface ValidationDao {
	
	// use for the done user validation for login ....
	public int userValidation(Validation v);
	
	// user for the done service provider validation for login
    public int serviceProviderValidation(Validation v);
    
	// user for the  done  admin validation for login...
    public int adminValidation(Validation v);
}
