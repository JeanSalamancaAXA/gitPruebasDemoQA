@Elements
Feature: Elements

  Background:
    Given estoy en la pagina demoqa.com


  @text_box
  Scenario Outline: Test box
    When ingreso al apartado de elements y text box
    And completo los text box con "<Full Name>" "<Email>" "<Current Address>" "<Permanent Address>"
    And presiono el boton enviar
    Then Los datos son recibidos

    Examples:
      | Full Name      | Email        | Current Address | Permanent Address |
      | Jean Salamanca | jean@axa.com | cra 7 24        | cra 8 25          |
      #| laura prada.   | jean salamanca@axa.com | cr@ 45 24         | crr 454|
      #| P@ula rod      |je@axa@dadw.com         |cra. ""            |awda38434|

