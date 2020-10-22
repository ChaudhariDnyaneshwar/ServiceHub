package daointerfaceses;

import java.sql.Blob;

import java.util.List;

import pojoclasses.ServiceProvider;
import pojoclasses.User;

public interface ServiceProviderDao {
	
	//=======insert the service provider registration request into the database..
	public int save(ServiceProvider p);
	
	//=====get list of the service provider from data base.
	public List<ServiceProvider> getServiceProvider();
	
	//====get service provider image list from database..
	public Blob getSpImage(int id);
	
	//=====get service provider adhar card image from database..
	public Blob getSpAdharImage(int id);
	
	//===get service provider licence photo from database..
	public Blob getSpLicence(int id);
	
	 //===get service provider qualification photo from database..
	public Blob getSpQualificationImg(int id);
	
	//=====get the list of service provider registration  request list
	public List<ServiceProvider> getList();
	
	//==get service provider registration request image from database..
	public Blob getspRequestImage(int id);
	
	//==get service provider registartion request qualification certificate image from database...
	public Blob getspRequestQcertificate(int id);
	
	//==get service provider registration request licence image from database...
	public Blob getspReqeustlicence(int id);
	
	//==get service provider registartion request Adhar card image from database...
	public Blob getspRequestAddarImage(int id);
	
	//===Reject service provider registration request from admin...
	public int rejectServiceProvider(int id);
	
	//===Accept Service provider registration request  from admin...
	public int acceptSpRequest(int id);
	
	//=== delete service provider from database to through admin
	public int deleteSrviceProvider(int id);
	
	//==get designation related service provider for user...
	public  List<ServiceProvider> getDrelatedSp(String designation);
	
	//===get client appointment list for service provider ..
    public List<User> getClient(String spuname);
	
    //get updated password when service provider forget his passowrd
    public int updateSpPassword(ServiceProvider s);

   //get service provider profile==========================
    
    public List<ServiceProvider> getSpProfile(ServiceProvider s);

   //get service provider image for profile====
     
    public Blob getSpImageProfile(ServiceProvider s);

}
