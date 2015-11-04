package com.walter.onlineexample;

public class Student {
   private String id,names,email,phone,course;
   public Student(String id,String names,String email,String phone, String course)
   {
	 this.id=id;
	 this.names=names;
	 this.email=email;
	 this.phone=phone;
	 this.course=course;
			 
   }
   public String getId()    {return id;}
   public String getNames() {return names;}
   public String getCourse(){return course;}
   public String getEmail() {return email;}
   public String getPhone() {return phone;}
	
}
