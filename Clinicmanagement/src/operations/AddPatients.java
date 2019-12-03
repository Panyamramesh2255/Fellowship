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

import classes.Doctors;
import classes.Patients;
/**
 * 
 *  @author  PanyamRamesh
 * purpose: Clinic management patient functionality
 *
 */
public class AddPatients {
	Scanner scanner=new Scanner(System.in);
	public void addpatients(File fp) throws IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		
		System.out.println("Enter patient name :");
		String name=scanner.next();
		System.out.println("Enter patient id :");
		int id=scanner.nextInt();
		System.out.println("Enter mobilenumber :");
		long mobilenumber=scanner.nextLong();
		System.out.println("Enter age :");
		int age=scanner.nextInt();
		Patients p=new Patients(name,id,mobilenumber,age);
		
		if(fp.length()!=0)
		{
			List<Patients> addpatients=new ArrayList<Patients>(Arrays.asList(mapper.readValue(fp, Patients[].class)));
			addpatients.add(p);
			mapper.writeValue(fp, addpatients);
			System.out.println("added sucessfully :");
		}
		else
		{
			List<Patients> addpa=new ArrayList<Patients>();
			addpa.add(p);
			mapper.writeValue(fp, p);
			System.out.println("addedsucessfully");
		}
		
	}
	public void displayListOfPatients() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		File fp=new File("/home/bridgeit/Desktop/patients.json");
		List<Patients> display=new ArrayList<Patients>(Arrays.asList(mapper.readValue(fp, Patients[].class)));
	    System.out.println(" List of Patients: ");
	    
		for(int i=0;i<display.size();i++)
	    {
	    	String str=display.get(i).toString();
	    	System.out.println(str);
	    	
	    }
		System.out.println();
		
		
	}
	

}