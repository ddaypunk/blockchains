/**
 * Converting https://dev.to/codesphere/how-to-build-your-own-blockchain-in-nodejs-3ijh
 * into a KotlinApp for practice
 */
fun main() {
    val a = Block("{from: \"Joe\", to \"Jane\"}")
    val b = Block("{from: \"Jane\", to \"Joe\"}")

    val chain = BlockChain()

    chain.add(a)
    chain.add(b)

    print(chain.print())
}