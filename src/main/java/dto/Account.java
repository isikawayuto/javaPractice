package dto;

public class Account {
	int id;
	String name;
	String age;
	String gender;
	String birthday;
	String address;
	String tel;
	String mail;
	String salt;
	String pw;
	public Account(int id, String name, String age, String gender, String birthday, String address, String tel,
			String mail, String salt, String pw) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.salt = salt;
		this.pw = pw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
