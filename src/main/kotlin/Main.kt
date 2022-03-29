class VariablesEntornoYPropiedadesSistema {
    private var variablesEntorno: MutableMap<Any, Any> = mutableMapOf<Any, Any>()
    private var propiedadesSistema: MutableMap<Any, Any> = mutableMapOf<Any, Any>()

    /**
     * La función [obtenerVariablesEntorno] ordena todas las variables de entorno para mostrarlas ordenadamente
     * @return [variablesEntorno] Mapa que contiene todas las variables de entorno del sistema ya ordenadas
     */
    fun obtenerVariablesEntorno(): MutableMap<Any, Any> {
        System.getenv().forEach { t, u -> variablesEntorno[t] = u }
        return variablesEntorno
    }

    /**
     * La función [obtenerPropiedadesSistema] ordena todas las propiedades del sistema para mostrarlas ordenadamente
     * @return [propiedadesSistema] Mapa que contiene todas las propiedades del sistema ya ordenadas
     */
    fun obtenerPropiedadesSistema(): MutableMap<Any, Any> {
        System.getProperties().forEach { t, u -> propiedadesSistema[t] = u }
        return propiedadesSistema
    }

    /**
     * La función [consultarVariableEntorno] le permitirá consultar el valor de una variable de entorno en concreto
     * @param [variable] De tipo String, corresponderá a la variable de entorno cuyo valor desee consultar
     * @return Variable de tipo String, la cual corresponderá al valor deseado
     */
    fun consultarVariableEntorno(variable: String): String {
        var variableEntorno: String = ""

        try {
            variablesEntorno.forEach { t, u ->
                if (variable == t) variableEntorno = u as String
            }
        } catch (e: java.util.NoSuchElementException) { println("No existe tal variable de entorno") }
        return variableEntorno
    }

    /**
     * La función [consultarPropiedadSistema] le permitirá consultar el valor de una propiedad del sistema en concreto
     * @param [propiedad] De tipo String, corresponderá a la propiedad del sistema cuyo valor desee consultar
     * @return Variable de tipo String, la cual corresponderá al valor deseado
     */
    fun consultarPropiedadSistema(propiedad: String): String {
        var propiedadSistema: String = ""

        try {
            propiedadesSistema.forEach { t, u ->
                if (propiedad == t) propiedadSistema = u as String
            }
        } catch (e: java.util.NoSuchElementException) { println("No existe tal propiedad del sistema") }
        return propiedadSistema
    }
}

fun main() {
    val varProp = VariablesEntornoYPropiedadesSistema()

    println("VARIABLES DE ENTORNO")
    println("====================")
    println()
    //System.getenv().forEach { t, u -> println("${t} = ${u}") }
    varProp.obtenerVariablesEntorno().forEach { println("${it.key} = ${it.value}") }
    println()
    println("PROPIEDADES DEL SISTEMA")
    println("=======================")
    //System.getProperties().forEach { t, u -> println("${t} = ${u}") }
    varProp.obtenerPropiedadesSistema().forEach { println("${it.key} = ${it.value}") }
}