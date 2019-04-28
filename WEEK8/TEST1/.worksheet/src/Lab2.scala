
object Lab2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(102); 

  def isVowel(ch: Char, vowels:String="aeiou"): Boolean = {
  	vowels.contains(ch)
  };System.out.println("""isVowel: (ch: Char, vowels: String)Boolean""");$skip(18); val res$0 = 
  
  isVowel('f');System.out.println("""res0: Boolean = """ + $show(res$0));$skip(248); 
   
  def vowels(s: String, vowelChars: String ="aeiou", ignoreCase: Boolean = true): String = {
  	if (ignoreCase)
  		for (ch <- s.toLowerCase if isVowel(ch, vowelChars)) yield ch
  	else
  		for (ch <- s if isVowel(ch, vowelChars)) yield ch
  };System.out.println("""vowels: (s: String, vowelChars: String, ignoreCase: Boolean)String""");$skip(133); 
  
  def vowels2(s: String): String = {
  	var outString = ""
  	for (ch <- s)
  		if (isVowel(ch)) outString += ch
  	outString
  };System.out.println("""vowels2: (s: String)String""");$skip(158); 
  
  def vowels3(s: String): String = {
  	if (s.length == 0) ""
  	else {
			if (isVowel(s.head)) s.head + vowels3(s.tail)
	  	else vowels3(s.tail)
  	}
  };System.out.println("""vowels3: (s: String)String""");$skip(196); 
  
  def vowels4(s: String): String = {
  	var i = s.length - 1
  	var outString = ""
  	while (i >= 0) {
  		if (isVowel(s(i)))
  			outString = s(i) + outString
  		i -= 1
  	}
  	outString
  };System.out.println("""vowels4: (s: String)String""");$skip(40); val res$1 = 
  
  
  vowels("this is going to work");System.out.println("""res1: String = """ + $show(res$1));$skip(23); val res$2 = 
  vowels2("Nicaragua");System.out.println("""res2: String = """ + $show(res$2));$skip(23); val res$3 = 
  vowels3("Nicaragua");System.out.println("""res3: String = """ + $show(res$3));$skip(23); val res$4 = 
  vowels4("Nicaragua");System.out.println("""res4: String = """ + $show(res$4));$skip(25); val res$5 = 
  
  vowels("NICARAGUA");System.out.println("""res5: String = """ + $show(res$5));$skip(62); val res$6 = 
  vowels(ignoreCase = true, s="NICARAGUA", vowelChars = "ai");System.out.println("""res6: String = """ + $show(res$6))}
  
}
