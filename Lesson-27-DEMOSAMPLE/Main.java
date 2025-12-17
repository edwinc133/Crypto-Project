class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting all lower case 
    // letters to another lower case letter. 
    char[] sub = new char[5];
    sub[0] = 'a';
    sub[1] = 'e';
    sub[2] = 'i';
    sub[3] = 'o';
    sub[4] = 'u';



  
    char[] sub2 = new char[5];
  sub2[0] = '\u2662';
  sub2[1] = '\u280F';
  sub2[2] = '\u25D0';
  sub2[3] = '\u2663';
  sub2[4] = '\u2803';

    
    // Encoding message
    String file = Input.readFile("test.txt");

    //substitution
    String encodedMsg1 = Substituion(file,sub,sub2);
    Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    String encodedMsg2 = Cipher(encodedMsg1);
    Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    String encodedMsg3 = Swap(encodedMsg2);
    Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    String file2 = Input.readFile("Encode1.txt");
    
    String decodedMsg1 = Swap(file2);
    Input.writeFile("Decode1.txt", decodedMsg1);
    
    String decodedMsg2 = decode(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);
    
     String decodedMsg3 = Substituion(decodedMsg2, sub2, sub);
    Input.writeFile("Decode1.txt", decodedMsg3);
    
    
  }
  // Level 1 swap string
  String Swap(String txt){
    String bld="";
    for(int x = 0; x <= txt.length()-1; x+=3){
      if(x+2 <= txt.length()-1){
        bld+=txt.charAt(x+2);
      }
      if(x+1 <= txt.length()-1){
        bld+=txt.charAt(x+1);
      }
      bld+=txt.charAt(x);

    }
    
    return bld; 
  }


  
  
  //Level 2 Cipher encoding with no wrapping
  String Cipher(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii+=3;
      bld+= (char)ascii;
    }
     
    return bld;
  }

    String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=txt.length()-1; x>=0; x--){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii-=3;  
      bld+= (char)ascii;
    }
    return bld;
  }

  // Level 3 Substituion encoding
  String Substituion(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      index=indexOf(ch,sub);
      if(index!=-1){
        bld+=sub2[index];
      }
      else{
        bld+=ch;
      }
    }
    return bld; 
  }
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
  return -1; 
  }
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }
}

