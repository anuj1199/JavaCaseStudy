package CaseStudy1;
import java.util.*;


class Person{
	private String name;
	private String dateOfBirth;
	private String gender;
	private String mobileNumber;
	private String bloodGroup;
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	public String getGender() {
		return gender;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup=bloodGroup;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	
}
class Donor extends Person{
	private String bloodBankName;
	private String donorType;
	private String donationDate;
	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName=bloodBankName;
	}
	public String getBloodBankName() {
		return bloodBankName;
	}
	public void setDonorType(String donorType) {
		this.donorType=donorType;
	}
	public String getDonorType() {
		return donorType;
	}
	public void setDonationDate(String donationDate) {
		this.donationDate=donationDate;
	}
	public String getDonationDate() {
		return donationDate;
	}
	public void displayDonationDetails() {
		System.out.println("Donation Details:");
		System.out.println("Name: "+getName());
		System.out.println("Date Of Birth: "+getDateOfBirth());
		System.out.println("Gender: "+getGender());
		System.out.println("Mobile Number: "+getMobileNumber());
		System.out.println("Blood Group: "+getBloodGroup());
		System.out.println("Blood Bank Name: "+getBloodBankName());
		System.out.println("Donor Type: "+getDonorType());
		System.out.println("Donation Date: "+getDonationDate());
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Donor d=new Donor();
		System.out.println("Enter the name: ");
		d.setName(sc.nextLine());
		System.out.println("Enter date of birth(Date format should be dd-mm-yyyy): ");
		d.setDateOfBirth(sc.nextLine());
		System.out.println("Enter gender: ");
		d.setGender(sc.nextLine());
		System.out.println("Enter mobile number: ");
		d.setMobileNumber(sc.nextLine());
		System.out.println("Enter blood group: ");
		d.setBloodGroup(sc.nextLine());
		System.out.println("Enter blood bank name: ");
		d.setBloodBankName(sc.nextLine());
		System.out.println("Enter donor type: ");
		d.setDonorType(sc.nextLine());
		System.out.println("Enter donation date(Date format should be dd-mm-yyyy): ");
		d.setDonationDate(sc.nextLine());
		d.displayDonationDetails();
	}

}
