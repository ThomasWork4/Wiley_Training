//import org.scalatest.prop.TableDrivenPropertyChecks
//import org.scalatest.propspec.AnyPropSpec
//
//import scala.collection.immutable._
//
//class propTest extends AnyPropSpec with TableDrivenPropertyChecks{
//  //For checking properties
//
//  val example = Table("Set", BitSet.empty,HashSet.empty[Int],TreeSet.empty[Int])
//
//  property("An empty Set should have size 0"){
//    forAll(example){
//      set => {
//        assert(set.size === 0)
//      }
//    }
//  }
//
//
//
//}
