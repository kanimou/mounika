package GettingData;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

 class AttendenceDetails {
	public static void main(String args[]) throws FileNotFoundException
	{
		AttendenceDetails att=new AttendenceDetails();
		System.out.println("Enter the input filename EmployeeDetails");
		Scanner sc1=new Scanner(System.in);
        String file=sc1.next();		
        List<EmployeeDetails> employee =att.readEmployee(file);
       int choice;
       int number=1;
       System.out.println("Please choose an option to get the information");
       choice = sc1.nextInt();
        while (number != 2) {

                       
        	 System.out.println("please enter the date  to get the no:of employees present");
             Scanner sc2=new Scanner(System.in);
     	    	Date dt =Date.valueOf(sc2.next());
                          
     
                    		   if (choice == 1) {
                    			  
        					att.employeesPresent(employee,dt);

        	                } 
        					else if(choice == 2)
        					{
        						System.out.println("enter the id ");
        						int id;
        						id=sc1.nextInt();
								att.numberOfHoursWorked(employee,id,dt);

        						
        					}        	
         }
       } 

	
		
				private void numberOfHoursWorked( List<EmployeeDetails> employee, int id,Date dt) {
					
					int i=0;int intime=0;

							int outtime=0;

							int work_time=0;

							Time t=Time.valueOf("11:00:00");

							while(i<employee.size())

							{

								if((id==employee.get(i).getId())&&(dt.compareTo(employee.get(i).getDate())==0))

								{
									if(employee.get(i).isFlag())

										intime=i;

									else 
										outtime=i;
									}

								if(outtime!=0)

								{
									work_time+=employee.get(outtime).getTime().getTime()-employee.get(intime).getTime().getTime();

									outtime=0;

								}i++;

							}

							if(work_time==0)

								System.out.println("employee not present on that date");

							else

								System.out.println(new Time(work_time-t.getTime()));

						}
				
				   
					
				



				public static  List<EmployeeDetails> readEmployee(String file) throws FileNotFoundException 
		{
			
		
		 
          File f = new File(file);
          Scanner sc = new Scanner(f);
         

          List<EmployeeDetails> employee = new ArrayList<EmployeeDetails>();

          while(sc.hasNextLine()){
              String line = sc.nextLine();
              String[] details = line.split(" ");
              int i = Integer.parseInt(details[0]);
              String d = details[1];
              String t = details[2];
              String fl=details[3];
              EmployeeDetails emp=new EmployeeDetails(i,d,t,fl);
              employee.add(emp);
              System.out.println(emp.getId());
              System.out.println(emp.getDate());
              System.out.println(emp.getTime());
              
             }
         
		return employee;

       }
				
      public void  employeesPresent(List<EmployeeDetails> employee,Date dt) {
    	  
			
			 Set<Integer> set=new HashSet<Integer>();
             for (int i = 0; i < employee.size(); i++) {
    			//System.out.println(employee.get(i).getId());
    		    boolean equal =(dt).equals(employee.get(i).getDate());
    		  
    			   if(equal==true){
    			  			set.add(employee.get(i).getId());
                     }
    			      
    			   else
    		   {
    			   System.out.println("NOT PRESENT");
    		   }
    			   
    		}
    	  
             System.out.println(set);
   }
	
      
      }
 
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



