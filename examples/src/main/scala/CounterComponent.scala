import scala.scalajs.js
import scala.scalajs.js.Dynamic.{ literal => json }

import com.tgf.pizza.scalajs.mithril._

object CounterComponent extends Component {

  override val controller: js.Function = () => new CounterCtrl

  @inline def btn(callback: js.Function, label: String) =
    m("button", json("onclick" -> callback), label)

  val view: js.Function = (ctrl: CounterCtrl) => m("div", js.Array[VirtualDom](
    m("p", js.Array(
      m("span", "Count: "),
      ctrl.count()
    )),
    btn(ctrl.increment, "Increment"),
    btn(ctrl.decrement, "Decrement"),
    btn(ctrl.reset, "Reset")
  ))

  private[this] class CounterCtrl {
    val count: MithrilProp[Int] = m.prop(0)

    val increment = () => count() = _ + 1
    val decrement = () => count() = math.max(0, count() - 1)
    val reset = () => count() = 0
  }
}
