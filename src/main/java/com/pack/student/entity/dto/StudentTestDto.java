package com.pack.student.entity.dto;

/*
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */
public class StudentTestDto {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailAddress;
	private String uploadedPhotos;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUploadedPhotos() {
		return uploadedPhotos;
	}
	public void setUploadedPhotos(String uploadedPhotos) {
		this.uploadedPhotos = uploadedPhotos;
	}
	

}
