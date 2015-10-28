package co.technius.scalajs.mithril

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation._
import scala.annotation.meta.field

@js.native
trait MithrilComponent extends js.Object {
  def controller: js.UndefOr[js.Function]
  def view: js.Function
}

@JSExportDescendentObjects
trait Component {
  @(JSExport @field) def controller: js.Function = () => Unit
  @(JSExport @field) def view: js.Function
}
