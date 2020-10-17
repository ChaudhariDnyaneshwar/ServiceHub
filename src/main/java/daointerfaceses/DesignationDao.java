package daointerfaceses;

import java.util.List;

import pojoclasses.Designation;

public interface DesignationDao {

	//adding designation..
	public int addDesignation(Designation da);
   // get list of designation..
	public List<Designation> getDesignation();
    

}
