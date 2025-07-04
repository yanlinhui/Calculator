fun StringBuilder.checkEndOperation():Boolean{
    val str = this.toString()
    return str.endsWith("+")||str.endsWith("-")||str.endsWith("×")||str.endsWith("÷")
}

fun StringBuilder.replaceOperation(str: String){
    replace(this.length-1,this.length,str)

}

fun StringBuilder.checkOperatinInput(str:String){
    if (isEmpty()) return
    if(checkEndOperation()){
        replaceOperation(str)
    }else{
        append(str)
        return
    }
}

fun StringBuilder.checkIfCanAppend(numStr:String):Boolean{
    if ((numStr == "00"||numStr == "0") && isEmpty()) return false
    if (isEmpty()){
        append(numStr)
        return true
    }
    if (numStr == "00"||numStr == "0"){
        if (this.last() in '0'..'9'){
            append(numStr)
            return true
        }
    }else{
        append(numStr)
        return true
    }
    return false
}