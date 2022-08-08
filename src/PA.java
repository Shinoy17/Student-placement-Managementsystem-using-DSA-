import java.io.Serializable;
// Shinoy
public class PA implements Serializable{
    private String password; //Password
	private Long phNo; //phone numberr
	private String email; //email
	private String name; //name
    private String Organisation; //Organisation name 

    //single parametric constructor for class
    PA(String password){
        this.password = password;
    }

    //multi parametric constructor for class
    PA(String password, Long phNo, String email,String name, String Organisation){
        this.password = password;
        this.phNo = phNo;
        this.email = email;
        this.name = name;
        this.Organisation = Organisation;
    }

    //setter and getter for password
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //setter and getter for phone number 
    public Long getPhone(){
        return this.phNo;
    }
    public void setPhone(Long phNo){
        this.phNo = phNo;
    }

    //setter and getter for email
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String Email){
        this.email = Email;
    }

    //setter and getter for name
    public String getName(){
        return this.name;
    }
    public void setName(String Name){
        this.name = Name;
    }

    //setter and getter for organisation name
    public String getOrganisation(){
        return this.Organisation;
    }
    public void setOrganisatin(String Organisation){
        this.Organisation = Organisation;
    }


    //all details in multiple lines 
    public String toString(){
        return ("name: " + this.name +";\nphone: "+ this.phNo +";\nEmail: "+ 
        this.email +";\nOrganisation: "+ this.Organisation);
    }

    //all details in single lines 
    public String oneLineString(){
		return("name: " + this.name + "phone: " + this.phNo + 
        "; Email: " +this.email+"; Organisation: "+ 
        this.Organisation);
	}
    


}
