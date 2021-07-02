import java.lang.StringBuilder

class BlockChain {
    private val blockChain = arrayListOf(startGenesisBlock())

    private fun startGenesisBlock(): Block{
        return Block("{}")
    }

    private fun obtainLatestBlock(): Block {
        return this.blockChain[this.blockChain.size - 1]
    }

    fun add(newBlock: Block) {
        newBlock.prevHash = this.obtainLatestBlock().hash
        newBlock.hash = newBlock.computeHash()
        this.blockChain.add(newBlock)
    }

    fun checkChainValidity(): Boolean {
        for(i in 1 until this.blockChain.size) {
            val currBlock = this.blockChain[i]
            val prevBlock = this.blockChain[i - 1]

            if(currBlock.hash != currBlock.computeHash()) {
                return false
            }

            if (currBlock.prevHash != prevBlock.hash) {
                return false
            }
        }

        return true
    }

    fun print(): String {
        return buildString {
            append("\n==== CHAIN START ====")
            append("\nChain: $blockChain")

            blockChain.forEach {
                append("\n\n\t==== BLOCK START ====")
                append("\n\tTimestamp: ${it.timestamp}")
                append("\n\tHash: ${it.hash}")
                append("\n\tPrev: ${it.prevHash.ifEmpty { "Genesis" }}")
                append("\n\tData: ${it.data}")
                append("\n\t====  BLOCK END  ====")
            }
            append("\n\nValid: ${checkChainValidity()}")
            append("\n==== CHAIN END ====")
        }
    }
}