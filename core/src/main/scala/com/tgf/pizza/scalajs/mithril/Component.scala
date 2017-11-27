package com.tgf.pizza.scalajs.mithril

import scala.scalajs.js
import scala.scalajs.js.annotation._


@js.native
trait MithrilComponent extends js.Object {
  val controller: js.Function
  val view: js.Function
}

@JSExportDescendentObjects
@JSExportAll
trait Component {
  val controller: js.Function = () => Unit
  val view: js.Function
}
