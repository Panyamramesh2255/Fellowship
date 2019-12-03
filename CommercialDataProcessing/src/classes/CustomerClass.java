package classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author  PanyamRamesh
 * purpose: Company model class
 *
 *
 */
public class CustomerClass {

	   @JsonIgnoreProperties
		String id;
	    @JsonIgnoreProperties
		String name;
	    @JsonIgnoreProperties
		String sharename;
	    @JsonIgnoreProperties
		int numberofshares;
	    @JsonIgnoreProperties
	    int amount;
		public CustomerClass(String id,String name,String sharename,int numberofshares,int amount )
		{
			this.id=id;
			this.name=name;
			this.sharename=sharename;
			this.numberofshares=numberofshares;
			this.amount=amount;
		}

	/*
	 * public CustomerClass() { }
	 */
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSharename() {
			return sharename;
		}
		public void setSharename(String sharename) {
			this.sharename = sharename;
		}
		public int getNumberofshares() {
			return numberofshares;
		}
		public void setNumberofshares(int numberofshares) {
			this.numberofshares = numberofshares;
		}
		
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "id=" + id + ", name=" + name + ", sharename=" + sharename + ", numberofshares="
					+ numberofshares +",amount ="+ amount;
		}
		

		}



