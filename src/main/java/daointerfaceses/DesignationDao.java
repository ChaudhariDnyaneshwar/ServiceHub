package daointerfaceses;

import java.util.List;

import pojoclasses.Designation;

public interface DesignationDao {

	public int addDesignation(Designation da);
    public List<Designation> getDesignation();
    

}
