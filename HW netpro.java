/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;
import java.util.ArrayList;
 
import java.util.concurrent.Callable;
 

 class Thrr implements Callable <Object>  {
    String add ;
    
    public Thrr (String add){
        this.add = add ;
    }
    
    @Override
    public Object call() throws UnknownHostException 
    {
                InetAddress address;
        
        address = InetAddress.getByName(add);
         return address ;
        
     
      
    }
 
     
    

    
}
public class JavaApplication8 {

    
    public static void main(String[] args) throws Exception {
     
        BufferedReader br = new BufferedReader(new FileReader("d:\\networkpro.txt"));
        String line ;
        ArrayList<String> arr  = new ArrayList<>() ;
        while((line = br.readLine())!=null){
            arr.add(line) ;         
        }
        
        Thrr[] t = new Thrr[arr.size()];
        Future[]fuu=new Future[arr.size()]; 
         ExecutorService ser = Executors.newFixedThreadPool(arr.size()-1);
        for (int i = 0 ; i <arr.size(); i++){
          t[i]= new Thrr(arr.get(i)) ;          
                    fuu[i]=ser.submit(t[i]);
             System.out.println( fuu[i].get()) ; 
               
           
        }
       ser.shutdown();
        }
               
               
    }