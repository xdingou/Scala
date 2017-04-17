package com.programming.in.scala.chapter7

object ListOfFiles {
  
  def main(args: Array[String]) = {
    try{
      val files = (new java.io.File(".")).listFiles()
   
    
    for(file <- files)
      println(file)
      
      
   println("////////////////////////////////////////////")
    for(file <- files if(file.getName.endsWith("h")))
      println(file)
      
      
   println("////////////////////////////////////////////")
   
   for(file <- files
       if file.isFile(); 
       if file.getName.endsWith("h")
       )println(file)
 
   println("/////////////////////InnerLoop///////////////////////")
    
   for(file <- files
     if file.getName.endsWith(".txt");
        line <- listofLines(file);
        if(line.contains("Dinesh")) 
   )println(file +":"+line)
   
   
   println("/////////////////////Yield///////////////////////")
   val forLineLengths:Array[Int] = for(file <- files
                             if file.isFile;
                             if file.getName.endsWith(".txt");
                             line <- listofLines(file);
                             if line.contains("Scala")
                           )yield line.length();
    
    for(len <- forLineLengths)
        println("Length:"+len)
        
    }catch{
      case ex : java.io.FileNotFoundException =>
      case ex : java.io.IOException =>
    }finally{
      
    }
  }
  
  def listofLines(file : java.io.File):List[String] = {
    scala.io.Source.fromFile(file).getLines().toList
  }
  
  
}