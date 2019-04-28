
object Lab2 {

  def isVowel(ch: Char, vowels:String="aeiou"): Boolean = {
  	vowels.contains(ch)
  }                                               //> isVowel: (ch: Char, vowels: String)Boolean
  
  isVowel('f')                                    //> res0: Boolean = false
   
  def vowels(s: String, vowelChars: String ="aeiou", ignoreCase: Boolean = true): String = {
  	if (ignoreCase)
  		for (ch <- s.toLowerCase if isVowel(ch, vowelChars)) yield ch
  	else
  		for (ch <- s if isVowel(ch, vowelChars)) yield ch
  }                                               //> vowels: (s: String, vowelChars: String, ignoreCase: Boolean)String
  
  def vowels2(s: String): String = {
  	var outString = ""
  	for (ch <- s)
  		if (isVowel(ch)) outString += ch
  	outString
  }                                               //> vowels2: (s: String)String
  
  def vowels3(s: String): String = {
  	if (s.length == 0) ""
  	else {
			if (isVowel(s.head)) s.head + vowels3(s.tail)
	  	else vowels3(s.tail)
  	}
  }                                               //> vowels3: (s: String)String
  
  def vowels4(s: String): String = {
  	var i = s.length - 1
  	var outString = ""
  	while (i >= 0) {
  		if (isVowel(s(i)))
  			outString = s(i) + outString
  		i -= 1
  	}
  	outString
  }                                               //> vowels4: (s: String)String
  
  
  vowels("this is going to work")                 //> res1: String = iioioo
  vowels2("Nicaragua")                            //> res2: String = iaaua
  vowels3("Nicaragua")                            //> res3: String = iaaua
  vowels4("Nicaragua")                            //> res4: String = iaaua
  
  vowels("NICARAGUA")                             //> res5: String = iaaua
  vowels(ignoreCase = true, s="NICARAGUA", vowelChars = "ai")
                                                  //> res6: String = iaaa
  
}