/*    
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *  
 *
 * ---------
 *goldbachlinearmapping.java
 * ---------
 * (C) Copyright 2022-2022, by Hangzhou Domain Zones Technology Co., Ltd. and Contributors.
 *
 * Original Author:  Lican Huang (Hangzhou Domain Zones Technology Co., Ltd.);
 * Contributor(s):    
 *
 */
package goldbachmapping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

 

public class goldbachlinearmapping {
	public static ArrayList<Integer> primes     ;	
	public static Integer[] primesarr     ;	
 
	public static int primesize;
	public static int[] evens  ;	
 	public static int[] primegap   ;	
 	
	public static int evensize;
	
	public static int zerocounts;
	public static int[] zerocountsarr;
	
	public static int[] preprimezerocountsarr;
	public static int[] pre2primezerocountsarr;
	public static int[] pre3primezerocountsarr;
	public static int smaillzero;
	public static int[] smaillzeroarr;
	
	public static String writeinfo;
	public static String wbfilenameprex;
	public static String wbdirectory;
	public static String wbdiskcharacter ;
	public static int substractsetumbers;
	public static int lessthanprimenumber;
	public static int calculatemode;
	
	public static void goldbachmappingmain(String[] args) {
		 
		primes = new ArrayList<Integer>();
		 
		
		wbdiskcharacter = new String();
		wbdirectory = new String();
		wbdiskcharacter="c:";
		wbdirectory = "prime";
		String primesfilename = wbdiskcharacter +"//"+ wbdirectory +"//"+"primes3.txt";
	 
		String wbprimesfilename = "primes"; 
		//lessthanprimenumber = 3000000;	
		lessthanprimenumber = 30000 ;	 
		calculatemode = 3;
		int substractsetsize=0;
		
		try {
			readprimeformfile(primesfilename,lessthanprimenumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* 
		int[] substractset = {3 , 5,7 ,11, 13, 17, 19, 23 , 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79 , 83, 89,  97, 101, 103, 107, 109,113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,251, 257, 263,269,271,277,281,283,293, 307,311,313,317, 331,337,347,349,353,359, 367,373,379,383,389,397,401, 409,
		    		419, 421, 431 ,      433 ,      439 ,      443  ,     449   ,    457 ,
		           461  ,     463 ,      467  ,     479 ,      487   ,    491   ,    499  ,     503 ,
		           509  ,     521 ,      523 ,      541 ,      547   ,    557   ,    563  ,     569 ,
		           571  ,     577 ,      587 ,      593  ,     599   ,    601   ,    607  ,     613 ,
		           617  ,     619  ,     631 ,      641  ,     643  ,     647   ,    653  ,     659 ,
		           661  ,     673  ,     677 ,      683  ,     691  ,     701   ,    709  ,     719 ,
		           727   ,    733  ,     739  ,     743  ,     751  ,     757    ,   761  ,     769 ,
		           773  ,     787  ,     797  ,     809  ,     811  ,     821   ,    823  ,     827 ,
		           829  ,     839  ,     853  ,     857  ,     859  ,     863   ,    877  ,     881 ,
		           883  ,     887  ,     907  ,     911  ,     919  ,     929   ,    937  ,     941 ,
		           947  ,     953  ,     967  ,     971  ,     977  ,     983   ,    991  ,     997 };	
		
		*/
		
	 
		   
		  int[]  substractset = new int[substractsetsize];
		  for(int i=0;i<substractsetsize;i++)  
			 substractset[i]=primes.get(i) ;  
		 		
	      calculateprimemapping(wbprimesfilename,substractset,calculatemode);	
		
	}



	public static void readprimeformfile(String filename, int maxprime){
		 
		 try {
		 
		 BufferedReader br=new BufferedReader(new FileReader(filename));
		 String line=null;
		 int itemp = 0 ;
	
		 while( (line=br.readLine())!=null){
			String[] aa = line.split(" ");
			for (int i = 0; i<aa.length;i++ )
			{
				String temp = aa[i].trim();
				if (!temp.isEmpty()){
					     itemp = Integer.parseInt(temp);
					   
					     if(itemp>maxprime)					
					    {
					            br.close();					            
					          
					            return;
					     }
					     
		 			 	 primes.add(itemp);
			 			
				}
					
			}		     
		    
		 }
			 
		  br.close();
		  
		 } catch (IOException e) {
		   e.printStackTrace();
		 }
		 
	 }

	public static void writeprimemappingtofile(String filename, String info ) throws IOException{
		 Path path = Paths.get(filename) ;
		try (BufferedWriter writer =

				Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
				writer.write(info);

				}
		
	}
		 
	  
	public static  void  primesubstrac(int[] substractset){	
	   for(int j =0; j<substractset.length;j++) { 
		for(int i=0;i<primes.size();i++) {
			if(substractset[j]==primes.get(i)) {
				primes.remove(i);
				break;
			}
		}
	   }
	}
	
	

	
	public static  void calculateprimemapping(String wbfilename,int[] substractset, int mode){
	// mode=0 detail information
	//mode=1  without presentations such as 3+5=8
	//mode=2 	without presentations  , number of presentations for each even number, smallzeroeven;
	//mode=3 only saving image files	
		
		primesubstrac(substractset); 
		writeinfo = new String();		
		primesize = primes.size();
		primesarr = primes.toArray(new Integer[primesize]);
		evensize =primesarr[primesize-1] - primesarr[0]+1;
		evens= new int[evensize];
		primegap=new int[primesize];

		zerocountsarr = new int[primesize];
		smaillzeroarr = new int[primesize];
		preprimezerocountsarr = new int[primesize];
		pre2primezerocountsarr = new int[primesize];
		pre3primezerocountsarr = new int[primesize];
    
		String fileex =new String();
		fileex=fileex+"_";
		int tempi= substractset.length;
		fileex=fileex+tempi+"_";
     
		if(tempi>0)
		{
			fileex=fileex+substractset[0]+"_";
			fileex=fileex+substractset[tempi-1]+"_";
    	 
		}
    
		fileex=fileex+ primesarr[primesize-1]+"_";
    
		/*
    	for(int i=0;i<substractset.length;i++)
    	 	fileex=fileex+substractset[i]+"_";
		 */
		String dire=wbdiskcharacter +"//"+ wbdirectory +"//mode"+mode+"//set"+fileex;
    
		File dir = new File(dire); 
		if(!dir.exists()){
			dir.mkdirs();
		}
    
    
		String primesfilename = wbdiskcharacter +"//"+ wbdirectory +"//"+"primes.txt";
		String filenamepre = new String();
		filenamepre = wbfilename+fileex ;
		if(mode==0) {
    			 
			wbfilename=dire +"//" +filenamepre+"mapping.txt" ;
			wbfilenameprex =dire +"//" +filenamepre+"mapping";
		}
    
    
		if(mode==1) {
			wbfilename=dire +"//" +filenamepre +"mappingsmaill"+".txt";
			wbfilenameprex =dire +"//" +filenamepre+"mappingsmaill";
		}
    
		if(mode==2) {

			wbfilename=dire +"//" +filenamepre+"mappingtiny"+".txt";
			wbfilenameprex = dire +"//"+filenamepre+"mappingtiny";
		}
    
		if(mode==3) {

			wbfilename=dire +"//" +filenamepre+"mappingnowbtiny"+".txt";
			wbfilenameprex = dire +"//" +filenamepre +"mappingnowbtiny";
    
		}
    
    
		for(int i=0;i<evensize ;i++) {
			evens[i] =0;

			//  System.out.print(" "+ evens[i]);
		}
    
		for(int i=0;i<primesize;i++) {
			//	System.out.print(" "+ primes[0]);
			for(int j=0;j<=i;j++) {
				int even =  	primesarr[i]+primesarr[j];
				
				if(mode==0 ) {
					writeinfo =writeinfo +" "+ primesarr[i] +"+"+primesarr[j]+"="+even+" ";
				}
				int evenindex= (even -2*primesarr[0])/2;
				evens[evenindex] +=1;
	 
			}
		 
			if(mode==0||mode==1 ) {
				writeinfo =writeinfo +"\r\n";
			}
		    //  writeinfo =writeinfo +"... ";
	        //System.out.print(" "+ primesarr[i]);
	     
			zerocounts=0;
			smaillzero=0;
	     
			int prezeros=0;
			int pre2zeros=0;
			int pre3zeros=0;
	     
			int evensizetmp = primesarr[i] - primesarr[0]+1;
			for(int l=0;l<evensizetmp;l++) {
				int eventmp = primesarr[0]*2+l*2;
	      
				if(mode==0||mode==1) {
					writeinfo =writeinfo +"F("+eventmp+")="+evens[l]+"  ";
				}
				if(evens[l]==0) {
					zerocounts+=1;
					if(i>0) {
						if(eventmp<=primesarr[i-1]*2)
							prezeros+=1;
					}
					if(i>1) {
						if(eventmp<=primesarr[i-2]*2)
							pre2zeros+=1;
					} 
					if(i>2) {
						if(eventmp<=primesarr[i-3]*2)
							pre3zeros+=1;
					} 
					if(smaillzero==0) 
						smaillzero=eventmp;	 	     
				}
			}
	
			zerocountsarr[i]=zerocounts;
			preprimezerocountsarr[i]=prezeros;
			pre2primezerocountsarr[i]=pre2zeros;
			pre3primezerocountsarr[i]=pre3zeros;
			smaillzeroarr[i]=smaillzero;
			if(mode==0||mode==1) {
				writeinfo =writeinfo +"\r\n";
			}
			if(i>0) {
			   primegap[i]= primesarr[i]-primesarr[i-1];
			   if(mode==0||mode==1) {
			      writeinfo =writeinfo +"g("+primesarr[i]*2+")="+ primegap[i]+" ";
			   }			 
			}else{
				 primegap[i]= 0;
			   }
			if(mode==0||mode==1) {
				writeinfo =writeinfo +"S("+primesarr[i]*2+")="+zerocounts+"  ";
				if(zerocounts==0)
					writeinfo =writeinfo +"\r\n";	         
			}
			if(zerocounts>0)
				if(mode==0||mode==1) { 
					writeinfo =writeinfo +"SM("+primesarr[i]*2+")="+smaillzero+"  ";	 
					writeinfo =writeinfo +"\r\n";
				}
	      
	     	}
	
	 
		if(mode==0||mode==1||mode==2 ) {
			writeinfo =writeinfo +"primegaps" +"  ";  
			for (int i=0;i<primesize; i++) {
  	   
				writeinfo =writeinfo + primegap[i] +" ";
		    
			}
			writeinfo =writeinfo +"\r\n";
	 
			writeinfo =writeinfo +"Zerocounts" +"  ";  
			for (int i=0;i<primesize; i++) {  	   
				writeinfo =writeinfo + zerocountsarr[i] +" ";		    
			}
			writeinfo =writeinfo +"\r\n";
			writeinfo =writeinfo +"preprimeZerocounts" +"  ";  
			for (int i=0;i<primesize; i++) {
	     	   
	     	   writeinfo =writeinfo + preprimezerocountsarr[i] +" ";
			    
			}
			writeinfo =writeinfo +"\r\n";	  
			if(mode==0||mode==1 ) {
	
	            writeinfo =writeinfo +"smaillzeros" +"  ";  
		     	for (int i=0;i<primesize; i++) {
		     	   
		     		writeinfo =writeinfo + smaillzeroarr[i] +" ";
				    
		     	}
		     		writeinfo =writeinfo +"\r\n";	 
			}
			writeinfo =writeinfo +"pre2primeZerocounts" +"  ";  
				for (int i=0;i<primesize; i++) {
			     	   
					writeinfo =writeinfo + pre2primezerocountsarr[i] +" ";
					    
			       }
				writeinfo =writeinfo +"\r\n";	  	
			     	  
				writeinfo =writeinfo +"pre3primeZerocounts" +"  ";  
				for (int i=0;i<primesize; i++) {
				     	   
					writeinfo =writeinfo + pre3primezerocountsarr[i] +" ";
						    
				}
				writeinfo =writeinfo +"\r\n";	  	
				writeinfo =writeinfo +"\r\n";	  
							     	 
		}
	 
	    writeinfo =writeinfo + "smallzeroevennumber:" +smaillzeroarr[primesize-1] +"  ";		
		writeinfo =writeinfo +"primescount:" +primesize +"  ";		
		writeinfo =writeinfo +"minprime:" +primesarr[0] +"  ";	
		writeinfo =writeinfo +"maxprime:" +primesarr[primesize-1] +"  ";	

   	    writeinfo =writeinfo +"\r\n";	  	
	    writeinfo =writeinfo +"\r\n";	  
	    
	    writeinfo =writeinfo +"Substract Set:"   +"  ";		
	    for(int i =0 ; i<substractset.length;i++) {
	    	writeinfo =writeinfo + substractset[i]    +"  ";	
	    }
	    try {
	    	 
	    	writeprimemappingtofile( wbfilename, writeinfo);
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
		
}



