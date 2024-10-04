package jsp.servlet.mysql.crud.managementsystem01.model;


public class Members {

	protected  int id;
	protected  String name;
	protected  String address;
	protected  String course;
	protected  String gender;
	protected  String position;
	protected  String remarks;
	protected  String picturelocation;
	
	
	protected String username;
	protected String password;

   
    
  
	public Members() {}
	
    public Members(String name1, String address1, String course1,String gender1, String position1,String remarks1,String picturelocation1)
    {
    	super();
        this.name = name1;
        this.address = address1;
        this.course=course1;
        this.gender=gender1;
        this.position=position1;
        this.remarks=remarks1;
        this.picturelocation=picturelocation1;
     
    }
    
    public Members( int id1, String name1, String address1, String course1,String gender1, String position1,String remarks1,String picturelocation1)
    {
    	super();
        this.id = id1;
        this.name = name1;
        this.address = address1;
        this.course=course1;
        this.gender=gender1;
        this.position=position1;
        this.remarks=remarks1;
        this.picturelocation=picturelocation1;
     
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPicturelocation() {
		return picturelocation;
	}

	public void setPicturelocation(String picturelocation) {
		this.picturelocation = picturelocation;
	}
	
	//this setter and getter is for the login
	 public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
   
 
   
}
