fun main() {
    println("Bem vindo ao Bytebank")
    val contaAlaim = Conta("Alaim", 1001 )
    contaAlaim.depositar(300.20)

    val contaJhuli = Conta("Jhully", 1002)
    contaJhuli.depositar(500.00)


    println(contaAlaim.titular)
    println(contaAlaim.numero)
    println(contaAlaim.saldo)

    println(contaJhuli.titular)
    println(contaJhuli.numero)
    println(contaJhuli.saldo)

    println("deposito na conta do Alaim")//reutilizando código
    contaAlaim.depositar( 100.0)
    println(contaAlaim.saldo)
    println("sacando conta Alaim")
    contaAlaim.saca(50.0)
    println(contaAlaim.saldo)


    println("deposito na conta da Jully")
    contaJhuli.depositar( 50.0)
    println(contaJhuli.saldo)
    println("sacando conta Jhully")
    contaJhuli.saca(100.0)
    println(contaJhuli.saldo)

    println("Transferência  da conta da Jhully para o Alaim")
    if(contaJhuli.transfere(100.0, contaAlaim)){
        println("Transferência bem sucedida")
    }else{
        println("Falha na transferência")
    }

    println(contaAlaim.saldo)
    println(contaJhuli.saldo)



}

class Conta (
    val titular: String,
    val numero: Int
    ){     //agora sou obrigado a inicializar com valor

//    var titular = titular //var deve ser iniciado e pode ser modificado
//    var numero = numero
    var saldo = 0.0
        private set//apenas a classe ajusta o valor

//    constructor(titular: String, numero: Int) {   //modificar o que é padrão
//        this.titular = titular
//        this.numero = numero
//    }

    fun depositar(valor: Double ){
       if(valor>0){
           this.saldo += valor
       }
    }

    fun saca(valor: Double) {
        if(saldo >= valor){
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean{ //altero o tipo de retorno de Unit para Boolean
        if(saldo >= valor){
            saldo -= valor
            destino.depositar(valor)
            return true
        }//não preciso declarar o else
            return false
    }



//    fun getSaldo():Double {
//        return saldo
//    }
//
//    fun setSaldo(valor: Double){
//        if(valor > 0) {
//            saldo = valor
//        }
//    }

}

fun testaCopiasReferencias(){
    //variaveis do tipo primitivo
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("NumeroX $numeroX")
    println("NumeroY $numeroY")

    val contaJoao = Conta("João", 5001)//joão aponta para conta

    //var contaMaria = contaJoao //maria tambem aponta para conta
    var contaMaria = Conta("Maria", 1005)

    println("titular conta joão: ${contaJoao.titular }")
    println("titular conta maria: ${contaMaria.titular }")


}

//    while (i<5){
//        println("Bem vindo")
//    }

fun testaLacos(){
    for (i in 1..3) {

        val titular = "Alaim $i"
        val numeroConta = 1020 + i
        var saldo = i + 10.0
        saldo = 100 + 2.0
        saldo += 200


        println("Titular $titular")
        println("Número da conta $numeroConta")
        println("Saldo da conta $saldo")


        when {
            saldo > 0.0 -> println("Conta positiva")
            saldo == 0.0 -> println("Conta é neutra")
            else -> println("Contra é negativa")
        }
    }

    //loops aninhados
    loop@ for (i in 1..100) {
        println("i $i")
        for (j in 1..100) {
            println("j $j")
            if (j == 5) break@loop
        }
    }

}

