/*
 * Copyright 2022 Creative Scala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gradientdescent

import doodle.core.Point

object Loss {

  /** Calculated squared error / quadratic loss on a particular data point. */
  def pointLoss(pt: Point)(f: Double => Double): Double = {
    val expected = pt.y
    val actual = f(pt.x)
    val error = (actual - expected)

    error * error
  }

  /** Calculate squared error / quadratic loss on a data set. */
  def loss(data: List[Point])(f: Double => Double) = {
    data.foldLeft(0.0) { (accum, pt) => accum + pointLoss(pt)(f) }
  }
}
