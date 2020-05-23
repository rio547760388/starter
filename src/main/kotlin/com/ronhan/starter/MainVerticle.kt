package com.ronhan.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class MainVerticle : AbstractVerticle() {
  var logger: Logger = LoggerFactory.getLogger("com.ronhan.starter.MainVerticle")

  override fun start(startFuture: Future<Void>) {

    vertx.deployVerticle("com.ronhan.service.UserVerticle")

  }
}
