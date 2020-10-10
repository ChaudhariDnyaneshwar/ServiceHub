package daointerfaceses;

import pojoclasses.Validation;

public interface ValidationDao {
	
	public int userValidation(Validation v);
    public int serviceProviderValidation(Validation v);
    public int adminValidation(Validation v);
}
