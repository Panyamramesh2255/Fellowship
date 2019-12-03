package functions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.CustomerClass;
/**
 * 
 * @author PanyamRamesh
 * purpose: Adding cutomer
 */
public class Adding {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter id :");
			String id=scanner.next();
			System.out.println("Enter name :");
			String name=scanner.next();
			System.out.println("Enter ShareName");
			String sharename=scanner.next();
			System.out.println("Enter NumberOfShares");
			int numberofshares=scanner.nextInt();
			System.out.println("Enter amount :");
			int amount=scanner.nextInt();
			CustomerClass cc=new CustomerClass(id, name, sharename, numberofshares,amount);
			ObjectMapper mapper=new ObjectMapper();
			File fp=new File("/home/bridgeit/Desktop/cdp/customer.json");
			if(fp.length()!=0)
			{
				List<CustomerClass> customer=new ArrayList(Arrays.asList(mapper.readValue(fp, CustomerClass[].class)));
		        customer.add(cc);
		        mapper.writeValue(fp, customer);
		        System.out.println("Added :");
			}
			else
			{
				List<CustomerClass> customer=new ArrayList<CustomerClass>();
				customer.add(cc);
				mapper.writeValue(fp, customer);
				System.out.println("Added :");
			}
			
		
			
			
			
		}

	}

	}

