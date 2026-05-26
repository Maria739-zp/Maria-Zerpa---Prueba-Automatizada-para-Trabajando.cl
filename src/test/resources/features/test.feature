Feature: prueba de inicio de sesion

  Background:
    Given el usuario navega a la pagina de inicio "https://www.trabajando.cl/"
    When ingresa usuario
    And contraseña validos
    And hace click en ingresar


  @loginExitoso
  Scenario: Validar el inicio de sesion exitoso
    Then la pagina carga exitosamente

   @busquedaDeEmpleo
  Scenario: busqueda oferta de empleo
    When hace click en ver ofertas de trabajo
    And ingresa el cargo "QA" en la barra buscadora
    And hace click en el boton buscar
    Then la pagina deberia mostrar una lista de resultados relacionados

  @busquedaDeEmpleoAvanzada
  Scenario: Busqueda de empleo aplicando filtros avanzados
    When hace click en ver ofertas de trabajo
    And el usuario hace click en aplicar filtros
    And ingresa en el campo cargo "QA"
    And ingresa en el campo ubicacion "Metropolitana de Santiago"
    #And ingresa en el campo jornada "Jornada Completa"
    And ingresa en el campo carrera "Informatica"
    #And hace click en el checkbox de informatica
    And hace click en buscar empleo
    Then la pagina carga las opciones de empleo disponibles