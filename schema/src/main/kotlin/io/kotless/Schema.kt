package io.kotless


/**
 * Definition of Kotless application.
 *
 * It may include few Web applications with
 * routes served from static and via lambdas.
 *
 * @param kotlessConfig configuration of kotless itself
 * @param webapps web applications defined by application
 * @param lambdas lambdas used in application
 * @param statics static resources used in application
 */
data class Schema(val kotlessConfig: KotlessConfig, val webapps: Set<Webapp>, val lambdas: Set<Lambda>, val statics: Set<StaticResource>) : Visitable {
    override fun visit(visitor: (Any) -> Unit) {
        kotlessConfig.visit(visitor)
        lambdas.forEach { it.visit(visitor) }
        statics.forEach { it.visit(visitor) }
        webapps.forEach { it.visit(visitor) }

        visitor(this)
    }
}
