
object scalatut4 {
  println("Welcome to the Scala worksheet")   	//> Welcome to the Scala worksheet
  val i = new NonEmpty(5,new Empty,new Empty) 	//> i  : NonEmpty = {.5.}
  val j=i.insert(4)                           	//> j  : Inset = {{.4.}4.}
  j.insert(7).insert(9).insert(8).insert(11)  	//> res0: Inset = {{.8{.8.}}11{.11{.11{.11.}}}}
}

abstract class Inset{
    def isEmpty:Boolean
    def contains(e:Int):Boolean
    def insert(e: Int):Inset
    
}
class Empty extends Inset{
    def isEmpty = true
    def contains(e:Int)=false
    def insert(e:Int) = new NonEmpty(e,new Empty,new Empty)
    
    override def toString="."
}
class NonEmpty(e: Int,left:Inset,right:Inset) extends Inset{
    def isEmpty=false
    
    def contains(e:Int)= {
   	 if(e<this.e) left contains e
   	 else if(e>this.e) right contains e
   	 else true
    }
    
    def insert(e:Int):Inset ={
   	 if(e<this.e) new NonEmpty(e, left insert e,right)
   	 else if (e>this.e) new NonEmpty(e,left,right insert e)
   	 else this
   	 
    }
    
    override def toString="{"+left.toString + e + right.toString + "}"
}
