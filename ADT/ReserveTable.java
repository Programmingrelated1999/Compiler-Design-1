package ADT;
import java.lang.String;
import java.io.*;

public class ReserveTable
{
    
    public class ReserveTableElements{
        //name and code variables for token.
        String name;
        int code;
        public ReserveTableElements(String inputName, int inputCode){
            //constructor
            this.name = inputName;
            this.code = inputCode;
        }
        
    }
    
    //Reserve Table will have index and table
    int index = 0;
    ReserveTableElements[] table;
    
    public ReserveTable(int maxSize){
        //create an array with user defined maxsize
        this.table = new ReserveTableElements[maxSize];
    }
    
    public int Add(String name, int code){
        //create element object and then input the name and code. Add the element to the table.
        ReserveTableElements elementToAdd = new ReserveTableElements(name, code);
        this.table[index] = elementToAdd;
        index++;
        return index;
    }
    
    public int LookupName(String name){
        for(int i = 0; i < index; i++){
            //for loop to go through the table until find the String. If the String matches, return code associated.
            String compareName = this.table[i].name;
            if(compareName.compareToIgnoreCase(name) == 0){
                return this.table[i].code;
            }
        }
        return -1;
    }
    
    public String LookupCode(int code){
        //for loop to go through the table until find the code. If the code matches, return String associated.
        for(int i = 0; i < index; i++){
            if(this.table[i].code == code){
                return this.table[i].name;
            }
        }
        return "";
    }
    
    public void PrintReserveTable(String filename){
        
        //Printing to the text file
        try{  
            //file object set to the destination which function input filename describe.
            File file = new File(filename);
            
            //printwriter object
            PrintWriter pw = new PrintWriter(file);
            
            pw.println("Index \t\t\t Name \t\t\t\t Code");
            pw.println("-----------------------------------------------------------------------------------------------");
            //printing using for loop through all table elements
            for(int i = 0; i < index; i++){
                pw.println(i + "\t\t\t Name: " + this.table[i].name + "\t\t\t Code: " + this.table[i].code);
            }
            
            pw.close();
        }
        //throw exceptions
        catch(IOException e){
            e.printStackTrace();
        }
    
    }
}
