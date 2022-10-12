package com.wiley.ScalaLogging

import com.typesafe.scalalogging.LazyLogging


object Logging extends App with LazyLogging{
  logger.error("Hello World")

}
