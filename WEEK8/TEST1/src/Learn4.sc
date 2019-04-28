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
	}
	
	Time(20,30) before Time(21, 0)            //> res0: Boolean = true
	val t1 = Time(22)                         //> t1  : Lab41.Time = 22:00
	t1.hour                                   //> res1: Integer = 22
	t1.minute                                 //> res2: Integer = 0
	t1.hour = 5
	t1.hour_=(5)
	t1.hour                                   //> res3: Integer = 5

	
	24 * 60                                   //> res4: Int(1440) = 1440
	
	
	
	
	
	
	
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
	}
	
	
	
	 val late = new Time2(22,59)              //> late  : Lab41.Time2 = 22:59
	 late.hours                               //> res5: Int = 22
	 late.minutes                             //> res6: Int = 59
	 val early = new Time2(4,0)               //> early  : Lab41.Time2 = 4:00
	 
	 early before late                        //> res7: Boolean = true
	 late before early                        //> res8: Boolean = false
	 early.minutes                            //> res9: Int = 0
	 early                                    //> res10: Lab41.Time2 = 4:00
	 early.minutes_=(15)
	 early                                    //> res11: Lab41.Time2 = 4:15
	 early.minutes = 30
	 early                                    //> res12: Lab41.Time2 = 4:30
	
	
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
	}
	
	
	
	 val late2 = new Time3(22,59)             //> late2  : Lab41.Time3 = 22:59
	 late.hours                               //> res13: Int = 22
	 late.minutes                             //> res14: Int = 59
	 val early2 = new Time3(4,0)              //> early2  : Lab41.Time3 = 4:00
	 
	 early2 < late2                           //> res15: Boolean = true
	 late2 < early2                           //> res16: Boolean = false
	 early2                                   //> res17: Lab41.Time3 = 4:00
	 early2.minutes_=(15)
	 early2                                   //> res18: Lab41.Time3 = 4:15
	 early2.minutes = 25
	 early2                                   //> res19: Lab41.Time3 = 4:25
	 early2.minutes = 10
	 early2 - late2                           //> res20: Integer = -1129
	 late2 - early2                           //> res21: Integer = 1129
	 val noon = Time3(12,0)                   //> noon  : Lab41.Time3 = 12:00
	 Time3(9,0) < Time3(13, 30)               //> res22: Boolean = true
	
	
	
	
	
	
	
}