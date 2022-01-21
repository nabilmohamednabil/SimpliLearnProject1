package com.simplilearn;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FilenameUtils;

public class SIMPLEIT
{
   private static LinkedList<File> mylist    =  new LinkedList<File>();
   private static MyLinkedListImple mylist2  =  new MyLinkedListImple();
   private static Scanner in = new Scanner(System.in);
    
public static void main(String[] args) 
{
	    String userinput ;
		System.out.println("Application name is SimpliLearnProject1. \n");
		System.out.println("Developer details : Nabil Mohamed Nabil Gomaa \n" 
		+ "main list has options a,b,c to choose from \n user should enter character a or b or c"  );	
		File x = new File("/D:/") ;
		File[] y = x.listFiles();
		for(File xy : y) {
			if(xy.isDirectory()){
				mylist.add(xy); //list of directories
			
				}
			if(xy.isFile()){
				String fileNameWithOutExt = FilenameUtils.removeExtension(xy.getName());
				mylist2.push(fileNameWithOutExt); // list of files
				}      		
			}

		do{
		    System.out.println("please select one of the 3 options ( a , b , c) from below \n");
		    System.out.println(" a : List Files \n" + " b :  user interface Options \n" 
		    + " c : close the application\n"  );	
		    userinput = in.nextLine();
		    if( userinput.equals("a")) OptionA();
		    else if (userinput.equals("b")) OptionB();
		    
		  }while( !userinput.equals("c") ); 
		System.out.println("application closed");
 }

private static void OptionA (){
    
	mylist2.head = mylist2.mergeSort(mylist2.head);
	System.out.print("List of Files in Ascending order \n");
	mylist2.printList(mylist2.head);


	// System.out.println("find or not\n" + Integer.toString(SIMPLEIT.search(mylist)) );
	System.out.println("List of Directories in Ascending order \n");
	SIMPLEIT.traverse(mylist);

}
private static void OptionB()
{	
	 OptionA ();
	 String userinput  ; 
	 System.out.println("please select one of the 4 options ( d , e , f , g) from below \n");
     System.out.println(" d : Add a file to the existing directory list \n" 
	 + " e :  Delete a file from the existing directory list \n" 
     + " f :  Search a user specified file from the main directory\n"
	 + " g :  navigate back to the main context\n");
     
      userinput = in.nextLine();
     
     if( userinput.equals("d"))
     {
    	 System.out.println("Enter name of File \n");
    	 userinput = in.nextLine();
    	 File x = new File("/D:/" + userinput ) ;
    	 try {
			x.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 if(x.exists())
    	 System.out.println("File added is" + x.getName());
    	 
     }
     else if( userinput.equals("e"))
     {
    	 System.out.println("Enter name of File \n");
    	 userinput = in.nextLine();
    	 File x = new File("/D:/" + userinput ) ;
    	 Boolean res = x.delete();
    	 if(res){
    		 System.out.println("File deleted \n");
    	 } else {
    		 System.out.println("File not found \n");
    	 }   	 
     }
     else if( userinput.equals("f"))
     { 
    	 System.out.println("Enter name of File \n");
    	 userinput = in.nextLine();
    	 String datafound =  mylist2.binarySearch(mylist2.head,  userinput) ;
    	 if(datafound != null) {
    		 System.out.println("file  found \n");
    	 }else {
    		 System.out.println("file  not found \n"); 
    	 }
    	 
     }
     else if( userinput.equals("g"))
     {
	        System.out.println("you will return Back to the main context");
	         	 
     }
}


private  static void traverse (List<File> thelist){

	Collections.sort(thelist);
	for(File xy : thelist){
		System.out.println(xy.getName());
	}
	
 }

private  static int search (List<File> thelist){

	File x = new File("/D:/") ;
	File[] y = x.listFiles();
	return Collections.binarySearch(thelist , y[0]);
 }

} 
 

