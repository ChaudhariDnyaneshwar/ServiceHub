package pojoclasses;

import org.springframework.web.multipart.MultipartFile;

public class ServiceProvider 
{
    private int sp_id;
	private String fname;
	private String lname;
	private String mob_number;
	private String email;
	private String addar_number;
	private String gender;
	private String dateofbirth;
    private String specialization;
    private String office_address;
    private String city;
    private String tahsil;
    private String district;
    private String state;
    private String high_qualification;
    private String university_name;
    private String experiance;  
    private MultipartFile licence_certificate;
    private MultipartFile photo;
    private MultipartFile addar_image;
    private MultipartFile qualification_certificate;
    private String user_name;
    private String pssword;
    private String designation;
    
    
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSp_id() {
		return sp_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMob_number() {
		return mob_number;
	}
	public void setMob_number(String mob_number) {
		this.mob_number = mob_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddar_number() {
		return addar_number;
	}
	public void setAddar_number(String addar_number) {
		this.addar_number = addar_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTahsil() {
		return tahsil;
	}
	public void setTahsil(String tahsil) {
		this.tahsil = tahsil;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHigh_qualification() {
		return high_qualification;
	}
	public void setHigh_qualification(String high_qualification) {
		this.high_qualification = high_qualification;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	public String getExperiance() {
		return experiance;
	}
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
	
	public MultipartFile getLicence_certificate() {
		return licence_certificate;
	}
	public void setLicence_certificate(MultipartFile licence_certificate) {
		this.licence_certificate = licence_certificate;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public MultipartFile getAddar_image() {
		return addar_image;
	}
	public void setAddar_image(MultipartFile addar_image) {
		this.addar_image = addar_image;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPssword() {
		return pssword;
	}
	public void setPssword(String pssword) {
		this.pssword = pssword;
	}
	public MultipartFile getQualification_certificate() {
		return qualification_certificate;
	}
	public void setQualification_certificate(MultipartFile qualification_certificate) {
		this.qualification_certificate = qualification_certificate;
	}
    
    
    
}
