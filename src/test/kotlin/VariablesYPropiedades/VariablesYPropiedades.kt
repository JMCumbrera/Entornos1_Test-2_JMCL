package VariablesYPropiedades

import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledIfSystemProperty
import kotlin.test.assertEquals

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class VariablesYPropiedades {
    /**
     * Test que comprobará que el nombre de dominio del PC sea igual a DESKTOP-TO7R8UD.
     * Este test se ejecutará sólo si el nombre de usuario es '3kxhoDark'.
     */
    @Test
    @Order (1)
    @DisplayName ("Comprobación del nombre de usuario del sistema")
    @EnabledIfEnvironmentVariable (named = "USERNAME", matches = "3kxhoDark")
    internal fun `Test Propiedad Sistema username`() {
        assertEquals(System.getenv("USERNAME"),"3kxhoDark", message = "El nombre de usuario del PC no es 3kxhoDark")
    }

    /**
     * Test que comprobará que la arquitectura del procesador del PC sea AMD64.
     * Este test se ejecutará sólo si la arquitectura del procesador es de AMD.
     */
    @Test
    @Order (2)
    @DisplayName ("Comprobación de la arquitectura del procesador")
    @EnabledIfEnvironmentVariable (named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    internal fun `Test Arquitectura Procesador`() {
        assertEquals(System.getenv("PROCESSOR_ARCHITECTURE"), "AMD64", message = "La arquitectura del procesador no es AMD64")
    }

    /**
     * Test que comprobará que el número de hilos de procesamiento del PC sea igual a 16.
     * Este test se ejecutará sólo si el numero de hilos de procesamiento del PC es igual a 16.
     */
    @Test
    @Order (3)
    @DisplayName ("Comprobación del número de hilos de procesamiento del procesador")
    @EnabledIfEnvironmentVariable (named = "NUMBER_OF_PROCESSORS", matches = "16")
    internal fun `Test Numero Procesos`() {
        assertEquals(System.getenv("NUMBER_OF_PROCESSORS"), "16", message = "El número de hilos de procesamiento no es de 16")
    }

    /**
     * Test que comprobará que la versión de Toolbox coincida con '1.22.10970'.
     * Este test se ejecutará sólo la versión de Toolbox actual del equipo coincide con la antes mencionada.
     */
    @Test
    @Order (4)
    @DisplayName ("Comprobación de la versión de Toolbox")
    @EnabledIfEnvironmentVariable (named = "TOOLBOX_VERSION", matches = "1.22.10970")
    internal fun `Test Version Toolbox`() {
        assertEquals(System.getenv("TOOLBOX_VERSION"), "1.22.10970", message = "La versión de Toolbox no está actualizada")
    }

    /**
     * Test que comprobará si la versión de Java instalada corresponde a la '1.8.0_322', ejecutando
     * el test sólo si esto se cumple.
     */
    @Test
    @Order (5)
    @DisplayName ("Comprobación de la versión de Java")
    @EnabledIfSystemProperty (named = "java.version", matches = "1.8.0_322")
    internal fun `Test Version Java`() {
        assertEquals(System.getProperty("java.version"), "1.8.0_322", message = "La versión de Java no es la 1.8.0_322")
    }

    /**
     * Test que comprobará que el sistema de codificación de archivos sea UTF-8, ejecutándose sólo si esto se cumple.
     */
    @Test
    @Order (6)
    @DisplayName ("Comprobación del sistema de codificación de ficheros")
    @EnabledIfSystemProperty (named = "file.encoding", matches = "UTF-8")
    internal fun `Test File Encoding`() {
        assertEquals(System.getProperty("file.encoding"), "UTF-8", message = "El formato de codificación de archivos no es UTF-8")
    }

    /**
     * Test que comprobará que el nombre del SO sea Windows 11, ejecutándose
     * sólo si esto se cumple.
     */
    @Test
    @Order (7)
    @DisplayName ("Comprobación del nombre del sistema operativo")
    @EnabledIfSystemProperty (named = "os.name", matches = "Windows 11")
    internal fun `Test Nombre SO`() {
        assertEquals(System.getProperty("os.name"), "Windows 10", message = "El nombre del SO no es Windows 10")
    }

    /**
     * Test que comprobará que el idioma del sistema sea el inglés (en),
     * ejecutándose sólo si esto se cumple.
     */
    @Test
    @Order (8)
    @DisplayName ("Comprobación del idioma del sistema")
    @EnabledIfSystemProperty (named = "user.language", matches = "en")
    internal fun `Test Idioma Usuario`() {
        assertEquals(System.getProperty("user.language"), "es", message = "El idioma del sistema no es español")
    }
}
