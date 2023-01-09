/*05/18/2020
 * Caleb Eng 
 * Mr.ho
 * Methods project lv4 (taking in file information and outputting certain data on a csv file)
 * its long but it works
 */

import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class WeatherMainLV4{
  public static void main(String[] args)throws IOException {
    //Main Method
    //final list of numbers for csv files
    ArrayList<String> end = new ArrayList<String>();
    //different file names
    String[] files = new String [5];
    files[0] = "en_climate_hourly_ON_6158409_01-2020_P1H.csv";
    files[1] = "en_climate_hourly_ON_6158409_02-2020_P1H.csv";
    files[2] = "en_climate_hourly_ON_6158409_03-2020_P1H.csv";
    files[3] = "en_climate_hourly_ON_6158409_04-2020_P1H.csv";
    files[4] = "en_climate_hourly_ON_6158409_05-2020_P1H.csv";
    
    String[][][] data = openFiles(files);
    
    dataProcess(data,end);
    dataOutput(end);
    // End of Main Method
  }
  
  /**
   * Takes in information from text files, reads it line by line and picks out only the temperature & wind speed.
   * Saves the temperature/WS in a string[][][] array data
   * @param String[] dat   the name of the files in an array
   * @returns updated array values to be used later
   * @throws java.io.FileNotFoundException
   */
  public static String[][][] openFiles(String dat[])throws IOException{
    //setting up the arrays to store the information
    String[] month1 = new String[745];
    String[] month2 = new String[697];
    String[] month3 = new String[745];
    String[] month4 = new String[721];
    String[] month5 = new String[169];
    String[] wind1 = new String[745];
    String[] wind2 = new String[697];
    String[] wind3 = new String[745];
    String[] wind4 = new String[721];
    String[] wind5 = new String[169];
    
    String[][] tempa = {month1,month2,month3,month4,month5};
    String[][] wind = {wind1,wind2,wind3,wind4,wind5};
    String[][][] data ={tempa,wind};
    
    File[] allfiles = new File[5]; 
    
    for(int r = 0; r<5; r++){
      File path = new File (dat[r]);
      String route = (path.getAbsolutePath()+"\\");
      File file = new File(route);
      allfiles[r] = file;
    }
    for(int i = 0; i<5; i++){
      int load =0;
      Scanner fileInput = new Scanner(allfiles[i]);
      for(int track = 0; track<(data[0][i]).length; track++ ){
        
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
            
            if(track>0){
              
              
              while(commer >= 0) {
                comnumber[comNum] = commer;
                comNum++;
                commer = thing.indexOf(",", commer+1);
              }
              //grabing the temperature values 
              
              String temp = thing.substring((comnumber[8])+2, (comnumber[9])-1); 
              data[0][i][load]= temp;
              String windtemp = thing.substring(comnumber[16]+2, (comnumber[17])-1);
              data[1][i][load]= windtemp;
              load++;
              
            } 
          }
        }
      }
      
    }
    
    return data;
    
  }
  /**
   * Takes in the string data and processes it all into highs, lows and averages for the temperature durring each day/week/month/anualy 
   * @param  takes in a String[][][] arra & ArrayList<String> ends   all of the string data for the temperature/winds for every hour of all 5 months
   * @returns   returns the updated arraylist ends with the new processed information
   */
  public static String[][][] dataProcess (String[][][] arra, ArrayList<String> ends){ 
    //creating a copy of the value arrays but for doubles instead
    //a lot but needed arrays
    double yeartotal =0;
    double[] yearadd = new double[11];
    double[] temparray = new double[24];
    double[] windarray = new double[24];
    double[] tempweek = new double[168];
    double[] day8 = new double[192];
    double[] day3 = new double[72];
    double[] day2 = new double[48];
    double[] month1 = new double[744];
    double[] month2 = new double[696];
    double[] month3 = new double[744];
    double[] month4 = new double[720];
    double[] month5 = new double[168];
    double[] wind1 = new double[744];
    double[] wind2 = new double[696];
    double[] wind3 = new double[744];
    double[] wind4 = new double[720];
    double[] wind5 = new double[168];
    double[][] tempa = {month1,month2,month3,month4,month5};
    double[][] wind = {wind1,wind2,wind3,wind4,wind5};
    double[][][] datas ={tempa,wind};
    
    //converting the string into double values to sort 
    
    //temperature numbers
    ends.add(" ");
    for(int o = 0; o<5;o++){
      int i =0;
      int len = (arra[0][o].length)-1;
      
      while(i < len){
        if(!arra[0][o][i].equals("null")){
          double value = Double.parseDouble(arra[0][o][i]);
          datas[0][o][i] = value;
        }
        i++;
      }
    }
    //wind spd numbers
    for(int o = 0; o<5;o++){
      int i =0;
      int missNum= 0;
      int len = (arra[1][o].length-1);
      
      while(i < len){
        if(o==1 &&((i)==144)){
          datas[1][o][i] = 0.0;
          missNum++;
        }
        if(missNum ==1 && o==1){
          missNum = missNum-1;
        }
        if(!arra[1][o][i].equals("")&& missNum !=1){
          double value = Double.parseDouble(arra[1][o][i]);
          datas[1][o][i] = value;
        }
        
        i++;
      }
    }
    
    //daily reports on weather
    for(int o = 0; o<5;o++){
      double temp = 0.0;
      
      //values for hours in day and week -1
      int n = 23; 
      int nw = 167;
      int bigcount = 0;
      int lens = datas[0][o].length;
      
      for(int p = 0; p < lens/24; p++){
        double tempj = 0;
        for(int j = 0; j<=n; j++){
          temparray[j] = datas[0][o][bigcount];
          windarray[j] = datas[1][o][bigcount];
          bigcount++;
        }
        for (int f = 0; f < 23; f++) {
          for (int j = 0; j < 23; j++) {
            
            if ((windarray[j]) > windarray[j+1]) {
              temp =windarray[j+1];
              windarray[j+1] = windarray[j];
              windarray[j] = temp;
            }
          }
        }
        for (int f = 0; f < 23; f++) {
          for (int j = 0; j < 23; j++) {
            
            if ((temparray[j]) > temparray[j+1]) {
              temp =temparray[j+1];
              temparray[j+1] = temparray[j];
              temparray[j] = temp;
            }
          }
        }
        //weather warnings
        if(temparray[0]<=(-15)){
          ends.add("[Extreme cold Warning]");
        }
        if(temparray[0]>(-15)){
          ends.add("  ");
        }
        if (windarray[23]>=20){
          ends.add("[Warning winds up to "+String.valueOf(windarray[23])+" km/h]");
        }
        if(windarray[23]<20){
          ends.add("  ");
        }
        ends.add(String.valueOf(temparray[0])+"°C");
        ends.add(String.valueOf(temparray[23])+"°C");
        
        for(int adds =0; adds<24 ;adds++){
          tempj = tempj+temparray[adds];
        }
        ends.add(String.valueOf(tempj/24)+"°C");
        ends.add("|");
      }
      //weeks/months for jan
      if(o==0){
        //week
        ends.add("[Weekly Report]");
        int weekcount = 0;
        for(int weeknum = 0; weeknum<4; weeknum++){
          for(int j = 0; j<=nw; j++){
            tempweek[j] = datas[0][0][weekcount];
            weekcount++;
          }
          for (int f = 0; f < 167; f++) {
            for (int j = 0; j < 167; j++) {
              if ((tempweek[j]) > tempweek[j+1]) {
                temp =tempweek[j+1];
                tempweek[j+1] = tempweek[j];
                tempweek[j] = temp;
              }
            }
          }
          double temper = 0;
          for(int addo =0; addo<168 ;addo++){
            temper = temper + tempweek[addo];
          }
          int d3 =0;
          for(int j = 673; j<744; j++){
            day3[d3] = datas[0][0][j];
            d3++;
          }
          for (int f = 0; f < 71; f++) {
            for (int j = 0; j < 71; j++) {
              if ((day3[j]) > day3[j+1]) {
                temp =day3[j+1];
                day3[j+1] = day3[j];
                day3[j] = temp;
              }
            }
          }
          ends.add("  ");
          ends.add("  ");
          ends.add("  ");
          ends.add(String.valueOf(tempweek[0])+"°C");
          ends.add(String.valueOf(tempweek[167])+"°C");
          ends.add(String.valueOf(temper/168)+"°C");
          ends.add("-");
        }
        double four = 0;   
        for(int addo =673; addo<744 ;addo++){
          four = four + datas[0][0][addo];
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(day3[0])+"°C");
        ends.add(String.valueOf(day3[70])+"°C");
        ends.add(String.valueOf(four/72)+"°C");
        ends.add("-");
        
        //month
        ends.add("[Month Report]");        
        for(int f = 0; f < 743; f++){
          for(int r =0; r<743;r++){
            if ((datas[0][0][r]) > datas[0][0][r+1]) {
              temp =datas[0][0][r+1];
              datas[0][0][r+1] = datas[0][0][r];
              datas[0][0][r] = temp;
            }
          }
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(datas[0][0][0])+"°C");
        ends.add(String.valueOf(datas[0][0][743])+"°C");
        double monthcount = 0;
        for(int x =0; x<=743; x++){
          monthcount = monthcount+datas[0][0][x];
        }
        ends.add(String.valueOf(monthcount/744)+"°C");
        ends.add("-");
        ends.add("||");
      }
      
      //weeks/month of feb
      if(o==1){
        //week
        ends.add("[Weekly Report]");
        int weekcount2 = 0;
        
        for(int weeknum = 0; weeknum<3; weeknum++){
          for(int j = 0; j<=nw; j++){
            tempweek[j] = datas[0][1][weekcount2];
            weekcount2++;
          }
          for (int f = 0; f < 167; f++) {
            for (int j = 0; j < 167; j++) {
              
              if ((tempweek[j]) > tempweek[j+1]) {
                temp =tempweek[j+1];
                tempweek[j+1] = tempweek[j];
                tempweek[j] = temp;
              }
            }
          }
          double temper1 = 0;
          for(int addo =0; addo<168 ;addo++){
            temper1 = temper1 + tempweek[addo];
          }
          ends.add("  ");
          ends.add("  ");
          ends.add("  ");
          ends.add(String.valueOf(tempweek[0])+"°C");
          ends.add(String.valueOf(tempweek[167])+"°C");
          ends.add(String.valueOf(temper1/168)+"°C");
          ends.add("-");
        }
        int d8 =0;
        for(int j = 505; j<696; j++){
          day8[d8] = datas[0][1][j];
          d8++;
        }
        for (int f = 0; f < 191; f++) {
          for (int j = 0; j < 191; j++) {
            if ((day8[j]) > day8[j+1]) {
              temp =day8[j+1];
              day8[j+1] = day8[j];
              day8[j] = temp;
            }
          }
        }
        double days8 = 0;
        for(int x =0; x<=191;x++){
          days8 = days8 + day8[x];
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(day8[0])+"°C");
        ends.add(String.valueOf(day8[191])+"°C");
        ends.add(String.valueOf(days8/192)+"°C");
        ends.add("-");
        
        //month
        ends.add("[Month Report]");
        for(int f = 0; f < 678; f++){
          for(int r =0; r<678;r++){
            if ((datas[0][1][r]) > datas[0][1][r+1]) {
              temp =datas[0][1][r+1];
              datas[0][1][r+1] = datas[0][1][r];
              datas[0][1][r] = temp;
            }
          }
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(datas[0][1][0])+"°C");
        ends.add(String.valueOf(datas[0][1][678])+"°C");
        double monthcount = 0;
        for(int x =0; x<=678; x++){
          monthcount = monthcount+datas[0][1][x];
        }
        ends.add(String.valueOf(monthcount/679)+"°C");
        ends.add("-");
        ends.add("|||");
      }
      //weeks/month for march
      if(o==2){
        //week
        ends.add("[Weekly Report]");
        int weekcount = 0;
        for(int weeknum = 0; weeknum<4; weeknum++){
          for(int j = 0; j<=nw; j++){
            tempweek[j] = datas[0][2][weekcount];
            weekcount++;
          }
          for (int f = 0; f < 167; f++) {
            for (int j = 0; j < 167; j++) {
              if ((tempweek[j]) > tempweek[j+1]) {
                temp =tempweek[j+1];
                tempweek[j+1] = tempweek[j];
                tempweek[j] = temp;
              }
            }
          }
          double temper = 0;
          for(int addo =0; addo<168 ;addo++){
            temper = temper + tempweek[addo];
          }
          int d3 =0;
          for(int j = 673; j<744; j++){
            day3[d3] = datas[0][2][j];
            d3++;
          }
          for (int f = 0; f < 71; f++) {
            for (int j = 0; j < 71; j++) {
              if ((day3[j]) > day3[j+1]) {
                temp =day3[j+1];
                day3[j+1] = day3[j];
                day3[j] = temp;
              }
            }
          }
          ends.add("  ");
          ends.add("  ");
          ends.add("  ");
          ends.add(String.valueOf(tempweek[0])+"°C");
          ends.add(String.valueOf(tempweek[167])+"°C");
          ends.add(String.valueOf(temper/168)+"°C");
          ends.add("-");
        }
        double four = 0;   
        for(int addo =673; addo<744 ;addo++){
          four = four + datas[0][2][addo];
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(day3[0])+"°C");
        ends.add(String.valueOf(day3[70])+"°C");
        ends.add(String.valueOf(four/72)+"°C");
        ends.add("-");
        
        //month
        ends.add("[Month Report]");
        for(int f = 0; f < 743; f++){
          for(int r =0; r<743;r++){
            if ((datas[0][2][r]) > datas[0][2][r+1]) {
              temp =datas[0][2][r+1];
              datas[0][2][r+1] = datas[0][2][r];
              datas[0][2][r] = temp;
            }
          }
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(datas[0][2][0])+"°C");
        ends.add(String.valueOf(datas[0][2][743])+"°C");
        double monthcount = 0;
        for(int x =0; x<=743; x++){
          monthcount = monthcount+datas[0][2][x];
        }
        ends.add(String.valueOf(monthcount/744)+"°C");
        ends.add("-");
        ends.add("||||");
      }
      //weeks/month for april
      if(o==3){
        //week
        ends.add("[Weekly Report]");
        int weekcount = 0;
        for(int weeknum = 0; weeknum<4; weeknum++){
          for(int j = 0; j<=nw; j++){
            tempweek[j] = datas[0][3][weekcount];
            weekcount++;
          }
          for (int f = 0; f < 167; f++) {
            for (int j = 0; j < 167; j++) {
              if ((tempweek[j]) > tempweek[j+1]) {
                temp =tempweek[j+1];
                tempweek[j+1] = tempweek[j];
                tempweek[j] = temp;
              }
            }
          }
          double temper = 0;
          for(int addo =0; addo<168 ;addo++){
            temper = temper + tempweek[addo];
          }
          int d3 =0;
          for(int j = 673; j<720; j++){
            day2[d3] = datas[0][3][j];
            d3++;
          }
          for (int f = 0; f < 47; f++) {
            for (int j = 0; j < 47; j++) {
              if ((day2[j]) > day2[j+1]) {
                temp =day2[j+1];
                day2[j+1] = day2[j];
                day2[j] = temp;
              }
            }
          }
          ends.add("  ");
          ends.add("  ");
          ends.add("  ");
          ends.add(String.valueOf(tempweek[0])+"°C");
          ends.add(String.valueOf(tempweek[167])+"°C");
          ends.add(String.valueOf(temper/168)+"°C");
          ends.add("-");
        }
        double four = 0;   
        for(int addo =673; addo<720 ;addo++){
          four = four + datas[0][3][addo];
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(day2[0])+"°C");
        ends.add(String.valueOf(day2[47])+"°C");
        ends.add(String.valueOf(four/72)+"°C");
        ends.add("-");
        
        //month 
        ends.add("[Month Report]");
        for(int f = 0; f < 719; f++){
          for(int r =0; r<719;r++){
            if ((datas[0][3][r]) > datas[0][3][r+1]) {
              temp =datas[0][3][r+1];
              datas[0][3][r+1] = datas[0][3][r];
              datas[0][3][r] = temp;
            }
          }
        }
        ends.add("  ");
        ends.add("  ");
        ends.add("  ");
        ends.add(String.valueOf(datas[0][3][0])+"°C");
        ends.add(String.valueOf(datas[0][3][719])+"°C");
        double monthcount = 0;
        for(int x =0; x<=719; x++){
          monthcount = monthcount+datas[0][3][x];
        }
        ends.add(String.valueOf(monthcount/720)+"°C");
        ends.add("-");
        ends.add("|||||");
      }
      //week for may
      if(o==4){
        ends.add("[Weekly Report]");
        int weekcount3 = 0;
        
        for(int weeknum = 0; weeknum<1; weeknum++){
          for(int j = 0; j<=nw; j++){
            tempweek[j] = datas[0][4][weekcount3];
            weekcount3++;
          }
          for (int f = 0; f < 167; f++) {
            for (int j = 0; j < 167; j++) {
              
              if ((tempweek[j]) > tempweek[j+1]) {
                temp =tempweek[j+1];
                tempweek[j+1] = tempweek[j];
                tempweek[j] = temp;
              }
            }
          }
          double temper5 = 0;
          for(int addo =0; addo<168 ;addo++){
            temper5 = temper5 + tempweek[addo];
          }
          ends.add("  ");
          ends.add("  ");
          ends.add("  ");
          ends.add(String.valueOf(tempweek[0])+"°C");
          ends.add(String.valueOf(tempweek[167])+"°C");
          ends.add(String.valueOf(temper5/168)+"°C");
          ends.add("-");
        }
      }
    }
    //yearly report calculations
    int counters = 0;
    double temp = 0.0;
    
    for(int o = 0; o<5;o++){
      int leng = datas[0][o].length;
      for(int f = 0; f<leng;f++){
        yeartotal = yeartotal+datas[0][o][f];
      }
      
      yearadd[counters]=datas[0][o][0];
      counters++;
      yearadd[counters]=datas[0][o][leng-1];
      counters++;
    }
    
    for (int f = 0; f < 9; f++) {
      for (int j = 0; j < 9; j++) {
        if ((yearadd[j]) > yearadd[j+1]) {
          temp =yearadd[j+1];
          yearadd[j+1] = yearadd[j];
          yearadd[j] = temp;
        }
      }
    }
    ends.add("[Yearly Report]");
    ends.add("  ");
    ends.add("  ");
    ends.add("  ");
    ends.add(String.valueOf(yearadd[0])+"°C");
    ends.add(String.valueOf(yearadd[9])+"°C");
    ends.add(String.valueOf(yeartotal/3072)+"°C");
    ends.add("-");
    return arra;
  }
  /**
   * Takes in the processed data and outputs the information in an orderly csv file
   * @param  takes in a arraylist<String> ends   all of the proper information sorted out and processed
   * @return  new file C.E Weather Report with proper information and sorting
   * @throws java.io.FileNotFoundException
   */
  public static void dataOutput(ArrayList<String> ends)throws IOException{
    int daycount = 0;
    File file = new File("results.csv");
    file.createNewFile();
    PrintWriter pw = new PrintWriter(file);
    //top information
    pw.println("Month/day, Cold Warning, Wind Warning, Low(°C), High(°C), Average(°C)");
    for (int x = 0; x<ends.size();x++){
      String p = ends.get(x);
      //each bit of information printing 
      if(!p.equals("[Month Report]")&& !p.equals("[Yearly Report]")){
        if(!p.equals("[Weekly Report]")&&!p.equals("-")&&!p.equals(" ")&&!p.equals("|") && !p.equals("||") && !p.equals("|||") && !p.equals("||||") && !p.equals("|||||")){    
          pw.print(ends.get(x)+", ");  
        }
      }
      if(ends.get(x).equals("-")){
        pw.println();
      }
      if(ends.get(x).equals("[Month Report]")){
        pw.println(p);
      }
      if(ends.get(x).equals("[Yearly Report]")){
        pw.println(p);
      }
      if (ends.get(x).equals("[Weekly Report]")){
        pw.println(p);
      }
      if(ends.get(x).equals("|")&&!ends.get(x+1).equals("[Weekly Report]")){
        pw.println();
        daycount++;
        pw.print("Day: "+daycount+", ");
      }
      if (ends.get(x).equals("|")&&ends.get(x+1).equals("[Weekly Report]")){
        pw.println();
      }
      if(ends.get(x).equals(" ")){
        pw.println("January");
        daycount = 1;
        pw.print("Day: "+daycount+", ");
      }
      if(ends.get(x).equals("||")){
        pw.println("February");
        daycount = 1;
        pw.print("Day: "+daycount+", ");
      }
      if(ends.get(x).equals("|||")){
        pw.println("March");
        daycount = 1;
        pw.print("Day: "+daycount+", ");
      }
      if(ends.get(x).equals("||||")){
        pw.println("April");
        daycount = 1;
        pw.print("Day: "+daycount+", ");
      }
      if(ends.get(x).equals("|||||")){
        pw.println("May");
        daycount = 1;
        pw.print("Day: "+daycount+", ");
      } 
    }
    System.out.println("results.csv has been created");
    pw.close();
  }
}