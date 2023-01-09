/*05/15/2020
 * Caleb Eng 
 * Mr.ho
 * Methods project (taking in file information and outputting certain data)
 */

import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

class WeatherMainLV3{
  public static void main(String[] args)throws IOException {
    //Main Method
    String[] data = openFile("en_climate_hourly_ON_6158409_05-2020_P1H.csv");
    
    dataProcess(data);
    dataOutput(data);
    
    // End of Main Method
  }
  
  /**
   * Takes in information from text files, reads it line by line and picks out only the temperature. Saves the temapure in a string array (data[])
   * @param String dat   the name of the file wanted (month of may)
   * @returns updated array values to be used later
   * @throws java.io.FileNotFoundException
   */
  public static String[] openFile(String dat)throws IOException{
    //geting the file route
    File path = new File (dat);
    String route = (path.getAbsolutePath()+"\\");
    File file = new File(route);
    
    //creating the string array for the numbers 
    String[] data = new String[200];
    int load =0;
    Scanner fileInput = new Scanner(file);
    
    //reading the file line by line getting the proper information
    for(int i =0; i<=168; i++){
      Scanner lineReader = new Scanner(fileInput.nextLine());
      
      //reading the current file line word by word
      for(int f = 0; f<=1;f++){
        
        while(lineReader.hasNext()){
          
          //finding all of the comma so we can take the correct values
          int comNum = 0;
          int[] comnumber = new int[28];
          String date = lineReader.nextLine();
          String thing = date;
          
          int commer = thing.indexOf(",");
          
          if(i>0){
            while(commer >= 0) {
              comnumber[comNum] = commer;
              comNum++;
              commer = thing.indexOf(",", commer+1);
            }
            //grabing the tempature values 
            String temp = thing.substring((comnumber[8])+2, (comnumber[9])-1); 
            data[load]= temp;
            load++;
          } 
        }
      }
    }
    return data;
  }
  
