import scala.annotation.tailrec
import scala.math._
object scalatut1 {
  println("Welcome to the Scala worksheet")   	//> Welcome to the Scala worksheet
  lazy val a=1                                	//> a: => Int
  a                                           	//> res0: Int = 1
  var b=5.0.toInt                             	//> b  : Int = 5
 
  def h(x: Int):Float=(x*x).toFloat           	//> h: (x: Int)Float
  val fn: Int=> Float=h                       	//> fn  : Int => Float = <function1>
 
  fn(a)                                       	//> res1: Float = 1.0
  def fact(n:Int)={
  @tailrec
	def iter(acc:BigInt,n :BigInt): BigInt ={
 		 if(n<2) acc else iter(acc*n,n-1)
 		   }
 		   iter(1,n)
 		   }                                   	//> fact: (n: Int)scala.math.BigInt
 		   //fact(5000)

//finding sqrt using newtons step method
 		    
	def sqrtN(x:Double)={
 			val err=0.00000001
 		   
	def sqrt1(guess: Double): Double={
   	 if(isOk(guess)) guess else sqrt1(improve(guess))
	}
    
	def isOk(guess:Double)={
   	 if(abs(guess*guess-x)/x<err) true else false
	}
    
	def improve(guess:Double)={
   	 (guess+x/guess)/2
	}
	sqrt1(1.0)
	}                                         	//> sqrtN: (x: Double)Double
	sqrtN(36)                                 	//> res2: Double = 6.000000005333189
}
