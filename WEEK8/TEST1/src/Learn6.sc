object Lab61 {

  val zones = java.util.TimeZone.getAvailableIDs  //> zones  : Array[String] = Array(Africa/Abidjan, Africa/Accra, Africa/Addis_Aba
                                                  //| ba, Africa/Algiers, Africa/Asmara, Africa/Asmera, Africa/Bamako, Africa/Bangu
                                                  //| i, Africa/Banjul, Africa/Bissau, Africa/Blantyre, Africa/Brazzaville, Africa/
                                                  //| Bujumbura, Africa/Cairo, Africa/Casablanca, Africa/Ceuta, Africa/Conakry, Afr
                                                  //| ica/Dakar, Africa/Dar_es_Salaam, Africa/Djibouti, Africa/Douala, Africa/El_Aa
                                                  //| iun, Africa/Freetown, Africa/Gaborone, Africa/Harare, Africa/Johannesburg, Af
                                                  //| rica/Juba, Africa/Kampala, Africa/Khartoum, Africa/Kigali, Africa/Kinshasa, A
                                                  //| frica/Lagos, Africa/Libreville, Africa/Lome, Africa/Luanda, Africa/Lubumbashi
                                                  //| , Africa/Lusaka, Africa/Malabo, Africa/Maputo, Africa/Maseru, Africa/Mbabane,
                                                  //|  Africa/Mogadishu, Africa/Monrovia, Africa/Nairobi, Africa/Ndjamena, Africa/N
                                                  //| iamey, Africa/Nouakchott, Africa/Ouagadougou, Africa/Porto-Novo, Africa/Sao_T
                                                  //| ome, Africa/Timbuktu, Africa/Tripoli, Africa/Tunis, Africa/Windhoek, America/
                                                  //| Adak, America/Anchorage, 
                                                  //| Output exceeds cutoff limit.
  zones.map(s => s.split("/"))                    //> res0: Array[Array[String]] = Array(Array(Africa, Abidjan), Array(Africa, Accr
                                                  //| a), Array(Africa, Addis_Ababa), Array(Africa, Algiers), Array(Africa, Asmara)
                                                  //| , Array(Africa, Asmera), Array(Africa, Bamako), Array(Africa, Bangui), Array(
                                                  //| Africa, Banjul), Array(Africa, Bissau), Array(Africa, Blantyre), Array(Africa
                                                  //| , Brazzaville), Array(Africa, Bujumbura), Array(Africa, Cairo), Array(Africa,
                                                  //|  Casablanca), Array(Africa, Ceuta), Array(Africa, Conakry), Array(Africa, Dak
                                                  //| ar), Array(Africa, Dar_es_Salaam), Array(Africa, Djibouti), Array(Africa, Dou
                                                  //| ala), Array(Africa, El_Aaiun), Array(Africa, Freetown), Array(Africa, Gaboron
                                                  //| e), Array(Africa, Harare), Array(Africa, Johannesburg), Array(Africa, Juba), 
                                                  //| Array(Africa, Kampala), Array(Africa, Khartoum), Array(Africa, Kigali), Array
                                                  //| (Africa, Kinshasa), Array(Africa, Lagos), Array(Africa, Libreville), Array(Af
                                                  //| rica, Lome), Array(Africa, Luanda), Array(Africa, Lubumbashi), Array(Africa, 
                                                  //| Lusaka), Array(Africa, Ma
                                                  //| Output exceeds cutoff limit.
  
  zones.map(_.split("/"))                         //> res1: Array[Array[String]] = Array(Array(Africa, Abidjan), Array(Africa, Acc
                                                  //| ra), Array(Africa, Addis_Ababa), Array(Africa, Algiers), Array(Africa, Asmar
                                                  //| a), Array(Africa, Asmera), Array(Africa, Bamako), Array(Africa, Bangui), Arr
                                                  //| ay(Africa, Banjul), Array(Africa, Bissau), Array(Africa, Blantyre), Array(Af
                                                  //| rica, Brazzaville), Array(Africa, Bujumbura), Array(Africa, Cairo), Array(Af
                                                  //| rica, Casablanca), Array(Africa, Ceuta), Array(Africa, Conakry), Array(Afric
                                                  //| a, Dakar), Array(Africa, Dar_es_Salaam), Array(Africa, Djibouti), Array(Afri
                                                  //| ca, Douala), Array(Africa, El_Aaiun), Array(Africa, Freetown), Array(Africa,
                                                  //|  Gaborone), Array(Africa, Harare), Array(Africa, Johannesburg), Array(Africa
                                                  //| , Juba), Array(Africa, Kampala), Array(Africa, Khartoum), Array(Africa, Kiga
                                                  //| li), Array(Africa, Kinshasa), Array(Africa, Lagos), Array(Africa, Libreville
                                                  //| ), Array(Africa, Lome), Array(Africa, Luanda), Array(Africa, Lubumbashi), Ar
                                                  //| ray(Africa, Lusaka), Arr
                                                  //| Output exceeds cutoff limit.
  //zones.map(_.split("/")).map(_(1))
  zones.map(_.split("/")).filter(_.length > 1).map(_(1))
                                                  //> res2: Array[String] = Array(Abidjan, Accra, Addis_Ababa, Algiers, Asmara, As
                                                  //| mera, Bamako, Bangui, Banjul, Bissau, Blantyre, Brazzaville, Bujumbura, Cair
                                                  //| o, Casablanca, Ceuta, Conakry, Dakar, Dar_es_Salaam, Djibouti, Douala, El_Aa
                                                  //| iun, Freetown, Gaborone, Harare, Johannesburg, Juba, Kampala, Khartoum, Kiga
                                                  //| li, Kinshasa, Lagos, Libreville, Lome, Luanda, Lubumbashi, Lusaka, Malabo, M
                                                  //| aputo, Maseru, Mbabane, Mogadishu, Monrovia, Nairobi, Ndjamena, Niamey, Noua
                                                  //| kchott, Ouagadougou, Porto-Novo, Sao_Tome, Timbuktu, Tripoli, Tunis, Windhoe
                                                  //| k, Adak, Anchorage, Anguilla, Antigua, Araguaina, Argentina, Argentina, Arge
                                                  //| ntina, Argentina, Argentina, Argentina, Argentina, Argentina, Argentina, Arg
                                                  //| entina, Argentina, Argentina, Argentina, Aruba, Asuncion, Atikokan, Atka, Ba
                                                  //| hia, Bahia_Banderas, Barbados, Belem, Belize, Blanc-Sablon, Boa_Vista, Bogot
                                                  //| a, Boise, Buenos_Aires, Cambridge_Bay, Campo_Grande, Cancun, Caracas, Catama
                                                  //| rca, Cayenne, Cayman, Ch
                                                  //| Output exceeds cutoff limit.
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10)
                                                  //> res3: Iterator[Array[String]] = non-empty iterator
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10).toArray
                                                  //> res4: Array[Array[String]] = Array(Array(Abidjan, Accra, Addis_Ababa, Algier
                                                  //| s, Asmara, Asmera, Bamako, Bangui, Banjul, Bissau), Array(Blantyre, Brazzavi
                                                  //| lle, Bujumbura, Cairo, Casablanca, Ceuta, Conakry, Dakar, Dar_es_Salaam, Dji
                                                  //| bouti), Array(Douala, El_Aaiun, Freetown, Gaborone, Harare, Johannesburg, Ju
                                                  //| ba, Kampala, Khartoum, Kigali), Array(Kinshasa, Lagos, Libreville, Lome, Lua
                                                  //| nda, Lubumbashi, Lusaka, Malabo, Maputo, Maseru), Array(Mbabane, Mogadishu, 
                                                  //| Monrovia, Nairobi, Ndjamena, Niamey, Nouakchott, Ouagadougou, Porto-Novo, Sa
                                                  //| o_Tome), Array(Timbuktu, Tripoli, Tunis, Windhoek, Adak, Anchorage, Anguilla
                                                  //| , Antigua, Araguaina, Argentina), Array(Argentina, Argentina, Argentina, Arg
                                                  //| entina, Argentina, Argentina, Argentina, Argentina, Argentina, Argentina), A
                                                  //| rray(Argentina, Argentina, Aruba, Asuncion, Atikokan, Atka, Bahia, Bahia_Ban
                                                  //| deras, Barbados, Belem), Array(Belize, Blanc-Sablon, Boa_Vista, Bogota, Bois
                                                  //| e, Buenos_Aires, Cambrid
                                                  //| Output exceeds cutoff limit.
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10).toArray.map(_(0))
                                                  //> res5: Array[String] = Array(Abidjan, Blantyre, Douala, Kinshasa, Mbabane, Ti
                                                  //| mbuktu, Argentina, Argentina, Belize, Catamarca, Curacao, Ensenada, Guatemal
                                                  //| a, Indiana, Kentucky, Managua, Mexico_City, Nome, Port-au-Prince, Resolute, 
                                                  //| Sitka, Thunder_Bay, Casey, Troll, Ashkhabad, Calcutta, Dubai, Istanbul, Khan
                                                  //| dyga, Manila, Qatar, Srednekolymsk, Ujung_Pandang, Yerevan, South_Georgia, E
                                                  //| ucla, South, Atlantic, GMT, GMT+6, GMT-14, Greenwich, Belgrade, Gibraltar, L
                                                  //| jubljana, Oslo, Simferopol, Vatican, Christmas, BajaSur, Fakaofo, Kosrae, Pa
                                                  //| lau, Tongatapu, EST5EDT, Arizona, Samoa)
}

