package org.weir1218.samsa.kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration

actual class KafkaClient actual constructor(config: Map<String, Any>) {

    init {
        create(config)
    }

    private  var consumer: KafkaConsumer<String, String> ? = null

    actual fun create(config: Map<String, Any>) {
        // Validate or extend configuration as needed
        val defaultConfig = mapOf(
            "key.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer",
            "value.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer",
            "enable.auto.commit" to "false"
        )
        val effectiveConfig = defaultConfig + config

        consumer = KafkaConsumer<String, String>(effectiveConfig)
    }

    actual fun destroy() {
        consumer?.close()
    }


    actual fun fetchMessages(topic: String): List<String> {
        if (consumer == null) throw IllegalStateException("Consumer is not initialized. Call init() first.")

        consumer!!.subscribe(listOf(topic))
        val records = consumer!!.poll(Duration.ofMillis(1000))
        return records.map { it.value() }
    }
}