import java.util.*;
import java.io.*;
/**
* This code is a Command Line Interface program used to manipulate text in a file.
* that input.
<<<<<<< HEAD
*test12345
=======
*
>>>>>>> parent of f891418... Second
* Commands:
* 1. add
* 2. display
* 3. delete
* 4. clear
* 5. exit
*
* @author Koh Cheng Gee A0126199W
*
*/
public class TextBuddy{
  private static ArrayList<String> list=new ArrayList<String>();
  private static String input;
  private static String dest;
  private static PrintWriter printWriter;
  
  public static void main(String args[]) throws IOException {
    checkArgExistence(args);
    initPrinter(dest);
    run();

  }
  
  public static void checkArgExistence(String args[]){
    if(args.length!=1){
      System.out.println("Error! Please Insert Filename!");
      System.exit(0);
    }
    dest=args[0];
    
  }
  public static void initPrinter(String dest) throws IOException{

    printWriter = new PrintWriter (dest);
  }
  public static void run(){
    System.out.println("Welcome to TextBuddy. "+dest+" is ready to use");
    Scanner sc = new Scanner(System.in);
    while(true){
      checkInput(sc);
    }
  }
  public static void checkInput(Scanner sc){
    input=sc.next();
      if(input.equalsIgnoreCase("add")){
        addLine(sc);

      }else if(input.equalsIgnoreCase("delete")){
        deleteLine(sc);
      }else if(input.equalsIgnoreCase("display")){
        displayList();
      }else if(input.equalsIgnoreCase("clear")){
        clearList();
      }else if(input.equalsIgnoreCase("exit")){
        for(int i=0;i<list.size();i++){
          printWriter.println(list.get(i));
        } printWriter.close();
        System.exit(0);
      }else{
        System.out.println("Wrong Command");
      }
    
  }
  public static void addLine(Scanner sc){
        input=sc.nextLine();
        input=input.substring(1);
        list.add(input);
  }
  public static void deleteLine(Scanner sc){
    int i;
        i=sc.nextInt();
        if((i-1)<=list.size()){
          System.out.println("deleted from "+dest+": \""+list.get(i-1)+"\"");
          list.remove(i-1);
        }else{
          System.out.println("Data Not Exist");
        }
  }
  public static void displayList(){
    if(list.size()==0){
          System.out.println(dest+" is empty");
        }else{
          for(int i=0;i<list.size();i++){
            int index=i+1;
            System.out.println(index+". "+list.get(i));
          }
        }
  }
  public static void clearList(){
    list.clear();
    System.out.println("all content deleted from "+dest);
  }
    
}