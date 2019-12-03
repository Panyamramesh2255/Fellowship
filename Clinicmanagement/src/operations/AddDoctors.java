package operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import classes.Doctors;
import classes.Patients;
import clinic.ClinicManagement;
/**
 * 
 * @author  PanyamRamesh
 * purpose: Clinic management doctor functionality
 *
 */
public class AddDoctors {
	int cnt=0;
	ClinicManagement cm=new ClinicManagement();
  Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		AddDoctors ad=new AddDoctors();
		

	}
	public void adddoctors(File fp) throws JsonParseException, JsonMappingException, IOException
	{  
		ObjectMapper mapper=new ObjectMapper();
        fp.createNewFile();
		System.out.println("Enter doctor name :");
		String name=scanner.next();
		System.out.println("Enter doctor id :");
		int id=scanner.nextInt();
		System.out.println("Enter doctor specialization :");
		String specialization=scanner.next();
		System.out.println("Enter doctor availability :");
		String availability=scanner.next();
		Doctors d=new Doctors(name,id,specialization,availability);
		if(fp.length()!=0)
		{
		List<Doctors> adddoctor=new ArrayList<Doctors>(Arrays.asList(mapper.readValue(fp, Doctors[].class)));
		adddoctor.add(d);
		mapper.writeValue(fp, adddoctor);
		System.out.println("added sucessfully");
		}
		else
		{
			List<Doctors> adddoctor=new ArrayList<Doctors>();
			adddoctor.add(d);
	        mapper.writeValue(fp, adddoctor);
	 		System.out.println("added sucessfully");


		}
		cm.functions();
				
		

	}
	public void displayListOfDoctors() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		File fp=new File("/home/bridgeit/Desktop/doctors.json");
		List<Doctors> display=new ArrayList<Doctors>(Arrays.asList(mapper.readValue(fp, Doctors[].class)));
		System.out.println("List of doctors :");
		for(int i=0;i<display.size();i++)
		{
		String str=display.get(i).toString();
		//System.out.println(str);
		System.out.format("name:%7s    id:%-5s     specialization:%-10s     availability:%-5s",display.get(i).getName(),display.get(i).getId(),display.get(i).getSpecialization(),display.get(i).getAvilability());
		System.out.println();
		}
		System.out.println();
		//cm.functions();
		
	}
	public void takeAppointments() throws JsonParseException, JsonMappingException, IOException, NullPointerException
	{
		try {
		long length=0;
		ObjectMapper mapper=new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		displayListOfDoctors();
        System.out.println("select id of dotors to take appointment :");
        int choice=scanner.nextInt();
        if(choice<10)
        {
        File fp=new File("/home/bridgeit/Desktop/files/doctor"+choice+".json");
	
		
		System.out.println("Enter patient name :");
		String name=scanner.next();
		System.out.println("Enter patient id :");
		int id=scanner.nextInt();
		System.out.println("Enter mobilenumber :");
		long mobilenumber=scanner.nextLong();
		System.out.println("Enter age :");
		int age=scanner.nextInt();
		Patients p=new Patients(name,id,mobilenumber,age);
		
		if(fp.length()==0)
		{   
			List<Patients> addpa=new ArrayList<Patients>(Arrays.asList());
			addpa.add(p);
			mapper.writeValue(fp, p);
			System.out.println("appointment is fixed :");
			length=fp.length();
			cnt++;
			System.out.println("count "+cnt);
		}
		else 
		{
			List<Patients> addpatients=new ArrayList<Patients>(Arrays.asList(mapper.readValue(fp, Patients[].class)));
			if(addpatients.size()<5)
			{
			addpatients.add(p);
			mapper.writeValue(fp, addpatients);
			System.out.println("appointment is fixed :");
			cnt++;
			System.out.println("count "+cnt);
			}else
				System.out.println("Not Available please try on another date :");
		}
	
		cm.functions();
        }
        else
        {
        	System.out.println("Inavlid input !");
       
        cm.functions();
        }
		}
		catch(Exception e)
		{
			System.out.println("Invalid input !");
		}
		
	}
	public void appointmentfordoctors() throws JsonParseException, JsonMappingException, IOException
	{  ObjectMapper mapper=new ObjectMapper();
	ClinicManagement cm=new ClinicManagement();
		displayListOfDoctors();
		System.out.println();
		System.out.println("Enter id of doctors to check appointments :");
		int choice=scanner.nextInt();
		File fp=new File("/home/bridgeit/Desktop/files/doctor"+choice+".json");
		if(fp.length()!=0)
		{
		    List<Patients>appointment=new ArrayList(Arrays.asList(mapper.readValue(fp, Patients[].class)));
			for(int i=0;i<appointment.size();i++)
			{
				String str=appointment.get(i).toString();
				//System.out.println(str);
				System.out.format("name:%7s    id:%-5s  mobilenumber:%-7s    age:%-5s",appointment.get(i).getName(),appointment.get(i).getId(),appointment.get(i).getMobilenumber(),appointment.get(i).getAge()+"\n");
				System.out.println();
			}
			cm.functions();
			
		}
		else
		{
			System.out.println("No appointments !");
		}
		
		
	}
	public void bestdoctor() throws JsonParseException, JsonMappingException, IOException
	{    
		ClinicManagement cm=new ClinicManagement();
		int count1=0,size=0;
		String specialization="";
		ObjectMapper mapper=new ObjectMapper();
		File fp=new File("/home/bridgeit/Desktop/files");
		String[] str=fp.list((name,f1)->f1.endsWith(".json"));
		System.out.println("Name:      Rating:  ");
		for(String st:str)
		{   //System.out.println(st);
			File fp1=new File("/home/bridgeit/Desktop/files/"+st);
			if(fp1.length()!=0)
			{
			List<Patients>count=new ArrayList(Arrays.asList(mapper.readValue(fp1, Patients[].class)));
			 size=count.size();
			String name=st;
			
			System.out.println(st.substring(0,7)+"        "+size);
		    }
			if(size>count1)
			{
				count1=size;
				specialization=st;
			}
			
			
		}
		File file=new File("/home/bridgeit/Desktop/doctors.json");
		int n=Integer.parseInt((specialization.substring(6, 7)));
		List<Doctors> special=new ArrayList(Arrays.asList(mapper.readValue(file, Doctors[].class)));
		String specialize=special.get(n).getSpecialization();
		System.out.println("Clinic is famous for:  "+specialize+" treatment");
	  cm.functions();
		
	}
	
}
