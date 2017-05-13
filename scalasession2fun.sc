
object scalasession2fun {
  println("Welcome to the Scala worksheet")   	//> Welcome to the Scala worksheet
//sum of integer using acc
  def sumInts(x:Int,y:Int)={
 
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(n+acc,n+1)
      }
      iter(0,x)
  }                                           	//> sumInts: (x: Int, y: Int)Int
  sumInts(1,10)                               	//> res0: Int = 55
 
//sum of sq using acc
  def sumSq(x:Int,y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(n*n+acc,n+1)
      }
      iter(0,x)
  }                                           	//> sumSq: (x: Int, y: Int)Int
  sumSq(1,10)                                 	//> res1: Int = 385
 
 
  def sum(f:Int=>Int,x:Int,y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(f(n)+acc,n+1)
      }
      iter(0,x)
  }                                           	//> sum: (f: Int => Int, x: Int, y: Int)Int
  sum(z=>z*z,1,10)                            	//> res2: Int = 385
 
 
  def prod(f:Int=>Int,x:Int,y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(f(n)*acc,n+1)
      }
      iter(0,x)
  }                                           	//> prod: (f: Int => Int, x: Int, y: Int)Int
  //prod(1,10)
 
  def mapreduce(map:Int=>Int,
     								 reduce:(Int,Int)=>Int,
     								 iden: Int,
     								 x:Int,
     								 y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(reduce(map(n),acc),n+1)
      }
      iter(iden,x)
     								 
 }                                            	//> mapreduce: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int, x: Int, y
                                              	//| : Int)Int
 mapreduce(a=>a,(a,b)=>a*b,1,1,5)             	//> res3: Int = 120
 mapreduce(a=>a*a,(a,b)=>a+b,0,1,5)           	//> res4: Int = 55
 
 def mapreduce1(map:Int=>Int,
     								 reduce:(Int,Int)=>Int,
     								 iden: Int)
     								 (x:Int,
     								 y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(reduce(map(n),acc),n+1)
      }
      iter(iden,x)
     								 
 }                                            	//> mapreduce1: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(x: Int,
                                              	//|  y: Int)Int
 mapreduce1(a=>a,(a,b)=>a*b,1)(1,5)           	//> res5: Int = 120
 mapreduce1(a=>a*a,(a,b)=>a+b,0)(1,5)         	//> res6: Int = 55
 
 def mapreduce2(map:Int=>Int,
     								 reduce:(Int,Int)=>Int,
     								 iden: Int):(Int,Int)=>Int={
  def fn(x:Int,y:Int)={
      def iter(acc:Int,n:Int):Int={
     	 if(n>y) acc else iter(reduce(map(n),acc),n+1)
      }
      iter(iden,x)
   	 }
   	 fn
  }                                           	//> mapreduce2: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(Int, In
                                              	//| t) => Int
  val sumInts2=mapreduce2(x=>x,(x,y)=>x+y,0)  	//> sumInts2  : (Int, Int) => Int = <function2>
 
  val fact=mapreduce2(x=>x,(x,y)=>x*y,1)      	//> fact  : (Int, Int) => Int = <function2>
  sumInts2(1,10)                              	//> res7: Int = 55
  fact(1,5)                                   	//> res8: Int = 120
  fact(1,7)                                   	//> res9: Int = 5040
}
