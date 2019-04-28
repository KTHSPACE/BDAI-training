
object Lab1 {

  4 * 3                                           //> res0: Int(12) = 12
  2 / 5                                           //> res1: Int(0) = 0
  2.0 / 5.0                                       //> res2: Double(0.4) = 0.4
  3 / 5                                           //> res3: Int(0) = 0
  3 % 5                                           //> res4: Int(3) = 3
  
  val a = 6 * 7                                   //> a  : Int = 42
  a                                               //> res5: Int = 42
  a / 10                                          //> res6: Int = 4

  val b: BigInt = 6 * 7                           //> b  : BigInt = 42
  b.pow(1000)                                     //> res7: scala.math.BigInt = 17753762175756824895023459927060785266025241338933
                                                  //| 3830121866433218470832421443603270369699806687474089104928787716429205646797
                                                  //| 9682934737077049464296605508272514364193647791450330862622357351968709701692
                                                  //| 6893626339793976210524817665943409765000450688475580477423465801765534575905
                                                  //| 4920491964687859092794286951888196893257753512961312303142500199076828672388
                                                  //| 4039475329857509148162013746924850245250142292273919281341483030761218960837
                                                  //| 8514445805866392453838204891621655580313516255949859448656514553979179772189
                                                  //| 0644779927878664436883165382211500647791238674232812627101620876741669796650
                                                  //| 3703428016749799091197870288671741073316507101401112929443006664348800957958
                                                  //| 7709799057249526838180285935375753185150620988339294477339072043844392312410
                                                  //| 9419130052412940418052056836950663290529588691785317277527334817376409223416
                                                  //| 5375653338110417193480917514902717112293281089023929392425543606079300055100
                                                  //| 344172202132003242925720
                                                  //| Output exceeds cutoff limit.
  
  import scala.math._
  sqrt(10)                                        //> res8: Double = 3.1622776601683795
 
  1.to(10)                                        //> res9: scala.collection.immutable.Range.Inclusive = Range 1 to 10
  
  1 to 10                                         //> res10: scala.collection.immutable.Range.Inclusive = Range 1 to 10
  1.to(10).map(sqrt(_))                           //> res11: scala.collection.immutable.IndexedSeq[Double] = Vector(1.0, 1.4142135
                                                  //| 623730951, 1.7320508075688772, 2.0, 2.23606797749979, 2.449489742783178, 2.6
                                                  //| 457513110645907, 2.8284271247461903, 3.0, 3.1622776601683795)
  6.*(7)                                          //> res12: Int(42) = 42
  
  
  
  1 to 10 map(sqrt(_))                            //> res13: scala.collection.immutable.IndexedSeq[Double] = Vector(1.0, 1.4142135
                                                  //| 623730951, 1.7320508075688772, 2.0, 2.23606797749979, 2.449489742783178, 2.6
                                                  //| 457513110645907, 2.8284271247461903, 3.0, 3.1622776601683795)
  

  val c: Int = 5                                  //> c  : Int = 5
  sqrt(c)                                         //> res14: Double = 2.23606797749979
  
  "Mississippi".distinct                          //> res15: String = Misp
  "Rhine".permutations                            //> res16: Iterator[String] = non-empty iterator
  "Rhine".permutations.toArray                    //> res17: Array[String] = Array(Rhine, Rhien, Rhnie, Rhnei, Rhein, Rheni, Rihne
                                                  //| , Rihen, Rinhe, Rineh, Riehn, Rienh, Rnhie, Rnhei, Rnihe, Rnieh, Rnehi, Rnei
                                                  //| h, Rehin, Rehni, Reihn, Reinh, Renhi, Renih, hRine, hRien, hRnie, hRnei, hRe
                                                  //| in, hReni, hiRne, hiRen, hinRe, hineR, hieRn, hienR, hnRie, hnRei, hniRe, hn
                                                  //| ieR, hneRi, hneiR, heRin, heRni, heiRn, heinR, henRi, heniR, iRhne, iRhen, i
                                                  //| Rnhe, iRneh, iRehn, iRenh, ihRne, ihRen, ihnRe, ihneR, iheRn, ihenR, inRhe, 
                                                  //| inReh, inhRe, inheR, ineRh, inehR, ieRhn, ieRnh, iehRn, iehnR, ienRh, ienhR,
                                                  //|  nRhie, nRhei, nRihe, nRieh, nRehi, nReih, nhRie, nhRei, nhiRe, nhieR, nheRi
                                                  //| , nheiR, niRhe, niReh, nihRe, niheR, nieRh, niehR, neRhi, neRih, nehRi, nehi
                                                  //| R, neiRh, neihR, eRhin, eRhni, eRihn, eRinh, eRnhi, eRnih, ehRin, ehRni, ehi
                                                  //| Rn, ehinR, ehnRi, ehniR, eiRhn, eiRnh, eihRn, eihnR, einRh, einhR, enRhi, en
                                                  //| Rih, enhRi, enhiR, eniRh, enihR)
  "ABC".sum                                       //> res18: Char = иб
  'A'.toInt                                       //> res19: Int = 65
  'B'.toInt                                       //> res20: Int = 66
   'C'.toInt                                      //> res21: Int = 67
   "ABC".sum.toInt                                //> res22: Int = 198
  
}