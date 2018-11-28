package latte.game.component

import latte.game.network.MapBean
import latte.game.server.{Manager, ProxyFactory, Player, Component}

/**
 * Created by linyuhe on 2018/9/14.
 */
object Skill extends Manager {

  def apply(player: Player): Skill = {
    ProxyFactory.getSyncProxy(new Skill(player))
  }

}

class Skill private(player: Player) extends Component(player) {

  def toMapBean = MapBean.empty

  override def start() = {}
}