package latte.game.command

import io.netty.channel.Channel
import io.netty.util.AttributeKey
import latte.game.network.MapBean
import latte.game.server.{Player, Command, PlayerNotFoundException}

/**
 * Created by linyuhe on 2018/9/13.
 */
object Command01 extends Command {

  // 登录
  def handler01(channel: Channel, request: MapBean): MapBean = {
    val playerId = request.getString("playerId")
    Player(playerId){
      case Some(player) =>
        channel.attr(AttributeKey.valueOf[String]("playerId")).set(player.id)
        player.channel = channel
        player.login()
      case None => throw PlayerNotFoundException(playerId)
    }
  }
}
