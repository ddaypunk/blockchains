import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.ZoneOffset

class Block(var data: String, var prevHash: String = "") {
    var timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
    var hash = this.computeHash()

    fun computeHash(): String {
        val strBlock = this.prevHash + this.timestamp + this.data

        return hashString("SHA-256", strBlock)
    }

    private fun hashString(type: String, data: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(data.toByteArray())

        return bytes.joinToString("") { "%02x".format(it) }
    }
}