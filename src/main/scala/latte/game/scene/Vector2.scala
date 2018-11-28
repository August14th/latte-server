package latte.game.scene

/**
 * Created by linyuhe on 2018/11/26.
 */

case class Vector2(x: Double, z: Double) {

  def +(v: Vector2) = Vector2(x + v.x, z + v.z)

  def -(v: Vector2) = Vector2(x - v.x, z - v.z)

  def *(len: Double) = Vector2(x * len, z * len)

  def /(len: Double) = *(1 / len)

  def *(v: Vector2) = x * v.x + z * v.z

  def len() = math.sqrt(x * x + z * z)

  def normalized = this / len()

  def angle() = {
    var  degree = math.toDegrees(math.atan(x / z))
    if(x < 0 && z < 0) degree = degree - 180
    else if(x >= 0 && z < 0) degree = 180 + degree
    degree
  }

}



