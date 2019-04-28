object Lab41 {

	class Time(private var _hour: Integer, val minute: Integer) {
		if (hour < 0 || hour >= 24 || minute < 0 || minute >=  60)
			throw new IllegalArgumentException
		def hour = _hour
		def hour_=(newHour: Int) {_hour = newHour}
		def before(other: Time): Boolean = {
			if (this.hour < other.hour) true
			else ((this.hour == other.hour) && (this.minute < other.minute))

		}
		override def toString = f"${hour}:${minute}%02d"
	}
	
	object Time {
		def apply(hour: Integer = 0, minute: Integer = 0) = {
			val t = new Time(hour, minute)
			t
		}
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(596); val res$0 = 
	
	Time(20,30) before Time(21, 0);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(19); 
	val t1 = Time(22);System.out.println("""t1  : Lab41.Time = """ + $show(t1 ));$skip(9); val res$1 = 
	t1.hour;System.out.println("""res1: Integer = """ + $show(res$1));$skip(11); val res$2 = 
	t1.minute;System.out.println("""res2: Integer = """ + $show(res$2));$skip(13); 
	t1.hour = 5;$skip(14); 
	t1.hour_=(5);$skip(9); val res$3 = 
	t1.hour;System.out.println("""res3: Integer = """ + $show(res$3));$skip(12); val res$4 = 

	
	24 * 60
	
	
	
	
	
	
	
	object Time2 {
		def apply(h: Integer = 0, m: Integer = 0) = new Time2(h, m)
	}
		
	
	class Time2(h: Integer = 0, m: Integer = 0) {
		 private var minutesSinceMidnight = h * 60 + m
		 if (h<0 || h>23 || m<0 || m>59) throw new IllegalArgumentException("hour or minute is incorrect")
		 def hours = minutesSinceMidnight / 60
		 def minutes = minutesSinceMidnight % 60
		 def minutes_= (newValue: Int) {
		 	if (newValue < 0 || newValue > 59) throw new IllegalArgumentException("minutes between 0 and 59")
		 	else minutesSinceMidnight = this.hours * 60 + newValue
		 }
		 def before(other: Time2): Boolean = this.minutesSinceMidnight < other.minutesSinceMidnight
		 override def toString = f"${hours}:${minutes}%02d"
	};System.out.println("""res4: Int(1440) = """ + $show(res$4));$skip(769); 
	
	
	
	 val late = new Time2(22,59);System.out.println("""late  : Lab41.Time2 = """ + $show(late ));$skip(13); val res$5 = 
	 late.hours;System.out.println("""res5: Int = """ + $show(res$5));$skip(15); val res$6 = 
	 late.minutes;System.out.println("""res6: Int = """ + $show(res$6));$skip(29); 
	 val early = new Time2(4,0);System.out.println("""early  : Lab41.Time2 = """ + $show(early ));$skip(23); val res$7 = 
	 
	 early before late;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(20); val res$8 = 
	 late before early;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(16); val res$9 = 
	 early.minutes;System.out.println("""res9: Int = """ + $show(res$9));$skip(8); val res$10 = 
	 early;System.out.println("""res10: Lab41.Time2 = """ + $show(res$10));$skip(22); 
	 early.minutes_=(15);$skip(8); val res$11 = 
	 early;System.out.println("""res11: Lab41.Time2 = """ + $show(res$11));$skip(21); 
	 early.minutes = 30;$skip(8); val res$12 = 
	 early
	
	
	object Time3 {
		def apply(h: Integer = 0, m: Integer = 0) = new Time3(h, m)
	}
		
	
	class Time3(h: Integer = 0, m: Integer = 0) {
		 private var minutesSinceMidnight2 = h * 60 + m
		 if (h<0 || h>23 || m<0 || m>59) throw new IllegalArgumentException("hour or minute is incorrect")
		 def hours = minutesSinceMidnight2 / 60
		 def minutes = minutesSinceMidnight2 % 60
		 def <(other: Time3): Boolean = this.minutesSinceMidnight2 < other.minutesSinceMidnight2
		 def -(other: Time3): Integer = this.minutesSinceMidnight2 - other.minutesSinceMidnight2
		 def minutes_= (newValue: Int) {
		 	if (newValue < 0 || newValue > 59) throw new IllegalArgumentException("minutes between 0 and 59")
		 	else minutesSinceMidnight2 = this.hours * 60 + newValue
		 }
		 override def toString = f"${hours}:${minutes}%02d"
	};System.out.println("""res12: Lab41.Time2 = """ + $show(res$12));$skip(852); 
	
	
	
	 val late2 = new Time3(22,59);System.out.println("""late2  : Lab41.Time3 = """ + $show(late2 ));$skip(13); val res$13 = 
	 late.hours;System.out.println("""res13: Int = """ + $show(res$13));$skip(15); val res$14 = 
	 late.minutes;System.out.println("""res14: Int = """ + $show(res$14));$skip(30); 
	 val early2 = new Time3(4,0);System.out.println("""early2  : Lab41.Time3 = """ + $show(early2 ));$skip(20); val res$15 = 
	 
	 early2 < late2;System.out.println("""res15: Boolean = """ + $show(res$15));$skip(17); val res$16 = 
	 late2 < early2;System.out.println("""res16: Boolean = """ + $show(res$16));$skip(9); val res$17 = 
	 early2;System.out.println("""res17: Lab41.Time3 = """ + $show(res$17));$skip(23); 
	 early2.minutes_=(15);$skip(9); val res$18 = 
	 early2;System.out.println("""res18: Lab41.Time3 = """ + $show(res$18));$skip(22); 
	 early2.minutes = 25;$skip(9); val res$19 = 
	 early2;System.out.println("""res19: Lab41.Time3 = """ + $show(res$19));$skip(22); 
	 early2.minutes = 10;$skip(17); val res$20 = 
	 early2 - late2;System.out.println("""res20: Integer = """ + $show(res$20));$skip(17); val res$21 = 
	 late2 - early2;System.out.println("""res21: Integer = """ + $show(res$21));$skip(25); 
	 val noon = Time3(12,0);System.out.println("""noon  : Lab41.Time3 = """ + $show(noon ));$skip(29); val res$22 = 
	 Time3(9,0) < Time3(13, 30);System.out.println("""res22: Boolean = """ + $show(res$22))}
	
	
	
	
	
	
	
}
