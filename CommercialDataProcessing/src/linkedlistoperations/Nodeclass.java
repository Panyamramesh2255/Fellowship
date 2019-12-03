package linkedlistoperations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.CompanyClass;
/**
 * 
 * @author PanyamRamesh
 * purpose: LinkedList
 *
 */
public class Nodeclass {
	ObjectMapper mapper=new ObjectMapper();
	public class Node
	{
		Object obj;
		Node next;
		public Node(Object obj)
		{
			this.obj=obj;
			this.next=next;
		}
		
	}
	Node head=null;
	public void storingShares() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
	File fp=new File("/home/bridgeit/Desktop/cdp/company.json");
	List<CompanyClass> company=new ArrayList(Arrays.asList(mapper.readValue(fp, CompanyClass[].class)));
	
	for(int i=0;i<company.size();i++)
	{
		Object obj=company.get(i);
		//System.out.println("object "+obj);
		Node newnode=new Node(obj);
		//System.out.println(newnode.obj);
		if(head==null)
		{
			//newnode=head;
			head=newnode;
		}
		else
		{
			Node current=head;
			while(current.next!=null)
				current=current.next;
			current.next=newnode;
			
		}
		
	}
	
	
	}
	public void display()
	{
		Node current=head;
		while(current.next!=null)
		{
			System.out.println(current.obj+" ");
			current=current.next;
		}
		System.out.println(current.obj);
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		Nodeclass nc=new Nodeclass();
		nc.storingShares();
		nc.display();
	}
	

}
