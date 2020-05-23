package com.ronhan.service

import io.reactivex.Completable
import io.vertx.core.json.JsonObject
import io.vertx.reactivex.core.AbstractVerticle
import io.vertx.reactivex.core.eventbus.MessageConsumer
import io.vertx.reactivex.ext.asyncsql.AsyncSQLClient
import io.vertx.reactivex.ext.asyncsql.PostgreSQLClient
import io.vertx.reactivex.ext.web.Router

class UserVerticle : AbstractVerticle() {
  override fun rxStart(): Completable? {

    var r: Router = Router.router(vertx)

    var postgreSQLClient: AsyncSQLClient? = PostgreSQLClient.createShared(vertx, JsonObject()
      .put("host", "192.168.202.202")
      .put("port", "5432")
      .put("username", "smartcart")
      .put("password", "nSkEmHLoEgCOoa9J")
      .put("replicaSet", "smartcartdevdb"))

    postgreSQLClient!!.query("select * from auth_user") { ret ->
      if (ret.succeeded()) {
        ret.mapEmpty<JsonObject>().map { row ->
          row.forEach {
            println("key: ${it.key}, value: ${it.value}")
          }
        }
      } else {
        println(ret.cause())
      }
    }

    vertx.createHttpServer()
      .requestHandler(r)
      .listen(8888)

    return Completable.complete()
  }
}