  /**
   * Takes in the string data and processes it all into highs, lows and averages for the tempature durring each day and the week 
   * @param  takes in a String[] arra     all of the string data for the tempature for every hour of 7 days 
   * @returns   returns the updated array with the first 24 spaces being the new processed information
   */
  public static String[] dataProcess(String[]arra){
    //new array for the processing of the values
    double[] day = new double[168];
    
    int i=0;
    //converting values from a string array into a double array
    while(i<=167){
      double value = Double.parseDouble(arra[i]);
      day[i] = value;
      i++;
    }
    double temp = 0.0;
    int n = 24; 
    //sorting every 24 values by low ==> high (24 hours in a day)
    for (int f = 0; f < n-1; f++) {
      for (int j = 0; j < n-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    
    for (int f = 24; f < 48-1; f++) {
      for (int j = 24; j < 48-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    for (int f = 48; f < 72-1; f++) {
      for (int j = 48; j < 72-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    for (int f = 72; f < 96-1; f++) {
      for (int j = 72; j < 96-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    for (int f = 96; f < 120-1; f++) {
      for (int j = 96; j < 120-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    for (int f = 120; f < 144-1; f++) {
      for (int j = 120; j < 144-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    for (int f = 144; f < 168-1; f++) {
      for (int j = 144; j < 168-1; j++) {
        
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    //new array for the new information
    double[] fin = new double[24];
    //daily lows/highs
    fin[0] = day[0];
    fin[1] = day[23];
    fin[2] = day[24];
    fin[3] = day[47];
    fin[4] = day[48];
    fin[5] = day[71];
    fin[6] = day[72];
    fin[7] = day[95];
    fin[8] = day[96];
    fin[9] = day[119];
    fin[10] = day[120];
    fin[11] = day[143];
    fin[12] = day[144];
    fin[13] = day[167];
    
    double tempnum = 0;
    //day average calculations
    for (int j = 0; j < 168; j++){
      if(j<=23){
        tempnum = tempnum + day[j];
      }
      if(j==23){
        fin[14] = tempnum/24;
        tempnum = 0;
      }
      if((j>23)&&(j<=47)){
        tempnum = tempnum + day[j];
      }
      if(j==47){
        fin[15] = tempnum/24;
        tempnum = 0;
      }
      if((j>47)&&(j<=71)){
        tempnum = tempnum + day[j];
      }
      if(j==71){
        fin[16] = tempnum/24;
        tempnum = 0;
      }
      if((j>71)&&(j<=95)){
        tempnum = tempnum + day[j];
      }
      if(j==95){
        fin[17] = tempnum/24;
        tempnum = 0;
      }
      if((j>95)&&(j<=119)){
        tempnum = tempnum + day[j];
      }
      if(j==119){
        fin[18] = tempnum/24;
        tempnum = 0;
      }
      if((j>119)&&(j<=143)){
        tempnum = tempnum + day[j];
      }
      if(j==143){
        fin[19] = tempnum/24;
        tempnum = 0;
      }
      if((j>143)&&(j<=167)){
        tempnum = tempnum + day[j];
      }
      if(j==167){
        fin[20] = tempnum/24;
        tempnum = 0;
      }
    }
    //sorting all of the values least to greatest
    for (int f = 0; f < 168-1; f++) {
      for (int j = 0; j < 168-1; j++) {
        if ((day[j]) > day[j+1]) {
          temp =day[j+1];
          day[j+1] = day[j];
          day[j] = temp;
        }
      }
    }
    //taking the week low/high/average
    fin[21] = day[0];
    fin[22] = day[167];
    fin[23] = (fin[14]+fin[15]+fin[16]+fin[17]+fin[18]+fin[19]+fin[20])/7;
    
    for(int  fina = 0; fina<=23; fina++){
      arra[fina] = String.valueOf(fin[fina]);
    }
    return arra;
  }
  /**
   * Takes in the processed data and outputs the information in an orderly list
   * @param  takes in a String[] data     all of the proper information sorted out and processed
   * @returns  returns out the final version of the array as needed
   */
  public static String[] dataOutput(String[]data){
    //printing out the values in a list day by day with a week report at the end
    for(int i = 0; i<=7; i++){
      if(i==0){
        System.out.println("May 1st:");
        System.out.println("Low: "+ data[0] + "°C");
        System.out.println("High: "+ data[1] +"°C");
        System.out.println("Average: "+ data[14]+"°C");
        System.out.println();
      }
      if(i==1){
        System.out.println("May 2nd:");
        System.out.println("Low: "+ data[2] + "°C");
        System.out.println("High: "+ data[3] +"°C");
        System.out.println("Average: "+ data[15]+"°C");
        System.out.println();
      }
      if(i==2){
        System.out.println("May 3rd:");
        System.out.println("Low: "+ data[4] + "°C");
        System.out.println("High: "+ data[5] +"°C");
        System.out.println("Average: "+ data[16]+"°C");
        System.out.println();
      }
      if(i==3){
        System.out.println("May 4th:");
        System.out.println("Low: "+ data[6] + "°C");
        System.out.println("High: "+ data[7] +"°C");
        System.out.println("Average: "+ data[17]+"°C");
        System.out.println();
      }
      if(i==4){
        System.out.println("May 5th:");
        System.out.println("Low: "+ data[8] + "°C");
        System.out.println("High: "+ data[9] +"°C");
        System.out.println("Average: "+ data[18]+"°C");
        System.out.println();
      }
      if(i==5){
        System.out.println("May 6th:");
        System.out.println("Low: "+ data[10] + "°C");
        System.out.println("High: "+ data[11] +"°C");
        System.out.println("Average: "+ data[19]+"°C");
        System.out.println();
      }
      if(i==6){
        System.out.println("May 7th:");
        System.out.println("Low: "+ data[12] + "°C");
        System.out.println("High: "+ data[13] +"°C");
        System.out.println("Average: "+ data[20]+"°C");
        System.out.println();
      }
      //week report
      if(i==7){
        System.out.println("Weekly Data:");
        System.out.println("Low: "+ data[21] + "°C");
        System.out.println("High: "+ data[22] +"°C");
        System.out.println("Average: "+ data[23]+"°C");
        System.out.println();
      }
    }
    return data;
  }
}