object Lab62 {

  1.to(10).reduceLeft(_*_)
  1 to 10 reduceLeft(_*_)
    
  def factorial (n: Integer): Integer = {
  	1 to n reduceLeft(_*_)
  }
  
  factorial(5)
  
  val mulLR = (x: Int, y: Int) => x * y
  
  (1 to 5).reduceLeft(mulLR)
  

  1.to(10).map(x => 2)
  1.to(10).map(x => 2).reduceLeft(_*_)
  

  (1 to 10).map(x => 2).reduceLeft(_*_)
  
  def biN(n: Int): Int = {
  	1.to(n).map(s => 2).reduceLeft(_*_)
  }

	biN(10)
	
	def pow(a: Int, n: Int): Integer = {
  	1.to(n).map(s => a).reduceLeft(_*_)
  }
  
  pow(2,10)
  pow(5, 5)
	
	def concat(strings: Seq[String], separator: String): String = {
		strings.reduceLeft(_ + separator + _)
	}
	
	concat(Array("Mary", "had", "a", "little", "lamb"), " ")
	
	
	
		
		
		
	val n3 = 10
 	var i = 1
  var f = 1

	def While3(cond: => Boolean) (body: => Unit) {
  	if (cond) {
  		body
  		While3(cond) (body)
  	}
  }
  
  While3 (i < n3) {f *= i; i += 1}
  

}