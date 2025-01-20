package org.weir1218.samsa.kafka

actual class KafkaClient actual constructor(config: Map<String, Any>) {
    actual fun fetchMessages(topic: String): List<String> {
        TODO("Not yet implemented")
    }

    actual fun init(config: Map<String, Any>) {
    }
}