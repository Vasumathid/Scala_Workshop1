import scala.math._
object scalatut2 {
  println("Welcome to the Scala worksheet")   	//> Welcome to the Scala worksheet
  var i=7+7                                   	//> i  : Int = 14
  -i                                          	//> res0: Int = -14
  var r1=new Rational(1,2)                    	//> r1  : Rational = 1/2
  var r3=new Rational(3,7)                    	//> r3  : Rational = 3/7
  var r2=r1 + r3                              	//> r2  : Rational = 9/14
  r1 - r2                                     	//> res1: Rational = -9/28
  -r1                                         	//> res2: Rational = -1/2
}
class Rational(n : Int,d: Int){
    
    require(d!=0,"Denominator can't be zero!!")
    
    def gcd(a:Int,b:Int):Int=if(b==0)a else gcd(b,a%b)
    private val g=gcd(n,d)
    
    def this(n:Int)=this(n,1)
    
    def numer=n/abs(g)
    def denom=d/abs(g)
    
    def +(that: Rational)=
   	 new Rational(this.numer*that.numer +this.denom * that.numer,this.denom * that.denom)
    
    def -(that: Rational)=
   	 new Rational(this.numer*that.numer -this.denom * that.numer,this.denom * that.denom)
    
    def unary_- =new Rational(-numer,denom)
   	 
    
    override def toString=numer+"/"+denom
}
