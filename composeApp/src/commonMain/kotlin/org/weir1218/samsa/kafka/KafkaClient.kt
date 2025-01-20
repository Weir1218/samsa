package org.weir1218.samsa.kafka

expect class KafkaClient(config: Map<String, Any>) {
    fun fetchMessages(topic: String): List<String>
    fun create(config: Map<String, Any>)
    fun destroy()
}
