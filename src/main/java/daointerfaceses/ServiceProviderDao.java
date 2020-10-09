package daointerfaceses;

import java.sql.Blob;

import java.util.List;

import pojoclasses.ServiceProvider;

public interface ServiceProviderDao {

	public int save(ServiceProvider p);
	public List<ServiceProvider> getServiceProvider();
	public Blob getSpImage(int id);
	public Blob getSpAdharImage(int id);
	public Blob getSpLicence(int id);
	public Blob getSpQualificationImg(int id);
	public List<ServiceProvider> getList();
	public Blob getspRequestImage(int id);
	public Blob getspRequestQcertificate(int id);
	public Blob getspReqeustlicence(int id);
	public Blob getspRequestAddarImage(int id);
	public int rejectServiceProvider(int id);
	public int acceptSpRequest(int id);
	public int deleteSrviceProvider(int id);
	public  List<ServiceProvider> getDrelatedSp(String designation);

	
}
